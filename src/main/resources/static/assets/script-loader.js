$(document).ready(function () {

    if (document.URL.search("/registration") > 1)
        scriptLoader("assets/customLib/js/registration.js");

    if (document.URL.search("/changePassword") > 1)
        scriptLoader("assets/customLib/js/changePassword.js");

    if (document.URL.search("/newPassword") > 1)
        scriptLoader("assets/customLib/js/newPassword.js");

    if (document.URL.search("/dashboard") > 1) {
        scriptLoader("assets/customLib/js/dashboard.js");
    }

});

var scriptLoader = function (url) {
    $.ajax({
        type: "GET",
        url: url,
        dataType: "script",
        cache: false
    });
};