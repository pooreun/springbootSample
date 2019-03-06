<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">
<head>
<title>cms</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script>

</script>
</head>
<body>
<div>
	
	<h1><spring:message code="login.title" /></h1>
	
	<h2>로그인 폼</h2>
	<form action="/cms/loginProcessing" method="post">
		<input type="text" name="username" placeholder="계정" required="required"/>
		<input type="password" name="password" placeholder="암호" required="required"/>
		<input type="submit" value="로그인"/>
	</form>
	
	<br/>
	
	<c:if test="${not empty sessionScope.message}">
    	<span style="color:green"><c:out value="${sessionScope.message}"/></span>
    	<c:remove var="message" scope="session" />
  	</c:if>
</div>
</body>
</html>