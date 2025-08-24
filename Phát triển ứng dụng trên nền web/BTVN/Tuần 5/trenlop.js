function hello() {
	alert ("Xin chao!");
}

// vd6.1
var x=5;
var shape= "round"
	document.write(typeof (x));
	document.write("<br>"+ typeof (shape));
	document.write("<br>"+ typeof (true));
	document.write("<br>"+ typeof (null));
// vd5.6
var fruit='apples';
var numfruit=12;
numfruit = numfruit + 20;
var temp ="There are " + numfruit + " "+ fruit + ".";
	document.write("<br>"+temp+"<br>");


function dispname (name) {
	alert("welcome, "+name);
}
//vd7.1
function chanle (x) {
	r=x%2;
	if (r==0)
	{
		document.write("so "+x+" la so chan");
	}
	else
	{
		document.write("so "+x+" la so le");
	}
}


// var x=prompt ("enter a num: ","");
// r=x%2;
// if (r==0)
// {
// document.write("so "+x+" la so chan");
// }
// else
// {
// document.write("so "+x+" la so le");
// }
// vd7.3
document.write("1.Oranges");
document.write("<br>2.Apples");
document.write("<br>3.Bananas");
document.write("<br>4.Cherries");
var exp=prompt ("Vui lòng hãy chọn một loại trái cấy trong danh sách:","");
switch (exp){
	case "Oranges":
		document.write("<br>Oranges are $0.59 a pound.");
		break;
	case "Apples":
		document.write("<br>Apples are $0.32 a pound.");
		break;
	case "Bananas":
		document.write("<br>Bananas are $0.48 a pound.");
		break;
	case "Cherries":
		document.write("<br>Cherries are $3.00 a pound.");
		break;
	default:
		document.write ("<br>Sorry, we have no this kind of fruit!!");
}
//Tính tổng
function tinhtong() {
	var x=prompt ("enter a num: ","");
	var sum=0;
	for(var i=1; i<=x; i++){
		sum= sum+i;
	}
	alert("Tong:"+ sum);
	
	alert("Ket hop Break "+ testBreak(sum));
}
//vd8.7
function testBreak (x) {
	var i = 0;
	while (i<6) {
	if (i == 3)
	break;
	i++;
	}
	return i*x;
}
//vd8.8
function testContinue() {
	i = 0;
	n = 0;
	while (i<5) {
		i++;
		if (i == 3)
		continue;
		n+=i;
	}
	alert("testContinue "+ n);	
}

// vd8.9
// 	checkiandj:
// 	while (i<4) {
// 		document.write (i + “<BR>”);
// 		i +=1;
// 		checkj:
// 		while (j>4) {
// 			document.write (j + “<BR>”);
// 			j -=1;
// 			if ((j%2) == 0)
// 			continue checkj;
// 			document.write (j + “is odd. <BR>”);
// 		}
// 		document.write(“i =” + i + “<BR>”);
// 		document.write(“j =” + j + “<BR>”); 
// }
//vd10.1
function ham() {
	myArray = new Array(3);
	myArray[0] = "Ha Noi";
	myArray[1] = "TP Da Nang";
	myArray[2] = "TP Ho Chi Minh";
	document.writeln(myArray[0] + "<BR>");
	document.writeln(myArray[1] + "<BR>");
	document.writeln(myArray[2] + "<BR>");
// vd10.2
	a = new Array ("a","b","c");
	a1=a.join(); // gán "a,b,c" vào a1 
	a2=a.join(","); // gán "a,b,c" vào a2
	a3=a.join("+"); // gán "a+b+c" vào a1
	document.writeln(a1 + "<BR>");
	document.writeln(a2 + "<BR>");
	document.writeln(a3 + "<BR>");
}