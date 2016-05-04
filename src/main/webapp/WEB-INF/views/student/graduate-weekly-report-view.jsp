<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <jsp:include page="../sidebar/sidebar-student.jsp" />
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div class="panel panel-default">
        <div class="panel-body">
          <p><b>标题：</b>${request.oneWeeklyReport.title}</p>
          <p><b>内容：</b></p>
          <p>${request.oneWeeklyReport.content}</p>
          <p><b>时间：</b>${request.oneWeeklyReport.date}</p>
          <a href="graduate-weekly-report" class="btn btn-primary fr">返回</a>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>