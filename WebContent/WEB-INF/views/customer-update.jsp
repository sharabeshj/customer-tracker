<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<jsp:include page="include.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Add Customer</title>
</head>
<body>
	<a href="${ pageContext.request.contextPath }/customer/list"><button class="btn btn-default">Back</button></a>
	
	<form:form modelAttribute="customer" action="update" method="POST" cssClass="form-horizontal">
		<form:hidden path="id"/>
		<div class="form-group">
			<label class="control-label col-sm-2" for="firstName">First Name:</label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" path="firstName" id="firstName"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastName">Last Name:</label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" path="lastName" id="lastName"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" path="email" id="email"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form:form>
</body>
</html>