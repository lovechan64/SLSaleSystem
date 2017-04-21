var curPage = $("#currentpage").val();
	var pageCount = $("#pageCount").val();
	function firstPage(){
		$("#currentpage").attr('value','1');
		$("#myForm").submit();
	}
	function lastPage(){
		$("#currentpage").attr('value',pageCount);
		$("#myForm").submit();
	}		
	function previousPage(){
		if(curPage > 0){
			$("#currentpage").attr('value',parseInt(curPage)-1);
			$("#myForm").submit();
		}
	}
	function nextPage(){
		if(curPage < pageCount){
			$("#currentpage").attr('value',parseInt(curPage)+1);
			$("#myForm").submit();
		}
	}
