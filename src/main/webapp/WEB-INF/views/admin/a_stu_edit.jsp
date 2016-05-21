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
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form action="student-update" method="post">

					<div class="row">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">学号：</label>
								<div class="col-sm-7">
									<input name="updateSno" type="text" class="form-control" value=${request.updateStudent.sno }>

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">姓名：</label>
								<div class="col-sm-7">
									<input name="updateName" type="text" class="form-control" value=${request.updateStudent.name }>

								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">性别：</label>
								<div class="col-sm-7">
									<input name="updateSex" type="number" class="form-control" value=${request.updateStudent.sex }>
									<label class="control-label">请输入性别编号,1:男,2:女</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">年级：</label>
								<div class="col-sm-7">
									<input name="updateGrade" type="text" class="form-control" value=${request.updateStudent.grade }>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">班级：</label>
								<div class="col-sm-7">
									<input name="updateClasses" type="text" class="form-control" value=${request.updateStudent.classes }>

								</div>
							</div>


							<div class="form-group">
								<label class="col-sm-2 control-label">电话：</label>
								<div class="col-sm-7">
									<input name="updatePhone" type="text" class="form-control" value=${request.updateStudent.phone }>

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">邮件：</label>
								<div class="col-sm-7">
									<input name="updateEmail" type="email" class="form-control" value=${request.updateStudent.email }>

								</div>
							</div>




						</div>
						<input type="submit"
							class="btn btn-primary practical-reports-submit col-sm-offset-8"
							value="提交" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../footer/footer.jsp" />
</body>
</html>