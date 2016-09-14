$('#dropdown').click(function(){
	$('.dropdown-menu').toggleClass('open')
})

$(function(){
	$("a[action ='index_logo']").on("click",function(){
		forwardWithHeader(platformUrl.toIndex);
	})
	$("a[action ='index']").on("click",function(){
		forwardWithHeader(platformUrl.toIndex);
	})
	$("a[action ='project']").on("click",function(){
		forwardWithHeader(platformUrl.projectList);
	})
	$("a[action ='agency']").on("click",function(){		
		forwardWithHeader(platformUrl.agencyIndex);
	})
	$("a[action ='investEvent']").on("click",function(){
		forwardWithHeader(platformUrl.eventIndex);
	})
	$("a[action ='competition']").on("click",function(){
		forwardWithHeader(platformUrl.analysis);
	})
})