<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to my Live Karaoke Band page</title>
</head>
<body>

	<c:if test = "${ not empty give_thanks}">
		<h2>Thank you for requesting ${give_thanks.title } by ${give_thanks.artist }!</h2>
	</c:if>
	<c:if test = "${ not empty whoops}">
		<h2>Something went wrong with your request for ${whoops.title } by ${whoops.artist } </h2>
		<h3>It may have already been requested...</h3>
	</c:if>

	Here is a list of songs that we know: <br/>

	<table border=1>
		<tr>
			<th>Artist</th>
			<th>Title</th>
			<th>Album</th>
		</tr>
		
		<c:forEach var="song" items="${requestScope.songs}">
		<tr>
			<td> ${song.artist } </td>
			<td> ${song.title } </td>
			<td> ${song.album } </td>
		</tr>
		</c:forEach>

	</table>
	
	<br/><br/><br/>
		Here is a list of songs that have been requested: <br/>

	<table border=1>
		<tr>
			<th>Artist</th>
			<th>Title</th>
			<th>Album</th>
		</tr>
		
		<c:forEach var="song" items="${requestScope.song_requests}">
		<tr>
			<td> ${song.artist } </td>
			<td> ${song.title } </td>
			<td> ${song.album } </td>
		</tr>
		</c:forEach>

	</table>
	
	<br/><br/><br/>
	<a href="requestSongForm">Click here to request a song!</a>
	
</body>
</html>