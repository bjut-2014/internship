<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css"  rel="stylesheet" />
<link href="styles/manage.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <jsp:include page="../sidebar/sidebar-admin.jsp" />
    </div>
  
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain weekReport">
        <div class="panel panel-default myPanel weekReport1">
            <div class="panel-head">学生管理
          <button class="btn btn-default btn-sm myPi">批量导入</button>
          <a href="student-save"><button class="btn btn-default btn-sm myBu"><span class="glyphicon glyphicon-plus"></span></button></a></div>
            <div class="panel-body">
                <s:if test="#request.students!=null">
                <table class="table table-hover">
                  <thead>
                     <tr id="the">
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>年级</th>
                        <th>班级</th>
                        <th>操作</th>
                     </tr>
                  </thead>
                  <tbody>
                  <s:iterator value="#request.students" var="list">
                      <tr>
                          <td><a href="student-view?studentId=${list.id}">${list.sno}</a></td>
                          <td>${list.name }</td>
                          <td>${list.sex }</td>
                          <td>${list.grade }</td>
                          <td>${list.classes }</td>
                          <td>
                          <a href="student-edit?studentId=${list.id}"><span class="glyphicon glyphicon-pencil Gl1"></span></a>
                          <button type="button" class="glyphicon glyphicon-trash myPu student-del" data-toggle="modal" data-target="#StudentDel" data-id=${list.id}></button>
                    	  
                    	  </td>
                       </tr>
                       </s:iterator>
                     </tbody>
               </table>
                </s:if>
            </div>
        </div>
    </div>
</div>


<%--删除弹窗--%>
<div class="modal fade" id="StudentDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-id>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">确认要删除这名学生的信息吗？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary student-del-confirm"  data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../footer/footer.jsp" />
<script src="scripts/student-del.js"></script>
</body>
</html>