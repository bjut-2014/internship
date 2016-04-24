<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<nav class="navbar navbar-fixed-top custom-navbar">--%>
  <%--<div class="container-fluid">--%>
    <%--<div class="navbar-header">--%>
      <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">--%>
        <%--<span class="sr-only">Toggle navigation</span>--%>
        <%--<span class="icon-bar"></span>--%>
        <%--<span class="icon-bar"></span>--%>
        <%--<span class="icon-bar"></span>--%>
      <%--</button>--%>
      <%--<a class="navbar-brand" href="index">嵌入式实训平台</a>--%>
    <%--</div>--%>
    <%--<div id="navbar" class="navbar-collapse collapse">--%>
      <%--<ul class="nav navbar-nav navbar-right">--%>
        <%--<li><a href="javascript:void(0)">您好，<s:property value="#session.currentUser.name" /></a></li>--%>
        <%--<li><a href="logout">注销</a></li>--%>
      <%--</ul>--%>
    <%--</div>--%>
  <%--</div>--%>
<%--</nav>--%>
<div class="nav-container">
    <div class="nav-title fl">嵌入式实训平台</div>
    <div class="nav-right fr">
        <span class="nav-hello">您好，${session.currentUser.name}</span>
        <a href="logout" class="logout"><span>注销</span></a>
    </div>
</div>