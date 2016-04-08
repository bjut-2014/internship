<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/student.css" rel="stylesheet">
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><a href="index">首页 <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="stu-info">个人信息</a></li>
        <li><a href="weekly-plan">周计划</a></li>
        <li><a href="practical-reports">实训报告</a></li>
        <li><a href="internship-reports">实习报告</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="reset-pwd">修改密码</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="panel panel-default">
            <div class="panel-body">
                <p>姓名：<s:property value="#session.currentUser.studentName" /></p>
                <p>学号：<s:property value="#session.currentUser.studentId"/></p>
                <p>校内导师：<s:if test="#session.currentUser.schoolTeacher==null">无</s:if><s:else><s:property value="#session.currentUser.schoolTeacher"/></s:else> </p>
                <p>校外导师：<s:if test="#session.currentUser.enterpriseTeacher==null">无</s:if><s:else><s:property value="#session.currentUser.enterpriseTeacher"/></s:else></p>
                <p>实习单位：<s:if test="#session.currentUser.practiceCompany==null">无</s:if><s:else><s:property value="#session.currentUser.practiceCompany"/></s:else></p>
                <p>实训成绩：<s:if test="#session.currentUser.studentScore==null">无</s:if><s:else><s:property value="#session.currentUser.studentScore"/></s:else></p>
            </div>
        </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>