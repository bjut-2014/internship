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
      <div>题目：<input type="text" class="form-control" value=""></div>
      <div>实习时间：
        <div class="input-group date col-sm-3" data-provide="datepicker" data-date-format="yyyy/mm/dd">
          <input type="text" class="form-control">
          <div class="input-group-addon">
            <span class="glyphicon glyphicon-th"></span>
          </div>
        </div>至
        <div class="input-group date col-sm-3" data-provide="datepicker" data-date-format="yyyy/mm/dd">
          <input type="text" class="form-control">
          <div class="input-group-addon">
            <span class="glyphicon glyphicon-th"></span>
          </div>
        </div>
      </div>
      <div>实习单位：<input type="text" class="form-control" value=""></div>
      <div>实习部门：<input type="text" class="form-control" value=""></div>
      <div>实习地点：<input type="text" class="form-control" value=""></div>
      <div>实习总结：<textarea class="form-control" rows="5" placeholder="3000个字以上"></textarea></div>
      <button type="button" class="btn btn-primary fr practical-reports-submit">提交</button>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>