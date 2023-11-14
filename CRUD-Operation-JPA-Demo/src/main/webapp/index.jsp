<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h2>Enter details to Add in Database</h2>
<form action="addUser">

Enter id:<input type="text" name="id"><br>
<br>
Enter name::<input type="text" name="name"><br><br>

<input type="submit" value="submit">
</form>
<h2>Display User Information</h2>
<form action="getUser">
Enter id:<input type="text" name="id"><br>
<br>

<input type="submit" value="submit">
</form> 

<h2>Enter details to delete</h2>

<form action="deleteUser">
Enter id:<input type="text" name="id"><br>
<br>

<input type="submit" value="submit">
</form>

<h2>Enter details to Update</h2>

<form action="updateUser">
Enter id:<input type="text" name="id"><br>
<br>

<input type="submit" value="submit">
</form>
</body>
</html>