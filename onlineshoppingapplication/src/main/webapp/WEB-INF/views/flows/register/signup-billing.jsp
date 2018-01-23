<%@include file="../flows-shared/header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="w3l_banner_nav_right">
	<!-- login -->

	<div class="w3_login">
		<h3>Sign up</h3>
		<div class="w3_login_module">
			<div class="module form-module">
				<div class="toggle">
					<i class="fa fa-times fa-pencil" aria-hidden="true"></i>

				</div>
				<div class="form">
					<h2>Address</h2>
					<sf:form method="post" modelAttribute="billing" id="billingForm">
						<sf:input type="text" path="addressLineOne" placeholder="Address Line One"
							required=" " />
						<sf:errors path="addressLineOne"
							cssClass="help-block alert alert-warning" element="em" />
						<sf:input type="text" path="addressLineTwo" placeholder="Address Line Two"
							required=" " />
						<sf:errors path="addressLineTwo"
							cssClass="help-block alert alert-warning" element="em" />

						<sf:input type="text" path="city" required=" "
							placeholder="City" />
						<sf:errors path="city"
							cssClass="help-block alert alert-warning" element="em" />

						<sf:input type="text" path="postalCode" required=" "
							placeholder="Postal Code"/>
						<sf:errors path="postalCode"
							cssClass="help-block alert alert-warning" element="em" />
							
						<sf:input type="text" path="state" required=" "
							placeholder="State"/>
						<sf:errors path="state"
							cssClass="help-block alert alert-warning" element="em" />
							
						<sf:input type="text" path="country" required=" "
							placeholder="Country"/>
						<sf:errors path="country"
							cssClass="help-block alert alert-warning" element="em" />
							
							
						<input type="submit" name="_eventId_confirm" value="Confirm">
						
					</sf:form>
				</div>
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

