
var industryList = null;
var roundIdList = null;
var title = null;
var locaIdList = null;
var allLocaIdList = new Array();
var allAboardIdList = new Array();
function initTable() {
	var oTable = new TableInit();
    oTable.Init();
  
}
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
      $('#dataId').bootstrapTable({
        url: platformUrl.getProjectInfoList,     //请求后台的URL（*）
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
        columns: [ {
            field: 'title',
            title: '项目名称',
            formatter:titleFormat
        },{
            field: 'industryName',
            title: '行业'
        },{
            field: 'industrySubName',
            title: '子行业'
        },{
            field: 'createDate',
            title: '成立时间'
        },{
            field: 'roundName',
            title: '<span class="block_left">当前融资轮次</span><span data-toggle="tooltip" title="项目最近一次融资的轮次" class="b4 block_left tooltips" >帮助</span>'
        },{
            field: 'investTime',
            title: '<span class="block_left">融资时间</span><span data-toggle="tooltip" title="项目最近一次融资的日期" class="b4 block_left tooltips" >帮助</span>',
            formatter:loadTimeFormat
        },{
            field: 'companyName',
            title: '<span class="block_left">投资方</span><span data-toggle="tooltip" title="项目最近一次融资的投资机构" class="b4 block_left tooltips" >帮助</span>'
        }/*,{
            field: 'loadTime',
            title: '收录时间',
            formatter:loadTimeFormat
        }*/]
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
	  $('#dataId').bootstrapTable('refresh',{
	        url: platformUrl.getProjectInfoList,      //请求后台的URL（*）
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
	        columns: [ {
	            field: 'title',
	            title: '项目名称',
	            formatter:titleFormat
	        },{
	            field: 'industryName',
	            title: '行业'
	        },{
	            field: 'industrySubName',
	            title: '子行业'
	        },{
	            field: 'createDate',
	            title: '成立时间',
	            formatter:loadTimeFormat
	        },{
	            field: 'roundName',
	            title: '当前融资轮次'
	        },{
	            field: 'investTime',
	            title: '融资时间',
	            formatter:loadTimeFormat
	        },{
	            field: 'companyName',
	            title: '投资方'
	        }/*,{
	            field: 'loadTime',
	            title: '收录时间',
	            formatter:loadTimeFormat
	        }*/]
	      });
  }
  function loadTimeFormat(value){
	  value =  formatDate(value);
	  return value;
  }
  function titleFormat(value,row){
		var str1 = "";
		if (row.pic) {
			str1=  "<img src='"+row.pic+"'" +" style='width:59px;height:58px;'>";
		} else {
			str1=  "<img src='"+"img/default1.gif"+"'" +">";
		}
		  var str =str1+"<a class='blue' href="+platformUrl.projectDetail+"?id="+row.id +" title='"+value+"'>"+value+"</a>"
		  return str;
	}
	function formatDate(date, format) {   
//	    if (!date) date = new Date();   
		if (!date) return "-";
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
	if($('#loca').hasClass('blue')){
		locaIdList = allLocaIdList;
	}
	var abord =$("#abord  li[class='blue']");
	abord.each(function(i,li){
		locaIdList.push(parseInt($(li).attr("id")));
	});
	
	if($('#abroad').hasClass('blue')){
		locaIdList = locaIdList.concat(allAboardIdList)
	}
	if($('#abroad').hasClass('blue') &&  $('#loca').hasClass('blue')){
		locaIdList = new Array();
	}
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
		$(".navbar-nav li").eq(1).addClass("active");
		queryIndustry();
		queryRoundList();
		queryDomesticDistrict();
		queryOverseasDistrict();
		initTable();
		//show();
		var domestic = $("#domestic li");
		domestic.each(function(i,li){
			allLocaIdList.push(parseInt($(li).attr("id")));
		});
		var abord =$("#abord  li");
		abord.each(function(i,li){
			allAboardIdList.push(parseInt($(li).attr("id")));
		});
	});
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
		if($('#loca').hasClass('blue')){
			locaIdList = allLocaIdList;
		}
		var abord =$("#abord  li[class='blue']");
		abord.each(function(i,li){
			locaIdList.push(parseInt($(li).attr("id")));
		});
		if($('#abroad').hasClass('blue')){
			locaIdList = locaIdList.concat(allAboardIdList)
		}
		if($('#abroad').hasClass('blue') &&  $('#loca').hasClass('blue')){
			locaIdList = null;
		}
		title = $("input[name='title']").val();
		forwardWithHeader(platformUrl.exportProjectList+"?industryList="+industryList+"&roundList="+roundIdList+"&title="+title+"&locaIdList="+locaIdList)

   }

