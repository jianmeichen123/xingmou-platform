/**
 * 
 */

$(function(){
	$(".navbar-nav li").eq(4).addClass("active");
	sendPostRequestByJsonObj(platformUrl.getIndustryList,{}, callBack.industryListSelectCallback);
	
	search()
	$(".row").on('click','.btn',function(){
		search();
	});
});


function search(){
	var year = $("#year_select").val();
	var industryId = $("#industry_select").val();
	var data = {}
	data['year'] = year;
	data['industryId'] = industryId;
	sendPostRequestByJsonObj(platformUrl.project_industryMonthTrendList,data, callBack.industryListCallback);
	sendPostRequestByJsonObj(platformUrl.project_getIndustryMontht,{"year":year}, callBack.industryMonthtCallback);
	sendPostRequestByJsonObj(platformUrl.index_industry_month,data, callBack.investIndustryLisCallback);
	
	sendPostRequestByJsonObj(platformUrl.industryDistrictRound,data, callBack.industryDistrictRoundCallback);
	sendPostRequestByJsonObj(platformUrl.industryRoundRound,data, callBack.industryRoundRoundCallback);
	sendPostRequestByJsonObj(platformUrl.investMoneyLevelYearRate,data, callBack.investMoneyLevelYearRateCallback);
	
/*	sendLuaRequest("http://xmlua.dev.galaxyinternet.com/analysis/industry?year="+year+"&industryId="+industryId, callBack.industryDistrictRoundCallback);
	sendLuaRequest("http://xmlua.dev.galaxyinternet.com/analysis/round?year="+year+"&industryId="+industryId, callBack.industryRoundRoundCallback);
	sendLuaRequest("http://xmlua.dev.galaxyinternet.com/analysis/money?year="+year+"&industryId="+industryId, callBack.investMoneyLevelYearRateCallback);*/
/*	callBack.industryDistrictRoundCallback()
	callBack.industryRoundRoundCallback()
	callBack.investMoneyLevelYearRateCallback()
	callBack.investIndustryLisCallback()*/
}
var callBack = {
		
		industryDistrictRoundCallback :function(data){
			var list = new Array()
			$(data['entityList']).each(function(i,p){
				var l = {}
				l['value'] = p.num;
				l['name'] = p.name;
				list.push(l);
			});
			area_(list)
			

		},
		industryRoundRoundCallback :function(data){
			var list = new Array()
			$(data['entityList']).each(function(i,p){
				var l = {}
				l['value'] = p.num;
				l['name'] = p.name;
				list.push(l);
			});
			round_(list)
		},
		investMoneyLevelYearRateCallback :function(data){
			var list = new Array()
			$(data['entityList']).each(function(i,p){
				var l = {}
				l['value'] = p.investNum;
				l['name'] = p.name.replace('－笔数',"");
				list.push(l);
			});
			
			quota_(list)
		},		
		investIndustryLisCallback :function(data){
			var data_month = new Array();
			var data_sl = new Array();
			var data_ht = new Array();
			var list = data['entityList'];
			$(list).each(function(i,p){
				data_month.push(p.month+"月");
				data_sl.push(p.projectNum);
				data_ht.push(p.projectNumInvest);
			});
			hyht(data_month,data_sl,data_ht);
		},
		industryListCallback : function(data){
			var info = data;
			$('dt[analysis-info="current_money_total"]').text(ZhMoney(info['current_money_total']))
			$('dt[analysis-info="invest_money_rate"]').text(info['invest_money_rate']+"%")
			$('dt[analysis-info="current_num_toal"]').text(info['current_num_toal']+"笔")
			$('dt[analysis-info="invest_num_rate"]').text(info['invest_num_rate']+"%")
			var data_month = new Array();
			var data_money = new Array();
			var data_rate = new Array();
			var investMoneyList = data['investMoneyList'];
			$(investMoneyList).each(function(i,p){
				data_rate.push(p.investRate);
				data_money.push(p.investMoney/10000000);
				data_month.push(p.month+"月");
			});
			zjje(data_month,data_money,data_rate);
			
			data_month = new Array();
			var data_num = new Array();
			data_rate = new Array();
			var investNumList = data['investNumList'];
			$(investNumList).each(function(i,p){
				data_rate.push(p.investRate);
				data_num.push(p.investNum);
				data_month.push(p.month+"月");
			});
			tzbs(data_month,data_num,data_rate);
	},
		industryListSelectCallback : function(data){
		var data = data['entityList'];
		$(data).each(function(i,p){
			var option = "<option value="+p.id+">"+p.title+"</option>";
			$("#industry_select").append(option);
			
		});
		
	},
	industryMonthtCallback :function(data){
		var list = data['pageList']['content'];
		var t = $("#industry_year_list")
		t.html('')
		if(t){
			$(list).each(function(i,p){
				var rate = "-";
				if(p.investRate !=undefined||p.investRate !="undefined"){
					rate = changeTwoDecimal_f(p.investRate*100);
				}
				var tr = "<tr><td>"+p.industryName+"</td> <td>"+ZhMoney(p.investMoney)+"</td> <td>"+p.investNum+"</td> <td>"+p.projectNum+"</td> <td>"+p.projectNumInvest+"</td> <td>"+rate+"</td> <td>"+p.companyNum+"</td></tr>" 
				t.append(tr);
			});
		}else{
			t.append("<tr>暂无数据</tr>")
		}
	}
}