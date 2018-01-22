<%@include file="../flows-shared/header.jsp" %>
<div class="container">
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${flowExecutionUrl}&_eventId=home">Online Shopping</a>
	            </div>
			</div>
		</nav>
	<div class="row">
	
		
		<div class="col-sm-offset-4 col-sm-4">
			<div class="text-center">		
				<h1>Welcome!</h1>
				<h3>onlineshopping.com</h3>
				<h6>You can use your email address as username to login!</h6>
				<div>
					<a href="${contextRoot}/login" class="btn btn-lg btn-success">Login Here</a>
				</div>
			</div>
		</div>
	
	
	</div>
	

</div>	
<%@include file="../flows-shared/footer.jsp" %>