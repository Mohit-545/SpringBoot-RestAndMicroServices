<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<body>
	
		<h1 style="color: blue; text-align: center"><u>Loan Approval Page</u></h1><br>
		<h2 style="color: green; text-align: center"><b>
		Your Loan has been approved for amount :: <%= new Random().nextInt(1000000)%></b>
		</h2><br>
		
		<h2 style="text-align: center"><a href="./">Home</a></h2><br>
		<h2 style="text-align: center"><a href="signout">Log Out</a></h2>
</body>
</html>