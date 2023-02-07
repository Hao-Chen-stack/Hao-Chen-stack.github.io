		// 账号验证
		function checkAcc(e) {
			var acc = e.value
			var accPattern = /^[A-Za-z0-9]{6,15}$/;
			document.getElementById("accMsg");
			if (acc == '') {
				accMsg.innerHTML = "账号不能为空"
				accMsg.style.display = "block"
			} else if (acc.length < 6 || acc.length > 15) {
				accMsg.innerHTML = "账号必须在6-15位之间"
				accMsg.style.display = "block"

			} else if (!accPattern.test(acc)) {
				accMsg.innerHTML = "请输入正确格式的账号"
				accMsg.style.display = "block"
			} else {
				accMsg.style.display = "none"
			}
		}
		
		// 密码验证
		function checkPwd(e) {
			var pwd = e.value
			document.getElementById("pwdMsg");
			if (pwd == '') {
				pwdMsg.innerHTML = "密码不能为空"
				pwdMsg.style.display = "block"
			} else if (pwd.length < 6 || pwd.length > 15) {
				pwdMsg.innerHTML = "密码必须在6-15位之间"
				pwdMsg.style.display = "block"
			} else {
				pwdMsg.style.display = "none"
			}
		}


		// 确认密码验证
		function checkPwd2(e) {
			var pwd = e.value
			document.getElementById("pwdMsg2");
			if (pwd == '') {
				pwdMsg2.innerHTML = "确认密码不能为空"
				pwdMsg2.style.display = "block"
			} else {
				pwdMsg2.style.display = "none"
			}
		}
		
		// 邮箱验证
		function checkEmail(e){
			var ema = e.value
			var emaPattern = /^[A-Za-z0-9._%-]+@([A-Za-z0-9-]+\.)+[A-Za-z]{2,4}$/;
			document.getElementById("emailMsg");
			if(ema == ''){
				emaMsg.innerHTML = "邮箱不能为空"
				emaMsg.style.display = "block"
			}else if(!emaPattern.test(ema)){
				emaMsg.innerHTML = "邮箱格式错误"
				emaMsg.style.display = "block"
			}else{
				emaMsg.style.display = "none"
			}
		}

		//手机号验证
		function checkPhone(e){
			var phone = e.value;
			var phonePattern = /^((13[0-9])|(14[1|5|7])|(15([0-3]|[5-9]))|(18[0-9]))\d{8}$/;
			var phoneMsg = document.getElementById("phoneMsg")
			 if(!phonePattern.test(phone)){
				phoneMsg.innerHTML="手机号格式错误"
				phoneMsg.style.display="block"
			}
			else{
				phoneMsg.style.display="none"
			}
		}
		