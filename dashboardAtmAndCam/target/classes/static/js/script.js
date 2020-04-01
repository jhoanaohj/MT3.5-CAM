

// BAR CHART
//var dataset = [80, 100, 56, 12, 100, 30, 40, 120, 160];

// var dataset = [1,2,3,4,5];
// var svgWidth = 500, svgHeight = 300, barPadding = 15;
// var barWidth = (svgWidth / dataset.length);
// //window.alert(barWidth)
// var svg = d3.select('svg')
// .attr("width", svgWidth)
// .attr("height", svgHeight);

// var yScale = d3.scaleLinear()
// .domain([0, d3.max(dataset)])
// .range([0,svgHeight]);

// var barChart = svg.selectAll("rect")
// .data(dataset)
// .enter()
// .append("rect")
// .attr("y", function(d){
//     return svgHeight - yScale(d);
// })
// .attr("height", d => yScale(d))
// .attr("width", barWidth - barPadding)
// .attr("transform", function(d,i){
//     var translate = [barWidth * i, 0];
//     console.log("translate " + translate);
//     console.log("distance to each other: " + (barWidth - barPadding));
//     console.log(i)
//     return "translate(" + translate + ")";
// })


var dataSet = [10.9, 20, 30, 40, 50];
var svgWidth = 500, svgHeight = 300;
var barPadding = 5;
var barWidth = (svgWidth / dataSet.length);

var svg = d3.selectAll('svg')
.attr("width", svgWidth)
.attr("height", svgHeight);

var barChart = svg.selectAll("rect")
.data(dataSet)
.enter()
.append("rect")
.attr("y", (d) => {
    return svgHeight - d;
})
.attr("height", (d)=> {
    return d;
})
.attr("width", barWidth - barPadding)
.attr("transform", (d,i)=>{
    var translate = [barWidth * i, 0];
    return "translate (" + translate + ")";
});

var url = "/queries/31370100";
// d3.json(url, function(data) {
//   console.log(data);
// });

var jsons = '[{"id":"31370100", "machine_name":"GUMACA BRANCH CAM",' +
        '"machine_type":"CAM","operation_start":"05:04:33","operation_end":"09:04:33"}]';

d3.json(jsons, (data)=>{
    console.log(data);
});



 