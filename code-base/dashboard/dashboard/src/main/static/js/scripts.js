function editRow(id) {
    $.ajax({
        url: "./tabEdit/" + id,
        method: "GET",
        contentType: "text/plain",
        success: function (data) {
            $("#profileModal .modal-body").html(data);
        },
        error: function () {
            alert("Ajax error, unable to populate modal contents!");
        },
    });

    $("#profileModal").modal("show");
};



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
                dom: "Bpt",
                buttons: ["pdf"], 
                data: data,
                columns: [
                    {data: "terminalId"},
                    {data: "machineName"},
                    {data: "machineType"},
                    {data: "handledBy"},
                    {data: "vendor"},
                    {data: "area"},
                    {data: "onsite"},
                    {data: "address"},
                    {data: "status"},
                    {
                        data: "terminalId",
                        render: function (data, type, row) {
                            let btn =
                                `<button class="btn btn-primary" onclick="editRow('${row.terminalId}')">Info</button>`;
                            return btn;
                        },
                    },
                ],
            });
        },
    });
});