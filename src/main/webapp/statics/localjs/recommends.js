$(document).ready(function(){
	var result ="";
	var jsonList = $.parseJSON(userListJOSN);
	result = "<li><ul class='nav nav-tabs nav-stacked' id='test'>";
	result = result + '<li class="nav-header hidden-tablet" style="cursor:pointer;">当前用户：'+loginCode+'</li>';
	for(var i = 0;i<jsonList.length;i++){
		
		//if(i>0)	style = "display: none;";
		
		//for(var j=0;j<jsonList[i].subMenus.length;j++){
			result = result + "<li><a class='ajax-link' style='cursor:pointer;' onclick='show("+i+");'>" +
					"<span class='icon icon-darkgray  icon-bullet-off'></span>推荐用户："+jsonList[i].loginCode + "</a></li>";
		//}
	}
	result = result +"</ul></li>";
	$("#recommend").append(result);
});		

function show(i){
	var jsonList = $.parseJSON(userListJOSN);
	var html="<h3>会员信息</h3><br><table><tr><td align='right'>会员登录名：</td><td>"+jsonList[i].loginCode+
	"</td></tr><tr><td align='right'>真实姓名：</td><td>"+jsonList[i].userName+
	"</td></tr><tr><td align='right'>用户类型：</td><td>"+jsonList[i].userTypeName+
	"</td></tr><tr><td align='right'>性别：</td><td>"+jsonList[i].sex+
	"</td></tr><tr><td align='right'>申请日期：</td><td>"+new Date(jsonList[i].createTime.time).pattern("yyyy-MM-dd HH:mm:ss")+
	"</td></tr><tr><td align='right'>证件号码：</td><td>"+jsonList[i].idCard+
	"</td></tr><tr><td align='right'>移动电话：</td><td>"+jsonList[i].mobile+
	"</td></tr><tr><td align='right'>电子邮箱：</td><td>"+jsonList[i].email+
	"</td></tr><tr><td align='right'>收货国家：</td><td>"+jsonList[i].country+
	"</td></tr><tr><td align='right'>收货地址：</td><td>"+jsonList[i].userAddress+
	"</td></tr><tr><td align='right'>邮政编码：</td><td>"+jsonList[i].postCode+"</td></tr></table>";
	$('#show').html(html);
	$("#show").show();
	   
}

	Date.prototype.pattern=function(fmt) {		 
		  var o = {		 
		  "M+" : this.getMonth()+1, //月份		 
		  "d+" : this.getDate(), //日		 
		  "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时		 
		  "H+" : this.getHours(), //小时		 
		  "m+" : this.getMinutes(), //分		 
		  "s+" : this.getSeconds(), //秒		 
		  "q+" : Math.floor((this.getMonth()+3)/3), //季度		 
		  "S" : this.getMilliseconds() //毫秒		 
		  };		 
		  var week = {		 
		  "0" : "/u65e5",		 
		  "1" : "/u4e00",		 
		  "2" : "/u4e8c",		 
		  "3" : "/u4e09",		 
		  "4" : "/u56db",		 
		  "5" : "/u4e94",		 
		  "6" : "/u516d"		
		  };		 
		  if(/(y+)/.test(fmt)){		 
		    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));		 
		  }		 
		  if(/(E+)/.test(fmt)){		 
		    fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);		 
		  }		 
		  for(var k in o){		 
		    if(new RegExp("("+ k +")").test(fmt)){		 
		      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));		 
		    }		 
		  }		 
		  return fmt;		 
		};	   
		   
	  //return (date.year+1900)+"-"+(date.month+1)+"-"+date.date+" "+date.hours+":"+date.minutes+":"+date.seconds;		 
