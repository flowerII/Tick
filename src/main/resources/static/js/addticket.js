$(document).ready(function(){
	//禁止jquery ajax缓存
	$.ajaxSetup({cache:false})
	$('#add_product_submit').click(function(e){
		//禁止表单默认的提交
		e.preventDefault()
		var str1=$('#activity_descript').val()
		if(str1.indexOf('-')<0){
			alert("类型输入错误！！")
			return ;
		}
		var r = /^\+?[1-9][0-9]*$/;　　//判断是否为正整数 
		str=$('#ticket_total_num').val()
        if(!r.test(str)){
        	alert('请填写正确数量！！')
        	return ;
        }
		//使用ajax提交用户登录数据并进行验证
		$.ajax({
			url:'/addTicket1',
			method:'GET',
			data:{
				activity_descript:$('#activity_descript').val(),
				ticket_total_num:$('#ticket_total_num').val(),
				start_time:$('#start_time').val()
			},
			type:'json',
			success:function(data){
				if(data==1){
					alert('新增成功！！')
					window.location.href="/admin"
				}
				else{
					alert(data)
				}
				
			},
			error:function(e){
				console.log(e)
			}
		})
	})
})