var productData = $(".cat-data");
var productImg = $(".cat-img");
var productNotFound = $("#prod-nf");

$(document).ready(function () {
	productData.fadeIn("slow");
	productImg.css("transition-duration", "0.6s");

	productNotFound.fadeIn("slow");
});

productData.mouseover(function () {
	$(this).find(".cat-img").css("filter", "grayscale(100%)")
});

productData.mouseout(function () {
	$(this).find(".cat-img").css("filter", "grayscale(0%)")
});

function imgError(image) {
	image.onerror = "";
	image.src = "/img/categories/cat_not_fnd.jpg";
	return true;
}




