<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav-container navbar-fixed-top">
    <a href="index" class="nav-title fl">嵌入式实训平台</a>
    <div class="nav-right fr">
        <span class="nav-hello">您好，<s:if test="#request.session.userType == 1">${session.currentUser.username}</s:if><s:else>${session.currentUser.name}</s:else></span>
        <s:if test="#request.session.userType == 1"><a href="adminLogout" class="logout"><span>注销</span></a></s:if><s:else><a href="logout" class="logout"><span>注销</span></a></s:else>
    </div>
</div>