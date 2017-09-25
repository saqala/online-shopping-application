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
	
	
	// code for jquery database
	
	var products = [
		
		['1', 'ABC'],
		['2', 'EFG'],
		['3', 'HEK'],
		['4', 'XCY'],
		['5', 'POI'],
		['6', 'AOI'],
		
	]
	
	;
	
	var $table  = $('#productListTable');

	// execute the below code only where we have this table
	
	if($table.length) {


		$table.DataTable({
			lengthMenu: [[3,5,10,-1], ['3 records','5 records','10 records','all records']],
			pageLength: 5,
			data:products
		});
		
		
	}
}

);
	
