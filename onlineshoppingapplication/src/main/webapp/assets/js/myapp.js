$(function() {

	switch (menu) {
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#allProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'Product Management':
		$('#manageProduct').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;		

	default:
		if(menu == "Home") break;
		$('#allProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}
	
	
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
	
	
	// code for jquery database
	
 var jsonUrl = '';
 if(window.categoryId == '') {
	 jsonUrl = window.contextRoot + '/json/data/all/products';
	 console.log(jsonUrl);
 }
 else {
	 jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
 }
	
	var $table  = $('#productListTable');

	// execute the below code only where we have this table
	
	if($table.length) {


		$table
		.DataTable({

			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
					{
						data : 'code',
						bSortable : false,
						mRender : function(data, type, row) {

							return '<img src="' + window.contextRoot
									+ '/resources/images/' + data
									+ '.jpg" class="dataTableImg"/>';

						}
					},
					{
						data : 'name'
					},
					{
						data : 'brand'
					},
					{
						data : 'unitPrice',
						mRender : function(data, type, row) {
							return '&euro; ' + data
						}
					},
					{
						data : 'quantity',
						mRender : function(data, type, row) {

							if (data < 1) {
								return '<span style="color:red">Out of Stock!</span>';
							}

							return data;

						}
					},
					{
						data : 'id',
						bSortable : false,
						mRender : function(data, type, row) {

							var str = '';
							str += '<nobr> <a href="'
									+ window.contextRoot
									+ '/show/'
									+ data
									+ '/product" class="btn btn-primary"><span class="fa fa-eye"></span></a> ';
						
							if(userRole !== 'ADMIN') {
								if (row.quantity < 1) {
									str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="fa fa-shopping-cart"></span></a>';
								} 									else {
									str += '<a href="'
										+ window.contextRoot
										+ '/cart/add/'
										+ data
										+ '/product" class="btn btn-success"><span class="fa fa-shopping-cart"></span></a></nobr>';

								}
							}
							else {
									
										str += '<a href="'
											+ window.contextRoot
											+ '/cart/manage/'
											+ data
											+ '/product" class="btn btn-warning"><span class="fa fa-pencil"></span></a></nobr>';
										
									
							
							}
							return str;

						}

					} ]
		});
		
		
	}

	// list of all products for admin
	var $productsTable = $('#productsTable');
	
	
	if($productsTable.length) {
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		console.log(jsonUrl);
		
		$productsTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},


					           	{data: 'code',
					           	 bSortable: false,
					           		mRender: function(data,type,row) {
					           			return '<img src="' + window.contextRoot
										+ '/resources/images/' + data
										+ '.jpg" class="dataTableImg"/>';					           			
					           		}
					           	},
					           	{
									data : 'name'
								},
								{
									data : 'brand'
								},
								{
									data : 'quantity',
									mRender : function(data, type, row) {

										if (data < 1) {
											return '<span style="color:red">Out of Stock!</span>';
										}

										return data;

									}
								},
								{
									data : 'unitPrice',
									mRender : function(data, type, row) {
										return '&euro; ' + data
									}
								},
								{
									data : 'active',
									bSortable : false,
									mRender : function(data, type, row) {
										var str = '';
										if(data) {											
											str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
											
										}else {
											str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
										}
										
										return str;
									}
								},
								{
									data : 'id',
									bSortable : false,
									mRender : function(data, type, row) {

										var str = '';
										str += '<a href="'
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/product" class="btn btn-primary"><span class="fa fa-pencil></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Product Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/manage/product/'+checkbox.prop('value')+'/activation',
							        		timeout : 100000,
							        		success : function(data) {
							        			bootbox.alert(data);							        										        			
							        		},
							        		error : function(e) {
							        			bootbox.alert('ERROR: '+ e);
							        			display(e);
							        		}						            	
							            });
							        }
							        else {							        	
							        	checkbox.prop('checked', !checked);
							        }
						    	}
						    });																											
						});
							
					}
				});
	}

$categoryForm = $('#categoryForm');
	
	if($categoryForm.length) {
		
		$categoryForm.validate({			
				rules: {
					name: {
						required: true,
						minlength: 3
					},
					description: {
						required: true,
						minlength: 3					
					}				
				},
				messages: {					
					name: {
						required: 'Please enter product name!',
						minlength: 'Please enter atleast five characters'
					},
					description: {
						required: 'Please enter product name!',
						minlength: 'Please enter atleast five characters'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					errorPlacement(error, element);
				}				
			}
		
		);
		
	}
	
/*validating the loginform*/
	
	// validating the product form element	
	// fetch the form element
	$loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({			
				rules: {
					username: {
						required: true,
						email: true
						
					},
					password: {
						required: true
					}				
				},
				messages: {					
					username: {
						required: 'Please enter your email!',
						email: 'Please enter a valid email address!'
					},
					password: {
						required: 'Please enter your password!'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					// Add the 'help-block' class to the error element
					error.addClass("help-block");
					
					// add the error label after the input element
					error.insertAfter(element);
				}				
			}
		
		);
		
	}
		
	
	$alert = $('.alert');
	if($alert.length) {
		setTimeout(function() {
	    	$alert.fadeOut('slow');
		   }, 3000
		);		
	}
}

);

/*------*/
/* handle refresh cart*/	
$('button[name="refreshCart"]').click(function(){
	var cartLineId = $(this).attr('value');
	var countField = $('#count_' + cartLineId);
	var originalCount = countField.attr('value');
	// do the checking only the count has changed
	if(countField.val() !== originalCount) {	
		// check if the quantity is within the specified range
		if(countField.val() < 1 || countField.val() > 3) {
			// set the field back to the original field
			countField.val(originalCount);
			bootbox.alert({
				size: 'medium',
		    	title: 'Error',
		    	message: 'Product Count should be minimum 1 and maximum 3!'
			});
		}
		else {
			// use the window.location.href property to send the request to the server
			var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + countField.val();
			window.location.href = updateUrl;
		}
	}
});		
	
jQuery(document).ready(function($) {
	  $.getScript( "https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js" )
	  	.done(function( script, textStatus ) {
	    	console.log( textStatus );
	      	console.log("asdasd");
	 		//'[data-toggle="tooltip"]').tooltip();
	  	})
	  	.fail(function( jqxhr, settings, exception ) {
	      console.log("Triggered ajaxError handler.");
		}); 	
	});