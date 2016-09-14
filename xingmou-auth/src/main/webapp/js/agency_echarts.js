
    // 项目数量
	function agencyAreaChart(lengend,list){
		 var myChart = echarts.init(document.getElementById('agency_echarts_r'));
			option = {
				    title : {
				        text: '机构关注领域分布(整站)',
				        x:'center',
				        textStyle: {
				            color: '#4f96ce',
				            fontWeight:'normal'
				        }
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{b} <br/>机构数: {c}个 ({d}%)"
				    },
				    /*legend: {
				        orient : 'vertical',
				        x : 'left',
				        data:lengend
				    },*/
				/*    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            magicType : {
				                show: true, 
				                type: ['pie', 'funnel'],
				                option: {
				                    funnel: {
				                        x: '25%',
				                        width: '50%',
				                        funnelAlign: 'left',
				                        max: 1548
				                    }
				                }
				            },
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },*/
				    calculable : true,
				    series : [
				        {
				            name:'投资领域',
				            type:'pie',
				            radius : '60%',
				            center: ['50%', '50%'],
				            color:['#73bbe1', '#3a96c7','#61a9ed','#5ea7d9','#7ab3e8', '#7cc9f1','#94dcf1','#48afe7','#3a77c7','#5484c2','#a2cdea','#86ecf8','#ade7f2','#31c4f0','#1caed9','#35b0f8','#7fd0ff','#7391e4','#5179ef','#404ccb'],
				            // color:['#fbd367','#ffa844','#ff765b','#ff4d28','#ffa5a9','#ff7289','#f04962','#f76b96', '#ff58a6','#ff93cd','#d05f9c','#b36197', '#d465c6','#eb92ee','#ba5ed4','#c3a7d3','#ab95de','#726fd1','#52dd99','#c2df7d'],
				            data:list
				        }
				    ]
				};
			myChart.setOption(option);
	}
	function investMoneyTop10(list,xAxis,numdata,moneydata){
	    var myChart = echarts.init(document.getElementById('agency_echarts_l'));
	    option = {
	    		title : {
			    	text: '投资额度top10',
			        x:'center',
			        textStyle: {
			            color: '#4f96ce',
			            fontWeight:'normal'
			        }
			    },
	    	    tooltip : {
	    	       //trigger: 'axis',
	    	    },
	    	    color:['#87cefa',"#ff7f50"],
	    	    //calculable : true,
	    	    legend: {
	    	    	 data:['投资金额','投资次数'],
	    		     backgroundColor: '#edf0f2',
	    		     y: '30',
	    		     x: 'center'
	    	    },
	    	    grid: {
	    	        x: 60,
	    	        y: 60,
	    	        x2: 35,
	    	        y2:80
	    	    },
	    	    xAxis : [
	    	             {axisLabel:{  
	   	    	          interval:0 ,  
	   	    	          rotate:30,
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
	   	    	            //name:'投资机构',
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
			    yAxis  : [
	    	             {
	 	    	            type : 'value',
	 	    	            name:'投资金额(亿)',
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
	    	             {
	 	    	            type : 'value',	 	    	           
	 	    	            min:0, 
	 	    	            max:500 ,
	 	    	            name:'投资次数(次)',
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
					name:"投资金额",
				    type:'bar',
				    barWidth:'10',
				    tooltip : {trigger: 'item'},
				    data:moneydata,
				    tooltip : {
				    	//trigger: 'axis',
 	  			        formatter: "{b} <br/>{a} : {c}亿"
 	  			    },
				},
				{
				    name:'投资次数',
				    type:'bar',
				    barWidth:'10',
				    tooltip : {trigger: 'item'},
				    data:numdata,
				    tooltip : {
				    	//trigger: 'axis',
 	  			        formatter: "{b} <br/>{a} : {c}次"
 	  			    },
				}
				]
	    	};
	  myChart.setOption(option);
   }
	
