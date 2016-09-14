var myChart_time = echarts.init(document.getElementById('project_echartx')) 
myChart_time.setOption(
        {
        	timeline: {
                //loop: false,        
            axisType: 'category',
            show: true,
            autoPlay: false,
            playInterval: 1500,
            data: ['2016','2015','2014','2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'],
            type: 'number',
    	    width:1050,
    	    left:20,
    	    controlPosition: 'none',
    	    label : {
    	        formatter : function(s) {
    	            return s+'年';
    	        },
    	      }
            
        }
    }
);
var option = {
		timeline : {
			data: ['2016','2015','2014','2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'],
	    type: 'number',
	    show : false,
	    z:15,
	    controlPosition: 'none',
	    label : {
	        formatter : function(s) {
	            return s+'年';
	        },
	      },
		},
		options : [ {
			tooltip : {
				trigger : 'axis'
			},
			 color: ['#ff7f50','#87cefa','#da70d6','#32cd32','#6495ed',
			            '#ff69b4','#ba55d3','#cd5c5c','#ffa500','#40e0d0',
			            '#1e90ff','#ff6347','#7b68ee','#00fa9a','#ffd700',
			            '#6699FF','#ff6666','#3cb371','#b8860b','#30e0e0'],
			title : {
				text:'项目行业分布分析',
				left: 'center',
				textStyle: {
		            color: '#4f96ce',
		            fontWeight:'normal'
		        }
			},
			toolbox : {
				show : true,
                x: 'right', 
                y: 'top',
				feature : {
					mark : {
						show : true
					},
/*					dataView : {
						show : true,
						readOnly : true
					},*/
					magicType : {
						show : true,
						type : [ 'line', 'bar', 'stack', 'tiled' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			  // 网格
		    grid: {
		    	 x: 50,
		         y: 80,
		         x2: 90,
		         y2: 80,
		        borderWidth: 0
		    },
		    legend: {
		        data:['项目数','已获投项目数','未获投项目数'],
		        backgroundColor: '#edf0f2',
		         y: '40',
		         x: 'center'
		    },
			xAxis : [
					{
						axisLabel : {
							interval : 0,
						},
						type : 'category',
						  data : [],
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
			yAxis : [ {
				
				type : 'value',
				name: '项目数量(个)',
				position : 'left',
				axisTick: {
	                show: false,
	                itemStyle: {
	                    color: '#fff'
	                }
	            },
	            splitLine : {
	                show : false,
	            }
			} ,{
				name: '已获投、未获投项目数量(个)',
				type : 'value',
				position : 'right',
				axisTick: {
	                show: false,
	                itemStyle: {
	                    color: '#fff'
	                }
	            },
	            splitLine : {
	                show : false,
	            }
			} ],
			series : [
					{
						name : '项目数',
						barWidth : '10',
						tooltip : {
							trigger : 'item',
							formatter : '{b} <br/>{a} : {c}个 '
						},
						type : 'bar',
						data : [ ],
						color:'#08c5ed',
					},
					{
						name : '已获投项目数',
						type : 'bar',
						barWidth : '10',
						tooltip : {
							trigger : 'item',
							formatter : '{b} <br/>{a} : {c}个 '
						},
						data : [ ],
						yAxisIndex: 1,
						color:'#72deda'
					}, {
						name : '未获投项目数',
						type : 'bar',
						barWidth : '10',
						color:'#ffa5a9',
						tooltip : {
							trigger : 'item',
							formatter : '{b} <br/>{a} : {c}个 '
						},
						data : [ ],
						yAxisIndex: 1
						
					},

					{
						name : '投资占比',
						type : 'pie',
						color:['#c3dce3', '#86de72','#58ebdf','#24d8e3','#72deda', '#64c1c9','#6e94c0','#5485be','#76b7e3','#44a8ed','#44cbed','#86ecf8','#ade7f2','#31c4f0','#1caed9','#35b0f8','#7fd0ff','#7391e4','#5179ef','#404ccb'],
						tooltip : {
							trigger : 'item',
							formatter : '{b}<br/> 项目数: {c}个 ({d}%)'
						},
						center : ['75%', '35%' ],
						radius : [ 0, 80 ],
						itemStyle : {
							normal : {
								labelLine : {
									length : 10
								}
							}
						},
						data : [ ]
					} ]
		} ]
	};
var myChart = echarts.init(document.getElementById('project_echarts'));
myChart.setOption(option)
$(function(){
	load();
	myChart_time.on('timelineChanged', function (params) {
    	var year = option['timeline']['data'][params.currentIndex]
    	if(year){
    		load(year)
    	}
    });

});
function load(year,dataIndex){
	if (year == undefined){
		year = 2016
	}
	if (dataIndex == undefined){
		dataIndex = 0
	}
	data = {}
	data['year'] = year
    // 项目数量
	myChart.clear()
	//option['timeline']['currentIndex'] = dataIndex;
	//sendPostRequestByJsonObj(platformUrl.getIndustryProjectTotalList,data,loadCharts.set_s1);
	sendPostRequestByJsonObj(platformUrl.getIndustryProjectList,data,loadCharts.set_s2);
	sendPostRequestByJsonObj(platformUrl.getRoundProjectList,data,loadCharts.set_round);
	myChart.setOption(option);
	
}

var loadCharts = {
		set_s1 :function(data){
			
			var investedNum = new Array()
			$(data['entityList']).each(function(i,p){
				titles.push(p['title'])
				investedNum.push(p['investedNum'])
			});
			option['options'][0]['xAxis'][0]['data'] = titles
			option['options'][0]['series'][0]['data'] = projectNum
		},
		set_s2 :function(data){
			var titles = new Array()
			var investedNums = new Array()
			var withoutInvestedNums = new Array()
			var projectNums = new Array()
			$(data['entityList']).each(function(i,p){
					titles.push(p['title'])
					investedNums.push(p['investedNum']);
					withoutInvestedNums.push(p['withoutInvestedNum'])
					projectNums.push(p['projectNum'])
			});
			option['options'][0]['xAxis'][0]['data'] = titles
			option['options'][0]['series'][0]['data'] = projectNums
			option['options'][0]['series'][1]['data'] = investedNums
			option['options'][0]['series'][2]['data'] = withoutInvestedNums
		},
		set_round:function(data){
			var round_titles = new Array()
			var kvs = new Array()
			$(data['entityList']).each(function(i,p){
				var kv = {}
				kv['name'] = p['title']
				kv['value'] = p['investedNum']
				round_titles.push(p['title'])
				kvs.push(kv)
			});
			option['options'][0]['series'][3]['data'] = kvs
			//option['options'][0]['legend']['data'][1] = round_titles
		}
}