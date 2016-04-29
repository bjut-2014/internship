<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css"  rel="stylesheet" />
<link href="styles/studentinfo.css" rel="stylesheet">
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active">
                    <a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a>
                </li>
                <li><a href="teacherinfo"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                <li><a href="teachercourses"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>课程</a></li>
                <li><a href=""><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>实习</a></li>
                <li><a href=""><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕设</a></li>
            </ul>
            <ul class="nav nav-sidebar reset-pwd-ul">
                <li><a href=""><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">           
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-notice">
                        <div class="panel-heading">
                            <h3 class="panel-title">基本信息  Basic Information</h3>                            
                        </div>
                        <table id="mytable" class="table table-striped">                       
                       <tbody>
                           <tr>
                              <td>职工号：</td>
                              <td></td>
                           </tr>
                           <tr>
                               <td>姓名：</td>
                               <td></td>
                           <tr>
                           		<td>性别：</td>
                                <td></td>
                           <tr>
                           		<td>职称：</td>
                           		<td></td>
                           	</tr>
                           	<tr>
                           		<td>专业方向：</td>
                           		<td></td>
                           	</tr>
                           	<tr>
                           		<td>联系方式：</td>
                           		<td></td>
                           	</tr>
                           	<tr>
                           		<td>邮箱：</td>
                           		<td></td>
                           	</tr>
                           </tbody>
                      </table>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-job">
                        <div class="panel-heading">
                            <h3 class="panel-title">个人动态  Personal Dynamics</h3>
                        </div>
                        <div class="panel-body panel-default">
                        	<div class="tab-pane active" id="user-activities">
                        		<div class="timeline-2">
                        			<div class="time-item">
                        				<div class="item-info">
                        					<div class="text-muted">2016年4月30日</div>
                        					<p>上传了《移动开发技术》案例库文件</p>
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
</body>
</html>