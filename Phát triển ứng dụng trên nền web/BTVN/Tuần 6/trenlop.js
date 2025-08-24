function doCal (x) 
{
var a;
a = Math.PI * x * x;
alert ("The area of a circle with a radius of " + x + "" + " is " + "" + a.toFixed(2));
}
function show (value){
	with (Math){
		document.write("Absulute value of a number " + value + " is : "+abs(eval(value)));
	} 
}
function c11_3(){
	var a = "big";
	var b = "small";
	var c = "bold";
	var d = "blink";
	var e = "UpperCase";
	var f = "LowerCase";
	document.write ("<BR>This is "+ a.big() + " text");
	document.write ("<BR>This is "+ b.small() + " text");
	document.write ("<BR>This is "+ c.bold() + " text");
	document.write ("<BR>This is "+ d.blink() + " text");
	document.write ("<BR>This is "+ e.toUpperCase() + " text");
	document.write ("<BR>This is "+ f.toLowerCase() + " text");
}

function c11_4(){
	str1 = "Đây là kết thúc của một dòng.";
	document.write(str1);
	document.write("<BR>");
	document.write("Vị trí của từ 'kết' là " +str1.search('kết'));
}

function disptime() {
	var time = new Date();
	var hour = time.getHours();
	var min = time.getMinutes();
	var sec = time.getSeconds();
	var temp = "" + ((hour>12) ? hour -12:hour);
	temp +=((min <10)? ":0" : ":") + min;
	temp +=((sec <10)? ":0" : ":") + sec;
	temp +=(hour>=12)? "P.M." : "A.M.";
	document.MyPage.time.value = temp;
}

function compute(form){
	if (confirm("Are you sure?")){
		form.ketqua.value = eval(form.expr.value);
	}
	else{
		alert("Please come back again.");
	} 
}

function checkNum(num){
	if (num ==""){
		alert("Please enter a number");
		return false;
	}
	if (isNaN(num)){
		alert("Please enter a numeric value");
		return false;
	}
	else {
		alert ("Thank you!");
	} 
}

var numq=0
function showLink(numq){
	if (numq==1){
		document.forms[0].elements[0].value= "You haveselected America";
	}
	if (numq==2){
		document.forms[0].elements[0].value= "You haveselected Korea";
	}
	if (numq==3){
		document.forms[0].elements[0].value= "You haveselected Vietnam";
	} 
}

function writeIt(value){
myfm.second_text.value = value;
}

function switchLight(){
	var the_box=window.document.form_2.check_1;
	var the_switch = "";
	if (the_box.checked == false){
		document.bgColor='black';
		alert ("Hey! Turn that back on!");
	}
	else{
		document.bgColor='white';
		alert ("Thanks!");
	} 
}

function offButton(){
	var the_box= window.document.form_1.radio_1;
	if(the_box.checked==true){
		window.document.form_1.radio_2.checked= false;
		document.bgColor='black';
		alert("Hey! Turn that back on!");
	}
}
function onButton(){
	var the_box=window.document.form_1.radio_2;
	if (the_box.checked == true){
		window.document.form_1.radio_1.checked = false;
		document.bgColor='white';
		alert ("Thanks!");
	}
}


function validateFirstName(){
	var str=form1.fname.value;
	if (str.length == 0){
		alert ("The first name cannot be empty");
		return false;
	}
	return true;
}
function validateLastName(){
	var str=form1.lname.value;
	if (str.length == 0){
		alert ("The last name cannot be empty");
		return false;
	}
	return true;
}
function validateEmail(){
	var str=form1.email.value;
	if (str.length == 0){
		alert ("The Email field cannot be empty");
		return false;
	}
}
function proccessForm(){
	disp = open("","result");
	disp.document.write("<TITLE> Result Page </TITLE>"+"<PRE>");
	disp.document.write("<H2 ALIGN='CENTER'>" + "Thanks for signing in " + "</H2>"+"<HR>"+"<BR><BR>");
	disp.document.write("First name \t\t:" + form1.fname.value+"<BR>");
	disp.document.write("Last name \t\t:"+form1.lname.value+"<BR>");
	disp.document.write("Email \t\t\t:" + form1.email.value+"<BR>");
	disp.document.write("Your comments \t\t:" + form1.comment.value+"<BR>");
	disp.document.write("<PRE>");
	if (disp.confirm("Is this information correct"))
		disp.close();
}