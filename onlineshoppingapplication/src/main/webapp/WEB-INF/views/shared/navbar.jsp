
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Online Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li id="home" class="nav-item"><a class="nav-link"
					href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li id="about" class="nav-item"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li id="services" class="nav-item"><a class="nav-link"
					href="${contextRoot}/services">Services</a></li>
				<li id="allProducts" class="nav-item"><a class="nav-link"
					href="${contextRoot}/show/all/products">View Products</a></li>
				<li id="manageProducts" class="nav-item"><a class="nav-link"
					href="${contextRoot}/manage/products">Manage Products</a></li>
				<li id="contact" class="nav-item"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				<li id="register"><a href="${contextRoot}/register"> Sign up</a></li>
				<li id="login"><a href="${contextRoot}/login"> Login</a></li>

				<li class="dropdown" id="userModel"><a
					class="btn btn-default dropdown-toggle" href="javascript:void(0)"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> ${userModel.fullName} <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">

						<li id="cart"><a href="${contextRoot}/cart/show"> <span
								class="glyphicon glyphicon-shopping-cart"></span>&#36;<span
								class="badge">${userModel.cart.cartLines}</span> - &#36;
								${userModel.cart.grandTotal}
						</a></li>
						<li role="separator" class="divider"></li>

						<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
					</ul></li>
			</ul>


		</div>
	</div>
</nav>
