<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
로그인 완료<br/>
<sec:authentication var="principal" property="principal" />
<br/>
<%-- 아이디 : <c:out value="${sessionScope.name}"/><br/> 
권한  : <c:out value="${sessionScope.Authorities}"/><br/> --%>

아이디 : <c:out value="${principal.username}"/><br/> 
 권한  : <c:out value="${principal.authorities}"/><br/>

${message}
<a href="<c:url value="/cms/logout" />">Logout</a>
</body>
</html>