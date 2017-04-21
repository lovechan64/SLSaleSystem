$("#rechargeMoney").blur(function(){
	var num = $.trim($("#rechargeMoney").val());
	var exp = /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
    if(!exp.test(num)){
    	alert('请输入正确的金额！');
    }
});

function validate(){
	var result = true;
	if($.trim($("#rechargeTime").val()) == "" || $("#rechargeTime").val() == null){
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请选择汇款日期</li>");
		result = false;
	}
	if($.trim($("#rechargeMoney").val()) == "" || $("#rechargeMoney").val() == null){
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请填写汇款金额</li>");
		result = false;
	}
	
	if(result){
		$("#confirm_rechargeTime").append($("#rechargeTime").val());
		$("#confirm_rechargeMoney").append($("#rechargeMoney").val());
		$("#confirm_note").append($("#note").val());
		$("#confirm_rechargeNum").append($("#rechargeNum").val());
		$('#viewConfirmDiv').modal('show');
	}
}
function doRecharge(){
	$('#myForm').submit();
	
}