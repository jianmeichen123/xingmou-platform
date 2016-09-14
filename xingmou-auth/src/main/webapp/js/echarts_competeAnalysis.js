function zjje(data_month,data_money,data_rate){
	   var tzjy = echarts.init(document.getElementById('tzjy'));
	    option = {
	    tooltip: {
	        trigger: 'axis'
	    },
	    toolbox: {
	        show: true,
	        y:'5',
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    dataZoom: {
	        show: true,
	        start: 0,
	        end: 100,
	        height:'20',
	        y2:'5',
	        backgroundColor: 'rgba(0,0,0,0)',       // 背景颜色
		    dataBackgroundColor: '#d3e4f4',            // 数据背景颜色
		    fillerColor: 'rgba(255,220,209,0.2)',   // 填充颜色
		    handleColor: 'rgba(70,130,180,0.8)' 
	    },
	    grid: {
	    	x: 60,
  	        y: 60,
  	        x2: 65,
  	        y2:50
	    },
	    legend: {
	        data:['投资金额','增长率（%）'],
	        backgroundColor: '#edf0f2',
	         y: '10',
	         x: 'center'
	    },
	    xAxis: [
	        {
	            type: 'category',
	            data: data_month,
	            axisTick: {
                    show: false
                },
                splitLine : {
                    show : false
                }
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            name: '投资金额（千万元）',
	            axisTick: {
                    show: false
                },
                splitLine : {
                    show : false
                }
	   /*          axisLabel: {
	                 formatter: '{value} 千万'
	             }*/
	        },
	        {
	            type: 'value',
	            name: '增长率(%)',
	            axisTick: {
                    show: false
                },
                splitLine : {
                    show : false
                },
/*	            min: 0,
	            max: 25,
	            interval: 10,*/
	            axisLabel: {
	                formatter: '{value} %'
	            }
	        }
	    ],
	    series: [
	       {
	            name:'投资金额',
	            type:'bar',
	            // areaStyle: {normal: {}},
	            barWidth:'12',
	            data:data_money,
	            itemStyle:{
	                normal:{
	                    color:'#4f96ce',
	                    lineStyle:{
	                        color:'#4f96ce',
	                        width:'2'
	                    }
	                }
	            }
	        },
	        {
	            name:'增长率（%）',
	            type:'line',
	            // areaStyle: {normal: {}},
	            data:data_rate,
	            yAxisIndex: 1,
	            symbol:'image://../img/circle.png',
	            symbolSize:5,
	            itemStyle:{
	                normal:{
	                    color:'#ff6e42',
	                    lineStyle:{
	                        color:'#ff6e42',
	                        width:'2'
	                    }
	                }
	            }
	        }
	    ]
	};
	    tzjy.setOption(option);
}
function tzbs(data_month,data_num,data_rate){
	  // 行业投资走势分析-投资笔数
    var tzbs = echarts.init(document.getElementById('tzbs'));
    option = {
    tooltip: {
        trigger: 'axis'
    },
    toolbox: {
        show: true,
        y:'5',
        feature: {
            saveAsImage: {}
        }
    },
    dataZoom: {
        show: true,
        start: 0,
        end: 100,
        height:'20',
        y2:'5',
        backgroundColor: 'rgba(0,0,0,0)',       // 背景颜色
	    dataBackgroundColor: '#c8f5f3',            // 数据背景颜色
	    fillerColor: 'rgba(255,220,209,0.2)',   // 填充颜色
	    handleColor: 'rgba(79,217,224,0.8)'   
    },
    grid: {
    	x: 60,
        y: 60,
        x2: 65,
        y2:50
    },
    legend: {
        data:['投资笔数','增长率（%）'],
        backgroundColor: '#edf0f2',
         y: '10',
         x: 'center'
    },
    xAxis: [
        {
            type: 'category',
            data: data_month,
            axisTick: {
                show: false
            },
            splitLine : {
                show : false
            }
        }
    ],
    yAxis: [
        {
            type: 'value',
            name: '投资笔数(笔)',
            axisTick: {
                show: false
            },
            splitLine : {
                show : false
            }
/*            min: 0,
            max: 250,
            interval: 50,*/
            // axisLabel: {
            //     formatter: '{value} ml'
            // }
        },
        {
            type: 'value',
            name: '增长率(%）',
            axisTick: {
                show: false
            },
            splitLine : {
                show : false
            },
/*            min: 0,
            max: 25,
            interval: 5,*/
            axisLabel: {
                formatter: '{value} %'
            }
        }
    ],
    series: [
       {
            name:'投资笔数',
            type:'bar',
            // areaStyle: {normal: {}},
            barWidth:'12',
            data:data_num,
            itemStyle:{
                normal:{
                    color:'#72deda',
                    lineStyle:{
                        color:'#72deda',
                        width:'2'
                    }
                }
            }
        },
        {
            name:'增长率（%）',
            type:'line',
            // areaStyle: {normal: {}},
            data:data_rate,
            yAxisIndex: 1,
            symbol:'image://../img/circle.png',
            symbolSize:5,
            itemStyle:{
                normal:{
                    color:'#ff6e42',
                    lineStyle:{
                        color:'#ff6e42',
                        width:'2'
                    }
                }
            }
        }
    ]
};
    tzbs.setOption(option);
}
function hyht(data_month,data_sl,data_ht){

/*    // 行业获投情况分析
    var myChart = echarts.init(document.getElementById('line_hyht'));
    myChart.setOption(option);
    option = {
    title: {
        text: ''
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['成立项目数量','项目获投数量'],
        x : 'center',
        y : '20px',
        backgroundColor: '#edf0f2',
        // borderColor: '#ccc',
        // padding:5,
        itemWidth:20,             // 图例图形宽度
        itemHeight: 20, 
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data:data_month
        }
    ],
    yAxis: [
            {
                type: 'value',
                name: '成立项目数',
            },
            {
                type: 'value',
                name: '项目获投率数',
            }
        ],
    series : [
        {
            name:'成立项目数量',
            type:'bar',
            stack: '总量',
            // areaStyle: {normal: {}},
            data:data_sl,
            itemStyle:{
                normal:{
                    color:'#72deda',
                    lineStyle:{
                        color:'#72deda',
                        width:'0.5'
                    }
                }
            }

        },
        {
            name:'项目获投数量',
            type:'line',
            stack: '总量',
            // areaStyle: {normal: {}},
            data:data_ht,
            yAxisIndex: 1,
            itemStyle:{
                normal:{
                    color:'#ff6e45',
                    lineStyle:{
                        color:'#ff6e45',
                        width:'2'
                    }
                }
            }

        }
    ]
};
    myChart.setOption(option);*/
	   var myChart = echarts.init(document.getElementById('line_hyht'));
	    
	option = {
		    title: {
		    },
		    tooltip: {
		        trigger: 'axis'
		    }, 
		    legend: {
		        data:['成立项目数', '项目获投数'],
		        x : 'center',
		        y : '20px',
		        backgroundColor: '#edf0f2',
		        borderColor: '#ccc',
		        padding:5,
		        itemWidth:20,             // 图例图形宽度
		        itemHeight: 20
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    dataZoom: {
		        show: true,
		        start: 0,
		        end: 100,
		        height:'20',
		        y2:'5',
		        backgroundColor: 'rgba(0,0,0,0)',       // 背景颜色
			    dataBackgroundColor: '#c8f5f3',            // 数据背景颜色
			    fillerColor: 'rgba(255,220,209,0.2)',   // 填充颜色
			    handleColor: 'rgba(79,217,224,0.8)' 
		      
		    },
	    // 网格
	    grid: {
	    	x: 60,
  	        y: 60,
  	        x2: 65,
  	        y2:50,
	       
	        // width: {totalWidth} - x - x2,
	        // height: {totalHeight} - y - y2,
	        //backgroundColor: 'rgba(0,0,0,0)',
	        borderWidth: 0
	        //borderColor: '#ccc'
	    },

		    xAxis: [
		        {
		            type: 'category',
		            boundaryGap: true,
		            data: data_month,
		            axisTick: {
	                    show: false
	                },
	                splitLine : {
	                    show : false
	                }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            scale: true,
		            name: '成立项目数(个)',
		            axisTick: {
	                    show: false
	                },
	                splitLine : {
	                    show : false
	                }
		        },
		        {
		            type: 'value',
		            scale: true,
		            name: '项目获投数(个)',
		            axisTick: {
	                    show: false
	                },
	                splitLine : {
	                    show : false
	                }
		        }
		    ],
		    series: [
		        {
		            name:'成立项目数',
		            type:'line',
		            xAxisIndex: 0,
		            yAxisIndex: 0,
		            data:data_sl,
		            itemStyle:{
		                normal:{
		                    color:'#72deda',
		                    lineStyle:{
		                        color:'#72deda',
		                        width:'2'
		                    }
		                }
		            }
		        },
		        {
		            name:'项目获投数',
		            type:'line',
		            xAxisIndex: 0,
		            yAxisIndex: 1,
		            data:data_ht,
		            itemStyle:{
		                normal:{
		                    color:'#ff6e45',
		                    lineStyle:{
		                        color:'#ff6e45',
		                        width:'2'
		                    }
		                }	
		            }		            
		            
		        }
		    ]
		};
	myChart.setOption(option);
}

function area_(data){
    // 行业投资分布分析-按地区
    var myChart = echarts.init(document.getElementById('area'));
    option = {
    		title: {
    		   text: '按地区分布',
    		    x:'center',
    		    textStyle: {
    		        color: '#4f96ce',
    		        fontWeight:'normal'

    		    }
    		},
tooltip: {
    trigger: 'item',
    formatter: "{b}<br/>投资次数（占比）: {c}笔 ({d}%)"
},
 color:['#73bbe1', '#3a96c7','#61a9ed','#5ea7d9','#7ab3e8', '#7cc9f1','#94dcf1','#48afe7','#3a77c7','#5484c2','#a2cdea','#86ecf8','#ade7f2','#31c4f0','#1caed9','#35b0f8','#7fd0ff','#7391e4','#5179ef','#404ccb'],
 legend: {
    orient: 'vertical',
    x: 'left'
},
toolbox: {
    show: true,
    feature: {
        saveAsImage: {}
    }
},

series: [
    {
        name:'按地区',
        type:'pie',
        radius: ['30%', '80%'],
        center: ['50%', '55%'],
        avoidLabelOverlap: false,
        itemStyle: {   // 饼图间隔线
            normal: {
                // color: 各异,
                borderColor: '#fff',
                borderWidth: 1
            }
        },
        label: {
            normal: {
                show: false,
                position: 'center'
            },
            emphasis: {
                show: true,
                textStyle: {
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            }
        },
        labelLine: {
            normal: {
                show: false
            }
        },
        data:data
    }
]
};
    myChart.setOption(option);
}

function round_(data){
	   // 行业投资分布分析-按轮次
    var myChart = echarts.init(document.getElementById('round'));
    option = {
tooltip: {
    trigger: 'item',
    formatter: "{b}<br/>投资次数（占比）: {c}笔 ({d}%)"
},
title: {
    text: '按轮次分布',
    x:'center',
    textStyle: {
        color: '#4f96ce',
        fontWeight:'normal'
    }
},
toolbox: {
    show: true,
    feature: {
        saveAsImage: {}
    }
},
color:['#c2df7d','#e4ea4d','#e4ff85','#b2d244','#c4ee31','#a4f464','#c5ff97','#08c5ed', '#51d5f2','#60e5f1','#72deda','#57d0d8', '#2ec4ce','#4fbfae','#91f8ff','#a1dade','#82d2d8','#c6e7f3','#85fec3','#52dd99'],
legend: {
    orient: 'vertical',
    x: 'left'
},
series: [
    {
        name:'按轮次分布',
        type:'pie',
        radius: ['30%', '80%'],
        center: ['50%', '55%'],
        avoidLabelOverlap: false,
        itemStyle: {   // 饼图间隔线
            normal: {
                // color: 各异,
                borderColor: '#fff',
                borderWidth: 1
            }
        },
        label: {
            normal: {
                show: false,
                position: 'center'
            },
            emphasis: {
                show: true,
                textStyle: {
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            }
        },
        labelLine: {
            normal: {
                show: false
            }
        },
        data:data
    }
]
};
    myChart.setOption(option);

}
function quota_(data){
	// 行业投资分布分析-按额度
    var myChart = echarts.init(document.getElementById('quota'));
    option = {
title: {
    text: '按额度分布',
    //backgroundColor: '#edf0f2',
    //padding: 5,                // 标题内边距，单位px，默认各方向内边距为5，
                               // 接受数组分别设定上右下左边距，同css
    //itemGap: 5,   
    x:'center',
    textStyle: {
        color: '#4f96ce',
        fontWeight:'normal'
    }
},    		
	
tooltip: {
    trigger: 'item',
    formatter: "{b}<br/>投资次数（占比）: {c}笔 ({d}%)"
},
toolbox: {
    show: true,
    feature: {
        saveAsImage: {}
    }
},
color:['#fbd367','#ffa844','#ff765b','#ff4d28','#ffa5a9','#ff7289','#f04962','#f76b96', '#ff58a6','#ff93cd','#d05f9c','#b36197', '#d465c6','#eb92ee','#ba5ed4','#c3a7d3','#ab95de','#726fd1','#52dd99','#c2df7d'],
legend: {
    orient: 'vertical',
    x: 'left'
},
series: [
    {
        name:'按额度',
        type:'pie',
        radius: ['30%', '80%'],
        center: ['50%', '55%'],
        avoidLabelOverlap: false,
        itemStyle: {   // 饼图间隔线
            normal: {
                // color: 各异,
                borderColor: '#fff',
                borderWidth: 1
            }
        },
        label: {
            normal: {
                show: false,
                position: 'center'
            },
            emphasis: {
                show: true,
                textStyle: {
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            }
        },
        labelLine: {
            normal: {
                show: false
            }
        },
        data:data
    }
]
};
    myChart.setOption(option);


}