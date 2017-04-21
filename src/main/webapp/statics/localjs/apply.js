$(document).ready(function(){
	$('#viewInfoDiv').modal('show');
});

$("#cashPV").blur(function(){
	validateMoney();
});

//验证提现金额
function validateMoney(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var cashPV = $.trim($("#cashPV").val()); 
	if(cashPV == "" || cashPV == null){
		result = false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请填写提现PV！</li>");
	}else{
		var exp = /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
		var baseBalance = $.trim($("#baseBalance").val()); 
	    if(!exp.test(cashPV)){
	    	result = false;
	    	$("#add_formtip").css("color","red");
			$("#add_formtip").append("<li>请输入正确的PV值！</li>");
	    }else if(parseInt(baseBalance) < parseInt(cashPV)){
	    	result = false;
	    	$("#add_formtip").css("color","red");
			$("#add_formtip").append("<li>提现PV不能大于剩余PV！</li>");
	    }
	}
	
	return result;
}

//验证银行名称
function validateBankName(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var bankName = $.trim($("#bankName").val());
	if(bankName == ""){
		result= false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请选择银行名称！</li>");
	}
	
	return result;
}

$("#bankBrance").blur(function(){
	validateBankBrance();
});

//验证支行名称
function validateBankBrance(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var bankBrance = $.trim($("#bankBrance").val());
	if(bankBrance == ""){
		result= false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请填写支行名称！</li>");
	}
	
	return result;
}

$("#accountName").blur(function(){
	validateAccountName();
});

//验证开户人
function validateAccountName(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var accountName = $.trim($("#accountName").val());
	if(accountName == ""){
		result= false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请填开户人！</li>");
	}
	
	return result;
}

$("#bankAccount").blur(function(){
	validateBankAccount();
});

//验证银行帐号
function validateBankAccount(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var bankAccount = $.trim($("#bankAccount").val());
	if(bankAccount == ""){
		result= false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请填写银行帐号！</li>");
	}
	
	return result;
}

$("#password").blur(function(){
	validatePassword();
});

function validatePassword(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var password = $.trim($("#password").val());
	if(password == ""){
		result = false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请输入二级密码！</li>");
		return result;
	}else{
		$.ajax({
			url:"/bank/validateLevelSencondPassword.html",
			data:{'password':password},
			type: 'get',
			dataType: 'html',
			async:false,
			//timeout: 1000,
			success:function(resultStr){
				if(resultStr != "true"){
					result= false;
					$("#add_formtip").css("color","red");
					$("#add_formtip").html("<li>二级密码不正确，请重新输入！</li>");
					return result;
				}
			},
			error:function(res){
				result= false;
				alert("执行检查二级密码出错！");
				return result;
			}
		});	
		
		return result;
	}
}

//添加用户信息验证
$(".nextbtn").click(function validateForm(){
	$("#add_formtip").html("");
	var result1 = validateMoney(true);
	var result2 = validateBankName(true);
	var result3 = validateBankBrance(true);
	var result4 = validateBankAccount(true);
	var result5 = validateAccountName(true);
	var result6 = validatePassword(true);
	if(result1 && result2 && result3 && result4 && result5 && result6){
		$("#confirm_cashPV").html("<label>提现PV：</label>"+$("#cashPV").val());
		$("#confirm_bankName").html("<label>银行名称：</label>"+$("#bankName").val());
		$("#confirm_bankBrance").html("<label>支行名称：</label>"+$("#bankBrance").val());
		$("#confirm_accountName").html("<label>开户人：</label>"+$("#accountName").val());
		$("#confirm_bankAccount").html("<label>银行卡号：</label>"+$("#bankAccount").val());
		$('#viewConfirmDiv').modal('show');
	}
});

$("#submit").click(function doTransfer(){
	$('#applyForm').submit();
});

