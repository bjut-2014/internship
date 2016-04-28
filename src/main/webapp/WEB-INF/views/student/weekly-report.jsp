<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/student.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                 <li>
                    <a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a>
                </li>
                <li><a href=""><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                <li><a href=""><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>课程</a></li>
                  <li class="active"><a href="weekly-report"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>实习</a></li>
                <li><a href=""><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕设</a></li>
            </ul>
            <ul class="nav nav-sidebar reset-pwd-ul">
                <li><a href=""><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
            </ul>
       
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain practiceInmation">
    
        <div class="panel panel-default myPanel">
            <div class="panel-head">实习信息 Practice Information</div>
            <div class="panel-body">
                <p>一堆实习信息啦啦啦</p>
                <!--<s:property value="#session.currentUser.studentName" />  -->
            </div>
        </div>
    </div>
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="panel panel-default myPanel weekReport">
            <div class="panel-head">周报 week Report<button class="glyphicon glyphicon-plus myBu"></button></div>
            <div class="panel-body">
                <table class="table weekTable">
                  <thead>
                     <tr id="the">
                        <th>标题</th>
                        <th>时间</th>
                        <th>操作</th>
                     </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>Tanmay</td>
                          <td>Bangalore</td>
                          <td><span class="glyphicon glyphicon-pencil Gl1"></span><span class="glyphicon glyphicon-trash Gl"></span></td>
                       </tr>
                      <tr>
                          <td>Tanmay</td>
                          <td>Bangalore</td>
                          <td><span class="glyphicon glyphicon-pencil Gl1"></span><span class="glyphicon glyphicon-trash Gl"></span></td>
                       </tr>
                 </tbody>
               </table>             
            </div>
        </div>
    </div>
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="panel panel-default myPanel practiceRerort">
            <div class="panel-head">实习报告 Practice Report</div>
            <div class="panel-body">
                <p>您的实习报告还未提交</p>
                <button class="myBu">提交报告</button>
            </div>
        </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>