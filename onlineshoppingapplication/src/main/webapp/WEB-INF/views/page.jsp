<%@include file="./shared/navbar.jsp"%>

		
			<c:if test="${userClickHome == true}">
				<!-- Page Content -->

				<%@include file="index.jsp"%>
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
			
						<!-- Load only when user clicks manage product -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>	

		
		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>

	
