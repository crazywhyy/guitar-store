$(document).ready(function () {
    // $('.close').click(function (e) {
    //     $(".more-info").css({ "witdh": "0%" });
    // });
    // var count = 0;
    $(".click-info").click(function (e) {
        e.preventDefault();
        $(".more-info").css("width", "100%");
    });
    $(".close").click(function (e) {
        e.preventDefault();
        $(".more-info").css("width", "0%");
        $(".info-pay").css("left", "-100%");
    });
    $(".intro .cart").click(function (e) {
        e.preventDefault();
        $(".cart-pop-up").css("right", "0%");
        // var count = $("#cartCount").val();
        // alert(count);
    });
    $(".thanhtoan").click(function (e) {
        e.preventDefault();
        $(".info-pay").css("left", "0%");
    });
});