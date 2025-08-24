<?php
session_start();
if(isset($_POST['submit'])){
    include('connect.php');
    $username = $_POST['username'];
    $password = $_POST['password'];
    $sql_admin = "SELECT * FROM admin WHERE username = :username AND password = :password";
    $stmt_admin = $conn->prepare($sql_admin);
    $stmt_admin->execute(array(':username'=>$username, ':password'=>$password));
    $row_admin = $stmt_admin->fetch(PDO::FETCH_ASSOC);
    if($row_admin){
        $_SESSION['username'] = $username;
        header("location: index.php");
    } else {
        $sql_khachhang = "SELECT * FROM khachhang WHERE username = :username AND password = :password";
        $stmt_khachhang = $conn->prepare($sql_khachhang);
        $stmt_khachhang->execute(array(':username'=>$username, ':password'=>$password));
        $row_khachhang = $stmt_khachhang->fetch(PDO::FETCH_ASSOC);
        if($row_khachhang){
            $_SESSION['username'] = $username;
            header("location: khachhang.php");
        } else {
            echo "Invalid username or password";
        }
    }
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style type="text/css">
        form {
            background:lightblue;
            width: 400px;
            height: 220px;
            margin-left:40%;
            padding:16px;
        }
        h2 {
            margin-left:47%;
        }
        button {
            margin-left:40%;
            padding:16px;
            background: lightblue;
        }
    </style>
</head>
<body>
    <h2>Đăng nhập</h2>
    <form method="post">
        <div class="form-group">
            <label>Tài khoản:</label>
            <input type="text" name="username" class="form-control">
        </div>
        <br><br>
        <div class="form-group">
            <label>Mật khẩu:</label>
            <input type="password" name="password" class="form-control">
        </div>
            <br><br>
        <button type="submit" name="submit">Đăng nhập</button>
    </form>
</body>
</html>
