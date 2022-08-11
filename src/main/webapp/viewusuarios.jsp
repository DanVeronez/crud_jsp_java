<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Visualização de Usuários</title>
	</head>
	
	<body>
		<%@ page import = "com.crudjspjava.dao.UsuarioDao, 
						   com.crudjspjava.bean.Usuario, 
						   java.util.*" %>
		
		<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
		
		<h1>Listagem de Usuários</h1>
		
		<%
			List<Usuario> list = UsuarioDao.pegarTodosOsUsuarios();
			request.setAttribute("list", list);
		%>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Password</th>
				<th>Email</th>
				<th>Sexo</th>
				<th>Pais</th>	
			</tr>
			
			<c:forEach items = "${list}" var = "usuario">
				<tr>
					<td>${usuario.getId()}</td>
					<td>${usuario.getNome()}</td>
					<td>${usuario.getPassword()}</td>
					<td>${usuario.getEmail()}</td>
					<td>${usuario.getSexo()}</td>
					<td>${usuario.getPais()}</td>	
				</tr>
			</c:forEach>
		</table>
		
	</body>
	
</html>