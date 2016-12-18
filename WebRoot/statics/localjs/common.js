/**
 * 验证二级密码
 * @param flag
 * @returns {Boolean}
 */
window.validateSecondaryPassword=function (flag){
	alert(flag);
	var result=false;
	if(null==flag || flag==''){
		$("#add_formtip").html("");
	}
	var password = $.trim($("#password").val());
	alert(password);
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