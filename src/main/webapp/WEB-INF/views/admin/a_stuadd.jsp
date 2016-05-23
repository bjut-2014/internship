<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<body>
	<jsp:include page="../nav/nav.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<jsp:include page="../sidebar/sidebar-admin.jsp" />
				<ul class="nav nav-sidebar reset-pwd-ul">
					<li><a href="resetPwd"><span
							class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form action="student-add" method="post">

					<div class="row">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">学号：</label>
								<div class="col-sm-7">
									<input name="addSno" type="text" class="form-control">

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">姓名：</label>
								<div class="col-sm-7">
									<input name="addName" type="text" class="form-control">

								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">性别：</label>
								<div class="col-sm-7">
									<input name="addSex" type="number" class="form-control">
									<label class="col-sm-2 control-label">请输入性别编号,1:男,2:女</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">年级：</label>
								<div class="col-sm-7">
									<input name="addGrade" type="text" class="form-control">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">班级：</label>
								<div class="col-sm-7">
									<input name="addClasses" type="text" class="form-control">

								</div>
							</div>


							<div class="form-group">
								<label class="col-sm-2 control-label">电话：</label>
								<div class="col-sm-7">
									<input name="addPhone" type="text" class="form-control">

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">邮件：</label>
								<div class="col-sm-7">
									<input name="addEmail" type="email" class="form-control">

								</div>
							</div>




						</div>
						<input type="submit"
							class="btn btn-primary col-sm-offset-8"
							value="提交" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../footer/footer.jsp" />
</body>
</html>