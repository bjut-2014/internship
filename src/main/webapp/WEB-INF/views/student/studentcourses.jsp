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
            <jsp:include page="../sidebar/sidebar-student.jsp" />
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
                                            <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td><label class="glyphicon glyphicon-open up"> 
 			                                    <input id="inputfile" name="uploadFile" style="display:none;" type="file" onchange="upload(this)" /> 
 			                                 </label> </td>
                                            </tr>
                                            <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td><label class="glyphicon glyphicon-open up"> 
 			                                    <input id="inputfile" name="uploadFile" style="display:none;" type="file" onchange="upload(this)" /> 
 			                                 </label></td>
                                            </tr>
                                               <s:iterator value="#request.comprehensiveCourseInfoList" var="info">
                                               <tr>
                                               
                                               		<td><s:property value="#info.course.name"/></td>
                                               		<td><s:property value="#info.teacherName"/></td>
                                               		<td><s:property value="#info.course.courseDate"/></td>
                                               		<td><s:property value="#info.course.coursePlace"/></td>
                                               		<td><s:property value="#info.stuScore"/></td>
                                               		<td><a href="scourseExample?courseId=<s:property value="#info.course.courseId" />"><span class="fa fa-folder-open do"></span></a></td>
	                                           		<td> 
	                                           			<s:if test="#info.homework==null"> 
 	                                           			<!--<s:form action="uploadHomework" enctype="multipart/form-data" method="post">--> 
	                                           				<!--<label class="glyphicon glyphicon-open up"><input id="inputfile" name="uploadFile" style="display:none;" type="file" onchange="upload()" /></label>--> 
 	                                           			<!--</s:form>--> 
 		                                           			<s:form action="uploadHomework" enctype="multipart/form-data" method="post"> 
 		                                           				<s:file name="upload" label="选择文件" /> 
 		                                           				<input type="hidden" name="courseId" value='<s:property value="#info.course.courseId" />' /> 
 																<s:submit value="上传"/> 
 		                                           			</s:form> 
 		                                           			<!--<td> 
 			                                           			<label class="glyphicon glyphicon-open up"> 
 			                                           				<input id="inputfile" name="uploadFile" style="display:none;" type="file" onchange="upload(this)" /> 
 			                                           			</label> 
 		                                           			</td>--> 
 	                                           			</s:if> 
 	                                           			<s:else> 
 	                                           				<a href="#info.homework.title.path"><s:property value="#info.homework.title" /></a> 
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
             </div>
</div>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp" />
 <script src="scripts/studentupload.js"></script>
</body>
</html>