<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UploadInternshipReport.jsp' starting page</title>
   
  </head>
  
  <body>
   <h2>上传报告</h2>
   <form action="upload" method="post" enctype="multipart/form-data">
   	<input name="upload" type="file"/><br>
   	<input type="submit" value="上传报告">
   </form>
  </body>
</html>
