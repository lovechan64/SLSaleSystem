
$('.viewRecharge').click(function(e){
	var m_id = $(this).attr('id');
	$.ajax({
		url:"/bank/base_account/addMessage.html",
		data:{id:m_id},
		type: 'POST',
		dataType: 'html',
		timeout: 1000,
		success:function(result){
			if(result=="1"){
				alert('已通知客服，尽快帮您处理！');
			}else{
				alert("发送失败，请联系管理员！");
			}
		},  
       error: function() {
    	   alert("操作失败！");
       } 
		
	});
});

function validate(){
	var radios = $('input[name=card]').val();
	var chkCount = 0;
	var chkValue = 0;
	for(var i=0;i<radios.length;i++){
		if(radios[i].checked){
			chkValue = radios[i].value;
			chkCount++;
		}
	}
	if(chkValue==0){
		alert("请选择汇款类型");
		return false;
	}else{
		$.ajax({
			url:"/bank/base_account/addMessage.html",
			data:{id:chkValue},
			success:function(result){
				if(reuslt>0){
					alert('已通知客服，尽快帮您处理！');
				}else{
					alert("发送失败！");
				}
			},  
           error: function() {
        	   alert("发送失败！");
	       } 
		});
	}
}


