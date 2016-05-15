<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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

			<div
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain weekReport">
				<div class="panel panel-default myPanel weekReport1">
					<div class="panel-head">
						毕设选题信息 <a href="graduation-pro-sele-save"><button
								class="btn btn-default btn-sm myBu">
								<span class="glyphicon glyphicon-plus"></span>
							</button> </a>
					</div>
					<div class="panel-body">
						<s:if test="#request.AllSelectInfo!=null">
							<table class="table table-hover">
								<thead>
									<tr id="the">
										<th>学生学号</th>
										<th>教师编号</th>
										<th>毕设课题</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="#request.AllSelectInfo" var="list">
										<tr>
											<td>${list.sno}</td>
											<td>${list.tno }</td>
											<td>${list.GraduationProTitle }</td>
											<td><a
												href="graduation-pro-sele-edit?graduationProSeleId=${list.id}"><span
													class="glyphicon glyphicon-pencil Gl1"></span></a>
												<button type="button"
													class="glyphicon glyphicon-trash myPu graduation-pro-sele-del"
													data-toggle="modal" data-target="#GraduationProSeleDel"
													data-id=${list.id}></button></td>
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
	<div class="modal fade" id="GraduationProSeleDel" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" data-id>
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">确认要删除这条毕设选题信息吗？</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button"
						class="btn btn-primary graduation-pro-sele-del-confirm"
						data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="../footer/footer.jsp" />
	<script src="scripts/graduation-pro-sele.js"></script>
</body>
</html>