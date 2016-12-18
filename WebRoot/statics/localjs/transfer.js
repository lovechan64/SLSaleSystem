$("#targetUser").blur(function(){
	validateTagertUser();
});

function validateTagertUser(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var targetUser = $.trim($("#targetUser").val());
	if(targetUser == ""){
		result= false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请输入转账目标！</li>");
		return result;
	}else{
		$.ajax({
			url:"/bank/validateLoginName.html",
			data:{'targetUser':targetUser},
			type: 'post',
			dataType: 'html',
			timeout: 1000,
			success:function(resultStr){
				if(resultStr != "have"){
					result = false;
					$("#add_formtip").css("color","red");
					$("#add_formtip").html("该目标用户不存在或不能进行转账，请重新输入！");
					return result;
				}else if(null==flag || flag==''){
					result = true;
					$("#add_formtip").css("color","green");
					$("#add_formtip").html("该目标用户可以转账！");
					return result;
				}
			},
			error:function(){
				result= false;
				alert("执行检查用户名出错！");
				return result;
			}
		});	
		
		return result;
	}
}

$("#transferMoney").blur(function(){
	validateMoney();
});

function validateMoney(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var transferMoney = $.trim($("#transferMoney").val()); 
	if(transferMoney == "" || transferMoney == null){
		result = false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请填写转账金额！</li>");
	}else{
		var exp = /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
		var baseBalance = $.trim($("#baseBalance").val()); 
	    if(!exp.test(transferMoney)){
	    	result = false;
	    	$("#add_formtip").css("color","red");
			$("#add_formtip").append("<li>请输入正确的金额！</li>");
	    }else if(parseInt(baseBalance) < parseInt(transferMoney)){
	    	result = false;
	    	$("#add_formtip").css("color","red");
			$("#add_formtip").append("<li>转账金额不能大于余额！</li>");
	    }
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
			async:false,
			url:"/bank/validateLevelSencondPassword.html",
			data:{'password':password},
			type: 'get',
			dataType: 'html',
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
	var result1 = validateTagertUser(true);
	var result2 = validateMoney(true);
	var result3 = validatePassword(true);
	if(result1 && result2 && result3){
		$("#confirm_targetUser").html("<label>转账目标：</label>"+$("#targetUser").val());
		$("#confirm_transferMoney").html("<label>转账金额：</label>"+$("#transferMoney").val()+"元");
		$("#confirm_note").html("<label>摘要信息：</label>"+$("#note").val());
		$('#viewConfirmDiv').modal('show');
	}
});

$("#submit").click(function doTransfer(){
	$('#transferForm').submit();

	//window.location.href=url;
});

