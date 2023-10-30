<%@page import="ProductManagement.ProductDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
  <form action="">
		<h1 align="center">Cart Details</h1>
		<table align="center" border="2" style="background-color: green;">
			<tr>
				<td>ProductName</td>
				<td>ProductDescription</td>
				<td>ProductPrice X ProductQuntity</td>
			<tr>
			<% 
				int totalPrice = 0;
				try{
					//HttpSession ses = request.getSession(false);
					ArrayList<ProductDetails> products = (ArrayList<ProductDetails>) session.getAttribute("products");
					for(ProductDetails product:products){
						totalPrice = totalPrice + product.getProductPrice() * product.getproductQuntity();
						%>
						<tr>
							<td><%= product.getProductName() %></td>
							<td><%= product.getProductDes() %></td>
							<td><%= product.getProductPrice() %> X <%= product.getproductQuntity() %></td>
							
						</tr>
						<%
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			%>
			<tr>
				<td colspan="3" align="right">TotalBill:<%= totalPrice %></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><button>Pay Bill</button></td>
			</tr>
		</table>
	</form>

</body>
</html>