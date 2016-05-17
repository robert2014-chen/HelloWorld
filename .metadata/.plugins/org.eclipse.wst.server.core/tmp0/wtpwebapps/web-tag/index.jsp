<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://web.robert.com/mywebtag" prefix="myiterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的迭代标签</title>
</head>
<body>
	<%
		List<String> a = new ArrayList<String>();
		a.add("Thinking in Java");
		a.add("Java核心技术");
		a.add("高并发编程");

		pageContext.setAttribute("a", a);
	%>

	<table border="1" bgcolor="#acd" width="300">
		<myiterator:iterator item="item" collection="a">
			<tr>
				<td>${pageScope.item }</td>
			</tr>
		</myiterator:iterator>
	</table>
</body>
</html>