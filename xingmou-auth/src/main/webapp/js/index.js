 /**
 * 
 */
//添加结束时间
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = ",";
    var month = date.getMonth() ;
    var strDate = date.getDate();

    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if(strDate>=15){
    	halfmonth(month++)
    	currentdate = date.getFullYear() + seperator1 + month 
    }else{
    	halfmonth(month)
    	currentdate = date.getFullYear() + seperator1 + month 
    }
     //seperator1 + strDate;
} 
function halfmonth(month){
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
}


var industrys = {}
var currentdate=null;
getNowFormatDate()
var last_whole_data = null
var circle_all = echarts.init(document.getElementById("circle_all"));
var mapChart = echarts.init(document.getElementById("map"));
var xmsl = echarts.init(document.getElementById('histogram_xmsl'));
var circle_year = echarts.init(document.getElementById("circle_year"));
 var line_jd = echarts.init(document.getElementById('line_jd'));
 var tzje = echarts.init(document.getElementById('histogram_tzje'));
 var line_hy = echarts.init(document.getElementById('line_hy'));
$(function(){
	
	$(".navbar-nav li").eq(0).addClass("active");
	  // 日历配置
	$(".row").on('click','.btn',function(){
		search();
	});
	  $('#datetimepicker').datetimepicker({
	      format: 'yyyy-mm',
	      language: "zh-CN",
	      weekStart: 1, 
	      startView: 3,
	      minView: 3,
	      startDate:new Date(2009,11),
	      endDate:currentdate,//结束时间，在这时间之后都不可选
	      autoclose: true
	    })   
	    
	      
	search();
	sendPostRequestByJsonObj(platformUrl.statisticsRound,{},loadCharts.statistics_round);
	sendPostRequestByJsonObj(platformUrl.statisticsAreas,{},loadCharts.statistics_areas);
	sendPostRequestByJsonObj(platformUrl.indexUpdateTime,{'code':'LAST_UPDATED_TIME'},loadCharts.update_time);
})

function search(){
	var now = new Date(); //当前日期
	var month = now.getMonth(); //上月
	var year = now.getFullYear(); //当前年 

	var bis_month = $('#datetimepicker').val()
	if (bis_month.length > 0){
		var str = bis_month.split("-")
		month = str[1]
	    year = str[0] 
	}
	data = {"year":year,"month":month}
	last_data = {"year":year,"month":month-1}
	if (month == 1){
		last_data = {"year":year-1,"month":12}
	}
	if(bis_month == ""){
		if (month < 10){
			$('#datetimepicker').val(year + "-0"+month)
		}else{
			$('#datetimepicker').val(year + "-"+month)
		}
	}
	$("#month-div").text($('#datetimepicker').val());
	circle_all.clear();
	mapChart.clear();
	xmsl.clear();
	circle_year.clear();
	tzje.clear();
	sendPostRequestByJsonObj(platformUrl.index_whole_month,last_data,loadCharts.set_old_data);
	sendPostRequestByJsonObj(platformUrl.index_whole_month,data,loadCharts.head_title);
	sendPostRequestByJsonObj(platformUrl.index_industry_month,data,loadCharts.project_num);
	sendPostRequestByJsonObj(platformUrl.index_round_month,data,loadCharts.invest_round_month);
	sendGetRequest(platformUrl.index_round_year+"?year="+year,{},loadCharts.invest_round_year);
	sendPostRequestByJsonObj(platformUrl.index_district_month,data,loadCharts.project_district);

}
function hideLoad(){
	circle_all.hideLoading();
	mapChart.hideLoading();
	xmsl.hideLoading();
	circle_year.hideLoading();
}
function showLoad(text){
	circle_all.showLoading({
	    text : text,
	    effect : 'bubble',
	    textStyle : {
	        fontSize : 30
	    }
	});
	mapChart.showLoading({
	    text : text,
	    effect : 'bubble',
	    textStyle : {
	        fontSize : 30
	    }
	});
	xmsl.showLoading({
	    text : text,
	    effect : 'bubble',
	    textStyle : {
	        fontSize : 30
	    }
	});
	circle_year.showLoading({
	    text : text,
	    effect : 'bubble',
	    textStyle : {
	        fontSize : 30
	    }
	});
}
var loadCharts = {
		
		update_time:function(data){
			$("#update-time").html('更新时间：'+data.entity.value);
		},
		set_old_data :function(data){
			last_whole_data = data['entity']
		},
		industrys_success :function(data){
			$(data['entity']).each(function(i,p){
				industrys[i] = p.title
			});
		},
		
		head_title :function(data){
			var new_data = new_data = data['entity']
			if(!(new_data)){
				new_data = {};
				new_data['investMoney'] = 0;
		        new_data['investfirmNum'] = 0;
	            new_data['investorNum'] = 0;
	            new_data['projectNum'] = 0;
			}
			new_data['investMoney_'] = 0;
	        new_data['investfirmNum_'] = 0;
            new_data['investorNum_'] = 0;
            new_data['projectNum_'] = 0;
            if (last_whole_data !=null&&last_whole_data !=undefined &&last_whole_data != "undefined"){
    			new_data['investMoney_'] = new_data['investMoney']-last_whole_data['investMoney'];
    	        new_data['investfirmNum_'] = new_data['investfirmNum']-last_whole_data['investfirmNum'];
                new_data['investorNum_'] = new_data['investorNum']-last_whole_data['investorNum'];
                new_data['projectNum_'] = new_data['projectNum']-last_whole_data['projectNum'];
            }
			$("dl[whole-month]").each(function(i,p){
				var p = $(p);
				var k = p.attr("whole-month");
				var html = "";
				if(new_data[k+"_"] <=0){
					html = '<span class="monve_all">' +ZhMoney(new_data[k])+'</span><span class="change up green">↓' +ZhMoney(new_data[k+"_"])+'</span>';
				}else{
					html = '<span class="monve_all">' +ZhMoney(new_data[k])+'</span><span class="change up red">↑' +ZhMoney(new_data[k+"_"])+'</span>';
				}
				p.find("dd").html(html);
			});
			$("#investfirmNum").text(new_data['investfirmNum']);
			$("#investorNum").text(new_data['investorNum']);
		},
		project_num :function(data){
			var projects_num = [] 
			var projects_money = [] 
			var projects_name = []
			$(data['entityList']).each(function(i,p){
				projects_name.push(p.industryName)
				projects_money.push(p.investMoney/100000000)
				projects_num.push(p.projectNum)
			});

		    bar_option['xAxis']['data'] = projects_name
		    bar_option['yAxis']['name'] =  "项目数量(个)"
		    bar_option['series'][0]['data'] =projects_num
		    bar_option['series'][0]['name'] ="项目数"
		    bar_option['tooltip']['formatter']='{b} <br/>{a} : {c}个 ';
		    xmsl.setOption(bar_option);
	       
	        bar_option['series'][0]['data'] = projects_money
	        bar_option['yAxis']['name'] =  "投资金额(亿)"
	        bar_option['series'][0]['name'] ="投资金额"
	        bar_option['tooltip']['formatter']='{b} <br/>{a} : {c}亿 ';
	        tzje.setOption(bar_option);
	        
	 
		},
		invest_round_month :function(data){
			    if(data['entityList'].length == 0){
			    	return;
			    }
				var projects_round = []
				$(data['entityList']).each(function(i,p){
					project_round = {}
					project_round['name'] = p.roundName
					project_round['value'] = p.projectNum
					projects_round.push(project_round)
				});
			   pre_option['series'][0]['data']  = projects_round;
			   pre_option['tooltip']['formatter']  = '{b} <br/>{a} : {c}个 ';;
			   circle_all.setOption(pre_option);
		        
		},
		invest_round_year :function(data){
			var projects_round = []
			$(data['entityList']).each(function(i,p){
				project_round = {}
				project_round['name'] = p.roundName
				project_round['value'] = p.projectNum
				projects_round.push(project_round)
			});
		   pre_option['series'][0]['data']  = projects_round;

		   circle_year.setOption(pre_option);
	},
		project_district :function(data){
		    mapChart.clear()
		    var map_kvs  = []
		    if(data['entityList'].length == 0){
		    	return;
		    }
			$(data['entityList']).each(function(i,p){
				if(p.districtName != undefined){
					kv = {}
					kv['name'] = p.districtName.replace("市","").replace("省","").replace("自治区","")
					kv['value'] = p.projectNum
					map_kvs.push(kv)
				}
			});
		    
		    map_option['series'][0]['data'] = convertData(map_kvs)
		    mapChart.setOption(map_option);
		},
		statistics_round :function(data){
			var projects_num = [] 
			var projects_money = [] 
			var projects_name = []
			$(data['entityList']).each(function(i,p){
				projects_name.push(p.title)
				projects_num.push(p.num)
			});

		    line_option['xAxis'][0]['data'] = projects_name
		    line_option['series'][0]['name'] =  "数量"
		    line_option['series'][0]['data'] =projects_num
		    
		    line_jd.setOption(line_option);
		},
		statistics_areas:function(data){
			var projects_num = [] 
			var projects_money = [] 
			var projects_name = []
			$(data['entityList']).each(function(i,p){
				projects_name.push(p.title)
				projects_num.push(p.num)
			});
		    
		    
		    line_option['xAxis'][0]['data'] = projects_name
		    line_option['series'][0]['name'] =  "数量"
		    line_option['series'][0]['data'] =projects_num
		    
		    line_hy.setOption(line_option);
		}
}