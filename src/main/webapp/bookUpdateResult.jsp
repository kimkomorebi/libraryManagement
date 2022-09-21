<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String r = request.getParameter("R");
		if(r.equals("Y")){
	%>
		<script type="text/javascript">
			alert("수정이 완료되었습니다");
		</script>
	<%
		}else if(r.equals("N")){
	%>
		<script type="text/javascript">
			alert("수정 실패, 관리자에게 문의해 주세요");
		</script>
	<%
		}
	%>
	<script type="text/javascript">
		location.href="bookList.do";
	</script>
</body>
</html>