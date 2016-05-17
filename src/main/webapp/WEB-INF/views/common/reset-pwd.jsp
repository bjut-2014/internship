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
            <s:if test="#request.session.userType == 2">
                <ul class="nav nav-sidebar">
                    <li><a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a></li>
                    <li><a href="tch-info"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                    <li><a href="tch-course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>实训课程</a></li>
                    <li><a href="teacher-weekly-report"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>工作实习</a></li>
                    <li><a href="teacher-graduation-weekly-report"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕业设计</a></li>
                </ul>
            </s:if>
            <s:elseif test="#request.session.userType == 3">
                <ul class="nav nav-sidebar">
                    <li><a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a></li>
                    <li><a href="stu-info"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                    <li><a href="course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>实训课程</a></li>
                    <li><a href="weekly-report"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>工作实习</a></li>
                    <li><a href="graduate-weekly-report"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕业设计</a></li>
                </ul>
            </s:elseif>
            <s:elseif test="#request.session.userType == 1">
            <ul class="nav nav-sidebar">
                <li><a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a></li>
                <li><a href="publishInfo"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>发布信息</a></li>
                <li><a href="admin-course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>实训课程</a></li>
                <li><a href="graduation-pro-sele"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>毕业设计</a></li>
                <li><a href="internship-detail"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>工作实习</a></li>
                <li><a href="student"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span>学生管理</a></li>
                <li><a href="admin-teacher"><span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span>教师管理</a></li>
            </ul>
            </s:elseif>
            <ul class="nav nav-sidebar reset-pwd-ul">
                <li class="active"><a href="reset"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
            </ul>
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