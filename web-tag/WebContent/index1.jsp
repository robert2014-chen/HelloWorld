<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://web.robert.com/mywebtag" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动态显示JSP标签片段</title>
</head>
<body>
	<mytag:fragment>
		<jsp:attribute name="fragment">
	${pageContext.request.remoteAddr }
	</jsp:attribute>
	</mytag:fragment>
</body>
</html>