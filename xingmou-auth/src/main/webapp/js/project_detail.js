/**
 * 
 */
$(function(){
	var id = $("div[data-id]").attr("data-id");
	agencyId = $(".member").attr("id");
	$(".navbar-nav li").eq(1).addClass("active");
	sendPostRequestByJsonObj(platformUrl.projectDetailList ,{"id":id},callbackFun.infoJob_success);
})
function loadTimeFormat(value){
	  value =  formatDate(value);
	  return value;
  }
function formatDate(date, format) {   
	    if (!date) date = new Date();   
	    if (!format) format = "yyyy-MM-dd";   
	    switch(typeof date) {   
	        case "string":   
	            date = new Date(date.replace(/-/, "/"));   
	            break;   
	        case "number":   
	            date = new Date(date);   
	            break;   
	    }    
	    if (!date instanceof Date) return;   
	    var dict = {   
	        "yyyy": date.getFullYear(),   
	        "M": date.getMonth() + 1,   
	        "d": date.getDate(),   
	        "H": date.getHours(),   
	        "m": date.getMinutes(),   
	        "s": date.getSeconds(),   
	        "MM": ("" + (date.getMonth() + 101)).substr(1),   
	        "dd": ("" + (date.getDate() + 100)).substr(1),   
	        "HH": ("" + (date.getHours() + 100)).substr(1),   
	        "mm": ("" + (date.getMinutes() + 100)).substr(1),   
	        "ss": ("" + (date.getSeconds() + 100)).substr(1)   
	    };       
	    return format.replace(/(yyyy|MM?|dd?|HH?|ss?|mm?)/g, function() {   
	        return dict[arguments[0]];   
	    });                   
	}
callbackFun = {	
	
	infoJob_success : function(data){
		//alert(data.entity.company)
		var object = data.entity;
		var gs = data.entity;
		//alert(object.loca)
		if(gs.picBig){
			$('.head_center_img').html('<img src='+gs.picBig+'>')
		}
		if(data.entity.industryName){
			$(detail_region_industryName).html(data.entity.industryName)
		}
		if(data.entity.industrySubName){
			$(detail_region_industrySubName).html(data.entity.industrySubName)
		}
		if(data.entity.districtName){
			$(detail_region_districtName).html(data.entity.districtName)
		}
		if(data.entity.districtSubName){
			$(detail_region_districtSubName).html(data.entity.districtSubName)
		}
		/*if(object){
			var detail_region='<span class="block_left">'+data.entity.industryName+'</span>'+
	        '<span class="block_left ico_arrow"></span>'+
	        '<span class="block_left">'+data.entity.industrySubName+'</span>'+
	        '<span class="block_left left_30px">'+object.districtName+'</span>'+
	        '<span class="block_left ico_arrow"></span>'+
	        '<span class="block_left">'+object.districtSubName+'</span>';
			//$('#detail_region').html(detail_region);
		}else{
			$('#detail_region').html('暂无信息');
		}*/
		if(gs.weblink){
			var html='<a href='+gs.weblink+' target="_blank">'+gs.weblink+'</a>';
			$('#weblink').html(html)
		}else{
			$('#weblink').html('暂无信息')
		}
		if(gs.companyName){
			$('#companyName').html(gs.companyName);
			$('#companyName_2').html(gs.companyName);
		}else{
			$('#companyName').html('暂无信息');
			$('#companyName_2').html('暂无信息');
		}
		var investsList=data.entity.investsList
		//alert(investsList)
		if(investsList !=''&& investsList!=null){
			var lis = "";
			for(i=0; i<investsList.length; i++){
				lis='<tr>';
				if(loadTimeFormat(investsList[i].investDate)){
					lis+='<td>'+loadTimeFormat(investsList[i].investDate)+'</td>';
				}else{
					lis+='<td>未透露</td>';
				}
				if(investsList[i].roundName){
					lis+='<td>'+investsList[i].roundName+'</td>';
				}else{
					lis+='<td>未透露</td>';
				}
				if(investsList[i].investMoney){
					lis+='<td>'+investsList[i].investMoney+'</td>';
				}else{
					lis+='<td>未透露</td>';
				}
				if(investsList[i].investfirmName){
					lis+='<td>'+investsList[i].investfirmName+'</td>';
				}else{
					lis+='<td>未透露</td>';
				}
				 //lis+='<tr><td>'+loadTimeFormat(investsList[i].investDate)+'</td><td>'+investsList[i].roundName+'</td><td>'+investsList[i].investMoney+'</td><td>'+investsList[i].investfirmName+'</td></tr>'
			}
			$("[data-list='joblis']").append(lis)
			
			
		}else{
			$('#delete_rt').show();
		}
	}
	
}