var staticUrl = "/queries/31370100";

 $.getJSON(staticUrl, (data) => {
    console.log(data);
    console.log(data[0].operation_start);
});

// $(document).ready(function () {
//     $('#sidebarCollapse').on('click', function () {
//         $('#sidebar').toggleClass('active');
// });
        
// });

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

// var	margin = {top: 30, right: 20, bottom: 30, left: 50},
// 	width = 500 - margin.left - margin.right,
// 	height = 50 - margin.top - margin.bottom;

// var dataset = [1,2,3,4,5,100,39,49,12,1.1,31,40];
// var svgWidth = 500, svgHeight = 300, barPadding = 10;
// var barWidth = (width / dataset.length);
//window.alert(barWidth)
// var svg = d3.select('svg')
// .attr("width", svgWidth)
// .attr("height", svgHeight);

// var yScale = d3.scaleLinear()
// .domain([0, d3.max(dataset)])
// .range([0,svgHeight]);

// var xScale = d3.scaleLinear()
// .domain([d3.max(dataset),0])
// .range(([svgWidth, 0]));

// var barChart = svg.selectAll("rect")
// .data(dataset)
// .enter()
// .append("rect")
// .attr("y", function(d){
//     return svgHeight - yScale(d);
// })
// .attr("x",(d)=>{
//     return 85;
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
const sample = [
    {
      language: 'Rust',
      value: 78.9,
      color: '#000000'
    },
    {
      language: 'Kotlin',
      value: 75.1,
      color: '#00a2ee'
    },
    {
      language: 'Python',
      value: 68.0,
      color: '#fbcb39'
    },
    {
      language: 'TypeScript',
      value: 67.0,
      color: '#007bc8'
    },
    {
      language: 'Go',
      value: 65.6,
      color: '#65cedb'
    },
    {
      language: 'Swift',
      value: 65.1,
      color: '#ff6e52'
    },
    {
      language: 'JavaScript',
      value: 61.9,
      color: '#f9de3f'
    },
    {
      language: 'C#',
      value: 60.4,
      color: '#5d2f8e'
    },
    {
      language: 'F#',
      value: 59.6,
      color: '#008fc9'
    },
    {
      language: 'Clojure',
      value: 59.6,
      color: '#507dca'
    },
    {
      language: 'JavaSpring',
      value: 100,
      color: 'red'
    },
    {
      language: 'PHP',
      value: 20.96,
      color: 'red'
    },
    {
        language: 'SpringBoot',
        value: 13.6,
        color: 'red'
      }
  ];

  const svg = d3.select('svg')
  .attr("width", "100%")
  .attr("height", "100%");
  
  const svgContainer = d3.select('#container');
  
  const margin = 80;
  const width = 1100 - 2 * margin;
  const height = 600 - 2 * margin;

  const chart = svg.append('g')
    .attr('transform', "translate(" + margin + ","+ margin +")");

  const xScale = d3.scaleBand()
    .range([0, width])
    .domain(sample.map((s) => s.language))
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
    .data(sample)
    .enter()
    .append('g')

  barGroups
    .append('rect')
    .attr('class', 'bar')
    .attr('x', (g) => xScale(g.language))
    .attr('y', (g) => yScale(g.value))
    .attr('height', (g) => height - yScale(g.value))
    .attr('width', xScale.bandwidth())
    .on('mouseenter', function (actual, i) {
      d3.selectAll('.value')
        .attr('opacity', 0)

      d3.select(this)
        .transition()
        .duration(300)
        .attr('opacity', 0.6)
        .attr('x', (a) => xScale(a.language) - 5)
        .attr('width', xScale.bandwidth() + 10)

      const y = yScale(actual.value)

      line = chart.append('line')
        .attr('id', 'limit')
        .attr('x1', 0)
        .attr('y1', y)
        .attr('x2', width)
        .attr('y2', y)

      barGroups.append('text')
        .attr('class', 'divergence')
        .attr('x', (a) => xScale(a.language) + xScale.bandwidth() / 2)
        .attr('y', (a) => yScale(a.value) + 30)
        .attr('fill', 'white')
        .attr('text-anchor', 'middle')
        .text((a, idx) => {
          const divergence = (a.value - actual.value).toFixed(1)
          
          let text = ''
          if (divergence > 0) text += '+'
          text += `${divergence}%`

          return idx !== i ? text : '';
        })

    })
    .on('mouseleave', function () {
      d3.selectAll('.value')
        .attr('opacity', 1)

      d3.select(this)
        .transition()
        .duration(300)
        .attr('opacity', 1)
        .attr('x', (a) => xScale(a.language))
        .attr('width', xScale.bandwidth())

      chart.selectAll('#limit').remove()
      chart.selectAll('.divergence').remove()
    })

  barGroups 
    .append('text')
    .attr('class', 'value')
    .attr('x', (a) => xScale(a.language) + xScale.bandwidth() / 2)
    .attr('y', (a) => yScale(a.value) + 30)
    .attr('text-anchor', 'middle')
    .text((a) => `${a.value}%`)
  
  svg
    .append('text')
    .attr('class', 'label')
    .attr('x', -(height / 2) - margin)
    .attr('y', margin / 2.4)
    .attr('transform', 'rotate(-90)')
    .attr('text-anchor', 'middle')
    .text('Love meter (%)')

  svg.append('text')
    .attr('class', 'label')
    .attr('x', width / 2 + margin)
    .attr('y', height + margin * 1.7)
    .attr('text-anchor', 'middle')
    .text('Languages')

  svg.append('text')
    .attr('class', 'title')
    .attr('x', width / 2 + margin)
    .attr('y', 40)
    .attr('text-anchor', 'middle')
    .text('Most loved programming languages in 2018')

  svg.append('text')
    .attr('class', 'source')
    .attr('x', width - margin / 2)
    .attr('y', height + margin * 1.7)
    .attr('text-anchor', 'start')
    .text('Source: Stack Overflow, 2018')



 