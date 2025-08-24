<?php
session_start();
if(!isset($_SESSION['username'])){
  header("location: login.php");
}
include 'connect.php';
	if($conn){
		//echo "Ket noi thanh cong!";
	}
	else{
		echo "Ket noi that bai!";
	}
	$sql= "SELECT * FROM dt";
	$stmt = $conn->prepare($sql);
	$query = $stmt->execute();

  if(isset($_POST['submit'])){
  $timkiem = $_POST['timkiem'];
  $sql3= "SELECT * FROM dt WHERE ten LIKE '%$timkiem%'";
  $stmt = $conn->prepare($sql3);
  $query = $stmt->execute();
}
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Web_DT</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<header>
		<h1>Sản phẩm nổi bật</h1>
	</header>
	<div class="container">
		<?php
			if($query){
				while($row = $stmt->fetch(PDO::FETCH_ASSOC)){
		?>
		<div class="product">
			
			<div class="product-info">
				<img src="./img/<?php echo $row['anh']?>" alt="Product 1">
				<div>
					<h2><?php echo $row['ten']?></h2>
					<p class="warranty">*Bảo hành: <?php echo $row['baohanh']?></p>
					<p class="status">*Trạng thái: <?php echo $row['trangthai']?></p>
				</div>
			</div>
			<div class="details">
				<p class="price">*Giá: <?php echo $row['gia']?></p>
				<div>
					<button>
            <span class="an">
              <div>
                <a href="sua.php?id=<?php echo $row['id']?>">Sửa</a> 
                <a href="xoa.php?id=<?php echo $row['id']?>">Xóa</a>
              </div>
            </span>      
          </button>
				</div>			
			</div>
			
		</div>
		<?php	
				}
				}
				?>
  </div>
	<div class="search">
    <form method="post">
      <p>Tên sản phẩm: <input type="text" name="timkiem"></p>
      <button type="submit" name="submit" value="submit">Tìm kiếm</button>
    </form>
  </div>
  <div class="logout">
    <button style="background: aqua;"><a href="them.php">Thêm</a></button>
    <button class="dangxuat" style="background: aqua;"><a href="logout.php">Đăng xuất</a></button>
  </div>
</body>
</html>