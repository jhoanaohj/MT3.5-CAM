var data = [
    {"platform": "Android", "percentage": 40.11},
    {"platform": "Windows", "percentage": 36.69},
    {"platform": "iOS", "percentage": 13.06}
];


var svgCirWidth = 600, svgCirHeight = 300, radius = Math.min(svgCirWidth, svgCirHeight) / 2;

const pieContainer = d3.select("#pieChart")
.append("svg")
.attr("width", svgCirWidth)
.attr("height", svgCirHeight);

//create group element to hold pie chart

var g = pieContainer.append("g")
.attr("transform", "translate(" + 250 + "," + radius + ")");

var color = d3.scaleOrdinal(d3.schemeCategory10);

var pie = d3.pie().value(function(d){
    return d.percentage;
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
.attr("fill", function(d){
    return color(d.data.percentage);
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
    .text((d) =>{
        return d.data.platform + ":" + d.data.percentage + "%"
    });