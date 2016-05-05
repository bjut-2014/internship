<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css"  rel="stylesheet" />
<link href="styles/t_internship1.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <jsp:include page="../sidebar/sidebar-teacher.jsp" />
        </div>
 
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="panel panel-default myPanel weekReport">
            <div class="panel-head">实习</div>
            <div class="panel-body">
               <table class="table table-bordered">
             
                  <thead>
                     <tr id="the">
                        <th>学号</th>
                        <th>姓名</th>
                        <th>周报</th>
                        <th>实习报告</th>
                     </tr>
                  </thead>
                  <tbody>
                  <s:if test="#request.students!=null">
                  <s:iterator value="#request.students" var="list">
                  	
                      <tr>
                          <td>${list.sno }</td>
                          <td>${list.name}</td>
                          <td>
                          <a href="teacher-weekly-report-all?studentId=${list.sno}"><span class="glyphicon glyphicon-eye-open Gl2"></span></a></td>
                    	  <td>
                    	  <a href="internship-report-download?studentId=${list.sno }"><span class="glyphicon glyphicon-save myPu"></span></a>
                    	  </td>
                       </tr>
                       
                       </s:iterator>
                  
                       </s:if>
                       
                 </tbody>
               </table>             
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>