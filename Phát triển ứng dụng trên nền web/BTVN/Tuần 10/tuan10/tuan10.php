<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
</head>
<body>
	<?php
	$sotrang=$pagenumber;
	$record=$rownumber;
	$totalRows=0;
	$paging = "Go 1 2 3 4 5 Next";
	echo " Gia tri cua paging: ";
	echo $paging;
	?>

	<h4>IF Statement</h4>
	
	<?php
	$b=true;
	if(($j>=3) && ($b!=true))
		echo "result is true"
	if(($j<3)||($b==true))
		echo "result is false";
	?>

	<h4>IF ELSE Statement</h4> 
	<?php 
	 $b=true; 
	 $j=3; 
	 if ($j>3) 
	 echo "result is true"; 
	 else 
	 { 
	 $j++; 
	 echo "result is $j"; 
	 } 
	?>

	<form method="post">
		<tr>
			<td>Name</td><td>:<input type="text" name="fullname"></td>
		</tr>
		<tr><td>Gender</td>
		<td>:<input type="radio" name="gender" value=M>Female</td>
		</tr>
		<tr>
			<td>&nbsp</td>
			<td>
				<input type="submit" value=Submit>
			</td>
		</tr>
	</form>
</body>
</html>