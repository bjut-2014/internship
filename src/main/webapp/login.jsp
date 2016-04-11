<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="WEB-INF/views/header/header.jsp" />
<link href="styles/student.css" rel="stylesheet">
<script src="scripts/jquery.min.js" type="text/javascript"></script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h3>嵌入式实训平台</h3>
				<form action="login" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">用户名：</label> <input type="text"
							class="form-control" name="username" id="exampleInputEmail1">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">密码：</label> <input
							type="password" class="form-control" name="password"
							id="exampleInputPassword1">
					</div>
					<div class="form-group">
                        <label>验证码：</label><br>
                        <input type="text" class="form-control captcha" name="checkCode">
                        <a class="captcha-link" href="javascript:void(0);">
                            <img src="createImageAction" class="captcha-img">&nbsp;&nbsp;&nbsp;&nbsp;换一张
                        </a>
					</div>
					<%--<div class="checkbox">--%>
						<%--<label> <input type="checkbox"> 记住密码--%>
						<%--</label>--%>
					<%--</div>--%>
					<s:actionerror cssStyle="color:red" />
					<button type="submit" class="btn btn-primary fr">登录</button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="WEB-INF/views/footer/footer.jsp" />
	<script src="scripts/login.js"></script>
</body>
</html>