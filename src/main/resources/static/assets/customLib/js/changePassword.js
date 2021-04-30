user = (function () {
    "use strict";
    // let form = $('#scheduleTimingFormId');
    // let isSubmitted = false;

    function _baseURL() {
        return ttplGlobal.baseUrl()+'changePassword';
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
                                $('#changePasswordForm')[0].reset();
                                // alert(res.text);
                                swal({
                                    title: res.text,
                                    text: "Click OK to exit",
                                    type: "success"
                                }, function (e) {
                                    // location.reload();
                                });


                            } else {
                                swal({
                                    title: res.text,
                                    text: "Click OK to exit",
                                    type: "error"
                                }, function (e) {
                                    // location.reload();
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
