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
function castTolineData(rawData){
	if(rawData){
		for(var index in rowData){
			console.log(rowData)
		}
	}
}
function getMessage(){
	var result ;
	$.ajax({
		type:"POST",
		url:"/WeightWeb/getLastRecords.chtml",
		async:true,
		success:function(data){
			if(data.resultType=='SUCCESS')
				result=data;
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
            data : [
                {type : 'average', name: '平均值'}
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