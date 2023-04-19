$(window).ready(navbarMedium);
$(window).resize(navbarMedium);

function navbarMedium() {
    var navbar = $(".navbar-nav");

    if ($(document).width() < 992) {
        navbar.css("display", "inline-block");
        $("#navbar-second").insertBefore("#navbar-login");
        $("#navbar-second").css("margin-right", "0");
        $("#navbar-login").css("margin-top", "1.15em");
        $("#navbar-first").css("margin-left", "50px");
        $("#navbar-login").css("display", "flex");
        $("#navbar-login").css("margin-right", "0");
        $(".navbar-user").css("display", "flex");

        if ($(document).width() < 785) {
            $("li.nav-item").css("float", "left");
            $(".navbar-collapse").css("border", "none");
            $("#navbar-login").css("display", "inline-flex");
            $("#navbar-login").css("vertical-align", "top");
            $("#navbar-login").css("margin-top", "1.3em");
            $("#navbar-first").css("margin-left", "0");
            $(".navbar-user").css("display", "inline");
        }
    } else {
        navbar.css("display", "flex");
        $("#navbar-second").insertAfter("#navbar-login");
        $("#navbar-login").css("margin-top", "0");
    }
}