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
                <div class="login-form">
                    <div class="login-input-con"><span class="user-icon"></span><input type="text" class="name" placeholder="用户名"/></div>
                    <div class="login-input-con"><span class="pwd-icon"></span><input type="password" class="password" placeholder="密码"/></div>
                    <div class="login-input-con">
                        <input type="text" class="code"/>
                        <a href="" class="code-link">
                            <img src="" class="code-img"/><span class="change-code">换一张</span>
                        </a>
                    </div>
                    <div class="login-checkbox unchecked"><span>记住密码</span></div>
                    <button class="login-bt">登录</button>
                </div>
			</div>
        </div>
    </div>
    <jsp:include page="WEB-INF/views/footer/footer.jsp" />
    <script src="scripts/login.js"></script>
</body>
</html>