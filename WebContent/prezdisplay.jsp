<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents SlideShow</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<h1>Presidents</h1>
<body>
<form action="president.do" method="POST">
<<<<<<< HEAD
	Term Number <input name="termNumber" type="number" min="1" max="45">
  <input type="submit" value ="submit">

</form>
<br><br><br><br>
<form action="president.do" method="POST">
<input type="submit" name="prevP" value ="prev">
</form>

<form action="president.do" method="POST">
=======
	Term Number<input name="termNumber" type="number" min="1" max="45">
	<input type="submit" value ="submit">
<input type="submit" name="prevP" value ="prev">
>>>>>>> 5be3d38eb323defd0b65076e19f748521f302a3a
<input type="submit" name="nextP" value ="next">
	
</form>

<<<<<<< HEAD
=======
	
>>>>>>> 5be3d38eb323defd0b65076e19f748521f302a3a

${currentPresident}


</body>
</html>
