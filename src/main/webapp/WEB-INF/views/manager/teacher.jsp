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
                    		<h3 class="panel-title">教师管理 Teacher Manage
                    			<a href="batch-import-tch"><span class="spanbtn">批量导入</span></a> 
	                       		<a href="admin-show-add-teacher"><span class="fa fa-plus-square rplus"></span></a>
	                       	</h3>	                                               
	                 	  </div>
                    	
                    	<div class="panel-body">
                    	 
					      <table  class="table table-striped">
				              <tbody>
				                  <tr>
				                     <th class="rborder">工号</th>
				                     <th class="rborder">老师姓名</th>
				                     <th class="rborder">性别</th>
				                     <th class="rborder">联系电话</th>
				                     <th class="rborder">电子邮件</th>
				                     <th class="rborder">方向</th>
				                     <th class="thin-width">操作</th>                                                                                                      
				                  </tr>
				                  <s:iterator value="#request.teachers" var="tch">
				                  <tr>
				                     <td class="rborder"><s:property value="#tch.tno" /></td>
				                     <td class="rborder"><s:property value="#tch.name" /></td>
				                     <td class="rborder"><s:if test="#tch.sex==2">女</s:if><s:else>男</s:else></td>
				                     <td class="rborder"><s:property value="#tch.phone" /></td>
				                     <td class="rborder"><s:property value="#tch.email" /></td>
				                     <td class="rborder"><s:property value="#tch.major" /></td>	
				                     <td>
				                         <a href="admin-show-update-tch?teacherId=<s:property value="#tch.teacherId"/>"><span class="glyphicon glyphicon-pencil mypencil"></span></a>
                              			 <s:if test="#tch.courses.size==0">
                              			 <a href="admin-delete-teacher?teacherId=<s:property value="#tch.teacherId"/>"><span class="glyphicon glyphicon-trash mytrash"></span></a>
				                    	</s:if>
				                    	<s:else>
				                    	<span>不能删</span>
				                    	</s:else>
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