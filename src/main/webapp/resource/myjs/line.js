$(function(){
	
	console.log("line.js is start");
	var chart = $("#echarts-line");
	require([
			   'echarts',
			   'echarts/chart/line'
			   ],
			   function(echart){
				 	var myChart =  echart.init(chart[0]);
				 	myChart.showLoading();
				 	var data = getMessage();
				 	console.log(data);
				 	myChart.setOption(option); 
				 	myChart.hideLoading();
			  }
			);
});
function getMessage(){
	var result ;
	$.ajax({
		type:"POST",
		url:"/getLastRecords",
		async:true,
		success:function(data){
			result= data;
		}
	});
	return result;
}
var option = {
	    title : {
	        text: '体重变化',
	        subtext: '个人出品'
	    },
	    tooltip : {
	        trigger: 'axis',
	        formatter:function (params){
	        	console.log(params);
	        }
	    },
	    legend: {
	        data:['早上','晚上']
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: true, readOnly: false},
	            magicType : {show: true, type: ['line', 'bar']},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    calculable : true,
	    xAxis : [
	        {
	            type : 'time',
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            axisLabel : {
	                formatter: '{value} kg'
	            }
	        }
	    ],
	    series : [
	        {
	            name:'早上',
	            type:'line',
	            data:[[new Date(2016,1,6),15],[new Date(2016,1,5),18], [new Date(2016,1,3),4] , [new Date(2016,1,4),12],[new Date(2016,1,2),8], [new Date(2016,1,1),9], [new Date(2015,12,30),11]],
	            markPoint : {
	                data : [
	                    {type : 'max', name: '最大值'},
	                    {type : 'min', name: '最小值'}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name: '平均值'}
	                ]
	            }
	        },
	        {
	            name:'晚上',
	            type:'line',
	            data:[[new Date(2016,1,6),15],[new Date(2016,1,5),18] , [new Date(2016,1,4),12], [new Date(2016,1,3),4],[new Date(2016,1,2),8], [new Date(2016,1,1),9], [new Date(2015,12,30),11]],
	            markPoint : {
	                data : [
	                    {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name : '平均值'}
	                ]
	            }
	        }
	    ]
	};