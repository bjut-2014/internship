<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css"  rel="stylesheet" />
<link href="styles/studentinfo.css" rel="stylesheet">
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="sidebar">
            <jsp:include page="../sidebar/sidebar-student.jsp" />
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">           
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-notice">
                        <div class="panel-heading">
                            <h3 class="panel-title">基本信息  Basic Information</h3>                            
                        </div>
                        <table id="mytable" class="table table-striped">                       
                       <tbody>
                           <tr>
                              <td>学号：</td>
                              <td><s:property value="#session.currentUser.sno"/></td>
                           </tr>
                           <tr>
                               <td>姓名：</td>
                               <td><s:property value="#session.currentUser.name"/></td>
                           <tr>
                           		<td>性别：</td>
                                <td><s:if test="#session.currentUser.sex==1">男</s:if><s:else>女</s:else> </td>
                           <tr>
                           		<td>班级：</td>
                           		<td><s:property value="#session.currentUser.classes"/></td>
                           	</tr>
                           	<tr>
                           		<td>年级：</td>
                           		<td><s:property value="#session.currentUser.grade"/></td>
                           	</tr>
                           	<tr>
                           		<td>联系方式：</td>
                           		<td><s:property value="#session.currentUser.phone"/></td>
                           	</tr>
                           	<tr>
                           		<td>邮箱：</td>
                           		<td><s:property value="#session.currentUser.email"/></td>
                           	</tr>
                           </tbody>
                      </table>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-job">
                        <div class="panel-heading">
                            <h3 class="panel-title">个人动态  Personal Dynamics</h3>
                        </div>
                        <div class="panel-body panel-default">
                        <s:iterator value="#request.stuSyslogList" var="stuList">
                        	<div class="tab-pane active" id="user-activities">
                        		<div class="timeline-2">
                        			<div class="time-item">
                        				<div class="item-info">
                        					<div class="text-muted"><s:date format="yyyy-MM-dd HH:mm:ss" name="#stuList.date" /></div>
                        					<p><s:property value="#stuList.no"/><s:property value="#stuList.name"/><s:property value="#stuList.behavior"/></p>
                        				</div>
                        			</div>
                        		</div>
                        	</div>
                        </s:iterator>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>