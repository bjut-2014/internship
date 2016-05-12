<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css"  rel="stylesheet" />
<link href="styles/course.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <jsp:include page="../sidebar/sidebar-teacher.jsp" />
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
               <div class="wraper container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                        	<div class="panel-heading">
                        		<h3 class="panel-title">案例库 Case Base</h3>
                        	</div>                          
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12 rposition">                                     	                                    
	                                    	<div class="rposotion">
	                                	     	 <label class="fa fa-plus-square plus">
	                                	     	 	<input type="file" name="uploadfile" class="uploadfile"/>
	                                	     	 	<input type="hidden" name="courseId" value="<s:property value="#request.courseId" />">
	                                	     	 </label>
                                                 
	                                	     </div>                               	                               
                                        <table class="table table-striped" style="border: 1px solid #ddd;">
                                            <thead>
                                                <tr>
                                                    <th class="rborder">案 例 名 称</th>
                                                    <th class="rborder">日 期</th>
                                                                                                      
                                                </tr>
                                            </thead>

                                     
                                            <tbody>
                                            	<s:iterator value="#request.caseLibraries" var="cl">
                                               <tr>
                                               		<td class="rborder"><s:property value="#cl.name" /></td>
                                               		<td class="rborder position"><s:date format="yyyy-MM-dd" name="#cl.date" /></td>
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
<jsp:include page="../footer/footer.jsp" />
 <script src="scripts/tch-caselibrary-upload.js"></script>
</body>
</html>