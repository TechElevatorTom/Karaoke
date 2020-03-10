<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request a song!</title>
</head>
<body>

	<form method="POST" action="submitRequestData">
		<label for="artist">Artist: </label>
		<input name="artist" type="text" id="artist" />
		
		<label for="title">Title: </label>
		<input name="title" type="text" id="title" />

		<label for="album">Album: </label>
		<input name="album" type="text" id="album" />
	
		<input type="submit" value="Make Request" />
	</form>

</body>
</html>