$(function(){
	// 点击切换新旧账号
	$('.bind-old-btn').click(function() {
		$('.bind-old-padding').show()
		$('.bind-new-btn').removeClass('bind-new-old-change-color')
		$(this).addClass('bind-new-old-change-color')
		$('.bind-prublic').hide()
		$('.bind-old').show()
		$('.bind-change-animate').css({
			'transform': 'translateX(0)'
		})
	})
	$('.bind-new-btn').click(function() {
		$('.bind-old-padding').hide()
		$('.bind-old-btn').removeClass('bind-new-old-change-color')
		$(this).addClass('bind-new-old-change-color')
		$('.bind-prublic').hide()
		$('.bind-new').show()
		$('.bind-change-animate').css({
			'transform': 'translateX(148px)'
		})
	})
})