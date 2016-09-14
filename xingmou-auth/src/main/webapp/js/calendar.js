// JavaScript Document
(function($){
	//点击空白关闭
	$.fn.closeDom = function(fn){
		if($(this).length==0){return false;}
		var $this = $(this);
		var documentHide = function(event){
			var whichOne = event.which,targetOne = event.target;
			var oneBox = $this.has($(targetOne)).length == 0?false:true;
			(whichOne==1||whichOne==0)&&!oneBox?$this.hide():false;
			fn();
		};
		$(document).on("mousedown",documentHide);	
	}

	/*
		日期{
			stamp:当前时间戳
			tit : 时间月份标题
			onClass:日期点击样式
			callback:点击日期后执行---参数为点击的时间戳年月日逗号分隔
		}
		使用规则
		占用 属性date="list" 存放日期天数列表 
		占用属性 date-day  用来存放当前日期
		占用 data-btn属性来标注前后按钮:prev,next
	*/
	$.fn.calendar = function(options){
		if($(this).length==0) return false;
		var opts = $.extend({
			stamp : +(new Date()),
			tit : "dt>strong",
			callback:function(){}
		},options);
		function date(t){	
			//节点属性
			this.listdom = t.find("[date='list']");
			this.title = t.find(opts.tit);
			this.prevBtn = t.find("[data-btn='prev']");
			this.nextBtn = t.find("[data-btn='next']");
			//date属性
			this.dobj = new Date(opts.stamp);
			this.year = this.dobj.getFullYear();
			this.month = this.dobj.getMonth();
			this.date = this.dobj.getDate();
			this.week = this.dobj.getDay();
			this.monthcount = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
			//记录属性
			this.readY = this.year;
			this.readM = this.month;
			//对外接口
			this.callback = opts.callback;
		};
		date.prototype = {
			init:function(){
				var _this = this;
				//设置二月天数，设置日期标题，设置日期列表，切换日历
				_this.february().setdateTit().setdatelist().changeDate().cutDate();
			},
			//2月份日期总数推算
			february : function(){
				var _this = this;
				if ((_this.year % 4 == 0 && _this.year % 100 != 0) || _this.year % 400 == 0){_this.monthcount[1] = 29; };	
				return _this;
			},
			//设置日历标题
			setdateTit : function(){
				var _this = this;
				_this.title.html(_this.readY+"年"+(_this.readM+1)+"月");
				return _this;
			},
			//日期列表创建
			setdatelist:function(){
				var _this = this;
				//当月第一天为周几
				var first = new Date(_this.readY,_this.readM,1).getDay();
				var monArr = [];
				for(var i=0; i<first; i++){
					monArr.push("<li></li>");
				}
				for(var i=1,len = _this.monthcount[_this.readM]; i<=len; i++){
					var _class = "";
					if(_this.year==_this.readY&&_this.month==_this.readM&&_this.date==i){
						_class = "on";
					}
					monArr.push("<li class=\""+_class+"\"><a href=\"javascript:;\" date-day=\""+_this.readY+","+(_this.readM+1)+","+i+"\">"+i+"</a></li>");	
				}
				_this.listdom.html(monArr.join(""));
				return _this;
			},
			//日历点击
			changeDate:function(){
				var _this = this;
				_this.listdom.on("click","li a",function(){
					var _date = $(this).attr("date-day");
					_this.callback(_date);
					return false;
				});
				return _this;
			},
			//切换日期
			cutDate:function(){
				var _this = this;
				_this.prevBtn.on("click",function(){
					_this.readM = _this.readM-1;
					_this.readY = _this.readM<0?_this.readY-1:_this.readY;
					_this.readM = _this.readM<0?11:_this.readM;
					//重置月份统计，标题，列表
					_this.february().setdateTit().setdatelist();
					return false;
				});
				_this.nextBtn.on("click",function(){
					_this.readM = _this.readM+1;
					_this.readY = _this.readM>11?_this.readY+1:_this.readY;
					_this.readM = _this.readM>11?0:_this.readM;
					//重置月份统计，标题，列表
					_this.february().setdateTit().setdatelist();
					return false;
				});	
			}
		};
		return $(this).each(function() {
			var $this = $(this);
			var obj = new date($this);
			obj.init();
        });
	};
})(jQuery);