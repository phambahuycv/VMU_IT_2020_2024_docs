<?php
include 'connect.php';
	if($conn){
		echo "Ket noi thanh cong!";
	}
	else{
		echo "Ket noi that bai!";
	}
	$sql= "SELECT * FROM diem";
	$stmt = $conn->prepare($sql);
	$query = $stmt->execute();
?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>test PDO</title>
</head>
<body>
	<button><a href="add_std.php">Them sinh vien</a></button>
	<div class="container">
		<table class="table table-inverse">
		<thead>
			<tr>
				<th>Ma SV</th>
				<th>Ho Ten</th>
				<th>Diem</th>
				<th>Thao tac</th>
			</tr>
		</thead>
		<tbody>
			<?php
				if($query){
					while($row = $stmt->fetch(PDO::FETCH_ASSOC)){
			?>
			<tr>
				<td><?php echo $row['id']?></td>
				<td><?php echo $row['ten']?></td>
				<td><?php echo $row['diem']?></td>
				<span><td><a href="edit.php?ID=<?php echo $row['id']?>">Sua</a> <a href="delete.php?ID=<?php echo $row['id']?>">Xoa</a></td></span>
			</tr>
			<?php	
				}
				}
				?>
		</tbody>
	</table>
	</div>
</body>
</html>