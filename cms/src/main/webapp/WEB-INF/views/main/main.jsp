<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<spring:message code="login.completed" />
	<br />
	<sec:authentication var="principal" property="principal" />
	<br />
	<%-- 아이디 : <c:out value="${sessionScope.name}"/><br/> 
권한  : <c:out value="${sessionScope.Authorities}"/><br/> --%>

	아이디 :
	<c:out value="${principal.username}" />
	<br /> 권한 :
	<c:out value="${principal.authorities}" />
	<br />
	<br /> ${message}
	<br />
	<br />

	<a href="/cms/main?lang=en">영문</a>
	<a href="/cms/main?lang=ko">한글</a>
	<br />

	<a href="<c:url value="/template/temp" />">Website Page Builder</a><br/>
	<a href="<c:url value="/template/webbuilder" />">Website Page Builder 2</a><br/>

	<a href="<c:url value="/cms/logout" />">Logout</a>
</body>
</html>