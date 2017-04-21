$('.delorder').click(function(){
	var id = $(this).attr('id');
	var orderNum = $(this).attr('orderNum');
	if(id!=null&&id!=''&&id!='undefined'){
		if(confirm("删除当天的订单，将会视为撤销订单。您确定要删除【"+orderNum+"】这个订单吗？")){
			$.post("/shopping/management/doRemove.html",{orderId:id,orderNum:orderNum},function(result){
				if("success" == result){
					alert("删除成功！");
					window.location.href="/shopping/management/list.html";
				}else{
					alert("删除失败！");
				}
			},'html');
		}
	}
});

$('.delCart').click(function(){
	//var id = $(this).attr('id');
	var id = $('input[name=cks]:checked').val();
	if(id==null || id=='' || id=='undefined'){
		alert("请选择要结算的订单！");
		return ;
	}
	var orderNum = $('#'+id).val();
	if(confirm("您确定要删除【"+orderNum+"】这个订单吗？")){
		$.post("/shopping/management/doRemove.html",{orderId:id,orderNum:orderNum},function(result){
			if("success" == result){
				alert("删除成功！");
				window.location.reload();
			}else{
				alert("删除失败！");
			}
		},'html');
	}
});

$('.gotobtn').click(function(){
	$('#myForm').submit();
});

$('.gotoSettlement').click(function(){
	var id = $('input[name=cks]:checked').val();
	if(id==null || id=='' || id=='undefined'){
		alert("请选择要结算的订单！");
		return ;
	}
	var orderNum  = document.getElementsByName(+id+'buyNum');
	buyNums = "";
	for(var i=0;i<orderNum.length;i++){
		if(buyNums==''){
			buyNums=orderNum[i].value;
		}else{
			buyNums=buyNums+","+orderNum[i].value;
		}
	}
	//alert(buyNums);
	$('#checkedIds').attr('value',id);
	$('#buyNums').attr('value',buyNums);
	$('#myForm').submit();
});