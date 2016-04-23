<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="WEB-INF/views/header/header.jsp" />
<link href="styles/login.css" rel="stylesheet">
<body>
    <div class="login-container">
        <div class="login-content">
            <p class="title">嵌入式实训平台</p>
            <img src="/images/login/login-line.png" class="login-line"/>
			<div class="login-form-container">
				<div class="login-roles">
                    <div class="radio-inline">
                        <label class="cr-styled" for="example-radio4">
                            <input type="radio" id="example-radio4" name="example-radios1" value="option1" checked>
                            <i class="fa teacher"></i>老师
                        </label>
                    </div>
                    <div class="radio-inline">
                        <label class="cr-styled" for="example-radio5">
                            <input type="radio" id="example-radio5" name="example-radios1" value="option2">
                            <i class="fa"></i>学生
                        </label>
                    </div>
                    <div class="radio-inline">
                        <label class="cr-styled" for="example-radio6">
                            <input type="radio" id="example-radio6" name="example-radios1" value="option3">
                            <i class="fa"></i>企业
                        </label>
                    </div>
                </div>
                <form action="login" method="post">
                    <div class="login-form">
                        <div class="login-input-con">
                            <span class="user-icon"></span><input type="text" class="name" name="username" placeholder="用户名"/>
                        </div>
                        <div class="login-input-con">
                            <span class="pwd-icon"></span><input type="password" class="password" name="password" placeholder="密码"/>
                        </div>
                        <div class="login-input-con">
                            <input type="text" class="code" placeholder="验证码" name="verifyCode"/>
                            <a href="javascript:void(0)" class="code-link">
                                <img src="verifyCodeAction" class="code-img"/><span class="change-code">换一张</span>
                            </a>
                        </div>
                        <div class="login-checkbox checked"><span>记住密码</span></div>
                        <div class="login-error"><s:actionerror/></div>
                        <button class="login-bt">登&nbsp;录</button>
                    </div>
                </form>
			</div>
        </div>
    </div>
    <jsp:include page="WEB-INF/views/footer/footer.jsp" />
    <script src="scripts/login.js"></script>
</body>
</html>