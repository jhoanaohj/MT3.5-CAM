$(document).ready(function () {
    $("#sidebar").mCustomScrollbar({
        theme: "minimal"
    });

    $('#dismiss, .overlay').on('click', function () {
        $('#sidebar').removeClass('active');
        $('.overlay').fadeOut();
    });

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').addClass('active');
        $('.overlay').fadeIn();
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });
});

$(document).ready( function () {
    $('#table_id').DataTable();
} );

$(document).ready(function (){
	   $('#table_id').DataTable({
	      lengthChange: false,
	      ajax: {
	          url: "/queries",
	          dataSrc: 'responseData'
	      },
	      columns: [
	    	  { data: "Terminal ID" }, 
	          { data: "Machine Name" }, 
	          { data: "Machine Type" }
	      ],
	      select: true
	   });
	});

console.log(columns)

 