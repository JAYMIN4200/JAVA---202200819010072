<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdatePage</title>
</head>
<body>
<form action="ProductUpdate?id=<%= request.getParameter("id") %>">
		<h1 align="center">Update Product</h1>
		<table align="center">
			<tr>
				<td>id:</td>
				<td><input type="text" name="id" value="<%= request.getParameter("id") %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>ProductName:</td>
				<td><input type="text" name="productName" ></td>
			</tr>
			<tr>
				<td>ProductDescription:</td>
				<td><input type="text" name="productDes" ></td>
			</tr>
			<tr>
				<td>ProductPrice:</td>
				<td><input type="text" name="productPrice" ></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" ></td>
			</tr>
		</table>
	</form>
</body>
</html>
