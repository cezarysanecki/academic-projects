var productImg = $(".unit-img");
var productDesc = $(".unit-desc");
var amountToPass = document.getElementById('amount');

$(document).ready(function () {
	productImg.fadeIn("slow");
	productDesc.fadeIn("slow");
	amountToPass.value = 1;
});

var btns = document.getElementsByClassName('button-inc');

for (let btn of btns) {
	btn.addEventListener('click', updateAmount);
}

var availableAmount = parseInt(document.getElementById('unit-available').textContent.trim(), 10);

function updateAmount() {
	var num = parseInt(document.getElementById('amount-num').textContent.trim(), 10);
	this.value === "minus" ? num-- : num++;
	
	if(num < 1)
		num = 1;
	else if(num > availableAmount)
		num = availableAmount;
	
	document.getElementById('amount-num').textContent = num;

	amountToPass.value = num;
}

$(window).ready(resizingProduct);
$(window).resize(resizingProduct);

function resizingProduct() {
	var prodBox = $(".prod-box");
	var prodDescBox = $(".prod-desc-box");

	if ($(document).width() < 992) {
		prodBox.css("padding", "0");
		prodDescBox.css("height", "350px");
		prodDescBox.css("margin-bottom", "50px");
	} else {
		prodBox.css("padding", "5% 0");
		prodDescBox.css("height", "auto");
		prodDescBox.css("margin-bottom", "0");
	}
}

function imgError(image) {
	image.onerror = "";
	image.src = "/img/products/prod_not_fnd.jpg";
	return true;
}



