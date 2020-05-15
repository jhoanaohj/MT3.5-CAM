// // Data Picker Initialization
$(document).ready(() => {

    const defaultDate = '2020-04-15';
    defaultLoad(defaultDate);


    $(document).ready(() => {
        $(".userChoice").on("change", () => {
            var selectedItem = $(".userChoice").val();
            console.log(selectedItem)

            if (selectedItem == 0) {
                console.clear();
                console.log("Default");
                defaultLoad(defaultDate);

            }
            else if (selectedItem == 1) {
                console.clear();
                console.log("Summary");
                $("#bar-chart").html('');
                $("#pieChart").html('');
                $("#lineChart").html('');
                $('#top5Downtime').html('');
                $("#mostDown").html('');
                $("#mostUp").html('');
                $("#pieChart2").html('');
                $("#barChart2").html('');
                $("#barChart3").html('');

                $("#divDateRange").html('');
                d3.selectAll("#divDateRange")
                    .append("em")
                    .attr("class", "fas fa-calendar calendar");

                d3.selectAll("#divDateRange")
                    .append("input")
                    .attr("type", "text")
                    .attr("id", "daterange")
                    .attr("class", "form-control")
                    .attr("style", "cursor: pointer");

                $('#daterange').daterangepicker({
                    opens: 'center',
                    showDropdowns: true,
                    startDate: "2020/04/15",
                    endDate: "2020/04/15",
                    batchMode: 'week',
                    showShortcuts: false,
                    locale: {
                        format: 'YYYY/MM/DD'
                    }
                }, function (start, end, label) {
                    var summaryStartDate = start.format('YYYY-MM-DD');
                    var summaryEndDate = end.format('YYYY-MM-DD');
                    window.alert("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
                    rangeLoad(summaryStartDate, summaryEndDate);
                })

            }
            else if (selectedItem == 2) {
                console.clear();
                //function dailyLoad()
                console.log("Daily");

                $("#bar-chart").html('');
                $("#pieChart").html('');
                $("#lineChart").html('');
                $('#top5Downtime').html('');
                $("#mostDown").html('');
                $("#mostUp").html('');
                $("#pieChart2").html('');
                $("#barChart2").html('');
                $("#barChart3").html('');

                d3.selectAll("#divDateRange")
                    .append("em")
                    .attr("class", "fas fa-calendar calendar");

                d3.selectAll("#divDateRange")
                    .append("input")
                    .attr("type", "text")
                    .attr("id", "dailySelect")
                    .attr("class", "form-control")
                    .attr("style", "cursor: pointer");

                $('#dailySelect').daterangepicker({
                    singleDatePicker: true,
                    opens: 'center',
                    showDropdowns: true,
                    showShortcuts: false,
                    locale: {
                        format: 'YYYY/MM/DD'
                    }
                }, function (start, end, label) {
                    //window.alert("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
                    console.log(start.format('YYYY-MM-DD'))
                    //gets the date selected
                    var dailyDate = start.format('YYYY-MM-DD');
                    dailyLoad(dailyDate);
                })


            }
            else if (selectedItem == 3) {
                console.clear();
                console.log("Weekly")

                $("#divDateRange").html('');
                $("#bar-chart").html('');
                $("#pieChart").html('');
                $("#lineChart").html('');
                $('#top5Downtime').html('');
                $("#mostDown").html('');
                $("#mostUp").html('');

                d3.selectAll("#divDateRange")
                    .append("span")
                    .append("em")
                    .attr("class", "fas fa-calendar calendar");

                d3.selectAll("#divDateRange")
                    .append("input")
                    .attr("type", "text")
                    .attr("id", "weekDateRange")
                    .attr("class", "form-control")
                    .attr("style", "cursor: pointer");

                $('#weekDateRange').daterangepicker({
                    singleDatePicker: true,
                    opens: 'center',
                    showDropdowns: true,
                    showShortcuts: false,
                    locale: {
                        format: 'YYYY/MM/DD'
                    }
                }, function (start, end, label) {
                    console.log(start.format('YYYY-MM-DD'))
                    //gets the date selected
                    var getSelectedDate = start.format('YYYY-MM-DD');
                    //gets the first day of the week
                    var firstDayWeek = moment(getSelectedDate).startOf('isoWeek');
                    //format the result to date
                    var startWeekObj = new Date(firstDayWeek.format("YYYY-MM-DD"));
                    //gets the year of the first week
                    var firstYearWeek = moment(startWeekObj).year();
                    //gets the month of the  first week
                    var firstMonthWeek = moment(startWeekObj).month() + 1;
                    //gets the day of the first week
                    var firstDayWeek = moment(startWeekObj).date();
                    //collect the results:
                    var completeFirstDaySelectedWeek = firstYearWeek + "-" + firstMonthWeek + "-" + firstDayWeek;

                    //gets the last day of the week
                    var lastDayWeek = moment(getSelectedDate).endOf('isoWeek');
                    //format the result to date
                    var lastWeekObj = new Date(lastDayWeek.format("YYYY-MM-DD"));
                    //gets the year of the first week
                    var lastYearWeek = moment(lastWeekObj).year();
                    //gets the month of the  first week
                    var lastMonthWeek = moment(lastWeekObj).month() + 1;
                    //gets the day of the first week
                    var lastDayWeek = moment(lastWeekObj).date();
                    //collect the results:
                    var completeLastDaySelectedWeek = lastYearWeek + "-" + lastMonthWeek + "-" + lastDayWeek;

                    console.log("First day of the selected week: " + completeFirstDaySelectedWeek);
                    console.log("Last day of the selected week: " + completeLastDaySelectedWeek);

                    rangeLoad(completeFirstDaySelectedWeek, completeLastDaySelectedWeek);

                })

            }
            else if (selectedItem == 4) {
                console.clear();
                console.log("Monthly")

                $("#divDateRange").html('');
                $("#bar-chart").html('');
                $("#pieChart").html('');
                $("#lineChart").html('');
                $('#top5Downtime').html('');
                $("#mostDown").html('');
                $("#mostUp").html('');

                d3.selectAll("#divDateRange")
                    .append("span")
                    .append("em")
                    .attr("class", "fas fa-calendar calendar");

                d3.selectAll("#divDateRange")
                    .append("input")
                    .attr("type", "text")
                    .attr("id", "monthPick")
                    .attr("class", "form-control")
                    .attr("style", "cursor: pointer");

                $('#monthPick').datepicker({
                    autoclose: true,
                    minViewMode: 1,
                    format: 'mm/yyyy'
                }).on('changeDate', function (selected) {
                    startDate = new Date(selected.date.valueOf());
                    startDate.setDate(startDate.getDate(new Date(selected.date.valueOf())));
                    console.clear();
                    //get the start and end of selected date
                    var startMonth = moment(startDate).startOf("month");
                    var endMonth = moment(startDate).endOf("month");

                    //get the piece by piece of the selected month
                    //current month
                    var getStartMonth = moment(startMonth).month() + 1;
                    var getStartDay = moment(startMonth).date();
                    var getStartYear = moment(startMonth).year();
                    //current month
                    var getEndMonth = moment(endMonth).month() + 1;
                    var getEndDay = moment(endMonth).date();
                    var getEndYear = moment(endMonth).year();

                    //get the date of next month
                    var nextMonth = moment(startMonth).add(1, "month");

                    //get the start and end of next month
                    var startNextMonth = moment(nextMonth).startOf("month");
                    var endNextMonth = moment(nextMonth).endOf("month");

                    //get the piece by piece of next month
                    //next month
                    var getStartNextMonth = moment(startNextMonth).month() + 1;
                    var getStartNextDay = moment(startNextMonth).date();
                    var getStartNextYear = moment(startNextMonth).year();

                    var getEndNextMonth = moment(endNextMonth).month() + 1;
                    var getEndNextDay = moment(endNextMonth).date();
                    var getEndNextYear = moment(endNextMonth).year();

                    //get the date of last month
                    var lastMonth = moment(startMonth).subtract(1, "month");

                    //get the start and end of last month
                    var startLastMonth = moment(lastMonth).startOf("month");
                    var endLastMonth = moment(lastMonth).endOf("month");

                    //get the piece by piece of last month
                    //last month
                    var getStartLastMonth = moment(startLastMonth).month() + 1;
                    var getStartLastDay = moment(startLastMonth).date();
                    var getStartLastYear = moment(startLastMonth).year();

                    var getEndLastMonth = moment(endLastMonth).month() + 1;
                    var getEndLastDay = moment(endLastMonth).date();
                    var getEndLastYear = moment(endLastMonth).year();

                    //combine all the date to use in query (CURRENT MONTH)
                    var startCurrMonthDate = getStartYear + "-" + getStartMonth + "-" + getStartDay;
                    var endCurrMonthDate = getEndYear + "-" + getEndMonth + "-" + getEndDay;

                    //combine all the date to use in query (NEXT MONTH)
                    var startNextMonthDate = getStartNextYear + "-" + getStartNextMonth + "-" + getStartNextDay;
                    var endNextMonthDate = getEndNextYear + "-" + getEndNextMonth + "-" + getEndNextDay;

                    //combine all the date to use in query (Last MONTH)
                    var startLastMonthDate = getStartLastYear + "-" + getStartLastMonth + "-" + getStartLastDay;
                    var endLastMonthDate = getEndLastYear + "-" + getEndLastMonth + "-" + getEndLastDay;

                    monthlyLoad(startLastMonthDate, endLastMonthDate, startCurrMonthDate, endCurrMonthDate, startNextMonthDate, endNextMonthDate)
                });
            }
            else if(selectedItem == 5){
                $("#bar-chart").html('');
                $("#pieChart").html('');
                $("#lineChart").html('');
                $('#top5Downtime').html('');
                $("#mostDown").html('');
                $("#mostUp").html('');
                $("#pieChart2").html('');
                $("#barChart2").html('');
                $("#barChart3").html('');

                $("#divDateRange").html('');
                d3.selectAll("#divDateRange")
                    .append("em")
                    .attr("class", "fas fa-calendar calendar");

                d3.selectAll("#divDateRange")
                    .append("input")
                    .attr("type", "text")
                    .attr("id", "daterange")
                    .attr("class", "form-control")
                    .attr("style", "cursor: pointer");

                $('#daterange').daterangepicker({
                    opens: 'center',
                    showDropdowns: true,
                    batchMode: 'week',
                    showShortcuts: false,
                    locale: {
                        format: 'YYYY/MM/DD'
                    }
                }, function (start, end, label) {
                    var summaryStartDate = start.format('YYYY-MM-DD');
                    var summaryEndDate = end.format('YYYY-MM-DD');
                    window.alert("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
                    rangeLoad(summaryStartDate, summaryEndDate);
                })
            }

        })
    });
});






//bookmark
