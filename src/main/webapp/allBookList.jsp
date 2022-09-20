<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import= "java.util.*, book.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<Book> book = (ArrayList<Book>)request.getAttribute("BOOK");
	%>
		<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div align="center">
			<table border="1">
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>저자</th>
					<th>출판사명</th>
					<th>가격</th>
					<th>출판일</th>
					<th>변경 / 삭제</th>
				</tr>
				<%
					for(Book b : book){
				%>
			<form action="bookUpdate.do" method="post">
				<tr>
					<td><input type="hidden" name="ID" value="<%= b.getId() %>"/><%= b.getId() %></td>
					<td><%= b.getB_name() %></td>
					<td><%= b.getA_name() %></td>
					<td><%= b.getPublisher() %></td>
					<td><%= b.getPrice() %></td>
					<td><%= b.getP_date() %></td>
					<td>
						<input type="submit" value="변경" name="BTN"/>
						<input type="submit" value="삭제" name="BTN"/>
					</td>
				</tr>
			</form>
				<%
					}
				%>
			</table>
			<br/>
			<form action="bookRegister.view">
				<input type="submit" value="도서 등록"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>