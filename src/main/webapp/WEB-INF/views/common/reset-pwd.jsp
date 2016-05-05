<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/reset-pwd.css" rel="stylesheet">
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        	<s:if test="#session.currentUser.userType==3">
            	<jsp:include page="../sidebar/sidebar-student.jsp" />
            </s:if>
            <s:else>
            	<jsp:include page="../sidebar/sidebar-teacher.jsp" />
            </s:else>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <form action="resetPwd" method="post">
                        <div class="form-group">
                            <label>初始密码：</label>
                            <input name="password" type="password" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>新密码：</label>
                            <input name="newpwd" type="password" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>确认新密码：</label>
                            <input name="renewpwd" type="password" class="form-control">
                        </div>
                        <div class="submit-error"><s:actionerror/></div>
                        <input type="submit" class="btn btn-primary fr" value="确认修改"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>