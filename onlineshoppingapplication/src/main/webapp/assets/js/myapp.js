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

}

);
	
