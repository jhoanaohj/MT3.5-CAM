$(document).ready(
		function () {
			$("#sidebar").mCustomScrollbar({
				theme: "minimal"
			});

			$('#dismiss, .overlay').on('click', function () {
				$('#sidebar').removeClass('active');
				$('.overlay').fadeOut();
			});

			$('#sidebarCollapse').on(
				'click',
				function () {
					$('#sidebar').addClass('active');
					$('.overlay').fadeIn();
					$('.collapse.in').toggleClass('in');
					$('a[aria-expanded=true]').attr(
						'aria-expanded', 'false');
				});

			$.ajax({
					url: ("./queries/"),
					method: "GET",
					dataType: "json",
					success: function (data) {
						$("#myTable")
							.dataTable(
								{
									"dom": 'Bfrtip',
									"buttons": ['pdf'],
									"data": data,
									"columns": [
										{'data': 'TerminalId'},
										{'data': 'MachineName'},
										{'data': 'MachineType'},
										{'data': 'HandledBy'},
										{'data': 'Vendor'},
										{'data': 'Area'},
										{'data': 'OnSite'},
										{'data': 'Address'},
										{'data': 'Status'},
										{'defaultContent': '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">From Ajax</button>'}]
								})

					}
				})
		})
		
		
