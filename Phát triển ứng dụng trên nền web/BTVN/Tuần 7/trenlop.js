$(document).ready(function(){
	$(".an").click(function(){
		$("p").hide();
		$("h2").hide();
	}
	);
}
);
$(document).ready(function(){
	$(".hien").click(function(){
		$("p").show();
		$("h2").show();
	}
	);
}
);

$(document).ready(function(){
	$("#btn1").click(function(){
		$("p").append(" <b>Appended text</b>.");
	}
	);

	$("#btn2").click(function(){
		$("ol").append(" <li>Appended item</li>");
	}
	);


	$("#btn3").click(function(){
		$("ol").prepend(" <li>Prepend item</li>");
	}
	);


	$("#btn4").click(function(){
		$("ol").before(" <li>Before item</li>");
	}
	);


	$("#btn5").click(function(){
		$("ol").after(" <li>After item</li>");
	}
	);
}
);


	




