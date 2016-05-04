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