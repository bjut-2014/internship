<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css"  rel="stylesheet" />
<link href="styles/practice.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
                 <li>
                    <a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a>
                </li>
                <li><a href=""><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                <li><a href=""><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>课程</a></li>
                  <li class="active"><a href="weekly-report"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>实习</a></li>
                <li><a href="graduate-weekly-report"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕设</a></li>
            </ul>
            <ul class="nav nav-sidebar reset-pwd-ul">
                <li><a href=""><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
            </ul>
        </div>
 <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <form action="weekly-report-update" method="post">

      <div class="row">
        <div class="form-horizontal">
          <div class="form-group">
            <label class="col-sm-2 control-label">题目：</label>
            <div class="col-sm-7">
              <input name="updateTitle"class="form-control" value=${request.updateReport.title}></input>
            </div>
          </div>
    
          <div class="form-group">
            <label class="col-sm-2 control-label">内容：</label>
            <div class="col-sm-7">
                <textarea name="updateContent" class="form-control" rows="20" placeholder="500个字以上">${request.updateReport.content}</textarea>
            </div>
          </div>
        </div>
        <input type="submit" class="btn btn-primary practical-reports-submit col-sm-offset-8" value="提交" />
      </div>
      </form>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>