package org.jasig.cas.web;

/*
 * Copyright 2007 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.ja-sig.org/products/cas/overview/license/
 */

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.HttpBasedServiceCredential;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.authentication.principal.WebApplicationService;
import org.jasig.cas.dao.UaClientDAO;
import org.jasig.cas.entity.UaClient;
import org.jasig.cas.services.UnauthorizedServiceException;
import org.jasig.cas.ticket.TicketException;
import org.jasig.cas.ticket.TicketValidationException;
import org.jasig.cas.ticket.proxy.ProxyHandler;
import org.jasig.cas.validation.Assertion;
import org.jasig.cas.validation.Cas20ProtocolValidationSpecification;
import org.jasig.cas.validation.ValidationSpecification;
import org.jasig.cas.web.support.ArgumentExtractor;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.net.URL;

/**
 * Process the /validate and /serviceValidate URL requests.
 * <p>
 * Obtain the Service Ticket and Service information and present them to the CAS
 * validation services. Receive back an Assertion containing the user Principal
 * and (possibly) a chain of Proxy Principals. Store the Assertion in the Model
 * and chain to a View to generate the appropriate response (CAS 1, CAS 2 XML,
 * SAML, ...).
 * 
 * @author Scott Battaglia
 * @version $Revision: 42776 $ $Date: 2008-01-04 09:15:42 -0500 (Fri, 04 Jan 2008) $
 * @since 3.0
 */
public class GVServiceValidateController extends AbstractController {

    /** View if Service Ticket Validation Fails. */
    private static final String DEFAULT_SERVICE_FAILURE_VIEW_NAME = "cas2ServiceFailureView";

    /** View if Service Ticket Validation Succeeds. */
    private static final String DEFAULT_SERVICE_SUCCESS_VIEW_NAME = "cas2ServiceSuccessView";

    /** Constant representing the PGTIOU in the model. */
    private static final String MODEL_PROXY_GRANTING_TICKET_IOU = "pgtIou";

    /** Constant representing the Assertion in the model. */
    private static final String MODEL_ASSERTION = "assertion";

    /** The CORE which we will delegate all requests to. */
    @NotNull
    private CentralAuthenticationService centralAuthenticationService;

    /** The validation protocol we want to use. */
    @NotNull
    private Class<?> validationSpecificationClass = Cas20ProtocolValidationSpecification.class;

    /** The proxy handler we want to use with the controller. */
    @NotNull
    private ProxyHandler proxyHandler;

    /** The view to redirect to on a successful validation. */
    @NotNull
    private String successView = DEFAULT_SERVICE_SUCCESS_VIEW_NAME;

    /** The view to redirect to on a validation failure. */
    @NotNull
    private String failureView = DEFAULT_SERVICE_FAILURE_VIEW_NAME;

    /** Extracts parameters from Request object. */
    @NotNull
    private ArgumentExtractor argumentExtractor;

    private UaClientDAO uaClientDAO;

    /**
     * Overrideable method to determine which credentials to use to grant a
     * proxy granting ticket. Default is to use the pgtUrl.
     * 
     * @param request the HttpServletRequest object.
     * @return the credentials or null if there was an error or no credentials
     * provided.
     */
    protected Credential getServiceCredentialsFromRequest(
        final HttpServletRequest request) {
    	
    	
        final String pgtUrl = request.getParameter("pgtUrl");
        logger.error("------pgtUrl----------" +  pgtUrl);
        
        if (StringUtils.hasText(pgtUrl)) {
            try {
                return new HttpBasedServiceCredential(new URL(pgtUrl));
            } catch (final Exception e) {
                logger.error("Error constructing pgtUrl", e);
            }
        }

        return null;
    }

    protected void initBinder(final HttpServletRequest request,
        final ServletRequestDataBinder binder) {
        binder.setRequiredFields(new String[] {"renew"});
    }

    protected final ModelAndView handleRequestInternal(
            final HttpServletRequest request, final HttpServletResponse response)
        throws Exception {
    	
    	
        final WebApplicationService service = this.argumentExtractor.extractService(request);
        final String serviceTicketId = service != null ? service.getArtifactId() : null;

        
        if (service == null
            || serviceTicketId == null) {
            return generateErrorView("INVALID_REQUEST", "INVALID_REQUEST", null);
        }
        
        final String clientId = request.getParameter("casClientId");

        try {
        	
        	if(StringUtils.hasText(clientId)){
            	UaClient uaClient= this.uaClientDAO.getUaClient(clientId);
                if(uaClient==null){
                	return generateErrorView("INVALID_CLIENT_ID", "INVALID_CLIENT_ID", new Object[]{ clientId});
                }
            }else{
//            	logger.error("-----------clientid[null]--------");
//            	return generateErrorView("INVALID_CLIENT_ID", "INVALID_CLIENT_ID", new Object[]{ "clientid[null]"});
            }
        	
            final Credential serviceCredentials = getServiceCredentialsFromRequest(request);
            String proxyGrantingTicketId = null;

            // XXX should be able to validate AND THEN use
            if (serviceCredentials != null) {
            	logger.info("-----------serviceCredentials is not [null]--------");
                try {
                    proxyGrantingTicketId = this.centralAuthenticationService
                        .delegateTicketGrantingTicket(serviceTicketId,
                            serviceCredentials);
                } catch (TicketException e) {
                    logger.error("TicketException generating ticket for: "
                        + serviceCredentials, e);
                }
            }else{
            	logger.info("-----------serviceCredentials[null]--------");
            }

            final Assertion assertion = this.centralAuthenticationService
                .validateServiceTicket(serviceTicketId,
                    service);

            
            final ValidationSpecification validationSpecification = this
                .getCommandClass();
            final ServletRequestDataBinder binder = new ServletRequestDataBinder(
                validationSpecification, "validationSpecification");
            initBinder(request, binder);
            binder.bind(request);

            if (!validationSpecification.isSatisfiedBy(assertion)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("ServiceTicket [" + serviceTicketId
                        + "] does not satisfy validation specification.");
                }
                return generateErrorView("INVALID_TICKET",
                    "INVALID_TICKET_SPEC", null);
            }

            final ModelAndView success = new ModelAndView(this.successView);
            success.addObject(MODEL_ASSERTION, assertion);

            if (serviceCredentials != null && proxyGrantingTicketId != null) {

            	
                final HttpBasedServiceCredential httpServiceCredentials = (HttpBasedServiceCredential) serviceCredentials;
                logger.debug(getPrincipalDigest(assertion));

            	if(!httpServiceCredentials.getCallbackUrl().toExternalForm().endsWith(getPrincipalDigest(assertion)))
            	{
	                final String proxyIou = this.proxyHandler.handle(
	                    serviceCredentials, proxyGrantingTicketId);
	            	logger.debug("proxyIou="+proxyIou);

	                success.addObject(MODEL_PROXY_GRANTING_TICKET_IOU, proxyIou);
            	}
            	else
            	{
	            	logger.debug("pgtId="+proxyGrantingTicketId);
            		success.addObject("pgtId",proxyGrantingTicketId);
            	}
            }
            
            return success;
        } catch (final TicketValidationException e) {
            return generateErrorView(e.getCode(), e.getCode(), new Object[] {serviceTicketId, e.getOriginalService().getId(), service.getId()});
        } catch (final TicketException te) {
            return generateErrorView(te.getCode(), te.getCode(),
                new Object[] {serviceTicketId});
        } catch (final UnauthorizedServiceException e) {
            return generateErrorView(e.getMessage(), e.getMessage(), null);
        }
    }

    private static String getPrincipalDigest(Assertion assertion) {
    	
    	Principal principal = assertion.getChainedAuthentications().get(assertion.getChainedAuthentications().size()-1).getPrincipal();
    	String userInfo = principal.getId()+principal.getAttributes().get("UID");
    	int hash;
    	hash = 0;
    	for(int i=0;i<userInfo.length();i++)
    	{
    		hash =31*hash + userInfo.charAt(i);
    	}
    	return Integer.toHexString(hash);
    }

    private ModelAndView generateErrorView(final String code,
                                           final String description, final Object[] args) {
        final ModelAndView modelAndView = new ModelAndView(this.failureView);
        modelAndView.addObject("code", code);
        modelAndView.addObject("description", getMessageSourceAccessor()
            .getMessage(description, args, description));

        return modelAndView;
    }

    private ValidationSpecification getCommandClass() {
        try {
            return (ValidationSpecification) this.validationSpecificationClass
                .newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * @param centralAuthenticationService The centralAuthenticationService to
     * set.
     */
    public void setCentralAuthenticationService(
        final CentralAuthenticationService centralAuthenticationService) {
        this.centralAuthenticationService = centralAuthenticationService;
    }

    public void setArgumentExtractor(
        final ArgumentExtractor argumentExtractor) {
        this.argumentExtractor = argumentExtractor;
    }

    /**
     * @param validationSpecificationClass The authenticationSpecificationClass
     * to set.
     */
    public void setValidationSpecificationClass(
        final Class<?> validationSpecificationClass) {
        this.validationSpecificationClass = validationSpecificationClass;
    }

    /**
     * @param failureView The failureView to set.
     */
    public void setFailureView(final String failureView) {
        this.failureView = failureView;
    }

    /**
     * @param successView The successView to set.
     */
    public void setSuccessView(final String successView) {
        this.successView = successView;
    }

    /**
     * @param proxyHandler The proxyHandler to set.
     */
    public void setProxyHandler(final ProxyHandler proxyHandler) {
        this.proxyHandler = proxyHandler;
    }

    public UaClientDAO getUaClientDAO() {
        return uaClientDAO;
    }

    public void setUaClientDAO(UaClientDAO uaClientDAO) {
        this.uaClientDAO = uaClientDAO;
    }
}
