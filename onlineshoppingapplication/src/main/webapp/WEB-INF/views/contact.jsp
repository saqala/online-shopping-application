		<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
		<div class="w3l_banner_nav_right">
<!-- mail -->
		<div class="mail">
			<h3>Mail Us</h3>
			<div class="agileinfo_mail_grids">
				<div class="col-md-4 agileinfo_mail_grid_left">
					<ul>
						<li><i class="fa fa-home" aria-hidden="true"></i></li>
						<li>address<span>Agadir Bensergao.</span></li>
					</ul>
					<ul>
						<li><i class="fa fa-envelope" aria-hidden="true"></i></li>
						<li>email<span><a href="mailto:me@slimanitech.com">me@slimanitech.com</a></span></li>
					</ul>
					<ul>
						<li><i class="fa fa-phone" aria-hidden="true"></i></li>
						<li>call to us<span>(+212) 668699818</span></li>
					</ul>
				</div>
				<div class="col-md-8 agileinfo_mail_grid_right">
					<sf:form action="${contextRoot}/contact" method="post" modelAttribute="visitor">
						<div class="col-md-6 wthree_contact_left_grid">
							<sf:input type="text" path="firstName" placeholder="Name*" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name*';}" required=""/>
							
							<sf:errors path="firstName" cssClass="help-block alert alert-warning" element="em" />
							
							<sf:input type="email" path="email" placeholder="Email*" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email*';}" required=""/>
							<sf:errors path="email" cssClass="help-block alert alert-warning" element="em" />
							
						</div>
						<div class="col-md-6 wthree_contact_left_grid">
							<sf:input type="text" path="contactNumber" placeholder="Telephone*" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Telephone*';}" required=""/>
							<sf:errors path="contactNumber" cssClass="help-block alert alert-warning" element="em" />
						
							<sf:input type="text" path="subject" placeholder="Subject*" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Subject*';}" required=""/>
							<sf:errors path="subject" cssClass="help-block alert alert-warning" element="em" />
					
						</div>
						<div class="clearfix"> </div>
						<sf:textarea  path="message" placeholdr = "Message..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required=""/>
						<input type="submit" name="submit"  value="Submit">
						<input type="reset" value="Clear">
					</sf:form>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
<!-- //mail -->
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->
<!-- map -->
	<div class="map">
		<iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d96748.15352429623!2d-74.25419879353115!3d40.731667701988506!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1sshopping+mall+in+New+York%2C+NY%2C+United+States!5e0!3m2!1sen!2sin!4v1467205237951" style="border:0"></iframe>
	</div>