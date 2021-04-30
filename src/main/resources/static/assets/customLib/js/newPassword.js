user = (function () {
    "use strict";
    function _baseURL() {
        return ttplGlobal.baseUrl() + 'newPassword';
    }

    function savePassword() {
        $("#btnSave").on('click', function () {
            $('.globalForm').validate({
                submitHandler: function (form) {
                    $.ajax({
                        url: _baseURL() + "/savePassword",
                        type: 'POST',
                        data: $(form).serializeArray(),
                        success: function (res) {
                            if (res.status == 1) {
                                window.location.href= _baseURL();
                            } else {
                                swal({
                                    title: res.text,
                                    text: "Click OK to exit",
                                    type: "error"
                                }, function (e) {
                                });
                            }
                        }
                    });
                }
            });
        });
    }

    return {
        savePassword: savePassword
    }
})();

$(document).ready(function () {
    user.savePassword();
});
