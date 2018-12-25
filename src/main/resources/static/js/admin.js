$(document).ready(function(){
	//禁止jquery ajax缓存
	$.ajaxSetup({cache:false})
	$('#add_ticket').click(function(e){
		//禁止表单默认的提交
		e.preventDefault()
		//使用ajax提交用户登录数据并进行验证
		$.ajax({
			url:'/addTicket',
			method:'GET',
			type:'text',
			success:function(data){
				$('#content').html(data)
				
			},
			error:function(e){
				console.log(e)
			}
		})
	})
	
	$('#total').click(function(e){
		//禁止表单默认的提交
		e.preventDefault()
		//使用ajax提交用户登录数据并进行验证
		$.ajax({
			url:'/getTotal',
			method:'GET',
			type:'text',
			success:function(data){
				$('#content').html(data)
				
			},
			error:function(e){
				console.log(e)
			}
		})
	})
	
	$('.submenu').click(function(e){
		//禁止表单默认的提交
		e.preventDefault()
		//使用ajax提交用户登录数据并进行验证
		$.ajax({
			url:'/getDetail',
			method:'GET',
			data:{
				activity_id:$(this).attr('id')
			},
			type:'text',
			success:function(data){
				$('#content').html(data)
				
			},
			error:function(e){
				console.log(e)
			}
		})
	})
})