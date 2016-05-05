$(document).ready(function(){
	
	$(".input-score").blur(function(){
		var _this = $(this);		
		var _sno = _this.parent().siblings('.sno');
		var _cno = _this.parent().siblings('.cno');
		console.log(_this.val());
		console.log(_sno.html());
		console.log(_cno.html());
		$.ajax({
			type:"POST",
			url:"test",
			data:{
				sno:_sno.html(),
				cno:_cno.html(),
				score:_this.val(),
				
			},
			success:function(data){
				
			},
			error:function(jqXHR){
				alert("发生错误："+jqXHR.status);
			}
		});
	});
});