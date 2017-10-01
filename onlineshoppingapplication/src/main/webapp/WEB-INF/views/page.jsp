<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<c:set var="contextRoot" value="${pageContext.request.contextPath}">
</c:set>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">



<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Header comes here -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<c:if test="${userClickHome == true}">
				<!-- Page Content -->

				<%@include file="home.jsp"%>
			</c:if>

			<!-- User click About -->
			<c:if test="${userClickAbout == true}">
				<!-- Page Content -->
				<%@include file="about.jsp"%>
			</c:if>

			<!-- User click Contact -->
			<c:if test="${userClickContact == true}">
				<!-- Page Content -->
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- User click Category or All Products -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<!-- Page Content -->

				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- User click Single Product -->
			<c:if test="${userClickShowProduct == true}">
				<!-- Page Content -->

				<%@include file="singleProduct.jsp"%>
			</c:if>

			<!-- User click Manage Products-->
			<c:if test="${userClickManageProducts == true}">
				<!-- Page Content -->

				<%@include file="manageProducts.jsp"%>
			</c:if>

		</div>
		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>

	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/jquery.validate.min.js"></script>
	<script src="${js}/popper.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/dataTables.bootstrap.js"></script>
	<script src="${js}/bootbox.min.js"></script>
	<script src="${js}/myapp.js"></script>
</body>

</html>
