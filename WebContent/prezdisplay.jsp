<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents SlideShow</title>
<!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class ="all">
<div class ="col">

<h1>Presidents</h1>


<br><br><br><br><br><br><br><br>
<div class= "presdetails">

<img src="${currentPresident.img}"><br><br><br>
${currentPresident.name}<br>
${currentPresident.startYear} - ${currentPresident.endYear}<br>
${currentPresident.party}<br>
${currentPresident.fact}<br>
<br>

<div class="iform">
<form action="president.do" method="POST">
<input type="submit" class="button" name="prevP" value ="prev">

	<input name="termNumber" class="textinput" type="number" min="1" max="45">
	<input type="submit" class="button" value ="submit">

<input type="submit" class="button" name="nextP" value ="next">

</form>
<br>
<form>
  <select id="filterdrop" class="button"  name="filterdrop">
    <option value="" >None</option>
    <option value="party">Party</option>
    <option value="name" >Name</option>
    <option value="year" >Year</option>
    <option value="fact" >Fact</option>
  </select>
  <label for="inputString"></label>
  <input type="text" class="textinput" inputString" name="inputString">
  <input type="submit" class="button" name="inputGo" value ="Search">
  <input type="submit" class="button" name="reset" value ="Reset">
</form>


</div>
</div>


</div>
</div>

</body>
</html>
