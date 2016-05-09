<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav-container navbar-fixed-top">
    <a href="index" class="nav-title fl col-md-2">嵌入式实训平台</a>
    <div class="nav-right fr">
        <span class="nav-hello">您好，${session.currentUser.name}</span>
        <a href="logout" class="logout"><span>注销</span></a>
    </div>
</div>