<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css"  rel="stylesheet" />
<link href="styles/publishinfo.css" rel="stylesheet"/>
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="sidebar col-sm-3 col-md-2">
            <jsp:include page="../sidebar/sidebar-admin.jsp" />
        </div>   
    </div>
    
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 mymain">
    	
               <div class="row">
                <div class="col-sm-12">             	
                    <div class="panel panel-default">
                    	<div class="panel-heading">                  		
                    		<h3 class="panel-title">课程 Course
	                       		<a href="admin-show-add-course"><span class="fa fa-plus-square rplus"></span></a>
	                       	</h3>	                                               
	                 	  </div>
                    	
                    	<div class="panel-body">
                    	 
					      <table  class="table table-striped">
				              <tbody>
				                  <tr>
				                     <th class="rborder">课程名称</th>
				                     <th class="rborder">老师</th>
				                     <th class="rborder">时间</th>
				                     <th class="rborder">地点</th>
				                     <th class="thin-width">操作</th>                                                                                                      
				                  </tr>
				                  <s:iterator value="#request.courses" var="cou">
				                  <tr>
				                   <td class="rborder"><s:property value="#cou.name"/></td>
				                     <td class="rborder"><s:property value="#cou.teacher.name"/></td>
				                     <td class="rborder"><s:property value="#cou.courseDate"/></td>
				                     <td class="rborder"><s:property value="#cou.coursePlace"/></td>	
				                     <td>
				                         <a href="admin-show-update-course?courseId=<s:property value="#cou.courseId"/>""><span class="glyphicon glyphicon-pencil mypencil"></span></a>
                              			 <a href="admin-delete-course?courseId=<s:property value="#cou.courseId"/>"><span class="glyphicon glyphicon-trash mytrash"></span></a>
				                     </td>
				                     </tr>
				                  </s:iterator>
				                 </tbody>
				           </table>
					     </div>
                    	</div>
               		</div>
        		</div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>