<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<ul>
			<c:forEach items="${books }" var="book">
				<li>${book }</li>
			</c:forEach>
		</ul>
		<%
			out.println("业务调用结束的时间：" + new java.util.Date());
			if (request.isAsyncStarted()) {
				//完成异步调用
				request.getAsyncContext().complete();
			}
		%>
	</div>
</body>
</html>