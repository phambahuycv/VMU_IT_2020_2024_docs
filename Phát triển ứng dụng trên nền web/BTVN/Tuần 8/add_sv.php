<?php
include('conn.php');
if(!empty($_POST['submit'])){
	if(isset($_POST['ten'])&&isset($_POST['id'])&&isset($_POST['diem'])){
		$ten = $_POST['hoten'];
		$id = $_POST['id'];
		$diem = $_POST['diem'];

		$sql = "INSERT INTO diem (id,ten,diem) VALUES('$id','$ten','$diem')";
		$stmt = $conn->prepare($sql);
		$query = $stmt->execute();
		if($query){
			header("location:index.php");
		}
		else{
			echo "Them that bai,vui long thu lai";
		}
	}
}
?>