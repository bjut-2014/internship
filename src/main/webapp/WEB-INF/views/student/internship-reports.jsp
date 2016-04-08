<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/bootstrap-datepicker.min.css" rel="stylesheet">
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
      <div class="row">
        <div class="form-horizontal">
          <div class="form-group">
            <label class="col-sm-2 control-label">题目：</label>
            <div class="col-sm-7">
              <input type="email" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">实习时间：</label>
            <div class="input-group date input-group-date col-sm-3 datepicker">
                <input type="text" class="form-control">
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-th"></i>
                </span>
            </div>
            <label class="col-sm-1 control-label control-label-to">至</label>
            <div class="input-group date col-sm-3 datepicker">
                <input type="text" class="form-control">
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-th"></i>
                </span>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">实习单位：</label>
            <div class="col-sm-7">
              <input type="email" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">实习部门：</label>
            <div class="col-sm-7">
              <input type="email" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">实习地点：</label>
            <div class="col-sm-7">
              <input type="email" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">实习总结：</label>
            <div class="col-sm-7">
                <textarea class="form-control" rows="5" placeholder="3000个字以上"></textarea>
            </div>
          </div>
        </div>
        <button type="button" class="btn btn-primary practical-reports-submit col-sm-offset-8">提交</button>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
<script src="scripts/bootstrap-datepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.datepicker').datepicker({
        autoclose: true,
        format: "yyyy/dd/mm",
        todayHighlight: true
    });
</script>
</body>
</html>