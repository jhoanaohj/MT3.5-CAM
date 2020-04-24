function editRow(id) {
  // Show modal here, now you have access to the terminal id :)
		var tmp = null;
		$.ajax({
	        'type': "GET",
	        'url': "./tab/{terminal_id}/",
	        'data': {id},
	        'success': function (data) {
	        	tmp = data;
	        },
	    });
		
		$('#myModal').modal('show')
		
}

//$( "#modalText" ).replaceWith( "#returning" );
	
//  var win = window.open("./tab/" + id, "_blank");
//  win.focus();
	




$(document).ready(function () {
  $("#sidebar").mCustomScrollbar({
    theme: "minimal",
  });

  $("#dismiss, .overlay").on("click", function () {
    $("#sidebar").removeClass("active");
    $(".overlay").fadeOut();
  });

  $("#sidebarCollapse").on("click", function () {
    $("#sidebar").addClass("active");
    $(".overlay").fadeIn();
    $(".collapse.in").toggleClass("in");
    $("a[aria-expanded=true]").attr("aria-expanded", "false");
  });

  $.ajax({
    url: "./queries/",
    method: "GET",
    dataType: "json",
    success: function (data) {
      $("#myTable").dataTable({
        dom: "Bfrtip",
        buttons: ["pdf"],
        data: data,
        columns: [
          { data: "TerminalId" },
          { data: "MachineName" },
          { data: "MachineType" },
          { data: "HandledBy" },
          { data: "Vendor" },
          { data: "Area" },
          { data: "OnSite" },
          { data: "Address" },
          { data: "Status" },
          {
            data: "TerminalId",
            render: function (data, type, row) {
              var btn = '<button class="btn btn-primary" onclick="editRow(\'' + row.TerminalId +"')\">" + "Info" +  "</button>";
              return btn;
            },
          },
        ],
      });
    },
  });
});
		
