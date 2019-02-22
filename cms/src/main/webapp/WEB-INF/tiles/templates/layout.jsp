<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<!DOCTYPE html>
<!--[if IEMobile 7]><html class="no-js iem7 oldie"><![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js ie7 oldie" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js ie8 oldie" lang="en"><![endif]-->
<!--[if (IE 9)&!(IEMobile)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|(gt IEMobile 7)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<t:insertAttribute name="meta"></t:insertAttribute>
<%-- <t:insertAttribute name="js"></t:insertAttribute> --%>
<%-- <t:insertAttribute name="css"></t:insertAttribute> --%>
</head>
<body>
	<t:insertAttribute name="header"></t:insertAttribute>
	<t:insertAttribute name="content"></t:insertAttribute>
	<t:insertAttribute name="footer"></t:insertAttribute>
</body>
</html>