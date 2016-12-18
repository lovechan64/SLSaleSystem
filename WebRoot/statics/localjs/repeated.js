$('.gotobtn').click(function(){
	var result = validateChecked();
	if(result){
		$('#myForm').attr('action','/shopping/management/settlement.html');
		$('#myForm').submit();
	}
});

$('.nextbtn').click(function(){
	var result = validateChecked();
	var checkedIds = $("#checkedIds").val();
	var buyNums = $("#buyNums").val();
	var type = $("#type").val();
	if(result){
		$.post("/shopping/repeated/saveOrderInfo.html",{checkedIds:checkedIds,buyNums:buyNums,type:type},function(result){
			if("success"==result){
				if(confirm("加入购物车成功，马上去购物车结算？")){
					window.location.href='/shopping/management/shoppingCart.html';
				}
			}else{
				alert("支付失败，请联系管理员！");
			}
		});
	}
});
function validateChecked(){
	var checked = [];
	var buyNumArray = [];
	$('input:checkbox:checked').each(function() {
		checked.push($(this).val());
	});
	if(checked==null || checked ==''){
		alert("请选择要购买的套餐！");
		return false;
	}
	for(var i=0;i<checked.length;i++){
		var id = checked[i];
		var sumNum = $("#"+id).attr('num');
		var buyNum = $("#"+id).attr('value');
		if(buyNum==null || buyNum ==''||isNaN(buyNum)){
			alert("请填写正确的购买数量！");
			return false;
		}
		if(parseInt(sumNum)>=parseInt(buyNum)){
			buyNumArray[i]=buyNum;
		}else{
			alert("购买数量不能超过库存数量！");
			return false;
		}
	}
	$('#checkedIds').attr('value',checked);
	$('#buyNums').attr('value',buyNumArray);
	return true;
}

function returnResult(result){
	return result ;
}
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
			async:false,
			//timeout: 1000,
			success:function(resultStr){
				if(resultStr != "true"){
					result= false;
					$("#add_formtip").css("color","red");
					$("#add_formtip").html("<li>二级密码不正确，请重新输入！</li>");
					return returnResult(result);
				}
			},
			error:function(res){
				result= false;
				alert("执行检查二级密码出错！");
				return returnResult(result);
			}
		});	
		
		return result;
	}
}

$('.modify').click(function(){
	$('#userInfo').hide();
	$('#viewConfirmDiv').show();
});

$('.saveUserInfo').click(function(){
	$("#add_formtip").html("");
	var result = true;
	var expressType = $("#expressType").val();
	var userAddress = $.trim($('#userAddress').val());
	var postCode = $.trim($('#postCode').val());
	if(expressType == "" || expressType == null){
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>请选择快递类型。</li>");
		result = false;
	}
	if(userAddress == "" || userAddress == null){
		$("#add_formtip").css("color","red");
		$("#add_formtip").append("<li>对不起，收货地址不能为空。</li>");
		result = false;
	}
	
	if(result){
		$.ajax({
			url:'/shopping/updateUserInfo.html',
			data:{expressType:expressType,userAddress:userAddress,postCode:postCode},
			dateType:'html',
			success:function(result){
				if('success'==result){
					alert('修改成功！');
					$("#add_formtip").html("");
				}
			}
		});
	}
});

$('.paymentbtn').click(function(){
	var result = validatePassword();
	var orderNum = $("#orderNum").val();
	var sum = $("#sumPV").val();
	var type = $("#type").val();
	if(result){
		$.post("/shopping/repeated/doSettlement.html",{orderNum:orderNum,sum:sum,type:type},function(result){
			if("success"==result){
				if(confirm("支付成功，查看订单？")){
					window.location.href='/shopping/management/list.html';
				}
			}else if(null == result){
				alert("不能重复提交！");
			}else{
				alert("支付失败，请联系管理员！");
			}
		});
	}
});

