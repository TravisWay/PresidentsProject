<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents SlideShow</title>
</head>
<h1>Presidents</h1>
<body>

<form action="president.do" method="POST">
	Term Number<input name="termNumber" type="number" min="1" max="45">
	<input type="submit" value ="submit">
	
</form>

<form action="president.do" method="POST">
<input type="submit" name="prevP" value ="prev">
</form>	

<form action="president.do" method="POST">
<input type="submit" name="nextP" value ="next">
</form>
	

${currentPresident}


</body>
</html>