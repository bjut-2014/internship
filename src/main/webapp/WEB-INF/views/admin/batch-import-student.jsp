<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css" rel="stylesheet" />
<link href="styles/publishinfo.css" rel="stylesheet" />
<body>
	<jsp:include page="../nav/nav.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="sidebar">
				<jsp:include page="../sidebar/sidebar-admin.jsp" />
			</div>
		</div>

		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 mymain">

			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								学生管理 Teacher Manage 
							</h3>
						</div>

						<div class="panel-body">

							<div>
								文件格式：xls<br>
								文件内容格式：学号、姓名、性别、年级、班级<br>
							</div>
								
							<hr/>
							
							<form action="upload-stu-excel" enctype="multipart/form-data" method="post">
								<s:file name="upload" label="选择文件"/>
								<input type="submit" value="提交"/>
							</form>

							<table class="table table-striped">
								<tbody>
									<tr>
										<th class="rborder">学号</th>
										<th class="rborder">姓名</th>
										<th class="rborder">性别</th>
										<th class="rborder">年级</th>
										<th class="rborder">班级</th>
									</tr>
									<s:iterator value="#session.students" var="stu">
										<tr>
											<td class="rborder"><s:property value="#stu.sno" /></td>
											<td class="rborder"><s:property value="#stu.name" /></td>
											<td class="rborder"><s:if test="#stu.sex==2">女</s:if>
												<s:else>男</s:else></td>
											<td class="rborder"><s:property value="#stu.grade" /></td>
											<td class="rborder"><s:property value="#stu.classes" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
							<form action="import-stu" method="post">
								<input type="submit" value="导入">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer/footer.jsp" />
</body>
</html>