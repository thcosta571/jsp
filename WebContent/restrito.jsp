
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!Date data = new Date();%>
	<h1>Ola:</h1>

	<h3><%=request.getAttribute("usuario").toString()%></h3>
	<h2>Voce acessou um area restrita em:</h2>
	<h1><%=new Date()%></h1>
	<h1>
		<a href=calculo.html> Calcular idade</a>
	</h1>

	<a href=invalidar.jsp> Logout</a>


</body>
</html>