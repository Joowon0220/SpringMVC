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
	<h1>글수정</h1>
	
	<form action="updateres.do" method="post">
		<input type="hidden" name="myno" value="${dto.myno }">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="myname" value="${dto.myname }"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="50" name="mycontent">${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="저장">
					<input type="button" value="취소" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>