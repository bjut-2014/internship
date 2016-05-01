<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="nav nav-sidebar">
  <li class="<s:if test="#request.navId == 1">active</s:if>"><a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a></li>
  <li class="<s:if test="#request.navId == 2">active</s:if>"><a href=""><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
  <li class="<s:if test="#request.navId == 3">active</s:if>"><a href=""><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>课程</a></li>
  <li class="<s:if test="#request.navId == 4">active</s:if>"><a href=""><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>实习</a></li>
  <li class="<s:if test="#request.navId == 5">active</s:if>"><a href=""><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕设</a></li>
</ul>
<ul class="nav nav-sidebar reset-pwd-ul">
  <li class="<s:if test="#request.navId == 6">active</s:if>"><a href="resetPwd"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
</ul>