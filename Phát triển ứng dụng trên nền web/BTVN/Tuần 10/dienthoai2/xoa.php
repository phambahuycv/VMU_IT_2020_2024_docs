<?php
include('connect.php');
$id=$_GET['id'];
$sql2= "DELETE FROM dt WHERE id = '$id'";
$stmt = $conn->prepare($sql2);
$query= $stmt->execute();
header("location:index.php");
?>