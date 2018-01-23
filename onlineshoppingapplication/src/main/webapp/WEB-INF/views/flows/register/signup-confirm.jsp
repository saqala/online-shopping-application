<%@include file="../flows-shared/header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="w3l_banner_nav_right">
	<!-- login -->

	<div class="w3_login">
		<h3>Confirm informations</h3>
		<div class="w3_login_module">
			<div class="module form-module">
				<div class="toggle">
					<i class="fa fa-times fa-pencil" aria-hidden="true"></i>
				</div>
				<div class="form">
					<h2>Personal Details</h2>
					<br>
					<h3>
						Name : <strong>${registerModel.user.firstName}
							${registerModel.user.lastName}</strong>
					</h3>
					<br>
					<h4>
						Email : <strong>${registerModel.user.email}</strong>
					</h4>
					<br>
					<h4>
						Contact : <strong>${registerModel.user.contactNumber}</strong>
					</h4>
					<br>
					<h4>
						Role : <strong>${registerModel.user.role}</strong>
					</h4>
					<br>
					<h1>
						<a href="${flowExecutionUrl}&_eventId_personal"><span
							class="label label-info">Edit</span></a>
					</h1>
				</div>
			</div>
			<div class="module form-module">
				<div class="toggle">
					<i class="fa fa-times fa-pencil" aria-hidden="true"></i>
				</div>
				<div class="form">
					<h2>Billing Address</h2>
					<br>
					<h4>
						Address Line One : <strong>${registerModel.billing.addressLineOne}
						</strong>
					</h4>
					<br>
					<h4>
						Address Line Two : <strong>${registerModel.billing.addressLineTwo}</strong>
					</h4>
					<br>
					<h4>
						City : <strong>${registerModel.billing.city} -
							${registerModel.billing.postalCode}</strong>
					</h4>
					<br>
					<h4>
						State : <strong>${registerModel.billing.state}</strong>
					</h4>
					<br>
					<h4>
						Country : <strong>${registerModel.billing.country}</strong>
					</h4>
					<br>
					<h1>
						<a href="${flowExecutionUrl}&_eventId_billing"><span
							class="label label-info">Edit</span></a>
					</h1>
				</div>

			</div>
			<div class="text-center">
			<h1>
				<a href="${flowExecutionUrl}&_eventId_submit"><span
					class="label label-success">Confirm</span></a>
			</h1>			
			</div>

		</div>
		<script>
			$('.toggle').click(function() {
			});
		</script>
	</div>
	<!-- //login -->

</div>
<div class="clearfix"></div>
</div>
<%@include file="../flows-shared/footer.jsp"%>
