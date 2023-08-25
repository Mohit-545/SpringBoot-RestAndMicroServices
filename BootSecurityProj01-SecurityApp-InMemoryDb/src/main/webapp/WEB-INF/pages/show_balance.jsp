<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<body>

		<h1 style="color: blue; text-align: center"><u>Customer Balance Page</u></h1><br>
		<h2 style="color: green; text-align: center"> Current Account Balance :: 
		<%= new Random().nextInt(10000000) %>
		</h2><br>
		
		<h2 style="text-align: center"><a href="./" >Home</a></h2><br>
		<h2 style="text-align: center"><a href="signout">Log Out</a></h2>

</body>
</html>