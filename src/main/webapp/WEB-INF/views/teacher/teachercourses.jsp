<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/courses.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li>
                    <a href="tch-index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a>
                </li>
                <li><a href="tch-info"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                <li class="active"><a href="tch-course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>课程</a></li>
                <li><a href=""><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>实习</a></li>
                <li><a href=""><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕设</a></li>
            </ul>
            <ul class="nav nav-sidebar reset-pwd-ul">
                <li><a href=""><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                </ol>

               
               <div class="wraper container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">                          
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <table id="mytable" class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>课程名称</th>                                                   
                                                    <th>时间</th>
                                                    <th>地点</th>                                                   
                                                    <th class="position">案例库上传</th>
                                                    <th class="position">作业下载</th>
                                                </tr>
                                            </thead>

                                     
                                            <tbody>
                                            	<s:iterator value="#request.tchCourseList" var="tchList">
                                            	<tr>
                                            		<td><s:property value="#tchList.name"/></td>
                                            		<td><s:property value="#tchList.courseDate"/></td>
                                            		<td><s:property value="#tchList.coursePlace"/></td>
                                            		<td><a href="tcourseExample?courseId=<s:property value="#tchList.courseId" />"><span class="glyphicon glyphicon-open tup"></span></a></td>
	                                           		<td>
	                                           			<a href="thomework?courseId=<s:property value="#tchList.courseId" />"><span class="glyphicon glyphicon-save tdo"></span></a>	                                           			                                       		
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
             </div>
</div>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp" />
<script src="scripts/lib/dropzone.js"></script>
</body>
</html>