<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
        <jsp:include page="../sidebar/sidebar-teacher.jsp" />
        </div>
 
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="panel panel-default myPanel weekReport">
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                  <thead>
                     <tr id="the">
                        <th>标题</th>
                        <th>日期</th>
                        <th>查看</th>
                     </tr>
                  </thead>
                  <tbody>
                      <s:if test="#request.weeklyReportList!=null">
                       <s:iterator value="#request.weeklyReportList" var="list">
                      <tr>
                          <td>${list.title }</td>
                          <td>${list.date }</td>
                          <td><a href="teacher-weekly-report-view?weeklyReportId=${list.id }"><span class="glyphicon glyphicon-eye-open Gl2"></span></a></td>
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
</html>