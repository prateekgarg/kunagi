var kunagihp = {};

kunagihp.subscribe = function(baseUrl) {
    var email = prompt('Please enter your email for subscription');
    if (!email) return;
    window.location = baseUrl + email;
}

kunagihp.paypal = function() {
    var amount = $("#amountslider").slider("value");
    var tax = "0";
    var url = "https://www.paypal.com/cgi-bin/webscr/?cmd=_xclick"
    url += "&business=wi@koczewski.de";
    url += "&currency_code=EUR"
    url += "&amount="+amount;
    url += "&tax="+tax;
    url += "&item_name=Kunagi";
    url += "&no_note=0";
    url += "&no_shipping=1";
    url += "&image_url=" + encodeURIComponent("http://kunagi.org/img/kunagi.png");
    url += "&return=" + encodeURIComponent("http://kunagi.org/download-file.html");
    url += "&cancel_return=" + encodeURIComponent("http://kunagi.org/payment.html");
    window.location = url;
}

$(function() {
    $("#amountslider").slider({
        value: 10,
        min: 5,
        max: 90,
        step: 5,
        slide: function(event, ui) {
            $("#amount").val(ui.value + " EUR");
        }
    });
    $("#amount").val($("#amountslider").slider("value") + " EUR");
});
