
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int idade = (int) session.getAttribute("idade");
	%>

	<h3>
		SUA IDADE É:<%=idade%>
		<h3>

			<a href=calculo.html> Calcular Novamente</a> <br />
</body>
</html>