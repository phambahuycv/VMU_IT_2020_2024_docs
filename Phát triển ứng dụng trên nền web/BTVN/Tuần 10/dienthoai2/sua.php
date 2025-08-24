<?php
session_start();
if(!isset($_SESSION['username'])){
  header("location: login.php");
}
include('connect.php');
$id = $_GET['id'];
$sql1 = "SELECT * FROM dt WHERE id = '$id'";
$stmt = $conn->prepare($sql1);
$query = $stmt->execute();
$result = $stmt->fetch(PDO::FETCH_ASSOC);
if(!empty($_POST['submit'])){
	if(isset($_POST['ten'])&&isset($_POST['baohanh'])&&isset($_POST['trangthai'])&&isset($_POST['gia'])&&isset($_POST['anh'])){
		$ten = $_POST['ten'];
		$baohanh = $_POST['baohanh'];
		$trangthai = $_POST['trangthai'];
		$gia = $_POST['gia'];
		$anh = $_POST['anh'];
		$sql = "UPDATE dt SET ten='$ten',baohanh='$baohanh',trangthai='$trangthai',gia='$gia',anh='$anh' WHERE id='$id'";
		$stmt = $conn->prepare($sql);
		$query = $stmt->execute();
		if($query){
			header("location:index.php");
		}
		else{
			echo "Sua that bai,vui long thu lai";
		}
	}
}
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Sửa</title>
	<style type="text/css">
		form {
            background:lightblue;
            width: 400px;
            height: 220px;
            margin-left:40%;
            padding:16px;
        }
        button {
	</style>
</head>
<body>
	<div class="container">
		<form method="post">
			<table>
				<tbody>
					<tr>
						<td>Nhập tên sản phẩm</td>
						<td><input type="text" name="ten" value="<?php echo $result['ten']?>"></td>
					</tr>

					<tr>
						<td>Nhập thời gian bảo hành</td>
						<td><input type="text" name="baohanh" value="<?php echo $result['baohanh']?>"></td>
					</tr>

					<tr>
						<td>Nhập trạng thái sản phẩm</td>
						<td><input type="text" name="trangthai" value="<?php echo $result['trangthai']?>"></td>
					</tr>

					<tr>
						<td>Nhập giá sản phẩm</td>
						<td><input type="text" name="gia" value="<?php echo $result['gia']?>"></td>
					</tr>
					<tr>
						<td>Nhập ảnh sản phẩm</td>
						<td><input type="file" name="anh" value=""></td>
					</tr>
				</tbody>
			</table>
			<button style="submit" name="submit" value="submit">Lưu</button>
		</form>
	</div>
</body>
</html>