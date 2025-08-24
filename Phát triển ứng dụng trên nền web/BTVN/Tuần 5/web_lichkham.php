<?php
	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		$username = $_POST['username'];
		$email = $_POST['email'];
		$password = $_POST['password'];
		$confirm_password = $_POST['confirm-password'];

		// Kiểm tra xem các trường thông tin đã được điền đầy đủ hay chưa
		if (empty($username) || empty($email) || empty($password) || empty($confirm_password)) {
			echo "Vui lòng nhập đầy đủ thông tin.";
		} else {
			// Kiểm tra xem mật khẩu và xác nhận mật khẩu có khớp nhau hay không
			if ($password != $confirm_password) {
				echo "Mật khẩu và xác nhận mật khẩu không khớp.";
			} else {
				// Kết nối đến cơ sở dữ liệu
				$conn = mysqli_connect('localhost', 'username', 'password', 'database_name');

				// Kiểm tra xem kết nối có thành công hay không
				if (!$conn) {
					die("Kết nối đến cơ sở dữ liệu thất bại: " . mysqli_connect_error());
				}

				// Kiểm tra xem tài khoản đã tồn tại trong cơ sở dữ liệu hay chưa
				
