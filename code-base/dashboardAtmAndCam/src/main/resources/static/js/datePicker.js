// Data Picker Initialization
$(document).ready(()=>{
    $('#daterange').daterangepicker({
        "opens": 'center',
        "showDropdowns" : true,
        "locale" :{
            format: 'YYYY/MM/DD'
        }
    }), function(start, end, label){
        window.alert("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
    }
});

$('#daterange').on('apply.daterangepicker', function(ev, picker){
    var startDate = picker.startDate.format('YYYY-MM-DD');
    var endDate = picker.endDate.format('YYYY-MM-DD');
    console.log(startDate);
    console.log(endDate);

    var sampUrl = "/sampleURL/" + startDate;
    console.log(sampUrl);
});
