$(function() {
	// 头部搜索框
	var inputVal = $('#top-search-input').val()
	$('#top-search-input').focus(function() {
		if ($(this).val() == inputVal) {
			$(this).val('')
		}
		$(this).css({
			'color': '#333',
			'border-color': '#df3225'
		})
		$('.search i').css('color', '#df3225')
	})
	$('#top-search-input').blur(function() {
		if ($(this).val() == inputVal || $(this).val() == '') {
			$(this).val(inputVal)
			$(this).css({
				'color': '#ccc',
				'border-color': 'rgba(51,51,51,0.2)'
			})
			$('.search i').css('color', '#333')
		} else {
			$(this).css('color', '#333')
		}

	})

	//						vip  部分
	$('.vip').hover(function() {
		$(".showPersionMsg").show();
	}, function() {
		$(".showPersionMsg").hide();
	})
	$('.showPersionMsg').hover(function() {
		$('.showPersionMsg').show();
	}, function() {
		$(this).hide();
	})

	//鼠标放进个人中心是改变背景颜色
	$(".vip-msg-in").hover(function() {
		$(this).addClass('checkcolor')
		//				alert(1)
	}, function() {
		$(this).removeClass('checkcolor')
	})

	// 重新登录
	$('#log-in-cancel-btn').click(function() {
		$('.log-in-again').hide()
	})
	$('#log-in-again-btn').click(function() {
		$('.log-in-again').hide()
	})
	// 注册登录切换````````````````````````````````````````````````````````````````````````````````````
	/**
	// 点击登录
	$('#btn-load').click(function() {
		load();
		unScroll();
	})
	$('.load-span').click(function() {
		load();
		unScroll();
	})**/

	function load() {
		$('.header-load-concent').find('h1').removeClass('change change2')
		$('.header-load-concent').find('h1').find('span').removeClass('change-color')
		$('.motaiceng').show();
		$('.header-load-concent').show();
		$('.header-loading').show();
		$('.header-zhuce').hide();
		$('.header-load-concent').find('h1').addClass('change2')
		$('.header-load-concent').find('h1').find('.load-span').addClass('change-color')
        $('.load-zhuce-footer').show()
	}
	// 点击注册```````````````````````````````````````````````````````````````````````````````````````
	/**
	$('#btn-zhuce').click(function() {
		register()
		unScroll();
	})
	$('.zhuce-span').click(function() {
		register()
		unScroll();
	})**/

	function register() {
		$('.header-load-concent').find('h1').removeClass('change change2')
		$('.header-load-concent').find('h1').find('span').removeClass('change-color')
		$('.motaiceng').show();
		$('.header-load-concent').show();
		$('.header-loading').hide();
		$('.header-zhuce').show();
		$('.header-load-concent').find('h1').addClass('change')
		$('.header-load-concent').find('h1').find('.zhuce-span').addClass('change-color')
        $('.zhuce-first').show()
        $('.zhuce-second').hide()
        $('.load-zhuce-footer').show()
	}
	//点击关闭登录界面
	$('.load-del').click(function() {
		$('.motaiceng').hide();
		$(".ddd").hide()
		$('.header-load-concent').hide();
		$('.header-find-possword').addClass('header-find-possword')
		removeUnScroll();
		$('.num-phone').css('visibility', 'hidden')
		$('.num-possword').css('visibility', 'hidden')
        $("#findLoginUserPasswordErrorInfo").hide()


	})
	$('.motaiceng').click(function() {
		$('.motaiceng').hide();
		$(".ddd").hide()
		$('.header-load-concent').hide();
		removeUnScroll();
		$('.num-phone').css('visibility', 'hidden')
		$('.num-possword').css('visibility', 'hidden')
        $("#findLoginUserPasswordErrorInfo").hide()
	})
	// 滚动条禁止滚动
	function unScroll() {
		var top = $(document).scrollTop();
		$(document).on('scroll.unable', function(e) {
			$(document).scrollTop(top);
		})
	}
	// 允许滚动
	function removeUnScroll() {
		$(document).unbind("scroll.unable");
	}

	//  账号框和密码获得失去焦点
	$(".inp-load").focus(function cls() {
		//捕获触发事件的对象，并设置为以下语句的默认对象 
		with(event.srcElement)
		//如果当前值为默认值，则清空 
		if (value == defaultValue) {
			value = ""
		}
		$(this).css("color", "#333")
		$(this).parent().css("border-color", "rgba(223, 50, 37, 1)")
	});

	$(".inp-load").blur(function cls() {

		//捕获触发事件的对象，并设置为以下语句的默认对象 
		with(event.srcElement)
		//如果当前值为默认值，则清空 
		if (value == "") {
			value = defaultValue
			$(this).css("color", "rgba(153, 153, 153, 1)")
		}
		$(this).parent().css("border-color", "rgba(228, 228, 228, 1)")
	});
	// 输入账号框 失去焦点时,清空value内容,判断输入格式是否正确
	$(".inp-load1").focus(function() {
		$(this).parent().addClass('header-loading-input11')
	})
	$(".inp-load1").blur(function res() {
		$(this).parent().removeClass('header-loading-input11')
		var val = $(this).val();
		var reg = new RegExp("^([0-9A-Za-z\\-_\\.]+)@([0-9a-z]+\\.[a-z]{2,3}(\\.[a-z]{2})?)$");
		var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
		if (val == "") { //输入不能为空
			$('.right-phone-num').css("visibility", "visible")
		} else if (reg.test(val)) {
			$('.right-phone-num').css("visibility", "hidden")
		} else if (myreg.test(val)) {
			$('.right-phone-num').css("visibility", "hidden")
		} else {
			$('.right-phone-num').css("visibility", "visible")
		}
	});

	//输入密码框失去焦点时
	$(".inp-load2").focus(function() {
		$(this).parent().addClass('header-loading-input22')
	})
	$(".inp-load2").blur(function res() {
		$(this).parent().removeClass('header-loading-input22')
		var val = $(this).val();
		var reg = /^.{6,}$/;
		var flag = reg.test(val);
		if (flag == false) {
			$('.num-possword').css("visibility", "visible")
			// return false;
		} else {
			$('.num-possword').css("visibility", "hidden")
		}
	});

	// 注册部分------------------------------------------------------------------
	$(".zhuce-public").focus(function cls() {

		$('.zhuce-ma').css("display", "block")
		//捕获触发事件的对象，并设置为以下语句的默认对象 
		with(event.srcElement)
		//如果当前值为默认值，则清空 
		if (value == defaultValue) {
			value = ""
		}
		$(this).css("color", "#333")
		$(this).parent().css("border-color", "rgba(223, 50, 37, 1)")
	});
	//注册失去焦点时
	$(".zhuce-public").blur(function cls() {
		//捕获触发事件的对象，并设置为以下语句的默认对象 
		with(event.srcElement)
		//如果当前值为空，则重置为默认值 
		if (value == "") {
			value = defaultValue
			$(this).css("color", "rgba(153, 153, 153, 1)")
		}
		$(this).parent().css("border-color", "rgba(228, 228, 228, 1)")
	});

	$('.header-loading-input').find("input").focus(function() {
		var index = $(this).index()
	})


	// 输入邮箱判断
	$(".zhece-email").focus(function() {
		$(this).parent().addClass('header-zhuce-input11')
	})
	$(".zhece-email").blur(function res() {
		$(this).parent().removeClass('header-zhuce-input11')
		var val = $(this).val();
		var reg = /^\w{3,}(\.\w+)*@[A-z0-9]+(\.[A-z]{2,5}){1,2}$/;
		var flag = reg.test(val);
		if (flag == false) {
			$('.right-email').css("visibility", "visible")
			// return false;
		} else {
			$('.right-email').css("visibility", "hidden")
		}
	});
	// 输入手机号码判断
	$(".zhece-phone").focus(function() {
		$(this).parent().addClass('header-zhuce-input22')
	})
	$(".zhece-phone").blur(function res() {
		$(this).parent().removeClass('header-zhuce-input22')
		var val = $(this).val();
		var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
		var flag = reg.test(val);
		if (flag == false) {
			$('.right-phone').css("visibility", "visible")
			// return false;
		} else {
			$('.right-phone').css("visibility", "hidden")
		}
	});
	// 输入注册判断
	$(".zhece-id").focus(function() {
		$(this).parent().addClass('header-zhuce-input33')
	})
	$(".zhece-id").blur(function res() {
		$(this).parent().removeClass('header-zhuce-input33')
		if($(".zhece-id").val()==''){
			$('.right-id').css("visibility", "visible")
        }else {
            $('.right-id').css("visibility", "hidden")
		}

	});

	// 输入密码判断
	$(".zhece-password1").focus(function() {
		$(this).parent().addClass('header-zhuce-input44')
	})
	$(".zhece-password1").blur(function res() {
		$(this).parent().removeClass('header-zhuce-input44')
		var val = $(this).val();
		var reg = /^.{6,}$/;
		var flag = reg.test(val);
		if (flag == false) {
			$('.right-possword').css("visibility", "visible")
			// return false;
		} else {
			$('.right-possword').css("visibility", "hidden")
		}
	});
	// 输入第二次密码判断是否一致
	$(".zhece-password-rr").focus(function() {
		$(this).parent().addClass('header-zhuce-input55')
	})
	$(".zhece-password-rr").blur(function res() {
		$(this).parent().removeClass('header-zhuce-input55')
		var val = $(this).val();
		var val1 = $('.zhece-password1').val();
		if (val != val1) {
			$('.right-same11').css("visibility", "visible")
			// return false;
		} else {
			$('.right-same11').css("visibility", "hidden")
		}
	});

	//  后台判断验证码输入验证码判断


	// 找回密码--------------------------------------------------------------
	$(".find-p").focus(function cls() {
		//捕获触发事件的对象，并设置为以下语句的默认对象 
		with(event.srcElement)
		//如果当前值为默认值，则清空 
		if (value == defaultValue) {
			value = ""
		}
		$(this).css("color", "#333")
		$(this).parent().css("border-color", "rgba(223, 50, 37, 1)")
	});
	//找回密码失去焦点时
	$(".find-p").blur(function cls() {
		//捕获触发事件的对象，并设置为以下语句的默认对象 
		with(event.srcElement)
		//如果当前值为空，则重置为默认值 
		if (value == "") {
			value = defaultValue
			$(this).css("color", "rgba(153, 153, 153, 1)")
		}
		$(this).parent().css("border-color", "rgba(228, 228, 228, 1)")
	});
	// 切换找回密码背景
	$("#right-phone").focus(function() {
		$(this).parent().addClass('send-msg11')
	})
	$("#right-phone").blur(function res() {
		$(this).parent().removeClass('send-msg11')
	});

	$(".send-msg3").focus(function() {
		$(this).parent().addClass('send-msg33')
	})
	$(".send-msg3").blur(function res() {
		$(this).parent().removeClass('send-msg33')
	});

	$(".zhece-password-rrr").focus(function() {
		$(this).parent().addClass('send-msg4')
	})
	$(".zhece-password-rrr").blur(function res() {
		$(this).parent().removeClass('send-msg44')
        var val111 = $(this).val();
        var val222 = $('.zhece-password2').val();
        if (val111 != val222) {
            $('.right-same22').css("visibility", "visible")
            // return false;
        } else {
            $('.right-same22').css("visibility", "hidden")
        }
	});

	// 输入密码切换
	$('#forget-possword').click(function() {
		$('.header-load-concent-1').hide()
		$(".ddd").show()
	})
	// 关闭广告
	$('.advertisement-del').click(function(){
		$('.advertisement, #advertisement').hide()
	})
})
