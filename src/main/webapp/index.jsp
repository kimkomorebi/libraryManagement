<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<section>
		<form action="bookList.do" method="post">
			<input type="submit" value="���� ���"/>
		</form>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>