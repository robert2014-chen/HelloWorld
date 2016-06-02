<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <style type="text/css">  
        body {background-color: black;color: white;}   
        span {text-align: center;color: green;background-color: yellow;}   
        .notice {color: rgb(250,37,62);}   
        hr { background-color: fuchsia; height: 5px;}   
    </style>  
<title>FormatNumber标签使用</title>
</head>
<body>
	<div>

		<h1>FormatNumber标签使用</h1>
		<div>
			<fmt:setLocale value="fr_fr" />
			France:
			<fmt:formatNumber value="123456789.012" />
		</div>
		<div>
			<fmt:setLocale value="zh_cn" />
			China:
			<fmt:formatNumber value="123456789.012" />
		</div>
		<div>
			<fmt:setLocale value="de_de" />
			Germany:
			<fmt:formatNumber value="123456789.012" />
		</div>
	</div>


	<div>
		<h1>parseNumber标签</h1>
		<p>用来将字符串类型的数字、货币、或百分比转换成数字类型</p>
		<TEXTAREA rows=7 cols=60> fmt:parseNumber value="numberString"
			[type={number|currency|percent|}] [pattern="pattern" ]
			[parseLocale="parseLocale" ] [integerOnly="{false|true}" ]
			[var="varname" ] [scope="page|request|session|application" ]</TEXTAREA>
		<div>
			<fmt:parseNumber type="number" pattern="#,#00.0#">123.00a1</fmt:parseNumber>
			<br />
		</div>

	</div>

	<div>

		<hr />
		<span>格式化日期：</span><br />
		<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
		<fmt:formatDate value="${now}" type="date" />
		<br />
		<fmt:formatDate value="${now}" type="both" dateStyle="long"
			timeStyle="long" />
		<br />
		<fmt:formatDate value="${now}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" />
		<br />
		<hr />
		<span>数字 格式化并输出：</span><br /> 数字:
		<fmt:formatNumber value="1234567890" type="number" />
		<br />
		<!-- 定制数字格式时，# 表示按照默认格式来， -->
		数字，定制了格式:
		<fmt:formatNumber value="1234567890" type="number" pattern="#,#00.0#" />
		<br /> 货币：
		<fmt:formatNumber value="35000" type="currency" />
		<br /> 百分比：
		<fmt:formatNumber value="0.317" type="percent" />
		<br />
		<hr />
	</div>

</body>
</html>