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
                <li class="active">
                    <a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a>
                </li>
                <li><a href="stu-info"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                <li><a href="course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>课程</a></li>
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
                                                    <th>老师</th>
                                                    <th>时间</th>
                                                    <th>地点</th>
                                                    <th>成绩</th>
                                                    <th class="position">案例库下载</th>
                                                    <th class="position">作业上传</th>
                                                </tr>
                                            </thead>

                                     
                                            <tbody>
                                               <s:iterator value="#request.comprehensiveCourseInfoList" var="info">
                                               <tr>
                                               		<td><s:property value="#info.course.name"/></td>
                                               		<td><s:property value="#info.teacherName"/></td>
                                               		<td><s:property value="#info.course.courseDate"/></td>
                                               		<td><s:property value="#info.course.coursePlace"/></td>
                                               		<td><s:property value="#info.stuScore"/></td>
                                               		<td><a href="scourseExample"><span class="fa fa-folder-open do"></span></a></td>
	                                           		<td>
	                                           			<label class="glyphicon glyphicon-open up"><input id="inputfile" style="display:none;" type="file"></input></label>
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