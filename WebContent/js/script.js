
//count trong cart 
var count_car = document.getElementById("cartCount").innerHTML;
var count_car = Number(count_car);
// onclick class="cart" --> id="cartCount" ++;
var cart = document.getElementsByClassName("cart");
for (var i = 0; i < cart.length; i++) {
    cart[i].onclick = function () {
        // alert("yhanh");
        count_car = count_car + 1;
        // return false để khỏi reload trang
        document.getElementById("cartCount").innerHTML = count_car;
        document.getElementById("cart-nav").innerHTML = count_car;
        document.getElementById("cart-nav2").innerHTML = count_car;
        return false
    };
}
//tang-cart
// document.getElementById("tang-cart").onclick = function () {
//     alert("t");
// }
// count cart
// var int_val = document.getElementById("count-cart").value;
// // var int_val = Number(int_val);
// var tang_cart = document.getElementById("tang-cart");
// document.getElementById("tang-cart").onclick = function () {
//     document.getElementById("count-cart").value = Number(int_val) + 1;
// }


// var items = document.querySelectorAll(".table-item .info"),// lấy tất cả NoteList trong thể tìm được
//     tab = [], index;
// for (var i = 0; i < items.length; i++) {
//     tab.push(items[i].innerHTML);
// }


// document.getElementsByClassName("btn-delete")[0].onclick = function () {

// }
