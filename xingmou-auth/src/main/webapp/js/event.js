var industryList = null;
var roundIdList = null;
var title = null;
var locaIdList = null;
function initTable() {
	var oTable = new TableInit();
    oTable.Init();
  
}
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    var url =platformUrl.queryEventList;
    oTableInit.Init = function () {
      $('#dataId').bootstrapTable({
        url: url,     //请求后台的URL（*）
        method: 'post',           //请求方式（*）
        toolbar: '#toolbar',        //工具按钮用哪次容器
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
            field: 'title',
            title: '项目名称',
            formatter:titleFormat
        }, {
            field: 'industryName',
            title: '行业',
            formatter:industryFormat
        }, {
            field: 'industrySubName',
            title: '子行业',
            formatter:dataNullFormat
        },{
            field: 'roundName',
            title: '投资轮次'
        },{
            field: 'investMoney',
            title: '投资金额'
        },{
            field: 'investDate',
            title: '投资时间',
            formatter:loadTimeFormat
        },{
            field: 'investPer',
            title: '投资占比',
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
       locaIdList:locaIdList,
       title:title
      };
      topScroll();
      return temp;
    };
    return oTableInit;
  };
  function topScroll(){
	  $(document).scrollTop(0);
  }
  function removeTimeAll() {
	  $("#time_all").removeClass("green");
  }
  
  function loadTable() {
	  var url =platformUrl.queryEventList;
	  $('#dataId').bootstrapTable('refresh',{
	        url: url,     //请求后台的URL（*）
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
	            field: 'title',
	            title: '项目名称',
	            formatter:titleFormat
	        }, {
	            field: 'industryName',
	            title: '行业',
	            formatter:industryFormat
	        }, {
	            field: 'industrySubName',
	            title: '子行业',
	            formatter:dataNullFormat
	        },{
	            field: 'roundName',
	            title: '投资轮次'
	        },{
	            field: 'investMoney',
	            title: '投资金额'
	        },{
	            field: 'investDate',
	            title: '投资时间',
	            formatter:loadTimeFormat
	        },{
	            field: 'investPer',
	            title: '投资占比',
	         }]
	      });
  }

  function loadTimeFormat(value){
	  value =  formatDate(value);
	  return value;
  }
  function industryFormat(value){
	  if(value){
		  return value;
	  }else{
		  return "未知"
	  }
  }
  
  function titleFormat(value, row, index){
	  	  var id = row.projectId;
		  var str ="<a class='blue' style='cursor:pointer' href="+platformUrl.projectDetail+"?id="+id +" title='"+value+"'>"+value+"</a>"
		  return str;
  }

  function dataNullFormat(value){
	  if(value){
		  return value;
	  }else{
		  return "未知";
	  }
	  
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
  
  function queryParams(params) {  //配置参数
	  var pageNum= params.offset / params.limit;
      var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
       pageSize: params.limit,  //页面大小
       pageNum: pageNum, //页码
       roundList: roundIdList,
       industryList:industryList,
       locaIdList:locaIdList,
       title:title
      };
      return temp;
	  }
  
 $("button[action='search']").on("click",function(){
	industryList = new Array();
	roundIdList = new Array();
	locaIdList = new Array();
	
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
	
	//封装locaIdList
	var domestic = $("#domestic li[class='blue']");
	domestic.each(function(i,li){
		locaIdList.push(parseInt($(li).attr("id")));
	});
	var abord =$("#abord  li[class='blue']");
	abord.each(function(i,li){
		locaIdList.push(parseInt($(li).attr("id")));
	});
	
	if (industryList.length<1) {
		industryList =null;
	}
	
	if (roundIdList.length <1) {
		roundIdList = null;
	}
	if (locaIdList.length <1) {
		locaIdList = null;
	}
	
	title = $.trim($("input[name='title']").val());
	loadTable();
})
	$(function() {
		$(".navbar-nav li").eq(3).addClass("active");
		queryEcharsEventIndustry();
		queryEcharsEventRound();
		
		queryIndustry();
		queryRoundList();
		queryDomesticDistrict();
		queryOverseasDistrict();
		initTable();
		
		//show();
	});
    
//行业分布的echars
 function queryEcharsEventIndustry(){
 	sendPostRequestByJsonObj(platformUrl.getIndustryProjectTotalList,null,function(data){
 		var industry_json={};
 		var money_json=new Array();
 		var list = new Array();
 		var xAxis=  new Array(); 
 		var entity=data.entityList
 		for(var i=entity.length-1;i>=0;i--){
 			xAxis.push(entity[i].title);
 			list.push(entity[i].investedNum);
 		}
		test3(list,xAxis)
 		
 	});
 }
    var ms = {}
    //投资轮次占比
    function queryEcharsEventRound(){
    	sendPostRequestByJsonObj(platformUrl.sumByRoundStatis,null,function(data){
    		var list = new Array()
    		var yAxisList=[];
    		var entity = data.entityList;
    		$(entity).each(function(i,p){
    			var l = {};
    			var total=p.numLa+p.numLb+p.numLc+p.numLd+p.numLe;
    			l['name'] = p.roundName;
    			l['value']=total;
    			v="<br/>未透露:"+
    			p.numLa+"次("+parseFloat((p.numLa/total*100).toFixed(2))+"%)<br/>数十万:"+
    			p.numLb+"次("+parseFloat((p.numLb/total*100).toFixed(2))+"%)<br/>数百万:"+
    			p.numLc+"次("+parseFloat((p.numLc/total*100).toFixed(2))+"%)<br/>数千万:"+
    			p.numLd+"次("+parseFloat((p.numLd/total*100).toFixed(2))+"%)<br/>上亿元:"+
    			p.numLe+"次("+parseFloat((p.numLe/total*100).toFixed(2))+"%)";
    			ms[p.roundName] = v;
    			list.push(l);
    			yAxisList.push(p.roundName);
    		})
			test2(list,yAxisList)
    	});
    }
	function queryDomesticDistrict(){
		var json={"type":1,"level":1};
		sendPostRequestByJsonObj(platformUrl.getDistrictList,json,domesticDistrictCallBack)
		
	}
	function queryOverseasDistrict(){
		var json={"type":2,"level":2};
		sendPostRequestByJsonObj(platformUrl.getDistrictList,json,overseasDistrictCallBack)
	}
	function queryRoundList() {
		var json={"type":1};
		sendPostRequestByJsonObj(platformUrl.getRoundList,json, roundListCallback);
	}

	function queryIndustry() {
		sendPostRequestByJsonObj(platformUrl.getIndustryList,null, industryListCallback);
	}
	
	function overseasDistrictCallBack(data){
		var list = data.entityList
		if(list != "" || list != undefined || list != null){
			var tbodyList = $("#abord"); 
			tbodyList.empty();
			var i=0;
			$(list).each(function(i,p){
				var temp= '<li id=' + p.id+'>'+p.name+'</li>'
			    tbodyList.append(temp);
			  });
		}
	}
	function domesticDistrictCallBack(data){
		var list = data.entityList
		if(list != "" || list != undefined || list != null){
			var tbodyList = $("#domestic"); 
			tbodyList.empty();
			var i=0;
			$(list).each(function(i,p){
				var temp= '<li id=' + p.id+'>'+p.name+'</li>'
			    tbodyList.append(temp);
			  });
		}
	}
	function industryListCallback(data) {
		var list = data.entityList;
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
	$(".options").delegate("li","click",function(){
		$(this).parent().siblings(".total").removeClass('blue');
		$(this).toggleClass('blue');
		if($(".options li.blue").length==0){
			$(".total").addClass('blue');
		}
	});
	$("div").delegate(".total","click",function(){
		$(this).siblings('.options').children('li').removeClass('blue');
		$(this).toggleClass('blue');
	});
	
	function exportData(){
		//loading层
		var index = layer.load(1,{time: 2*1000});
		industryList = [];
		roundIdList = [];
		locaIdList = [];
		
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
		
		//封装locaIdList
		var domestic = $("#domestic li[class='blue']");
		domestic.each(function(i,li){
			locaIdList.push(parseInt($(li).attr("id")));
		});
		var abord =$("#abord  li[class='blue']");
		abord.each(function(i,li){
			locaIdList.push(parseInt($(li).attr("id")));
		});
		
		title = $.trim($("input[name='title']").val());
		forwardWithHeader(platformUrl.exportInvestEvent+"?industryList="+industryList+"&roundList="+roundIdList+"&locaIdList="+locaIdList+"&title="+title)
}
