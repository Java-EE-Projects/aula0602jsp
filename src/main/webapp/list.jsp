<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propriedades</title>
</head>
<body>

<%
	@SuppressWarnings("unchecked")
	Map<String, String> props = (Map<String, String>) request.getAttribute("props");
	//System.out.println(props);
%>

<CENTER><h1>Propriedades</h1></CENTER>

<a href="Edit">Criar uma nova Propriedade</a>
<br><br>
<table border="1" width="100%">
 <tr>
 	<td align="center"><strong>Propriedades</strong></td>
 	<td align="center"><strong>Valor</strong></td>
 	<td colspan="2"></td>
 </tr>
 
 
 <% if(props != null ) { %>
	 <% for(Map.Entry<String, String> entry : props.entrySet()) { %>
	 	<tr>
	 		<td align="center"> <%= entry.getKey() %> </td>
	 		<td align="center"> <%= entry.getValue() %> </td>
	 		<td align="center"> <a href="Edit?key=<%=entry.getKey()%>">Editar</a></td>
	 		<td align="center"> <a href="Delete?key=<%=entry.getKey()%>">Excluir</a></td>
	 	</tr>
	  <% } %>
	  <% System.out.println("Listou registros"); %>
 <% } else { %>
 	<p>Nenhuma propriedade disponível. props é null</p>
 <% } %>
 
 </table>

</body>
</html>