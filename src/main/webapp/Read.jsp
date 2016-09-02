<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.beerfun.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, shrink-to-fit=no, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

</head>

<body>

	<table>
		<tr>
			<th></th>
		</tr>
		<%
			DAO.readFromDB();

			Beer readToJSP = new Beer();
			for (int i = 0; i < DAO.ourBeers.size(); i++) {
				readToJSP = DAO.ourBeers.get(i);
		%>
		<tr>
			<td><%=readToJSP.getName()%></td>
			<td><%=readToJSP.getBrewer()%></td>
			<td><%=readToJSP.getStyle()%></td>
			<td><%=readToJSP.getAbv()%></td>
		</tr>
		<%
			}
			DAO.ourBeers.clear();
		%>
	</table>






</body>
</html>