$(document).ready(function(){
	$("#password").blur(function(){
		validateSecondaryPassword();
});

	//添加用户信息验证
	$(".nextbtn").click(function(){
		$("#confirm_formtip").html("");
		var userId = $('[name=userId]:checked').val();
		if(userId!=null && userId!=''){
			$('#viewConfirmDiv').modal('show');
		}else{
			$("#confirm_formtip").css("color","red");
			$("#confirm_formtip").html("<li>请选择要激活的会员！</li>");
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
		$("#add_formtip").html("<li>请输入二级密码！</li>");
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


$("#submit").click(function(){
	$("#add_formtip").html("");
	var result4 = validateSecondaryPassword(true);
	if(result4){
		$('#myForm').attr('action','/shopping/activate/gotoActivate.html');
		$('#myForm').submit();
	}
});

$(".prevbtn").click(function(e){
	window.location.href="/shopping/activate/gotoActivate.html";
});

function doActivate(rootCode,totalCode){
	if(null!=totalCode){
		url="/shopping/activate/doActivate.html";
		data={totalCode:totalCode};
		$.ajax({
			url:url,
			data:data,
			dataType:'html',
			success:function(result){
				if(result=="successd"){
					alert("安置成功！");
					window.location.href="/shopping/activate/gotoActivate.html?totalCode="+rootCode+"&rootCode="+rootCode;
				}else{
					alert("操作失败！");
				}
			},
			error:function(){
				alert("操作失败！");
			}
		});
	}
}
