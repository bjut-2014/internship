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
      <jsp:include page="../sidebar/sidebar-teacher.jsp" />
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div class="panel panel-default">
        <div class="panel-body">
          <p><b>标题：</b>${request.graduationWeeklyReport.title}</p>
          <p><b>内容：</b></p>
          <p>${request.graduationWeeklyReport.content}</p>
          <p><b>时间：</b>${request.graduationWeeklyReport.date}</p>
          <a href="teacher-graduation-weekly-report-all" class="btn btn-primary fr">返回</a>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>