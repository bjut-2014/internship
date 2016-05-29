<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/manage.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <jsp:include page="../sidebar/sidebar-admin.jsp" />
    </div>

      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain weekReport">
        <div class="panel panel-default myPanel">
            <div class="panel-head">实习信息 Internship Information
                <a href="internship-detail-save"><button class="glyphicon glyphicon-plus myBu"></button></a>
            </div>
            <div class="panel-body">
                <s:if test="#request.AllInternshipDetails!=null">
                <table class="table table-striped">
             
                  <thead>
                     <tr id="the">
                        <th>学生学号</th>
                        <th>实习时间</th>
                        <th>公司名称</th>
                        <th>校外导师</th>
                        <th>实习分数</th>
                        <th>操作</th>
                     </tr>
                  </thead>
                  <tbody>
                      <s:iterator value="#request.AllInternshipDetails" var="list">
                          <tr>
                              <td>${list.sno}</td>
                              <td>${list.date }</td>
                              <td>${list.company_name}</td>
                              <td>${list.company_teacher }</td>
                              <td>${list.score }</td>
                              <td>
                              <a href="internship-detail-edit?internshipDetailId=${list.id}"><span class="glyphicon glyphicon-pencil Gl1"></span></a>
                              <button type="button" class="glyphicon glyphicon-trash myPu internship-detail-del" data-toggle="modal" data-target="#InternshipDetailDel" data-id=${list.id}></button>
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
</div>

<%--删除弹窗--%>
<div class="modal fade" id="InternshipDetailDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-id>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">确认要删除这条实习信息吗？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary internship-detail-del-confirm"  data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../footer/footer.jsp" />
<script src="scripts/internship-detail.js"></script>
</body>
</html>