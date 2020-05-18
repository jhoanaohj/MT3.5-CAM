function defaultLoad(defaultDate) {

    $("#divDateRange").html('');
    $("#bar-chart").html('');
    $("#pieChart").html('');
    $("#lineChart").html('');
    $('#top5Downtime').html('');
    $("#mostDown").html('');
    $("#mostUp").html('');
    $("#pieChart2").html('');
    $("#barChart2").html('');
    $("#barChart3").html('');

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
    $(document).ready(() => {
        $.ajax({
            url: (mostDownDefaultTerminal),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $.each(data, (key, val) => {
                    $("#mostDown").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    })

    var mostUpDefaultTerminal = "/mostUpTerminals/" + defaultDate;
    console.log(mostUpDefaultTerminal);
    $(document).ready(() => {
        $.ajax({
            url: (mostUpDefaultTerminal),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $("#mostUp").html('');
                $.each(data, (key, val) => {
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

            //console.log(data);

            const svgContainer = d3.select('#bar-chart')
                .append('svg');

            const margin = 90;
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
                .text('Availability (%) of CAM per region for date: ' + defaultDate)
            /** END FOR BAR CHART */
        })
        .catch((error) => {
            console.log(error);
        });

    /** START OF PIE CHART */
    $(document).ready(() => {
        var plannedVsUnplannedURL = "/plannedvsunplanned/" + defaultDate;
        console.log(plannedVsUnplannedURL);
        d3.json(plannedVsUnplannedURL)
            .then((data) => {

                var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

                const pieContainer = d3.select("#pieChart")
                    .append("svg")
                    .attr("width", svgCirWidth)
                    .attr("height", svgCirHeight);

                //create group element to hold pie chart

                var g = pieContainer.append("g")
                    .attr("transform", "translate(" + 350 + "," + radius + ")");

                var color = d3.scaleOrdinal(d3.schemeSet3);

                var pie = d3.pie().value(function (d) {
                    return d.result;
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
                        return color(d.data.result);
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
                        return d.data.result + "%";
                    });

                var legendG = g.selectAll(".legend")
                    .data(pie(data))
                    .enter()
                    .append("g")
                    .attr("transform", function (d, i) {
                        return "translate(" + (-250) + "," + (i * 15 + 20) + ")";
                    })
                    .attr("class", "legend");

                legendG.append("rect")
                    .attr("width", 10)
                    .attr("height", 10)
                    .attr("fill", function (d) {
                        return color(d.value);
                    });

                legendG.append("text")
                    .text(function (d) {
                        return d.data.planned;
                    })
                    .style("font-size", 12)
                    .attr("y", 10)
                    .attr("x", 11);


            })
            .catch((error) => {
                console.log(error);
            });
    })
    /* END OF PIE CHART UNPLANNED VS PLANNED */

    /** START OF PIE CHART */
    $(document).ready(() => {
        var downTimeVsupTimeURL = "/upvsdowntimepercent/" + defaultDate;
        //console.log(plannedVsUnplannedURL);
        d3.json(downTimeVsupTimeURL)
            .then((data) => {

                var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

                const pieContainer = d3.select("#pieChart2")
                    .append("svg")
                    .attr("width", svgCirWidth)
                    .attr("height", svgCirHeight);

                //create group element to hold pie chart

                var g = pieContainer.append("g")
                    .attr("transform", "translate(" + 350 + "," + radius + ")");

                var color = d3.scaleOrdinal(d3.schemeSet3);

                var pie = d3.pie().value(function (d) {
                    return d.percentage_result;
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
                        return color(d.data.percentage_result);
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
                        return d.data.percentage_result + "%";
                    });

                var legendG = g.selectAll(".legend")
                    .data(pie(data))
                    .enter()
                    .append("g")
                    .attr("transform", function (d, i) {
                        return "translate(" + (-250) + "," + (i * 15 + 20) + ")";
                    })
                    .attr("class", "legend");

                legendG.append("rect")
                    .attr("width", 10)
                    .attr("height", 10)
                    .attr("fill", function (d) {
                        return color(d.value);
                    });

                legendG.append("text")
                    .text(function (d) {
                        return d.data.columns_percent;
                    })
                    .style("font-size", 12)
                    .attr("y", 10)
                    .attr("x", 11);


            })
            .catch((error) => {
                console.log(error);
            });
    })
    /* END OF PIE CHART */


    /* START OF LINE CHART */
    $(document).ready(() => {
        // set the dimensions and margins of the graph
        var margin = { top: 40, right: 20, bottom: 30, left: 150 },
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
            .attr('x', width / 2 + 170)
            .attr('y', margin.top / 2)
            .attr('text-anchor', 'middle')
            .text('Overall performance of CAMs per hour by percentage(%): ');

        // Get the data
        var perHourResult = "/perHourAvailabilities/" + defaultDate;
        //console.log(perHourResult);

        d3.json(perHourResult)
            .then((data) => {
                draw(data);
            })
            .catch((error) => {
                console.log(error);
            });
    });
    /* END OF LINE CHART */

    /* START OF HORIZONTAL LINE CHART */
    $(document).ready(() => {

        // Get the data
        var plannedVsUnplannedBar = "/plannedResult/" + defaultDate;
        //console.log(perHourResult);

        d3.json(plannedVsUnplannedBar)
            .then((data) => {
                // set the dimensions and margins of the graph
                var margin = { top: 100, right: 10, bottom: 10, left: 120 },
                    width = 1000 - margin.left - margin.right,
                    height = 400 - margin.top - margin.bottom;

                // append the svg object to the body of the page
                var svg = d3.select("#barChart2")
                    .append("svg")
                    .attr("width", width + margin.left + margin.right)
                    .attr("height", "350")
                    .append("g")
                    .attr("transform",
                        "translate(" + 370 + "," + 130 + ")");

                svg.append('text')
                    .attr('class', 'title')
                    .attr('x', "350")
                    .attr('y', "-50")
                    .attr('text-anchor', 'middle')
                    .text('Error count on Planned Result: ');

                // Parse the Data

                // Add X axis
                var x = d3.scaleLinear()
                    .range([0, width])
                    .domain([0, d3.max(data, (s) => s.event_count)]);


                svg.append("g")
                    .attr("transform", "translate(0," + height + ")")
                    .call(d3.axisBottom(x))
                    .selectAll("text")
                    .attr("transform", "translate(-10,0)rotate(-45)")
                    .style("text-anchor", "end");

                // Y axis
                var y = d3.scaleBand()
                    .range([height, 0])
                    .domain(data.map(function (d) { return d.event_description; }))
                    .padding(.4);

                svg.append("g")
                    .call(d3.axisLeft(y))

                //Bars
                const barGroups = svg.selectAll("myRect")
                    .data(data)
                    .enter()
                    .append("g");

                barGroups
                    .append("rect")
                    .attr("x", x(0))
                    .attr("y", function (d) { return y(d.event_description); })
                    .attr("width", function (d) { return x(d.event_count); })
                    .attr("height", y.bandwidth())
                    .attr("fill", "#69b3a2");

                barGroups
                    .append('text')
                    .attr('class', 'value')
                    .attr('y', (a) => y(a.event_description) + y.bandwidth() / 2)
                    .attr('x', (a) => x(a.event_count) + 30)
                    .attr('text-anchor', 'middle')
                    .text((a) => `${a.event_count}`);
            })
            .catch((error) => {
                console.log(error);
            });

    });
    /* END OF HORIZONTAL LINE CHART */

    /* START OF HORIZONTAL LINE CHART */
    $(document).ready(() => {

        // Get the data
        var plannedVsUnplannedBar = "/unplannedResult/" + defaultDate;
        d3.json(plannedVsUnplannedBar)
            .then((data) => {
                // set the dimensions and margins of the graph
                var margin = { top: 100, right: 10, bottom: 10, left: 120 },
                    width = 1000 - margin.left - margin.right,
                    height = 400 - margin.top - margin.bottom;

                // append the svg object to the body of the page
                var svg = d3.select("#barChart3")
                    .append("svg")
                    .attr("width", width + margin.left + margin.right)
                    .attr("height", "350")
                    .append("g")
                    .attr("transform",
                        "translate(" + 370 + "," + 130 + ")");

                svg.append('text')
                    .attr('class', 'title')
                    .attr('x', "350")
                    .attr('y', "-50")
                    .attr('text-anchor', 'middle')
                    .text('Error count on Unplanned Result: ');

                // Parse the Data

                // Add X axis
                var x = d3.scaleLinear()
                    .range([0, width])
                    .domain([0, d3.max(data, (s) => s.event_count)]);


                svg.append("g")
                    .attr("transform", "translate(0," + height + ")")
                    .call(d3.axisBottom(x))
                    .selectAll("text")
                    .attr("transform", "translate(-10,0)rotate(-45)")
                    .style("text-anchor", "end");

                // Y axis
                var y = d3.scaleBand()
                    .range([height, 0])
                    .domain(data.map(function (d) { return d.event_description; }))
                    .padding(.4);

                svg.append("g")
                    .call(d3.axisLeft(y))

                //Bars
                const barGroups = svg.selectAll("myRect")
                    .data(data)
                    .enter()
                    .append("g");

                barGroups
                    .append("rect")
                    .attr("x", x(0))
                    .attr("y", function (d) { return y(d.event_description); })
                    .attr("width", function (d) { return x(d.event_count); })
                    .attr("height", y.bandwidth())
                    .attr("fill", "#69b3a2");

                barGroups
                    .append('text')
                    .attr('class', 'value')
                    .attr('y', (a) => y(a.event_description) + y.bandwidth() / 2)
                    .attr('x', (a) => x(a.event_count) + 30)
                    .attr('text-anchor', 'middle')
                    .text((a) => `${a.event_count}`);
            })
            .catch((error) => {
                console.log(error);
            });

    });
    /* END OF HORIZONTAL LINE CHART */

} //END OF FUNCTION DEFAULT LOAD

//bookmark2 daily
function dailyLoad(dailyDate) {

    $("#bar-chart").html('');
    $("#pieChart").html('');
    $("#lineChart").html('');
    $('#top5Downtime').html('');
    $("#mostDown").html('');
    $("#mostUp").html('');
    $("#pieChart2").html('');
    $("#barChart2").html('');
    $("#barChart3").html('');

    var staticUrlTop5Downtime = "/topdowntime/" + dailyDate;
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

    var mostDownDefaultTerminal = "/mostDownTerminals/" + dailyDate;
    console.log(mostDownDefaultTerminal);
    $(document).ready(() => {
        $.ajax({
            url: (mostDownDefaultTerminal),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $.each(data, (key, val) => {
                    $("#mostDown").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    })

    var mostUpDefaultTerminal = "/mostUpTerminals/" + dailyDate;
    console.log(mostUpDefaultTerminal);
    $(document).ready(() => {
        $.ajax({
            url: (mostUpDefaultTerminal),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $("#mostUp").html('');
                $.each(data, (key, val) => {
                    $("#mostUp").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    });

    console.log("d3 version: " + d3.version);

    /** CODE FOR THE BAR CHART */
    var defaultHighAvailStaticUrl = "/highAvailabilities/" + dailyDate;
    console.log(defaultHighAvailStaticUrl);

    d3.json(defaultHighAvailStaticUrl)
        .then((data) => {
            //console.log(data);

            const svgContainer = d3.select('#bar-chart')
                .append('svg');

            const margin = 90;
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
                .text('Availability (%) of CAM per region for date: ' + dailyDate)
            /** END FOR BAR CHART */
        })
        .catch((error) => {
            console.log(error);
        });

    /** START OF PIE CHART */
    $(document).ready(() => {
        var plannedVsUnplannedURL = "/plannedvsunplanned/" + dailyDate;
        //console.log(plannedVsUnplannedURL);
        d3.json(plannedVsUnplannedURL)
            .then((data) => {

                var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

                const pieContainer = d3.select("#pieChart")
                    .append("svg")
                    .attr("width", svgCirWidth)
                    .attr("height", svgCirHeight);

                //create group element to hold pie chart

                var g = pieContainer.append("g")
                    .attr("transform", "translate(" + 350 + "," + radius + ")");

                var color = d3.scaleOrdinal(d3.schemeSet3);

                var pie = d3.pie().value(function (d) {
                    return d.result;
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
                        return color(d.data.result);
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
                        return d.data.result + "%";
                    });

                var legendG = g.selectAll(".legend")
                    .data(pie(data))
                    .enter()
                    .append("g")
                    .attr("transform", function (d, i) {
                        return "translate(" + (-250) + "," + (i * 15 + 20) + ")";
                    })
                    .attr("class", "legend");

                legendG.append("rect")
                    .attr("width", 10)
                    .attr("height", 10)
                    .attr("fill", function (d) {
                        return color(d.value);
                    });

                legendG.append("text")
                    .text(function (d) {
                        return d.data.planned;
                    })
                    .style("font-size", 12)
                    .attr("y", 10)
                    .attr("x", 11);


            })
            .catch((error) => {
                console.log(error);
            });
    })
    /* END OF PIE CHART UNPLANNED VS PLANNED */

    /** START OF PIE CHART */
    $(document).ready(() => {
        var downTimeVsupTimeURL = "/upvsdowntimepercent/" + dailyDate;
        //console.log(plannedVsUnplannedURL);
        d3.json(downTimeVsupTimeURL)
            .then((data) => {

                var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

                const pieContainer = d3.select("#pieChart2")
                    .append("svg")
                    .attr("width", svgCirWidth)
                    .attr("height", svgCirHeight);

                //create group element to hold pie chart

                var g = pieContainer.append("g")
                    .attr("transform", "translate(" + 350 + "," + radius + ")");

                var color = d3.scaleOrdinal(d3.schemeSet3);

                var pie = d3.pie().value(function (d) {
                    return d.percentage_result;
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
                        return color(d.data.percentage_result);
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
                        return d.data.percentage_result + "%";
                    });

                var legendG = g.selectAll(".legend")
                    .data(pie(data))
                    .enter()
                    .append("g")
                    .attr("transform", function (d, i) {
                        return "translate(" + (-250) + "," + (i * 15 + 20) + ")";
                    })
                    .attr("class", "legend");

                legendG.append("rect")
                    .attr("width", 10)
                    .attr("height", 10)
                    .attr("fill", function (d) {
                        return color(d.value);
                    });

                legendG.append("text")
                    .text(function (d) {
                        return d.data.columns_percent;
                    })
                    .style("font-size", 12)
                    .attr("y", 10)
                    .attr("x", 11);


            })
            .catch((error) => {
                console.log(error);
            });
    })
    /* END OF PIE CHART */


    /* START OF LINE CHART */
    $(document).ready(() => {
        // set the dimensions and margins of the graph
        var margin = { top: 40, right: 20, bottom: 30, left: 150 },
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
            .attr('x', width / 2 + 170)
            .attr('y', margin.top / 2)
            .attr('text-anchor', 'middle')
            .text('Overall performance of CAMs per hour by percentage(%): ');

        // Get the data
        var perHourResult = "/perHourAvailabilities/" + dailyDate;
        //console.log(perHourResult);

        d3.json(perHourResult)
            .then((data) => {
                draw(data);
            })
            .catch((error) => {
                console.log(error);
            });
    });
    /* END OF LINE CHART */

    /* START OF HORIZONTAL LINE CHART */
    $(document).ready(() => {

        // Get the data
        var plannedVsUnplannedBar = "/plannedResult/" + dailyDate;
        //console.log(perHourResult);

        d3.json(plannedVsUnplannedBar)
            .then((data) => {
                // set the dimensions and margins of the graph
                var margin = { top: 100, right: 10, bottom: 10, left: 120 },
                    width = 1000 - margin.left - margin.right,
                    height = 400 - margin.top - margin.bottom;

                // append the svg object to the body of the page
                var svg = d3.select("#barChart2")
                    .append("svg")
                    .attr("width", width + margin.left + margin.right)
                    .attr("height", "350")
                    .append("g")
                    .attr("transform",
                        "translate(" + 370 + "," + 130 + ")");

                svg.append('text')
                    .attr('class', 'title')
                    .attr('x', "350")
                    .attr('y', "-50")
                    .attr('text-anchor', 'middle')
                    .text('Error count on Planned Result: ');

                // Parse the Data

                // Add X axis
                var x = d3.scaleLinear()
                    .range([0, width])
                    .domain([0, d3.max(data, (s) => s.event_count)]);


                svg.append("g")
                    .attr("transform", "translate(0," + height + ")")
                    .call(d3.axisBottom(x))
                    .selectAll("text")
                    .attr("transform", "translate(-10,0)rotate(-45)")
                    .style("text-anchor", "end");

                // Y axis
                var y = d3.scaleBand()
                    .range([height, 0])
                    .domain(data.map(function (d) { return d.event_description; }))
                    .padding(.4);

                svg.append("g")
                    .call(d3.axisLeft(y))

                //Bars
                const barGroups = svg.selectAll("myRect")
                    .data(data)
                    .enter()
                    .append("g");

                barGroups
                    .append("rect")
                    .attr("x", x(0))
                    .attr("y", function (d) { return y(d.event_description); })
                    .attr("width", function (d) { return x(d.event_count); })
                    .attr("height", y.bandwidth())
                    .attr("fill", "#69b3a2");

                barGroups
                    .append('text')
                    .attr('class', 'value')
                    .attr('y', (a) => y(a.event_description) + y.bandwidth() / 2)
                    .attr('x', (a) => x(a.event_count) + 30)
                    .attr('text-anchor', 'middle')
                    .text((a) => `${a.event_count}`);
            })
            .catch((error) => {
                console.log(error);
            });

    });
    /* END OF HORIZONTAL LINE CHART */

    /* START OF HORIZONTAL LINE CHART */
    $(document).ready(() => {

        // Get the data
        var plannedVsUnplannedBar = "/unplannedResult/" + dailyDate;
        //console.log(perHourResult);

        d3.json(plannedVsUnplannedBar)
            .then((data) => {
                // set the dimensions and margins of the graph
                var margin = { top: 100, right: 10, bottom: 10, left: 120 },
                    width = 1000 - margin.left - margin.right,
                    height = 400 - margin.top - margin.bottom;

                // append the svg object to the body of the page
                var svg = d3.select("#barChart3")
                    .append("svg")
                    .attr("width", width + margin.left + margin.right)
                    .attr("height", "350")
                    .append("g")
                    .attr("transform",
                        "translate(" + 370 + "," + 130 + ")");

                svg.append('text')
                    .attr('class', 'title')
                    .attr('x', "350")
                    .attr('y', "-50")
                    .attr('text-anchor', 'middle')
                    .text('Error count on Unplanned Result: ');

                // Parse the Data

                // Add X axis
                var x = d3.scaleLinear()
                    .range([0, width])
                    .domain([0, d3.max(data, (s) => s.event_count)]);


                svg.append("g")
                    .attr("transform", "translate(0," + height + ")")
                    .call(d3.axisBottom(x))
                    .selectAll("text")
                    .attr("transform", "translate(-10,0)rotate(-45)")
                    .style("text-anchor", "end");

                // Y axis
                var y = d3.scaleBand()
                    .range([height, 0])
                    .domain(data.map(function (d) { return d.event_description; }))
                    .padding(.4);

                svg.append("g")
                    .call(d3.axisLeft(y))

                //Bars
                const barGroups = svg.selectAll("myRect")
                    .data(data)
                    .enter()
                    .append("g");

                barGroups
                    .append("rect")
                    .attr("x", x(0))
                    .attr("y", function (d) { return y(d.event_description); })
                    .attr("width", function (d) { return x(d.event_count); })
                    .attr("height", y.bandwidth())
                    .attr("fill", "#69b3a2");

                barGroups
                    .append('text')
                    .attr('class', 'value')
                    .attr('y', (a) => y(a.event_description) + y.bandwidth() / 2)
                    .attr('x', (a) => x(a.event_count) + 30)
                    .attr('text-anchor', 'middle')
                    .text((a) => `${a.event_count}`);
            })
            .catch((error) => {
                console.log(error);
            });

    });
    /* END OF HORIZONTAL LINE CHART */
}

// //bookmark3 
// function weeklyLoadRange(startDate, endDate) {
//     var getFirstDayWeek = startDate;
//     var getLastDayWeek = endDate;
//     console.clear();

//     console.log(getFirstDayWeek);
//     console.log(getLastDayWeek);

//     $("#bar-chart").html('');
//     $("#pieChart").html('');
//     $("#lineChart").html('');
//     $('#top5Downtime').html('');
//     $("#mostDown").html('');
//     $("#mostUp").html('');
//     $("#pieChart2").html('');
//     $("#barChart2").html('');
//     $("#barChart3").html('');

// } //END OF FUNCTION WEEKLY LOAD RANGE

//bookmark4
function rangeLoad(startDate, endDate) {

    $("#bar-chart").html('');
    $("#pieChart").html('');
    $("#lineChart").html('');
    $('#top5Downtime').html('');
    $("#mostDown").html('');
    $("#mostUp").html('');
    $("#pieChart2").html('');
    $("#barChart2").html('');
    $("#barChart3").html('');

    var staticUrlTop5Downtime = "/topdowntime/" + startDate + "/" + endDate;
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

    var mostDownDefaultTerminal = "/mostDownTerminals/" + startDate + "/" + endDate;
    console.log(mostDownDefaultTerminal);
    $(document).ready(() => {
        $.ajax({
            url: (mostDownDefaultTerminal),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $.each(data, (key, val) => {
                    $("#mostDown").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    })

    var mostUpDefaultTerminal = "/mostUpTerminals/" + startDate + "/" + endDate;
    console.log(mostUpDefaultTerminal);
    $(document).ready(() => {
        $.ajax({
            url: (mostUpDefaultTerminal),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $("#mostUp").html('');
                $.each(data, (key, val) => {
                    $("#mostUp").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    });

    console.log("d3 version: " + d3.version);

    /** CODE FOR THE BAR CHART */
    var defaultHighAvailStaticUrl = "/highAvailabilities/" + startDate + "/" + endDate;
    console.log(defaultHighAvailStaticUrl);

    d3.json(defaultHighAvailStaticUrl)
        .then((data) => {
            //console.log(data);

            const svgContainer = d3.select('#bar-chart')
                .append('svg');

            const margin = 90;
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
                .text('Availability (%) of CAM per region for dates: ' + startDate + " to " + endDate);
            /** END FOR BAR CHART */
        })
        .catch((error) => {
            console.log(error);
        });

    /** START OF PIE CHART */
    $(document).ready(() => {
        var plannedVsUnplannedURL = "/plannedvsunplanned/" + startDate + "/" + endDate;
        console.log(plannedVsUnplannedURL);
        d3.json(plannedVsUnplannedURL)
            .then((data) => {

                var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

                const pieContainer = d3.select("#pieChart")
                    .append("svg")
                    .attr("width", svgCirWidth)
                    .attr("height", svgCirHeight);

                //create group element to hold pie chart

                var g = pieContainer.append("g")
                    .attr("transform", "translate(" + 350 + "," + radius + ")");

                var color = d3.scaleOrdinal(d3.schemeSet3);

                var pie = d3.pie().value(function (d) {
                    return d.result;
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
                        return color(d.data.result);
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
                        return d.data.result + "%";
                    });

                var legendG = g.selectAll(".legend")
                    .data(pie(data))
                    .enter()
                    .append("g")
                    .attr("transform", function (d, i) {
                        return "translate(" + (-250) + "," + (i * 15 + 20) + ")";
                    })
                    .attr("class", "legend");

                legendG.append("rect")
                    .attr("width", 10)
                    .attr("height", 10)
                    .attr("fill", function (d) {
                        return color(d.value);
                    });

                legendG.append("text")
                    .text(function (d) {
                        return d.data.planned;
                    })
                    .style("font-size", 12)
                    .attr("y", 10)
                    .attr("x", 11);


            })
            .catch((error) => {
                console.log(error);
            });
    })
    /* END OF PIE CHART UNPLANNED VS PLANNED */

    /** START OF PIE CHART */
    $(document).ready(() => {
        var downTimeVsupTimeURL = "/upvsdowntimepercent/" + startDate + "/" + endDate;
        console.log(downTimeVsupTimeURL);
        d3.json(downTimeVsupTimeURL)
            .then((data) => {

                var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

                const pieContainer = d3.select("#pieChart2")
                    .append("svg")
                    .attr("width", svgCirWidth)
                    .attr("height", svgCirHeight);

                //create group element to hold pie chart

                var g = pieContainer.append("g")
                    .attr("transform", "translate(" + 350 + "," + radius + ")");

                var color = d3.scaleOrdinal(d3.schemeSet3);

                var pie = d3.pie().value(function (d) {
                    return d.percentage_result;
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
                        return color(d.data.percentage_result);
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
                        return d.data.percentage_result + "%";
                    });

                var legendG = g.selectAll(".legend")
                    .data(pie(data))
                    .enter()
                    .append("g")
                    .attr("transform", function (d, i) {
                        return "translate(" + (-250) + "," + (i * 15 + 20) + ")";
                    })
                    .attr("class", "legend");

                legendG.append("rect")
                    .attr("width", 10)
                    .attr("height", 10)
                    .attr("fill", function (d) {
                        return color(d.value);
                    });

                legendG.append("text")
                    .text(function (d) {
                        return d.data.columns_percent;
                    })
                    .style("font-size", 12)
                    .attr("y", 10)
                    .attr("x", 11);


            })
            .catch((error) => {
                console.log(error);
            });
    })
    /* END OF PIE CHART */


    /* START OF LINE CHART */
    $(document).ready(() => {
        // set the dimensions and margins of the graph
        var margin = { top: 40, right: 20, bottom: 30, left: 150 },
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
            .attr('x', width / 2 + 170)
            .attr('y', margin.top / 2)
            .attr('text-anchor', 'middle')
            .text('Overall performance of CAMs per hour by percentage(%): ');

        // Get the data
        var perHourResult = "/perHourAvailabilities/" + startDate + "/" + endDate;
        //console.log(perHourResult);

        d3.json(perHourResult)
            .then((data) => {
                draw(data);
            })
            .catch((error) => {
                console.log(error);
            });
    });
    /* END OF LINE CHART */

    /* START OF HORIZONTAL LINE CHART */
    $(document).ready(() => {

        // Get the data
        var plannedVsUnplannedBar = "/plannedResult/" + startDate + "/" + endDate;
        //console.log(perHourResult);

        d3.json(plannedVsUnplannedBar)
            .then((data) => {
                // set the dimensions and margins of the graph
                var margin = { top: 100, right: 10, bottom: 10, left: 120 },
                    width = 1000 - margin.left - margin.right,
                    height = 400 - margin.top - margin.bottom;

                // append the svg object to the body of the page
                var svg = d3.select("#barChart2")
                    .append("svg")
                    .attr("width", width + margin.left + margin.right)
                    .attr("height", "350")
                    .append("g")
                    .attr("transform",
                        "translate(" + 370 + "," + 130 + ")");

                svg.append('text')
                    .attr('class', 'title')
                    .attr('x', "350")
                    .attr('y', "-50")
                    .attr('text-anchor', 'middle')
                    .text('Error count on Planned Result: ');

                // Parse the Data

                // Add X axis
                var x = d3.scaleLinear()
                    .range([0, width])
                    .domain([0, d3.max(data, (s) => s.event_count)]);


                svg.append("g")
                    .attr("transform", "translate(0," + height + ")")
                    .call(d3.axisBottom(x))
                    .selectAll("text")
                    .attr("transform", "translate(-10,0)rotate(-45)")
                    .style("text-anchor", "end");

                // Y axis
                var y = d3.scaleBand()
                    .range([height, 0])
                    .domain(data.map(function (d) { return d.event_description; }))
                    .padding(.4);

                svg.append("g")
                    .call(d3.axisLeft(y))

                //Bars
                const barGroups = svg.selectAll("myRect")
                    .data(data)
                    .enter()
                    .append("g");

                barGroups
                    .append("rect")
                    .attr("x", x(0))
                    .attr("y", function (d) { return y(d.event_description); })
                    .attr("width", function (d) { return x(d.event_count); })
                    .attr("height", y.bandwidth())
                    .attr("fill", "#69b3a2");

                barGroups
                    .append('text')
                    .attr('class', 'value')
                    .attr('y', (a) => y(a.event_description) + y.bandwidth() / 2)
                    .attr('x', (a) => x(a.event_count) + 30)
                    .attr('text-anchor', 'middle')
                    .text((a) => `${a.event_count}`);
            })
            .catch((error) => {
                console.log(error);
            });

    });
    /* END OF HORIZONTAL LINE CHART */

    /* START OF HORIZONTAL LINE CHART */
    $(document).ready(() => {

        // Get the data
        var plannedVsUnplannedBar = "/unplannedResult/" + startDate + "/" + endDate;
        //console.log(perHourResult);

        d3.json(plannedVsUnplannedBar)
            .then((data) => {
                // set the dimensions and margins of the graph
                var margin = { top: 100, right: 10, bottom: 10, left: 120 },
                    width = 1000 - margin.left - margin.right,
                    height = 400 - margin.top - margin.bottom;

                // append the svg object to the body of the page
                var svg = d3.select("#barChart3")
                    .append("svg")
                    .attr("width", width + margin.left + margin.right)
                    .attr("height", "350")
                    .append("g")
                    .attr("transform",
                        "translate(" + 370 + "," + 130 + ")");

                svg.append('text')
                    .attr('class', 'title')
                    .attr('x', "350")
                    .attr('y', "-50")
                    .attr('text-anchor', 'middle')
                    .text('Error count on Unplanned Result: ');

                // Parse the Data

                // Add X axis
                var x = d3.scaleLinear()
                    .range([0, width])
                    .domain([0, d3.max(data, (s) => s.event_count)]);


                svg.append("g")
                    .attr("transform", "translate(0," + height + ")")
                    .call(d3.axisBottom(x))
                    .selectAll("text")
                    .attr("transform", "translate(-10,0)rotate(-45)")
                    .style("text-anchor", "end");

                // Y axis
                var y = d3.scaleBand()
                    .range([height, 0])
                    .domain(data.map(function (d) { return d.event_description; }))
                    .padding(.4);

                svg.append("g")
                    .call(d3.axisLeft(y))

                //Bars
                const barGroups = svg.selectAll("myRect")
                    .data(data)
                    .enter()
                    .append("g");

                barGroups
                    .append("rect")
                    .attr("x", x(0))
                    .attr("y", function (d) { return y(d.event_description); })
                    .attr("width", function (d) { return x(d.event_count); })
                    .attr("height", y.bandwidth())
                    .attr("fill", "#69b3a2");

                barGroups
                    .append('text')
                    .attr('class', 'value')
                    .attr('y', (a) => y(a.event_description) + y.bandwidth() / 2)
                    .attr('x', (a) => x(a.event_count) + 30)
                    .attr('text-anchor', 'middle')
                    .text((a) => `${a.event_count}`);
            })
            .catch((error) => {
                console.log(error);
            });

    });
    /* END OF HORIZONTAL LINE CHART */
} //END OF FUNCTION RANGELOAD

//bookmark5 monthView
function monthlyLoad(lastMonStartDate, lastMonEndDate, currMonStartDate, currMonEndDate, nextMonStartDate, nextMonEndDate) {
    
    $("#bar-chart").html('');
    $("#pieChart").html('');
    $("#lineChart").html('');
    $('#top5Downtime').html('');
    $("#mostDown").html('');
    $("#mostUp").html('');
    $("#pieChart2").html('');
    $("#barChart2").html('');
    $("#barChart3").html('');

    console.log("Start of Last month: " + lastMonStartDate);
    console.log("End of Last Month: " + lastMonEndDate);

    console.log("Start of Current Date: " + currMonStartDate);
    console.log("end of Current Date: " + currMonEndDate);

    console.log("Start of Next month: " + nextMonStartDate);
    console.log("End of Next Month: " + nextMonEndDate);

    var staticUrlTop5Downtime = "/topdowntime/" + currMonStartDate + "/" + currMonEndDate;
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

    var mostDownStaticTerminal = "/mostDownTerminals/" + currMonStartDate + "/" + currMonEndDate;
    console.log(mostDownStaticTerminal);
    $(document).ready(() => {
        $.ajax({
            url: (mostDownStaticTerminal),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $.each(data, (key, val) => {
                    $("#mostDown").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    })

    var mostUpStaticTerminal = "/mostUpTerminals/" + currMonStartDate + "/" + currMonEndDate;
    console.log(mostUpStaticTerminal);
    $(document).ready(() => {
        $.ajax({
            url: (mostUpStaticTerminal),
            method: "GET",
            dataType: "json",
            success: (data) => {
                $("#mostUp").html('');
                $.each(data, (key, val) => {
                    $("#mostUp").append("<li>" + val.terminal_id + " - " + val.machine_name + "</li>");
                })
            }
        })
    });

    /** CODE FOR THE BAR CHART */
    var availabilityPerMonth = "/availabilityPerMonth/" + lastMonStartDate + "/" + lastMonEndDate + "/" + currMonStartDate + "/" + currMonEndDate + "/" + nextMonStartDate + "/" + nextMonEndDate;
    console.log(availabilityPerMonth);

    d3.json(availabilityPerMonth)
        .then((data) => {
            //console.log(data);

            const svgContainer = d3.select('#bar-chart')
                .append('svg');

            const margin = 80;
            const width = 1000 - 2 * margin;
            const height = 600 - 2 * margin;

            const chart = svgContainer.append('g')
                .attr('transform', "translate(" + margin + "," + margin + ")");

            const xScale = d3.scaleBand()
                .range([0, width])
                .domain(data.map((s) => s.months))
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
                .attr('x', (g) => xScale(g.months))
                .attr('y', (g) => yScale(g.availability_percent))
                .attr('height', (g) => height - yScale(g.availability_percent))
                .attr('width', xScale.bandwidth())

            barGroups
                .append('text')
                .attr('class', 'value')
                .attr('x', (a) => xScale(a.months) + xScale.bandwidth() / 2)
                .attr('y', (a) => yScale(a.availability_percent) + 30)
                .attr('text-anchor', 'middle')
                .text((a) => `${a.availability_percent}%`)

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
                .text('Availability (%) of CAM per Month')
            /** END FOR BAR CHART */

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
                var perHourResult = "/perHourAvailabilities/" + currMonStartDate + "/" + currMonEndDate;
                //console.log(perHourResult);

                d3.json(perHourResult)
                    .then((data) => {
                        draw(data);
                    })
                    .catch((error) => {
                        console.log(error);
                    });
            });

        })
        .catch((error) => {
            console.log(error);
        });

    /** START OF PIE CHART */
    $(document).ready(() => {
        var plannedVsUnplannedURL = "/plannedvsunplanned/" + currMonStartDate + "/" + currMonEndDate;
        console.log(plannedVsUnplannedURL);
        d3.json(plannedVsUnplannedURL)
            .then((data) => {

                var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

                const pieContainer = d3.select("#pieChart")
                    .append("svg")
                    .attr("width", svgCirWidth)
                    .attr("height", svgCirHeight);

                //create group element to hold pie chart

                var g = pieContainer.append("g")
                    .attr("transform", "translate(" + 350 + "," + radius + ")");

                var color = d3.scaleOrdinal(d3.schemeSet3);

                var pie = d3.pie().value(function (d) {
                    return d.result;
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
                        return color(d.data.result);
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
                        return d.data.result + "%";
                    });

                var legendG = g.selectAll(".legend")
                    .data(pie(data))
                    .enter()
                    .append("g")
                    .attr("transform", function (d, i) {
                        return "translate(" + (-250) + "," + (i * 15 + 20) + ")";
                    })
                    .attr("class", "legend");

                legendG.append("rect")
                    .attr("width", 10)
                    .attr("height", 10)
                    .attr("fill", function (d) {
                        return color(d.value);
                    });

                legendG.append("text")
                    .text(function (d) {
                        return d.data.planned;
                    })
                    .style("font-size", 12)
                    .attr("y", 10)
                    .attr("x", 11);


            })
            .catch((error) => {
                console.log(error);
            });
    })
    /* END OF PIE CHART UNPLANNED VS PLANNED */

    /** START OF PIE CHART */
    $(document).ready(() => {
        var downTimeVsupTimeURL = "/upvsdowntimepercent/" + currMonStartDate + "/" + currMonEndDate;
        console.log(downTimeVsupTimeURL);
        d3.json(downTimeVsupTimeURL)
            .then((data) => {

                var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

                const pieContainer = d3.select("#pieChart2")
                    .append("svg")
                    .attr("width", svgCirWidth)
                    .attr("height", svgCirHeight);

                //create group element to hold pie chart

                var g = pieContainer.append("g")
                    .attr("transform", "translate(" + 350 + "," + radius + ")");

                var color = d3.scaleOrdinal(d3.schemeSet3);

                var pie = d3.pie().value(function (d) {
                    return d.percentage_result;
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
                        return color(d.data.percentage_result);
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
                        return d.data.percentage_result + "%";
                    });

                var legendG = g.selectAll(".legend")
                    .data(pie(data))
                    .enter()
                    .append("g")
                    .attr("transform", function (d, i) {
                        return "translate(" + (-250) + "," + (i * 15 + 20) + ")";
                    })
                    .attr("class", "legend");

                legendG.append("rect")
                    .attr("width", 10)
                    .attr("height", 10)
                    .attr("fill", function (d) {
                        return color(d.value);
                    });

                legendG.append("text")
                    .text(function (d) {
                        return d.data.columns_percent;
                    })
                    .style("font-size", 12)
                    .attr("y", 10)
                    .attr("x", 11);


            })
            .catch((error) => {
                console.log(error);
            });
    })
    /* END OF PIE CHART */

    /* START OF HORIZONTAL BAR CHART */
    $(document).ready(() => {

        // Get the data
        var plannedVsUnplannedBar = "/plannedResult/" + currMonStartDate + "/" + currMonEndDate;
        //console.log(perHourResult);

        d3.json(plannedVsUnplannedBar)
            .then((data) => {
                // set the dimensions and margins of the graph
                var margin = { top: 100, right: 10, bottom: 10, left: 120 },
                    width = 1000 - margin.left - margin.right,
                    height = 400 - margin.top - margin.bottom;

                // append the svg object to the body of the page
                var svg = d3.select("#barChart2")
                    .append("svg")
                    .attr("width", width + margin.left + margin.right)
                    .attr("height", "350")
                    .append("g")
                    .attr("transform",
                        "translate(" + 370 + "," + 130 + ")");

                svg.append('text')
                    .attr('class', 'title')
                    .attr('x', "350")
                    .attr('y', "-50")
                    .attr('text-anchor', 'middle')
                    .text('Error count on Planned Result: ');

                // Parse the Data

                // Add X axis
                var x = d3.scaleLinear()
                    .range([0, width])
                    .domain([0, d3.max(data, (s) => s.event_count)]);


                svg.append("g")
                    .attr("transform", "translate(0," + height + ")")
                    .call(d3.axisBottom(x))
                    .selectAll("text")
                    .attr("transform", "translate(-10,0)rotate(-45)")
                    .style("text-anchor", "end");

                // Y axis
                var y = d3.scaleBand()
                    .range([height, 0])
                    .domain(data.map(function (d) { return d.event_description; }))
                    .padding(.4);

                svg.append("g")
                    .call(d3.axisLeft(y))

                //Bars
                const barGroups = svg.selectAll("myRect")
                    .data(data)
                    .enter()
                    .append("g");

                barGroups
                    .append("rect")
                    .attr("x", x(0))
                    .attr("y", function (d) { return y(d.event_description); })
                    .attr("width", function (d) { return x(d.event_count); })
                    .attr("height", y.bandwidth())
                    .attr("fill", "#69b3a2");

                barGroups
                    .append('text')
                    .attr('class', 'value')
                    .attr('y', (a) => y(a.event_description) + y.bandwidth() / 2)
                    .attr('x', (a) => x(a.event_count) + 30)
                    .attr('text-anchor', 'middle')
                    .text((a) => `${a.event_count}`);
            })
            .catch((error) => {
                console.log(error);
            });

    });
    /* END OF HORIZONTAL BAR CHART */

    /* START OF HORIZONTAL BAR CHART */
    $(document).ready(() => {

        // Get the data
        var plannedVsUnplannedBar = "/unplannedResult/" + currMonStartDate + "/" + currMonEndDate;
        //console.log(perHourResult);

        d3.json(plannedVsUnplannedBar)
            .then((data) => {
                // set the dimensions and margins of the graph
                var margin = { top: 100, right: 10, bottom: 10, left: 120 },
                    width = 1000 - margin.left - margin.right,
                    height = 400 - margin.top - margin.bottom;

                // append the svg object to the body of the page
                var svg = d3.select("#barChart3")
                    .append("svg")
                    .attr("width", width + margin.left + margin.right)
                    .attr("height", "350")
                    .append("g")
                    .attr("transform",
                        "translate(" + 370 + "," + 130 + ")");

                svg.append('text')
                    .attr('class', 'title')
                    .attr('x', "350")
                    .attr('y', "-50")
                    .attr('text-anchor', 'middle')
                    .text('Error count on Unplanned Result: ');

                // Parse the Data

                // Add X axis
                var x = d3.scaleLinear()
                    .range([0, width])
                    .domain([0, d3.max(data, (s) => s.event_count)]);


                svg.append("g")
                    .attr("transform", "translate(0," + height + ")")
                    .call(d3.axisBottom(x))
                    .selectAll("text")
                    .attr("transform", "translate(-10,0)rotate(-45)")
                    .style("text-anchor", "end");

                // Y axis
                var y = d3.scaleBand()
                    .range([height, 0])
                    .domain(data.map(function (d) { return d.event_description; }))
                    .padding(.4);

                svg.append("g")
                    .call(d3.axisLeft(y))

                //Bars
                const barGroups = svg.selectAll("myRect")
                    .data(data)
                    .enter()
                    .append("g");

                barGroups
                    .append("rect")
                    .attr("x", x(0))
                    .attr("y", function (d) { return y(d.event_description); })
                    .attr("width", function (d) { return x(d.event_count); })
                    .attr("height", y.bandwidth())
                    .attr("fill", "#69b3a2");

                barGroups
                    .append('text')
                    .attr('class', 'value')
                    .attr('y', (a) => y(a.event_description) + y.bandwidth() / 2)
                    .attr('x', (a) => x(a.event_count) + 30)
                    .attr('text-anchor', 'middle')
                    .text((a) => `${a.event_count}`);
            })
            .catch((error) => {
                console.log(error);
            });

    });
    /* END OF HORIZONTAL BAR CHART */

}//end of function.monthlyLoad