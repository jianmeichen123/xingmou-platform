function test2(list,yAxisList){
	var industry_option = echarts.init(document.getElementById('event_round'));
	option = {
		    title : {
		    	text: '轮次获投次数占比(整站)',
		        x:'center',
		        textStyle: {
		            color: '#4f96ce',
		            fontWeight:'normal'
		        }
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter:function(data){
		        	var t = data.seriesName +"<br/>"+data.name+":" +data.value+"次("+data.percent+"%)"+ms[data.name];
		            return t;
		        },
		    },
		    color:['#c2df7d','#e4ea4d','#e4ff85','#b2d244','#c4ee31','#a4f464','#c5ff97','#08c5ed', '#51d5f2','#60e5f1','#72deda','#57d0d8', '#2ec4ce','#4fbfae','#91f8ff','#a1dade','#82d2d8','#c6e7f3','#85fec3','#52dd99'],
		   /* legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: yAxisList
		    },*/
		    series : [
		        {
		            name: '',
		            type: 'pie',
		            radius : '60%',
		            center: ['50%', '50%'],
		            data:list,
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
	industry_option.setOption(option);
}
function test3(list,xAxis){
	 var myChart = echarts.init(document.getElementById('event_industry'));
	    option = {
	    		title : {
			    	text: '行业获投项目数排行(整站)',
			        x:'center',
			        textStyle: {
			            color: '#4f96ce',
			            fontWeight:'normal'
			        }
			    },
	    	    tooltip : {
	    	        trigger: 'axis',
	    	        formatter: "{b} <br/>项目数: {c}个"
	    	    },
	    	    color:['#00C5CD'],
	    	    calculable : true,
	    	   /* legend: {
	    	        data:xAxis
	    	    },*/
	    	    grid: {
	    	        x: 60,
	    	        y: 60,
	    	        x2: 50,
	    	        y2: 90
	    	    },
	    	    xAxis : [
	    	        { axisLabel:{  
	   	    	          interval:0 ,  
	   	    	          rotate:40,
	                        /* formatter:function(val){  
	                       	  if(val){
	                       		var  val2=val
	                       		if(val.length>3){
	                       			val2 = val.substring(0,3)+"\n"+val.substring(3,val.length)
	                       		}
	                       		return val2;
	                       	  }
	                         }*/  
	   	    	         },
	    	            type : 'category',
	    	            data : xAxis,
	    	            axisTick: {
		                     show: false,
		                     itemStyle: {
		                         color: '#fff'
		                     }
		                 },
		                 splitLine : {
		                     show : false,
		                 }
	    	        },
	    	        
	    	    ],
	    	    yAxis : [
	    	        {
	    	            type : 'value',
	    	            name:"项目数（个）",
	    	            axisTick: {
		                     show: false,
		                     itemStyle: {
		                         color: '#fff'
		                     }
		                 },
		                 splitLine : {
		                     show : false,
		                 }
	    	        }
	    	    ],
	    	   series : [
				{
				    name:'行业分布',
				    type:'bar',
				    barWidth:'10',
				    tooltip : {trigger: 'item'},
				    data:list,
				    formatter: "{a} <br/>{b} : {c}个({d}%)"
				}
				]
	    	};
	        myChart.setOption(option);
}
