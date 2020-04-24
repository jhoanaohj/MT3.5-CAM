var data = [{"symbol":"MSFT","date":"Day1","price":40},{"symbol":"MSFT","date":"Day2","price":23.18},{"symbol":"MSFT","date":"Day3","price":24.43},{"symbol":"MSFT","date":"Day4","price":25.49},{"symbol":"MSFT","date":"Day5","price":27.48},{"symbol":"MSFT","date":"Day6","price":29.27},{"symbol":"IBM","date":"Day1","price":100.52},{"symbol":"IBM","date":"Day2","price":92.11},{"symbol":"IBM","date":"Day3","price":106.11},{"symbol":"IBM","date":"Day4","price":99.95},{"symbol":"IBM","date":"Day5","price":96.31},{"symbol":"IBM","date":"Day6","price":98.33},{"symbol":"AAPL","date":"Day1","price":21},{"symbol":"AAPL","date":"Day2","price":26.19},{"symbol":"AAPL","date":"Day3","price":25.41},{"symbol":"AAPL","date":"Day4","price":30.47},{"symbol":"AAPL","date":"Day5","price":12.88},{"symbol":"AAPL","date":"Day6","price":9.78}]

// Set the dimensions of the canvas / graph
var margin = {top: 30, right: 20, bottom: 30, left: 50},
    width = 600 - margin.left - margin.right,
    height = 270 - margin.top - margin.bottom;

// Parse the date / time
//var parseDate = d3.time.format("%b %Y").parse;

// Set the ranges
var x = d3.scale.ordinal().rangeRoundBands([0, width], .1);
var y = d3.scale.linear().range([height, 0]);

// Define the axes
var xAxis = d3.svg.axis().scale(x)
    .orient("bottom").ticks(5);

var yAxis = d3.svg.axis().scale(y)
    .orient("left").ticks(5).innerTickSize(-width)
    .outerTickSize(0)
    .tickPadding(10);

// Define the line
var priceline = d3.svg.line()	
    .x(function(d) { return x(d.date); })
    .y(function(d) { return y(d.price); });
    
// Adds the svg canvas
var svg = d3.select("#lineChart")
    .append("svg")
        .attr("width", width + margin.left + margin.right)
        .attr("height", height + margin.top + margin.bottom)
    .append("g")
        .attr("transform", 
              "translate(" + margin.left + "," + margin.top + ")");

// Get the data
    // Scale the range of the data
    x.domain(data.map(function(d){ return d.date; }));
    y.domain([0, d3.max(data, function(d) { return d.price; })]);

    // Nest the entries by symbol
    var dataNest = d3.nest()
        .key(function(d) {return d.symbol;})
        .entries(data);

    var color = d3.scale.category10();  // set the colour scale

    // Loop through each symbol / key
    dataNest.forEach(function(d) {

        svg.append("path")
            .attr("class", "line")
            .style("stroke", function() { // Add dynamically
                return d.color = color(d.key); })
            .attr("d", priceline(d.values));

    });

    // Add the X Axis
    svg.append("g")
        .attr("class", "x axis")
        .attr("transform", "translate(0," + height + ")")
        .call(xAxis);

    // Add the Y Axis
    svg.append("g")
        .attr("class", "y axis")
        .call(yAxis);
        
		d3.select(".y>path").remove();        