<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글상세</h1>
	
	<table border="1">
	<input type="hidden" name="myno" value="${dto.myno }">
		<tr>
			<th>이름</th>
			<td><input type="text" name="myname" value="${dto.myname }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="mytitle" value="${dto.mytitle }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="20" cols="50" name="mycontent" readonly="readonly">${dto.mycontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="글수정" onclick="location.href='updateform.do?myno=${dto.myno}'">
				<input type="button" value="글삭제" onclick="location.href='delete.do?myno=${dto.myno}'">
			</td>
		</tr>
	</table>
</body>
</html>