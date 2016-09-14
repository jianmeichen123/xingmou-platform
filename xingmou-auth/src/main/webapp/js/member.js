/**
 * 
 */
$(function(){
	var id = $("div[data-id]").attr("data-id");
	agencyId = $(".member").attr("id");
	sendPostRequestByJsonObj(platformUrl.queryJobList,{"investorId":id},callbackFun.infoJob_success);
	sendPostRequestByJsonObj(platformUrl.queryStudyList,{"investorId":id},callbackFun.infoStudy_success);
	sendPostRequestByJsonObj(platformUrl.queryMemberList,{"investfirmId":agencyId},callbackFun.investor_success);
	$(".navbar-nav li").eq(2).addClass("active");
})

callbackFun = {	
	
	investor_success : function(data){
		var name=$(".name").text();
		var list = data['entityList'];
		var lis = '';
		$(list).each(function(i,investor){
			var li = '<li><div class="block_left"><img src="${icon}"></div><div class="block_left aa" href="#">${name}</div><div class="block_left color_gray">${position}</div></li>';
			if(investor.icon != undefined||investor.icon != "undefined"){
				li = li.replace("${icon}",investor.icon);
			}
			if(investor.name != undefined||investor.name != "undefined"){
				li = li.replace("${name}",investor.name);
			}
			if(investor.investfirmPostionName != undefined||investor.investfirmPostionName != "undefined"){
				li = li.replace("${position}",investor.investfirmPostionName);
			}
			if(investor.name==name){
				li="";
			}
			lis += li;
		})
		$("ul[data-list='investor-ui']").html(lis);
			
	},
	
	infoJob_success : function(data){
		/*	if(data.entityList.length<1){
				$("#studylis").innerHtml("暂无")
					return false;
			}*/
			
			if(data.entityList){
				$(data.entityList).each(function(i,obj){
					var jobs = obj.title.split(",");
					var lis = "";
					$(jobs).each(function(i,p){
						var li="<li>"+p+"</li>";
						lis += li
					});
					$("ul[data-list='joblis']").html(lis)
				});
				
			}
		},
		infoStudy_success : function(data){
				if(data.entityList){
					$(data.entityList).each(function(i,obj){
						var study = obj.title.split(",");
						var lis = "";
						$(study).each(function(i,p){
							var li="<li>"+p+"</li>";
							lis += li
						});
						$("ul[data-list='studylis']").html(lis)
					});
					
				}
			},

}