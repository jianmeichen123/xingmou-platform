
var industryList = null;
var roundIdList = null;
var title = null;
var districtList = null;
function initTable() {
	var oTable = new TableInit();
    oTable.Init();
  
}
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
      $('#dataId').bootstrapTable({
        url: platformUrl.queryAgencyList,     //请求后台的URL（*）
        method: 'post',           //请求方式（*）
        toolbar: '#toolbar',        //工具按钮用哪个容器
        striped: true,           //是否显示行间隔色
        cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,          //是否显示分页（*）
        sortable: false,           //是否启用排序
        sortOrder: "asc",          //排序方式
        queryParams: oTableInit.queryParams,//传递参数（*）
        sidePagination: "server",      //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,            //初始化加载第一页，默认第一页
        pageSize: 20,            //每页的记录行数（*）
        pageList: [20],    //可供选择的每页的行数（*）
        strictSearch: true,
        clickToSelect: true,        //是否启用点击选中行
        height: 460,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",           //每一行的唯一标识，一般为主键列
        cardView: false,          //是否显示详细视图
        detailView: false,          //是否显示父子表
        columns: [{
            field: 'name',
            title: '机构名称',
            formatter: 'infoAgencyFormartter'
        },
        {
            field: 'investorNum',
            title: '机构成员数',
            formatter:'dataNullFormat'
        },{
            field: 'historyNum',
            title: '历史投资次数',
            formatter:'dataNullFormat'
        },{
            field: 'roundNames',
            title: '投资轮次',
            formatter:'roundFormat'
        },{
            field: 'areaNames',
            title: '投资领域',
            formatter:'areaFormat'
        },{
            field: 'link',
            title: '网址',
            formatter:webFormat
         }]
      });
    };
  
    //得到查询的参数
   oTableInit.queryParams = function (params) {
	  var pageNum= params.offset / params.limit;
      var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
       pageSize: params.limit,  //页面大小
       pageNum: pageNum, //页码
       roundList: roundIdList,
       industryList:industryList,
       name:title
      };
      topScroll();
      return temp;
    };
    return oTableInit;
  };
  function topScroll(){
	  $(document).scrollTop(0);
  }
  function loadTable() {
	  $('#dataId').bootstrapTable('refresh',{
	        url: '/galaxy/investfirms/queryAgencyList',     //请求后台的URL（*）
	        method: 'post',           //请求方式（*）
	        toolbar: '#toolbar',        //工具按钮用哪个容器
	        striped: true,           //是否显示行间隔色
	        cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	        pagination: true,          //是否显示分页（*）
	        sortable: false,           //是否启用排序
	        sortOrder: "asc",          //排序方式
	        queryParams: queryParams,//传递参数（*）
	        sidePagination: "server",      //分页方式：client客户端分页，server服务端分页（*）
	        pageNumber:1,            //初始化加载第一页，默认第一页
	        pageSize: 20,            //每页的记录行数（*）
	        pageList: [20],    //可供选择的每页的行数（*）
	        height: 460,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	        uniqueId: "id",           //每一行的唯一标识，一般为主键列
	        cardView: false,          //是否显示详细视图
	        detailView: false,          //是否显示父子表
	        columns: [{
	        	field: 'name',
	            title: '机构名称',
	            formatter: 'infoAgencyFormartter'
	        },{
	            field: 'investorNum',
	            title: '机构成员数',
	            formatter:'dataNullFormat'
	        },{
	            field: 'historyNum',
	            title: '历史投资次数',
	            formatter:'dataNullFormat'
	        }, {
	            field: 'roundNames',
	            title: '投资轮次',
	            formatter:'roundFormat'
	        },{
	            field: 'areaNames',
	            title: '投资领域',
	            formatter:'areaFormat'
	        },{
	            field: 'link',
	            title: '网址',
	         }]
	      });
  }
  function infoAgencyFormartter(value, row, index){
		var str1 = "";
		if (row.icon) {
			str1=  "<img src='"+platformUrl.logoPath+"/"+row.icon+"'" +">";
		} else {
			str1=  "<img src='"+"img/default1.gif"+"'" +">";
		}
		  var str =str1+"<a class='blue' href="+platformUrl.toAgencyDetal+"?id="+row.id +" title='"+value+"'>"+value+"</a>"
		  return str;
	}
	function roundFormat(value,row,index){
		if(value==null || value==""){
			return "-";
		}else{
			var str = "<span title='"+value+"'>"+value+"</span>";
			return str;
		}
	}
	function areaFormat(value,row,index){
		if(value==null || value==""){
			return "-";
		}else{
			var str = "<span title='"+value+"'>"+value+"</span>";
			return str;
		}
	}
	function webFormat(value,row,index){
		if(value==null || value==""){
			return "未知";
		}else{
			var str = "<a title='"+value+"' href='"+value+"' target='_blank'>"+value+"</a>";
			return str;
		}
	}
	  function dataNullFormat(value){
		  if(value){
			  return value;
		  }else{
			  return "0";
		  }
		  
	  }
  function loadTimeFormat(value){
	  value =  formatDate(value);
	  return value;
  }
  
  function titleFormat(value){
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
  /*function search1() {
	    industryList =null;
		roundIdList = null;
		title = $("#nameLike").val().replace(/(^\s*)|(\s*$)/g, "");
		loadTable();
  }*/
  
  function queryParams(params) {  //配置参数
	  var pageNum= params.offset / params.limit;
      var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
       pageSize: params.limit,  //页面大小
       pageNum: pageNum, //页码
       roundList: roundIdList,
       industryList:industryList,
       districtList:districtList,
       name:title
      };
      return temp;
	  }
  $("button[action='search']").on("click",function(){
		industryList = new Array();
		roundIdList = new Array();
		
		//封装industryList
		var industry = $("#industryId li[class='blue']");
		industry.each(function(i,li){
			industryList.push(parseInt($(li).attr("id")));
		});
		
		//封装roundIdList
		var round = $("#roundId li[class='blue']");
		round.each(function(i,li){
			roundIdList.push(parseInt($(li).attr("id")));
		});
		
		
		if (industryList.length<1) {
			industryList =null;
		}
		
		if (roundIdList.length <1) {
			roundIdList = null;
		}
 
		title = $.trim($("input[name='title']").val());
		loadTable();
	})

	$(function() {
		$(".navbar-nav li").eq(2).addClass("active");
		queryIndustry();
		queryRoundList();
		
		queryRankingStatis();
		queryAgencyArea();
		initTable();
		 
	});
/*	function queryDomesticDistrict(){
		sendPostRequestNgix(platformUrl.queryDomesticDistrict,domesticDistrictCallBack)
		
	}*/
/*	function queryOverseasDistrict(){
		sendPostRequestNgix(platformUrl.queryOverseasDistrict,overseasDistrictCallBack)
	}*/
  function queryAgencyArea(){
	  sendPostRequestByJsonObj(platformUrl.statisticsAreas,null, function(data){
		var list = new Array();
  		var lengend=[];
  		var entity = data.entityList;
  		
  		$(entity).each(function(i,p){
  			var l = {};
  			l['name'] = p.title;
  			l['value'] = p.num;
  			list.push(l)
  			lengend.push(p.title);
  			
  			
  		})
  		
  		agencyAreaChart(lengend,list)
	  })
  }
	 
  function queryRankingStatis(){
	  sendPostRequestByJsonObj(platformUrl.rankingStatis,null, function(data){
		var industry_json={};
  		var money_json=new Array();
  		var list = new Array();
  		var xAxis=  new Array();
  		var moneydata =[];
  		var numdata=[];
		var entity=data.entityList
		$(entity).each(function(i,p){
			xAxis.push(p.investfirmName);
			list.push(p.investMoney/100000000);
			numdata.push(p.investNum);
  			moneydata.push(p.investMoney/100000000);
		  });
		/*for(var i=entity.length-1;i>=0;i--){
			xAxis.push(entity[i].investfirmName);
			list.push(entity[i].investMoney/100000000);
			numdata.push(entity[i].investNum);
  			moneydata.push(entity[i].investMoney/100000000);
 		}*/
		investMoneyTop10(list,xAxis,numdata,moneydata)
	  });
  }

  
  function queryRoundList() {
	  var json ={"type":2};
		sendPostRequestByJsonObj(platformUrl.getRoundList,json, roundListCallback);
	}

	function queryIndustry() {
		sendPostRequestByJsonObj(platformUrl.getAreaList,null, industryListCallback);
	}
	
/*	function overseasDistrictCallBack(data){
		var list = data.data
		if(list != "" || list != undefined || list != null){
			var tbodyList = $("#abord"); 
			tbodyList.empty();
			var i=0;
			$(list).each(function(i,p){
				var temp= '<li id=' + p.id+'>'+p.name+'</li>'
			    tbodyList.append(temp);
			  });
		}
	}*/
/*	function domesticDistrictCallBack(data){
		var list = data.data
		if(list != "" || list != undefined || list != null){
			var tbodyList = $("#domestic"); 
			tbodyList.empty();
			var i=0;
			$(list).each(function(i,p){
				var temp= '<li id=' + p.id+'>'+p.name+'</li>'
			    tbodyList.append(temp);
			  });
		}
	}*/
	function industryListCallback(data) {
		var list = data.entityList
		if(list != "" || list != undefined || list != null){
			var tbodyList = $("#industryId"); 
			tbodyList.empty();
			var i=0;
			$(list).each(function(i,p){
				var temp= '<li id=' + p.id+'>'+p.title+'</li>'
			    tbodyList.append(temp);
			  });
		}
	}

	function roundListCallback(data) {
		var list = data.entityList;
		if(list != "" || list != undefined || list != null){
			var tbodyList = $("#roundId"); 
			tbodyList.empty();
			var i=0;
			$(list).each(function(i,p){
				var temp= '<li id=' + p.id+'>'+p.title+'</li>'
			    tbodyList.append(temp);
			  });
		}
		
	}
	// 点击切换样式
	$(".options1").delegate("li","click",function(){
		$(this).parent().siblings(".total").removeClass('blue');
		$(this).toggleClass('blue');
		if($(".options1 li.blue").length==0){
			$(this).parent().siblings(".total").addClass('blue');
		}
	});
	$(".options2").delegate("li","click",function(){
		$(this).parent().siblings(".total").removeClass('blue');
		$(this).toggleClass('blue');
		if($(".options2 li.blue").length==0){
			$(this).parent().siblings(".total").addClass('blue');
		}
	});
	$("div").delegate(".total","click",function(){
		$(this).siblings('.options').children('li').removeClass('blue');
		$(this).toggleClass('blue');
	});
	 $(".pagination li").delegate('a',"click",function(){
			})
	function exportData(){
		 //loading层
		var index = layer.load(1,{time: 2*1000});
		industryList = [];
		roundIdList =  [];
		
		//封装industryList
		var industry = $("#industryId li[class='blue']");
		industry.each(function(i,li){
			industryList.push(parseInt($(li).attr("id")));
		});
		
		//封装roundIdList
		var round = $("#roundId li[class='blue']");
		round.each(function(i,li){
			roundIdList.push(parseInt($(li).attr("id")));
		});
 
		title = $("input[name='title']").val();
		forwardWithHeader(platformUrl.exportAgencyList+"?industryList="+industryList+"&roundIdList="+roundIdList+"&title="+title)
	}


