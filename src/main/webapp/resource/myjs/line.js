$(function(){
	console.log("line.js is start");
	var chart = $("#echarts-line");
	require([
			   'echarts',
			   'echarts/chart/line',
			   'echarts/chart/bar',
			   ],
			   function(echart){
				 	var myChart =  echart.init(chart[0]);
				 	var series = []
				 	myChart.showLoading();
				 	myChart.setOption(option); 
				 	var data = getMessage();
				 	console.log(data);
				 	var lineData = castTolineData(data);
				 	lineBaseData.name="me";
				 	lineBaseData.data=lineData;
				 	series.push(lineBaseData);
				 	console.log(series)
				 	myChart.setSeries(series,true);
				 	myChart.setOption({legend:{data:['me']}});
				 	myChart.hideLoading();
			  }
			);
});
function castTolineData(rawData){
	var lineData=[];
	if(rawData){
		for(var index in rawData){
			var data = rawData[index];
			console.log(data)
			var pointData = [];
			pointData.push(new Date(data.createTime));
			pointData.push(data.weight);
			lineData.push(pointData);
		}
	}
	return lineData;
}
function getMessage(){
	var result ;
	$.ajax({
		type:"POST",
		url:"/WeightWeb/getLastRecords.chtml",
		async:false,
		success:function(data){
			if(data.resultType=='SUCCESS')
				result=data.data;
			else{
				console.log(data);
			}
		},
		error:function(request,text,error){
			
		}
	});
	return result;
}
/*
 * 需要补充数据 字段 name：String
 * 			   字段  data ：数组[][] 
 * 							date,value,id?(可以继续填充id吗？用于获取评论数据) 
 */
var lineBaseData = {
        type:'line',
        markPoint : {
            data : [
                {type : 'max', name: '最大值'},
                {type : 'min', name: '最小值'}
            ]
        },
        markLine : {
        	precision:2,
            data : [
                {type : 'average', name: '平均值',valueIndex:1}
            ]
        }
    };
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
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	           // dataView : {show: true, readOnly: false},
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
	    series : []
	};