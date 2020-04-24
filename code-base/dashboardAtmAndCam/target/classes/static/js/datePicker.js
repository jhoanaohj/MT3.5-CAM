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
                .padding(0.8)

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

    $("#bar-chart").html('');
    $("#pieChart").html('');

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
});
