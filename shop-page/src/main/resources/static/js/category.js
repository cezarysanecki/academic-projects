var productData = $(".prod-data");
var productImg = $(".prod-img");
var productNotFound = $("#prod-nf");

$(document).ready(function () {
	productData.fadeIn("slow");
	productImg.css("transition-duration", "0.6s");

	productNotFound.fadeIn("slow");
});

productData.mouseover(function () {
	$(this).find(".prod-img").css("filter", "grayscale(100%)")
});

productData.mouseout(function () {
	$(this).find(".prod-img").css("filter", "grayscale(0%)")
});

function imgError(image) {
	image.onerror = "";
	image.src = "/img/products/prod_not_fnd.jpg";
	return true;
}


