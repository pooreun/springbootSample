<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<html lang="ko">
<head>
    <title>CMS</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="No-Cache"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>

</head>
<!--<![endif]-->

<body>
<%-- <t:insertAttribute name="css"></t:insertAttribute> --%>
	<t:insertAttribute name="meta"></t:insertAttribute>
	<t:insertAttribute name="js"></t:insertAttribute>
	<t:insertAttribute name="header"></t:insertAttribute>
	<t:insertAttribute name="content"></t:insertAttribute>
	<t:insertAttribute name="footer"></t:insertAttribute>
</body>
</html>