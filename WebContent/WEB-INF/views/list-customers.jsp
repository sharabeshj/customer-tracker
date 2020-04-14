<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="include.jsp"></jsp:include>
<title>Customer List</title>
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/CSS/list-customer.css">
</head>
<body>
	<a href="form"><button class="add-button">Add Customer</button></a>
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr class=" row flex-nowrap">
				<th class=" col-md-1 center-align">#</th>
				<th class=" col-md-3 center-align">First Name</th>
				<th class=" col-md-3 center-align">Last Name</th>
				<th class= " col-md-3 center-align">Email</th> 
				<th class=" col-md-2 center-align">Action</th>
			</tr>
		</thead>
		<tbody>
			<% int i=0; %>
			<c:forEach var="customer" items="${customers}">
				<c:url var="deleteLink" value="delete">
					<c:param name="id" value="${ customer.id }"></c:param>
				</c:url>
				<tr class=" row flex-nowrap">
					<td class=" col-md-1 center-align"><%= ++i %></td>
					<td class=" col-md-3 center-align">${ customer.firstName }</td>
					<td class=" col-md-3 center-align">${ customer.lastName }</td>
					<td class= " col-md-3 center-align">${ customer.email }</td>
					<td class= " col-md-2 center-align">
						<a href="form-update?id=${ customer.id }">Update</a>
						<b> | </b>
						<a href="${ deleteLink }">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
</body>
</html>