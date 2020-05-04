// // Data Picker Initialization
$(document).ready(() => {
    
    $('#daterange').daterangepicker({
        opens: 'center',
        showDropdowns: true,
        startDate: "2020/04/15",
        endDate: "2020/04/15",
        locale: {
            format: 'YYYY/MM/DD'
        }
    }, function (start, end, label) {
        window.alert("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
    })
    //var defaultDate = moment().subtract(1, 'day').format("YYYY-MM-DD"); //code to get the yesterdate
    var defaultDate = "2020-04-15"
    console.log(defaultDate);

    var staticUrlTop5Downtime = "/topdowntime/" + defaultDate;
    console.log(staticUrlTop5Downtime);
    $(document).ready(() => {
        $.ajax({
            url: (staticUrlTop5Downtime),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $.each(data, (key, val) => {
                    $("#top5Downtime").append("<li>" + val.event_description + " - " + val.error_count + "</li>");
                });
            }
        })
    });

    var mostDownDefaultTerminal = "/mostDownTerminals/" + defaultDate;
    console.log(mostDownDefaultTerminal);
    $(document).ready(()=>{
        $.ajax({
            url:(mostDownDefaultTerminal),
            method: "GET",
            dataType: "json",
            success:(data)=>{
                $.each(data,(key,val)=>{
                    $("#mostDown").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    })

    var mostUpDefaultTerminal = "/mostUpTerminals/" + defaultDate;
    console.log(mostUpDefaultTerminal);
    $(document).ready(()=>{
        $.ajax({
            url: (mostUpDefaultTerminal),
            method: "GET",
            dataType: "json",
            success:(data)=>{
                $("#mostUp").html('');
                $.each(data,(key,val)=>{
                    $("#mostUp").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    });

    console.log("d3 version: " + d3.version);

    /** CODE FOR THE BAR CHART */
    var defaultHighAvailStaticUrl = "/highAvailabilities/" + defaultDate;
    console.log(defaultHighAvailStaticUrl);

    d3.json(defaultHighAvailStaticUrl)
        .then((data) => {
            console.log(data);

            const svgContainer = d3.select('#bar-chart')
                .append('svg');

            const margin = 80;
            const width = 1000 - 2 * margin;
            const height = 600 - 2 * margin;

            const chart = svgContainer.append('g')
                .attr('transform', "translate(" + margin + "," + margin + ")");

            const xScale = d3.scaleBand()
                .range([0, width])
                .domain(data.map((s) => s.region_iso_code))
                .padding(0.5)

            const yScale = d3.scaleLinear()
                .range([height, 0])
                .domain([0, 100]);

            // vertical grid lines
            // const makeXLines = () => d3.axisBottom()
            //   .scale(xScale)

            const makeYLines = () => d3.axisLeft()
                .scale(yScale)

            chart.append('g')
                .attr('transform', `translate(0, ${height})`)
                .call(d3.axisBottom(xScale));

            chart.append('g')
                .call(d3.axisLeft(yScale));

            chart.append('g')
                .attr('class', 'grid')
                .call(makeYLines()
                    .tickSize(-width, 0, 0)
                    .tickFormat('')
                )

            const barGroups = chart.selectAll()
                .data(data)
                .enter()
                .append('g')

            barGroups
                .append('rect')
                .attr('class', 'bar')
                .attr('x', (g) => xScale(g.region_iso_code))
                .attr('y', (g) => yScale(g.total_up_percentage))
                .attr('height', (g) => height - yScale(g.total_up_percentage))
                .attr('width', xScale.bandwidth())

            barGroups
                .append('text')
                .attr('class', 'value')
                .attr('x', (a) => xScale(a.region_iso_code) + xScale.bandwidth() / 2)
                .attr('y', (a) => yScale(a.total_up_percentage) + 30)
                .attr('text-anchor', 'middle')
                .text((a) => `${a.total_up_percentage}%`)

            svgContainer
                .append('text')
                .attr('class', 'label')
                .attr('x', -(height / 2) - margin)
                .attr('y', margin / 2.4)
                .attr('transform', 'rotate(-90)')
                .attr('text-anchor', 'middle')
                .text('Percentage(%)')

            svgContainer.append('text')
                .attr('class', 'label')
                .attr('x', width / 2 + margin)
                .attr('y', height + margin * 1.7)
                .attr('text-anchor', 'middle')
                .text('Terminals')

            svgContainer.append('text')
                .attr('class', 'title')
                .attr('x', width / 2 + margin)
                .attr('y', 40)
                .attr('text-anchor', 'middle')
                .text('Availability (%) of CAM for date: ' + defaultDate)
            /** END FOR BAR CHART */

            /** START OF PIE CHART */

            var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

            const pieContainer = d3.select("#pieChart")
                .append("svg")
                .attr("width", svgCirWidth)
                .attr("height", svgCirHeight);

            //create group element to hold pie chart

            var g = pieContainer.append("g")
                .attr("transform", "translate(" + 250 + "," + radius + ")");

            var color = d3.scaleOrdinal()
                .range(["#98abc5", "#8a89a6", "#7b6888", "#6b486b", "#a05d56", "#d0743c", "#ff8c00"])

            var pie = d3.pie().value(function (d) {
                return d.total_up_percentage;
            });

            var path = d3.arc()
                .outerRadius(radius)
                .innerRadius(0);

            var arc = g.selectAll("arc")
                .data(pie(data))
                .enter() //means keeps looping in the data
                .append("g");

            arc.append("path")
                .attr("d", path)
                .attr("fill", function (d) {
                    return color(d.data.total_up_percentage);
                })
                .append("text")
                .text("afdaf");

            var label = d3.arc()
                .outerRadius(radius)
                .innerRadius(0);

            arc.append("text")
                .attr("transform", (d) => {
                    return "translate(" + label.centroid(d) + ")";
                })
                .attr("text-anchor", "middle")
                .text((d) => {
                    return d.data.total_up_percentage + "%"
                });

            /* END OF PIE CHART */
        })
        .catch((error) => {
            console.log(error);
        });

    /* START OF LINE CHART */
    $(document).ready(() => {
        // set the dimensions and margins of the graph
        var margin = { top: 40, right: 20, bottom: 30, left: 50 },
            width = 1250 - margin.left - margin.right,
            height = 500 - margin.top - margin.bottom;

        // parse the date / time
        var parseTime = d3.timeParse("%H:%M:%S");


        // set the ranges
        var x = d3.scaleTime().range([0, width]);
        var y = d3.scaleLinear().range([height, 0]);

        // define the line
        var valueline = d3.line()
            .x(function (d) { return x(d.availability_time); })
            .y(function (d) { return y(d.total_hour_percentage); });

        // append the svg obgect to the body of the page
        // appends a 'group' element to 'svg'
        // moves the 'group' element to the top left margin
        var svgp = d3.select("#lineChart").append("svg")
            .attr("width", width + margin.left + margin.right)
            .attr("height", height + margin.top + margin.bottom);


        var svg = svgp.append("g")
            .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

        function draw(data) {
            // format the data
            data.forEach(function (d) {
                d.availability_time = (parseTime(d.availability_time));
                d.total_hour_percentage = d.total_hour_percentage;
            });

            // sort time ascending
            data.sort(function (a, b) {
                return a["availability_time"] - b["availability_time"];
            })

            // Scale the range of the data
            x.domain(d3.extent(data, function (d) {
                return d.availability_time;
            }));
            y.domain([0, d3.max(data, function (d) {
                return Math.max(d.total_hour_percentage);
            })]);
            /*
            y.domain([d3.min(data, d=>d.total_hour_percentage), 
                d3.max(data, d=>d.total_hour_percentage)]);*/

            // Add the valueline path.
            svg.append("path")
                .data([data])
                .attr("class", "line")
                .attr("d", valueline);
            // Add the X Axis
            svg.append("g")
                .attr("transform", "translate(0," + height + ")")
                .call(d3.axisBottom(x).ticks(d3.timeHour.every(1)).tickFormat(d3.timeFormat('%H:%M')));

            // Add the Y Axis
            svg.append("g")
                .call(d3.axisLeft(y));
        }

        svgp.append('text')
        .attr('class', 'title')
        .attr('x', width / 2)
        .attr('y', margin.top / 2)
        .attr('text-anchor', 'middle')
        .text('Overall performance of CAMs per hour by percentage(%): ');

        // Get the data
        var perHourResult = "/perHourAvailabilities/" + defaultDate;
        console.log(perHourResult);

        d3.json(perHourResult)
            .then((data) => {
                draw(data);
            })
            .catch((error) => {
                console.log(error);
            });
    });
    /* END OF LINE CHART */

});

$('#daterange').on('apply.daterangepicker', function (ev, picker) {
    var startDate = picker.startDate.format('YYYY-MM-DD');
    var endDate = picker.endDate.format('YYYY-MM-DD');
    console.log(startDate);
    console.log(endDate);

    var staticUrlDowntime = "/topdowntime/" + startDate + "/" + endDate;
    console.log(staticUrlDowntime);
    $(document).ready(() => {
        $.ajax({
            url: (staticUrlDowntime),
            method: "GET",
            dataType: "json",
            success: (data) => {
                console.log(data);
                $("#top5Downtime").html(' ');
                $.each(data, (key, val) => {
                    $("#top5Downtime").append("<li>" + val.event_description + " - " + val.error_count + "</li>");
                });
            }
        })
    });

    var mostDownRangedTerminal = "/mostDownTerminals/" + startDate + "/" + endDate;
    console.log(mostDownRangedTerminal);
    $(document).ready(()=>{
        $.ajax({
            url: (mostDownRangedTerminal),
            method: "GET",
            dataType: "json",
            success:(data)=>{
                $("#mostDown").html('');
                $.each(data,(key,val)=>{
                    $("#mostDown").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    });

    var mostUpRangedTerminal = "/mostUpTerminals/" + startDate + "/" + endDate;
    console.log(mostUpRangedTerminal);
    $(document).ready(()=>{
        $.ajax({
            url: (mostUpRangedTerminal),
            method: "GET",
            dataType: "json",
            success:(data)=>{
                $("#mostUp").html('');
                $.each(data,(key,val)=>{
                    $("#mostUp").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    });

    $("#bar-chart").html('');
    $("#pieChart").html('');
    $("#lineChart").html('');
   

    var HighAvailStaticUrl = "/highAvailabilities/" + startDate + "/" + endDate;
    console.log(HighAvailStaticUrl);

    d3.json(HighAvailStaticUrl)
        .then((data) => {
            console.log(data);

            const svgContainer = d3.select('#bar-chart')
                .append('svg');

            const margin = 80;
            const width = 1000 - 2 * margin;
            const height = 600 - 2 * margin;

            const chart = svgContainer.append('g')
                .attr('transform', "translate(" + margin + "," + margin + ")");

            const xScale = d3.scaleBand()
                .range([0, width])
                .domain(data.map((s) => s.region_iso_code))
                .padding(0.4)

            const yScale = d3.scaleLinear()
                .range([height, 0])
                .domain([0, 100]);

            // vertical grid lines
            // const makeXLines = () => d3.axisBottom()
            //   .scale(xScale)

            const makeYLines = () => d3.axisLeft()
                .scale(yScale)

            chart.append('g')
                .attr('transform', `translate(0, ${height})`)
                .call(d3.axisBottom(xScale));

            chart.append('g')
                .call(d3.axisLeft(yScale));

            chart.append('g')
                .attr('class', 'grid')
                .call(makeYLines()
                    .tickSize(-width, 0, 0)
                    .tickFormat('')
                )

            const barGroups = chart.selectAll()
                .data(data)
                .enter()
                .append('g')

            barGroups
                .append('rect')
                .attr('class', 'bar')
                .attr('x', (g) => xScale(g.region_iso_code))
                .attr('y', (g) => yScale(g.total_up_percentage))
                .attr('height', (g) => height - yScale(g.total_up_percentage))
                .attr('width', xScale.bandwidth())

            barGroups
                .append('text')
                .attr('class', 'value')
                .attr('x', (a) => xScale(a.region_iso_code) + xScale.bandwidth() / 2)
                .attr('y', (a) => yScale(a.total_up_percentage) + 30)
                .attr('text-anchor', 'middle')
                .text((a) => `${a.total_up_percentage}%`)

            svgContainer
                .append('text')
                .attr('class', 'label')
                .attr('x', -(height / 2) - margin)
                .attr('y', margin / 2.4)
                .attr('transform', 'rotate(-90)')
                .attr('text-anchor', 'middle')
                .text('Percentage (%)')

            svgContainer.append('text')
                .attr('class', 'label')
                .attr('x', width / 2 + margin)
                .attr('y', height + margin * 1.7)
                .attr('text-anchor', 'middle')
                .text('Terminals')

            svgContainer.append('text')
                .attr('class', 'title')
                .attr('x', width / 2 + margin)
                .attr('y', 40)
                .attr('text-anchor', 'middle')
                .text('Availability (%) of CAM/s for date: ' + startDate + ' - ' + endDate)
            /** END FOR BAR CHART */

            /** START OF PIE CHART */

            var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

            const pieContainer = d3.select("#pieChart")
                .append("svg")
                .attr("width", svgCirWidth)
                .attr("height", svgCirHeight);

            //create group element to hold pie chart

            var g = pieContainer.append("g")
                .attr("transform", "translate(" + 250 + "," + radius + ")");

            var color = d3.scaleOrdinal(d3.schemeCategory10);

            var pie = d3.pie().value(function (d) {
                return d.total_up_percentage;
            });

            var path = d3.arc()
                .outerRadius(radius)
                .innerRadius(0);

            var arc = g.selectAll("arc")
                .data(pie(data))
                .enter() //means keeps looping in the data
                .append("g");

            arc.append("path")
                .attr("d", path)
                .attr("fill", function (d) {
                    return color(d.data.total_up_percentage);
                })
                .append("text")
                .text("afdaf");

            var label = d3.arc()
                .outerRadius(radius)
                .innerRadius(0);

            arc.append("text")
                .attr("transform", (d) => {
                    return "translate(" + label.centroid(d) + ")";
                })
                .attr("text-anchor", "middle")
                .text((d) => {
                    return d.data.region_iso_code + ":" + d.data.total_up_percentage + "%"
                });

        })
        .catch((error) => {
            console.log(error);
        });
    /* START OF LINE CHART */
    $(document).ready(() => {
        // set the dimensions and margins of the graph
        var margin = { top: 40, right: 20, bottom: 30, left: 50 },
            width = 1250 - margin.left - margin.right,
            height = 500 - margin.top - margin.bottom;

        // parse the date / time
        var parseTime = d3.timeParse("%H:%M:%S");


        // set the ranges
        var x = d3.scaleTime().range([0, width]);
        var y = d3.scaleLinear().range([height, 0]);

        // define the line
        var valueline = d3.line()
            .x(function (d) { return x(d.availability_time); })
            .y(function (d) { return y(d.total_hour_percentage); });

        // append the svg obgect to the body of the page
        // appends a 'group' element to 'svg'
        // moves the 'group' element to the top left margin
        var svgp = d3.select("#lineChart").append("svg")
            .attr("width", width + margin.left + margin.right)
            .attr("height", height + margin.top + margin.bottom);


        var svg = svgp.append("g")
            .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

        function draw(data) {
            // format the data
            data.forEach(function (d) {
                d.availability_time = (parseTime(d.availability_time));
                d.total_hour_percentage = d.total_hour_percentage;
            });

            // sort time ascending
            data.sort(function (a, b) {
                return a["availability_time"] - b["availability_time"];
            })

            // Scale the range of the data
            x.domain(d3.extent(data, function (d) {
                return d.availability_time;
            }));
            y.domain([0, d3.max(data, function (d) {
                return Math.max(d.total_hour_percentage);
            })]);
            /*
            y.domain([d3.min(data, d=>d.total_hour_percentage), 
                d3.max(data, d=>d.total_hour_percentage)]);*/

            // Add the valueline path.
            svg.append("path")
                .data([data])
                .attr("class", "line")
                .attr("d", valueline);
            // Add the X Axis
            svg.append("g")
                .attr("transform", "translate(0," + height + ")")
                .call(d3.axisBottom(x).ticks(d3.timeHour.every(1)).tickFormat(d3.timeFormat('%H:%M')));

            // Add the Y Axis
            svg.append("g")
                .call(d3.axisLeft(y));
        }

        svgp.append('text')
        .attr('class', 'title')
        .attr('x', width / 2)
        .attr('y', margin.top / 2)
        .attr('text-anchor', 'middle')
        .text('Availability (%) of CAM for date: '+ startDate + '-' + endDate);

        // Get the data
        var perHourResult = "/perHourAvailabilities/" + startDate + "/" + endDate;
        console.log(perHourResult);

        d3.json(perHourResult)
            .then((data) => {
                draw(data);
            })
            .catch((error) => {
                console.log(error);
            });
    });
    /* END OF LINE CHART */
});
