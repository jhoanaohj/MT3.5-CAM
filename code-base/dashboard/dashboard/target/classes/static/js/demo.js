$(document).ready(function () {

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

$(document).ready(function() {
	$.ajax({
		url : ("./queries/"),
		method : "GET",
		dataType : "json",
		success : function(data) {
			$("#myTable").dataTable({
				"data" : data,
				"columns" : [{'data' : 'TerminalId'},
					         {'data' : 'MachineName'},
					         {'data' : 'MachineType'}]
			})
		}
	})
})

 