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
        <form action="graduation-pro-sele-update" method="post">

     <div class="row">
        <div class="form-horizontal">
          <div class="form-group">
            <label class="col-sm-2 control-label">学生学号：</label>
            <div class="col-sm-7">
              <input name="updateSno" type="text" class="form-control" value=${request.updateSelectInfo.sno }>
              
            </div>
          </div>
  
          
          <div class="form-group">
            <label class="col-sm-2 control-label">教师编号：</label>
            <div class="col-sm-7">
              <input name="updateTno" type="text" class="form-control" value=${request.updateSelectInfo.tno }>
              
            </div>
          </div>
    
    
    <div class="form-group">
            <label class="col-sm-2 control-label">毕设课题：</label>
            <div class="col-sm-7">
              <input name="updateGraduationProTitle" type="text" class="form-control" value=${request.updateSelectInfo.GraduationProSele }>
              
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