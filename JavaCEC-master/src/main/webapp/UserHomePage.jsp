<%@page import="ProductManagement.ProductDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
</head>
<body>
<form action="">
		<h1 align="center">Product Details</h1>
		<table align="center" border="2" style="background-color: blue;">
			<tr>
				<td>ProductID</td>
				<td>ProductName</td>
				<td>ProductDescription</td>
				<td>ProductPrice</td>
				<td>ProductDetails</td>
			<tr>
			<% 
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4306/javaproject", "root", "");
					Statement st = con.createStatement();
					String query = "select * from product";
					ResultSet rs = st.executeQuery(query);
					
					while(rs.next()){
						%>
						<tr>
							<td><%= rs.getInt(1) %></td>
							<td><%= rs.getString(2) %></td>
							<td><%= rs.getString(3) %></td>
							<td><%= rs.getString(4) %></td>
							<td><a href="AddToCart?id=<%= rs.getInt(1) %>">AddToCart</a></td>
						</tr>
						<%
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			%>
		</table>
		<a href="ViewCart.jsp">ViewCart</a>
	</form>
</body>
</html>
