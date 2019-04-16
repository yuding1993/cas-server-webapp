<!doctype html>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎登录</title>

    <link href="css/login.css" type="text/css" rel="stylesheet">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon" />
    <script src="js/jquery-1.8.3.min.js"></script>

    <script>

        function fvh() {
            var vh = $(window).height();
            $(".index_login").height(vh);
        }
        $(function () {
            fvh();
        })
        $(window).resize(function () {
            fvh();
        })

        $(function () {
            $(".re_password .rem_btn").click(function () {

                if ($(this).find("img").css("margin-top") == "0px") {
                    $(this).find("img").css("margin-top", "-30px");
                    $('#rememberMe').val('false')
                }
                else {
                    $(this).find("img").css("margin-top", "0px");
                    $('#rememberMe').val('true')
                }
            })
        })

        function iclogin(){


            var proxyEport = '<%=application.getInitParameter("proxyEport")%>';
            var eportCas = '<%=application.getInitParameter("eportCas")%>';
            var enfoClient = GetQueryString("service");

            var url = proxyEport + "/eportLogin/sucess?enfo-client="+enfoClient;
            var ssoUrl = eportCas + "?service=" + encodeURIComponent(url);
            window.location = ssoUrl;
        }
        function GetQueryString(name)
        {
            var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if(r!=null)return  unescape(r[2]); return null;
        }

        function icRegister(){

            var icRegisterUrl = '<%=application.getInitParameter("proxyEport")%>';
            var eportCas = '<%=application.getInitParameter("eportCas")%>';
            var enfoClient = GetQueryString("service");

            var url = icRegisterUrl + "/eportLogin/register?enfo-client="+enfoClient;
            var ssoUrl = eportCas + "?service=" + encodeURIComponent(url);
            window.location = ssoUrl;
        }

    </script>
</head>

<body>

<div class="index_login">
    <div class="outer_box">
        <div class="big_logo"></div>
        <h1 align="center">您好，欢迎登录智能通关系统</h1>
        <h2 align="center">Hello , Welcome!</h2>
        <div class="login_box">
            <form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true">
                <div class="w261">
                    <div class="user">
                        <spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
                        <form:input cssClass="input_box" placeholder="请输入用户名" id="username" size="25" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" />
                    </div>
                    <div class="user">
                        <spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
                        <form:password cssClass="input_box password" placeholder="请输入密码"  id="password" size="25" tabindex="2" path="password"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
                    </div>

                    <div class="re_password">
                        <!--
                        <p><a href="#">忘记密码？点击重置</a></p>
                        -->
                        <div class="remember">
                            <span>记住登录状态</span>
                            <div class="rem_btn">
                                <img src="images/rem_btn.png">
                            </div>
                            <input type="hidden" name="rememberMe" id="rememberMe" value="true"/>
                        </div>
                    </div>

                    <c:if test="${not empty count && count >= 3}">
                        <div class="verify">
                            <div class="verify_box">
                                <spring:message code="screen.welcome.label.captcha.accesskey" var="authcaptchaAccessKey" />
                                <input class="input_box" type="text" placeholder="请输入验证码" maxlength="10" name="captcha">
                                <input type="hidden" name="showCaptcha" value="true"/>
                            </div>
                            <div class="ver_img">
                                <img alt="<spring:message code="required.captcha" />"
                                     onclick="this.src='captcha.jpg?'+Math.random()" src="captcha.jpg">
                            </div>
                        </div>
                    </c:if>

                    <a href="#"><button class="button" type="submit">立即登录</button></a>
                    <li><a href="#" onclick="iclogin();return false;">/ IC卡登录</a></li>
                    <a href="#" onclick="icRegister();return false;">IC卡注册</a>
                    <form:errors path="*" id="msg" cssClass="alert_tip" element="div" htmlEscape="false"/>
                    <input type="hidden" name="lt" value="${loginTicket}"/>
                    <input type="hidden" name="execution" value="${flowExecutionKey}"/>
                    <input type="hidden" name="_eventId" value="submit"/>
                </div>
                <!--w261_end-->
            </form:form>
        </div><!--login_box_end-->
    </div><!--outer_box_end-->
    <div class="footer_wh w1200">
        <div class="footer_filing"><img src="images/wheport_17.png" width="30" height="29" alt=""/>鄂公网安备42010302000532号<span>|</span>鄂ICP备15021604号-2</div>
        <div class="footer_unit">武汉新港管理委员会 （版权所有）<span>|</span>武汉电子口岸有限公司 （运营）<span>|</span>电话：400-188-0270</div>
    </div>
</div>


</body>
</html>
