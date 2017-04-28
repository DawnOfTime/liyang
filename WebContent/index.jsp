<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value='/test/querys'/>" method="post">
	<table>
		<tr>
			<td>书名：<input type="text" name="book.sm" value="${book.sm}"/></td>
			<td>出版社：<input type="text" name="book.cbs" value="${book.cbs}"/></td>
			<td>作者：<input type="text" name="book.zz" value="${book.zz}"/></td>
			<td>出版时间：<input type="text" name="book.cbsj" value="${book.cbsj}"/></td>
			<td><input type="submit" value="查询"/></td>
		</tr>
	</table>
	<c:if test="${pageBean.beanList!=null}">
		<table align="center">
			<tr>
				<td>书名</td>
				<td>出版社</td>
				<td>作者</td>
				<td>出版时间</td>
			</tr>
			<c:forEach items="${pageBean.beanList}" var="item">
				<tr>
					<td>${item.sm}</td>
					<td>${item.cbs}</td>
					<td>${item.zz}</td>
					<td>${item.cbsj}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</form>
	<c:if test="${pageBean.beanList!=null}">
		<jsp:include page="paging.jsp"/>
	</c:if>
</body>
</html>