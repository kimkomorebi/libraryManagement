<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, book.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<String> list = (ArrayList<String>)request.getAttribute("LIST");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div align="center">
			<form action="bookRegister.do" method="post">
				<table border="1">
					<tr>
						<th>도서번호</th>
						<td><input type="text" name="BOOKNUM"/></td>
					</tr>
					<tr>
						<th>도서명</th>
						<td><input type="text" name="BOOKNAME"/></td>
					</tr>
					<tr>
						<th>저자명</th>
						<td>
							<select name="WRITER">
							<%
								for(String l : list){
							%>
								<option><%= l %></option>
							<%
								}
							%>
							</select>
						</td>
					</tr>
					<tr>
						<th>출판사명</th>
						<td><input type="text" name="PUBLISHER"/></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="PRICE"/></td>
					</tr>
					<tr>
						<th>출판일</th>
						<td><input type="text" name="DATE"/></td>
					</tr>
				</table>
				<br/>
				<input type="submit" value="도서 등록"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>