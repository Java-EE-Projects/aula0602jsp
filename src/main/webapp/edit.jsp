<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
</head>
<body>

<%
	String key = (String) request.getAttribute("key");
	if(key == null) {
		key = "";
	}
	
	String value = (String) request.getAttribute("value");
	if(value == null) {
		value = "";
	}
%>


<center><h1>Editar</h1></center>

<form action="Save" method="post">
<table>
<tr>
	<td>Chave:</td>
	<td> <input type="text" name="key" value=" <%=key%>"></td>
</tr>
<tr>
	<td>Valor:</td>
	<td><input type="text" name="value" value=" <%=value%>"></td>
</tr>
<tr>
	<td colspan="2" align="right"><input type="submit" value="Salvar"></td>
</tr>
</table>
</form>
</body>
</html>