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
				<form action="internship-detail-update" method="post">

					<div class="row">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">学生学号：</label>
								<div class="col-sm-7">
									<input name="update_sno" type="text" class="form-control" value=${request.updateOneInternshipDetail.sno }>

								</div>
							</div>


							<div class="form-group">
								<label class="col-sm-2 control-label">实习时间：</label>
								<div class="col-sm-7">
									<input name="update_date" type="date" class="form-control" value=${request.updateOneInternshipDetail.date }>

								</div>
							</div>


							<div class="form-group">
								<label class="col-sm-2 control-label">公司名称：</label>
								<div class="col-sm-7">
									<input name="update_companyName" type="text" class="form-control" value=${request.updateOneInternshipDetail.company_name }>

								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">公司地址：</label>
								<div class="col-sm-7">
									<input name="update_companyAddress" type="text" class="form-control" value=${request.updateOneInternshipDetail.company_address }>

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">校外导师：</label>
								<div class="col-sm-7">
									<input name="update_companyTeacher" type="text" class="form-control" value=${request.updateOneInternshipDetail.company_teacher }>

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">实习分数：</label>
								<div class="col-sm-7">
									<input name="update_score" type="text" class="form-control" value=${request.updateOneInternshipDetail.score }>

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