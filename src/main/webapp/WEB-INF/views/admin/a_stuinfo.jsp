<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <jsp:include page="../sidebar/sidebar-admin.jsp" />
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div class="panel panel-default">
        <div class="panel-body">
          <p><b>学号：</b>${request.oneStudent.sno}</p>
          <p><b>姓名：</b>${request.oneStudent.name}</p>
          <p><b>性别：</b>${request.oneStudent.sex}</p>
          <p><b>年级：</b>${request.oneStudent.classes}</p>
          <p><b>班级：</b>${request.oneStudent.grade}</p>
          <p><b>电话：</b>${request.oneStudent.phone}</p>
          <p><b>邮件：</b>${request.oneStudent.email}</p>
          
          
          <a href="student" class="btn btn-primary fr">返回</a>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>