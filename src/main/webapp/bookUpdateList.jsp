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
		Book b = (Book)request.getAttribute("B");
		ArrayList<String> name = (ArrayList<String>)request.getAttribute("NAME");
	%>
		<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div align="center">
			<form action="">
				<table border="1">
					<tr>
						<th>������ȣ</th>
						<td><input type="text" name="ID" value="<%= b.getId() %>" readOnly="readOnly"/></td>
					</tr>
					<tr>
						<th>������</th>
						<td><input type="text" name="B_NAME" value="<%= b.getB_name() %>"/></td>
					</tr>
					<tr>
						<th>���ڸ�</th>
						<td>
							<select name="WRITER">
								<%
									for(String n : name){
								%>
								<option><%= n %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>���ǻ��</th>
						<td><input type="text" name="PUBLISHER" value="<%= b.getPublisher() %>"/></td>
					</tr>
					<tr>
						<th>����</th>
						<td><input type="text" name="PRICE" value="<%= b.getPrice() %>"/></td>
					</tr>
					<tr>
						<th>������</th>
						<td><input type="text" name="DAY" value="<%= b.getP_date() %>"/></td>
					</tr>
				</table>
				<br/>
				<input type="submit" value="���� ���(����)"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>