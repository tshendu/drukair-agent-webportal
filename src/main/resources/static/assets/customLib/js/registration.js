user = (function () {
    "use strict";

    function _baseURL() {
        return ttplGlobal.baseUrl() + 'registration';
    }

    function getUser() {
        $.ajax({
            url: _baseURL() + "/getUser",
            type: "GET",
            success: function (res) {
                var data = res.dto;
                var customerRegistrationList = [
                    {
                        "mRender": function (data, type, row, meta) {
                            return meta.row + 1;
                        }
                    },
                    {"data": "username", "class": "username", "orderable": false},
                    {"data": "agentName", "class": "agentName", "orderable": true},
                    {
                        "data": "statusId", class: "status",
                        "mRender": function (data) {
                            var statusTag;
                            if (data == 1) {
                                statusTag = 'Active';
                            } else {
                                statusTag = 'Inactive';
                            }
                            return statusTag;
                        }
                    },
                    {
                        "class": "centerAlign",
                        defaultContent: '<a id="editBtn" class="btn btn-info btnEdit btn-grid">Edit</a>'
                    }
                ];
                if (res != null) {
                    $("#cRtable").dataTable({
                        "bFilter": true,
                        "data": data,
                        "columns": customerRegistrationList,
                        "bDestroy": true
                    })
                } else {
                    $("#cRtable").dataTable().fnClearTable();
                }
            }, error: function (errorThrown) {
            }
        })
    }


    function editUser() {
        $("#cRtable tbody").on('click', '.btnEdit', function () {
            var agentCode = $(this).closest('tr').find('.username').text();
            $.ajax({
                url: _baseURL() + "/editUser",
                type: "GET",
                data: {agentCode: agentCode},
                success: function (res) {
                    var data = res.dto;
                    populate(data);
                }
            });
        });
    }

    function saveUser() {
        $("#btnSave").on('click', function () {
            $('.globalForm').validate({
                submitHandler: function (form) {
                    $.ajax({
                        url: _baseURL() + "/saveUser",
                        type: 'POST',
                        data: $(form).serializeArray(),
                        success: function (res) {
                            if (res.status == 1) {
                                $('#registrationForm')[0].reset();
                                getUser();
                                swal({
                                    title: res.text,
                                    text: "Click OK to exit",
                                    type: "success"
                                }, function (e) {
                                });
                            } else {
                                swal({
                                    title: res.text,
                                    text: "Click OK to exit",
                                    type: "error"
                                }, function (e) {
                                    getUser();
                                });
                            }
                        }
                    });
                }
            });
        });
    }

    function populate(data) {
        for (var i in data) {
            if (typeof (data[i]) === 'object') {
                //populate(data[i]);
            } else {
                if (typeof data[i] == "string") {
                    var newData = data[i].replace("'", "\'");
                } else {
                    newData = data[i];
                }
                $(
                    "input[type='text'][name='" + i + "']," +
                    "input[type='hidden'][name='" + i + "'], " +
                    "input[type='checkbox'][name='" + i + "'], " +
                    "input[type='email'][name='" + i + "'], " +
                    "select[name='" + i + "'], textarea[name='" + i + "']"
                ).val(newData);
                if (typeof data[i] !== "string") {
                    $("input[type='radio'][name='" + i + "'][value='" + newData + "']").prop('checked', true);
                }
                if ($("input[name='" + i + "']").hasClass('datepicker')) {
                    $("input[name='" + i + "']").val($.datepicker.formatDate("dd-M-yy", new Date(newData)));
                }
            }
        }
        // $('form').find('input[type="checkbox"]').each(
        //     function () {
        //         if ($(this).siblings('input[type="hidden"]').val() == "true" ||
        //             $(this).siblings('input[type="hidden"]').val() == 1) {
        //             $(this).prop('checked', true);
        //         } else {
        //             $(this).prop('checked', false);
        //         }
        //     }
        // );
    }
    return {
        getUser: getUser,
        editUser: editUser,
        saveUser: saveUser
    }
})();
$(document).ready(function () {
    user.getUser();
    user.editUser();
    user.saveUser();
});