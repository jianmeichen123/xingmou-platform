// JavaScript Document
$(function(){
	
	//修改密码
	$("[data-btn='password']").on("click",function(){ 
		var $self = $(this);
		$('.sign li').removeClass('open')
		var _url = $self.attr("href");
		var _name= $self.attr("data-name");
		$.getHtml({
			url:_url,//模版请求地址
			data:"",//传递参数
			okback:function(){
				$("#popup_name").html(_name);
			}//模版反回成功执行	
		});
		return false;
	});
	
		// 导航切换样式
	 $(".navbar-nav li a").each(function(){  
		    $this = $(this);  
		    if($this[0].href==String(window.location)){  
		        $this.parent().addClass("active").siblings().removeClass("active");  
		    }   
		});

	 // placeholder属性兼容ie8
	//$('input, textarea').placeholder();
	
   // 显示更多
	var  len1=$('.options1').children('li').length;
	     len2=$('.options2').children('li').length;
	     len3=$('.options3').children('li').length;
	     len4=$('.options4').children('li').length;
	    nn=$('.options1').width();
	    nns=$('.options2').width();
	    nnns=$('.options3').width();
	    nnnns=$('.options4').width();
	    // alert(nn);
	     var sum=0;
	         sum1=0;
	         sum2=0;
	         sum3=0;
	     for (var i = 0; i < len1; i++) {
			  sum+= $('.options1').children('li').eq(i).width();
			 }
			  // alert(sum);
			  var summary=sum+20*(len1-1);
			  if(summary>nn){
			      $(".dropdown").show();
			    };

		 for (var j = 0; j < len2; j++) {
			  sum1+= $('.options2').children('li').eq(j).width();
			 }
			  var summary1=sum1+20*(len2-1);
			  if(summary1>nns){
			      $(".dropdown1").show();
			    };
		for (var j = 0; j < len3; j++) {
			  sum2+= $('.options3').children('li').eq(j).width();
			 }
			  var summary2=sum2+20*(len3-1);
			  if(summary2>nnns){
			      $(".dropdown2").show();
			    };
		for (var j = 0; j < len4; j++) {
				  sum3+= $('.options4').children('li').eq(j).width();
				 }
				  var summary3=sum3+20*(len4-1);
				  if(summary3>nnnns){
				      $(".dropdown3").show();
				    };

    $('.toggle').on("click",function(){
    var $self=$(this),
        _name = $self.attr("data-btn"),
        _siblings = $self.siblings();
        //点击展开
          if(_name=="show"){
          _siblings.show();
          $self.hide();
          $self.parent().siblings("[data-btn='box']").css({
          	height: 'auto'
          });
        };
        //点击隐藏
        if(_name=="hide"){
          _siblings.show();
          $self.hide();
          $self.parent().siblings("[data-btn='box']").css({
          	height: '30px'
          });
        }
        return false;
  });
    
	// 点击切换样式
	$(".options li").click(function(){
		$(this).parent().siblings(".total").removeClass('blue');
		$(this).toggleClass('blue');
		if($(".options li.blue").length==0){
			$(".total").addClass('blue');
		}
	});
	$(".total").click(function(){
		$(this).siblings('.options').children('li').removeClass('blue');
		$(this).toggleClass('blue');
	});
	// 提示
 $("[data-toggle='tooltip']").tooltip();
 //收缩展开搜索区
	$(".more_btn").click(function(){
		$(".panel-body").slideToggle();
	})
 	
});
