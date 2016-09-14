/**
 * 
 */
$(function(){
	var id = $("div[data-id]").attr("data-id");
	sendPostRequestByJsonObj(platformUrl.investfirmsDetail.replace("${id}",id),{},callbackFun.info_success);
	sendPostRequestByJsonObj(platformUrl.queryMemberList,{"investfirmId":id},callbackFun.investor_success);
	$(".navbar-nav li").eq(2).addClass("active");
})

callbackFun = {
	
	info_success : function(data){
		var t = "data-info" ;
		var info = data['entity']
		$('['+t+']').each(function(){
			var m = $(this)
			var k = m.attr(t)
			var v = info[k]
			if(v != undefined && v != "undefined"){
				if(m.is('img')){
					m.attr('src',platformUrl.logoPath + v)
				}else{
					m.text(v)
				}
			}
		});
		if(data['entity']['areaNames'] != undefined){
			var areaNames = data['entity']['areaNames'].split(",");
			var html = "";
			$(areaNames).each(function(i,p){
				html+= "<li>"+p+"</li>"
			});
			$("#areail").html(html)
		}
		
		if(data['entity']['roundames'] != undefined){
			var roundames = data['entity']['roundames'].split(",");
			var html = "";
			$(roundames).each(function(i,p){
				html+= "<li>"+p+"</li>"
			});
			$("#roundil").html(html)
		}
		
	},
	
	investor_success : function(data){
		var list = data['entityList'];
		var lis = '';
		$(list).each(function(i,investor){
			var li = '<li data-id='+investor.id+'><div class="block_left"><img src="${icon}"></div><div class="block_left">${name}</div><div class="block_left color_gray">${position}</div></li>';
			if(investor.icon != undefined||investor.icon != "undefined"){
				li = li.replace("${icon}",investor.icon);
			}
			if(investor.name != undefined||investor.name != "undefined"){
				li = li.replace("${name}",investor.name);
			}
			if(investor.investfirmPostionName != undefined||investor.investfirmPostionName != "undefined"){
				li = li.replace("${position}",investor.investfirmPostionName);
			}			
			lis += li;
		})
		$("ul[data-list='investor-ui']").html(lis);
		
		$("ul[data-list='investor-ui']").on("click",'li',function(){
			var id = $(this).attr("data-id");
			var url = platformUrl.investorDetail+"?id="+id;
			location.href= url;
		});
	}

}