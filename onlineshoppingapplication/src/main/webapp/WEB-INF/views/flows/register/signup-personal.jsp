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
					<h2>Personal</h2>
					<sf:form method="post" modelAttribute="user" id="registerForm">
						<sf:input type="text" path="firstName" placeholder="First Name"
							required=" " />
						<sf:errors path="firstName"
							cssClass="help-block alert alert-warning" element="em" />
						<sf:input type="text" path="lastName" placeholder="Last Name"
							required=" " />
						<sf:errors path="lastName"
							cssClass="help-block alert alert-warning" element="em" />

						<sf:input type="text" path="email" required=" "
							placeholder="Email - abc@zyx.com" />
						<sf:errors path="email"
							cssClass="help-block alert alert-warning" element="em" />

						<sf:input type="text" path="contactNumber" required=" "
							placeholder="Contact Number - XXXXXXXXXX" maxlength="10" />
						<sf:errors path="contactNumber"
							cssClass="help-block alert alert-warning" element="em" />

						<sf:input type="password" path="password" required=" "
							placeholder="Password" />
						<sf:errors path="password"
							cssClass="help-block alert alert-warning" element="em" />

						<sf:input type="password" path="confirmPassword" required=" "
							placeholder="Re-type password" />
						<sf:errors path="confirmPassword"
							cssClass="help-block alert alert-warning" element="em" />

						<div class="form-group">
							<label class="control-label">Select Role</label>
							<div class="">
								<label class="radio-inline"> <sf:radiobutton path="role"
										value="USER" checked="checked" /> User
								</label> <label class="radio-inline"> <sf:radiobutton
										path="role" value="SUPPLIER" /> Supplier
								</label>
							</div>
						</div>
						<input type="submit" name="_eventId_billing" value="Billing">
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
