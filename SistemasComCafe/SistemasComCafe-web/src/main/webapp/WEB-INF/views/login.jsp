<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<meta charset="utf-8" />
	<meta name="description" content="User login page" />
	<title>Acesso ao sistema - ${NOME_EMPRESA}</title>
</head>
<body>

tela de login - ${login_error}

	<form name='f' action='<c:url value="j_spring_security_check"/>' method='POST'>
		Usuário
		<input type="text" class="span12" style="text-transform:lowercase;" name='j_username' id='j_username' value=""/>
		
		<br>
		
		Senha:
		<input type="password" class="span12" name='j_password' id='j_password' value=""/>
		
		<br>
		
		<input type="submit" value="Submeter">
	</form>


</body>
</html>