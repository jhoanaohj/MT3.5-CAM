var staticUrl = "/queries/31370100";

 $.getJSON(staticUrl, (data) => {
    console.log(data);
    console.log(data[0].operation_start);
});

$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
});
        
});

//var jsonData2 = '[{"id":"31370100","machine_name":"GUMACA BRANCH CAM","machine_type":"CAM","operation_start":"05:04:33","operation_end":"09:04:33"}]'

// d3.json(url).then(function (data) {

//   if (typeof data === 'undefined' || data === null) {
//       console.error("Failed to retreive the data");
//   } else {
//       console.log(data);
//       window.alert(data.machine_name);
//   }
// }).catch(function (error) {
//   console.error("Failed to retreive the data or there was an error parsing the response: " + error);
// });

// var obj = JSON.parse(jsonData);
// document.getElementById("demo").innerHTML = obj.id + obj.machine_name;

var	margin = {top: 30, right: 20, bottom: 30, left: 50},
	width = 500 - margin.left - margin.right,
	height = 50 - margin.top - margin.bottom;

var dataset = [1,2,3,4,5,100,39,49,12,1.1];
var svgWidth = 500, svgHeight = 300, barPadding = 30;
var barWidth = (width / dataset.length);
//window.alert(barWidth)
var svg = d3.select('svg')
.attr("width", svgWidth)
.attr("height", svgHeight);

var yScale = d3.scaleLinear()
.domain([0, d3.max(dataset)])
.range([0,svgHeight]);

var barChart = svg.selectAll("rect")
.data(dataset)
.enter()
.append("rect")
.attr("y", function(d){
    return svgHeight - yScale(d);
})
.attr("x",(d)=>{
    return 85;
})
.attr("height", d => yScale(d))
.attr("width", barWidth - barPadding)
.attr("transform", function(d,i){
    var translate = [barWidth * i, 0];
    console.log("translate " + translate);
    console.log("distance to each other: " + (barWidth - barPadding));
    console.log(i)
    return "translate(" + translate + ")";
})


 