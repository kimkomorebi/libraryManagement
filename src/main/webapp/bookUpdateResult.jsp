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
			alert("������ �Ϸ�Ǿ����ϴ�");
		</script>
	<%
		}else if(r.equals("N")){
	%>
		<script type="text/javascript">
			alert("���� ����, �����ڿ��� ������ �ּ���");
		</script>
	<%
		}
	%>
	<script type="text/javascript">
		location.href="bookList.do";
	</script>
</body>
</html>