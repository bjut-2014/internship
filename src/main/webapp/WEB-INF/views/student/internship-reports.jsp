<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
        <li><a href="stu-info">个人信息</a></li>
        <li><a href="weekly-plan">周计划</a></li>
        <li><a href="practical-reports">实训报告</a></li>
        <li class="active"><a href="internship-reports">实习报告</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="reset-pwd">修改密码</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <%--没有实习报告--%>
        <div class="jumbotron">
            <h2>暂时没有实习报告</h2>
            <p><a class="btn btn-primary" href="/internship-reports-add">添加</a></p>
        </div>
        <%--有实习报告--%>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-body">
                    <p><b>题目：</b>${request.internshipReport.internshipreportTitle}</p>
                    <p><b>实习时间：</b>${request.internshipReport.internshipBeginTime}至${request.internshipReport.internshipEndTime}</p>
                    <p><b>实习单位：</b>${request.internshipReport.internshipCompany}</p>
                    <p><b>实习部门：</b>${request.internshipReport.internshipDepartment}</p>
                    <p><b>实习地点：</b>${request.internshipReport.internshipPlace}</p>
                    <p><b>实习总结：</b></p>
                    <p>${request.internshipReport.internshipSummary}</p>
                    <a href="/internship-reports-edit" class="btn btn-primary internship-reports-edit col-sm-offset-8">修改</a>
                </div>
            </div>
        </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>