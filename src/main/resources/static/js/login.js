$(document).ready(function(){
	//禁止jquery ajax缓存
	$.ajaxSetup({cache:false})
	$('#login').click(function(e){
		//禁止表单默认的提交
		e.preventDefault()
		//使用ajax提交用户登录数据并进行验证
		$.ajax({
			url:'/login',
			method:'POST',
			data:{
				username:$('#username').val(),
				password:$('#password').val()
			},
			type:'json',
			success:function(data){
				if(data==1){
					alert('登录成功！！')
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