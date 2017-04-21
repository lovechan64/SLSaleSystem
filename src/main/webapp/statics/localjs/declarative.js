$(document).ready(function(){
	$('#viewInfoDiv').modal("show");
	$("#password").blur(function(){
		validateSecondaryPassword();
	});

	//添加用户信息验证
	$(".nextbtn").click(function(){
		$("#add_formtip").html("");
		var result1 = validateMoney(true);
		var result2 = validateExpressType(true);
		var result3 = validateUserAddress(true);
		var result4 = validateSecondaryPassword(true);
		if(result1 && result2 && result3 && result4){
			var totalPrice = $("input[name=goodsPack]:checked").val();
			var packId = $("input[name=goodsPack]:checked").attr('id');
			var goodsPackName = $("input[name=goodsPack]:checked").attr('title');

			$("#confirm_loginCode").html("<label>报单会员：</label>"+$("#loginCode").val());
			$("#confirm_goodsPack").html("<label>选择套餐：</label>"+goodsPackName+"(消费PV:"+totalPrice+")<input type='hidden' id='packId' value='"+packId+"'/>");
			$("#confirm_userAddress").html("<label>收货地址：</label>"+$("#userAddress").val());
			$("#confirm_expressType").html("<label>快递类型：</label>"+$("#expressType").val());
			$("#confirm_postCode").html("<label>邮政编码：</label>"+$("#postCode").val());
			$('#viewConfirmDiv').modal('show');
		}
	});
});

/**
 * 验证二级密码
 * @param flag
 * @returns {Boolean}
 */
function validateSecondaryPassword(flag){
	var result=false;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var password = $.trim($("#password").val());
	if(password == ""){
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请输入二级密码！</li>");
		return result;
	}else{
		$.ajax({
			url:"/bank/validateLevelSencondPassword.html",
			data:{'password':password},
			async:false,
			type: 'post',
			dataType: 'html',
			//timeout: 1000,
			success:function(resultStr){
				if(resultStr != "true"){
					$("#add_formtip").css("color","red");
					$("#add_formtip").append("<li>二级密码不正确，请重新输入！</li>");
				}else{
					result = true;
				}
			},
			error:function(res){
				alert("执行检查二级密码出错！");
				return result;
			},
			complete:function(){
				return result;
			}
		});	
		
		return result;
	}
}

//上一步
$(".prevbtn").click(function validateForm(){
	window.location.href="/shopping/declarative/prompt.html";
});

$("#goodsPack").blur(function(){
	validateMoney();
});

//验证提现金额
function validateMoney(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var goodsPack = $("input[name=goodsPack]:checked").val();
	if(goodsPack == "" || goodsPack == null){
		result = false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请选择报单套餐！</li>");
	}else{
		var baseBalance = $.trim($("#baseBalance").val()); 
		if(parseInt(baseBalance) < parseInt(goodsPack)){
	    	result = false;
	    	$("#add_formtip").css("color","red");
			$("#add_formtip").append("<li>当前账户余额不足，请汇款充值！</li>");
	    }
	}
	
	return result;
}

$("#expressType").blur(function(){
	validateExpressType();
});

//验证快递类型
function validateExpressType(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var expressType = $.trim($("#expressType").val());
	if(expressType == ""){
		result= false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请选择快递类型！</li>");
	}
	
	return result;
}

$("#userAddress").blur(function(){
	validateUserAddress();
});

//验证收货地址
function validateUserAddress(flag){
	var result=true;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var userAddress = $.trim($("#userAddress").val());
	if(userAddress == ""){
		result= false;
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请填写收货地址！</li>");
	}
	
	return result;
}


$("#submit").click(function(){
	var targetUserId = $("#targetUserId").val();
	var expressType =  $("#expressType").val();
	var userAddress =  $("#userAddress").val();
	var postCode = $("#postCode").val();
	var packId = $("input[name=goodsPack]:checked").attr('id');
	//alert("targetUserId="+targetUserId+"&expressType="+expressType+"&userAddress="+userAddress+"&postCode="+postCode+"&packId="+packId);
	$.ajax({
		url:"/shopping/declarative/doDeclarative.html",
		data:{targetUserId:targetUserId,expressType:expressType,userAddress:userAddress,postCode:postCode,packId:packId},
		async:false,
		type: 'post',
		dataType: 'html',
		timeout: 1000,
		success:function(result){
			if(result == "success"){
				if(confirm("报单购货成功！马上去确认激活吗？")){
					window.location.href="/shopping/activate/list.html";
				}
			}else{
				alert("报单购货时发生错误，错误码："+result+"请联系管理员！");
			}
		},
		error:function(res){
			alert("报单购货时发生错误！");
		},
		complete:function(){
		}
	});	
});
