dashboard = (function () {
    "use strict";

    function baseURL() {
        return ttplGlobal.baseUrl() + 'dashboard';
    }

    function getCustomerDetails() {
        $("#generateBtn").on('click', function () {
            var agentCode = $('#agentCode').val();
            var startDate = $('#startDate').val();

            var endDate = $('#endDate').val();
            let isChecked = $('#specialGL').is(":checked");
            let specialGL = 0;
            if (isChecked) {
                specialGL = 1;
            }

            // var specialGL = $('#specialGL').val();

            if (startDate !== "" && endDate !== "") {
                $.ajax({
                    url: baseURL() + "/getCustomerDetails",
                    type: 'GET',
                    data: {
                        agentCode: agentCode,
                        startDate: startDate,
                        endDate: endDate,
                        specialGL: specialGL
                    },
                    success: function (res) {
                        if (res.status === 1) {
                            var data = res.dto;
                            var dat = data.userData;
                            // var url= "data:application/pdf;base64,"+dat;
                            // var pdfWindow = window.open(url);


                            var byteCharacters = atob(dat);
                            var byteNumbers = new Array(byteCharacters.length);
                            for (var i = 0; i < byteCharacters.length; i++) {
                                byteNumbers[i] = byteCharacters.charCodeAt(i);
                            }
                            var byteArray = new Uint8Array(byteNumbers);
                            var file = new Blob([byteArray], {type: 'application/pdf;base64'});
                            var fileURL = URL.createObjectURL(file);
                            window.open(fileURL);

                            // pdfWindow.document.write("<html><head><title>Customers Outstanding Detailed</title></head><body> " +
                            //     "<iframe width='100%' height='100%' src='data:application/pdf;base64, " +
                            //     encodeURI(dat) + "'></iframe></body></html>"
                            // )

                            //this trick will generate a temp <a /> tag
//                             var link = document.createElement("a");
//                             link.href = "data:application/pdf;base64,"+dat+"";
//
// //Set properties as you wise
//                             link.download = "CustomersOutstanding";
//                             link.target = "blank";
//
// //this part will append the anchor tag and remove it after automatic click
//                             document.body.appendChild(link);
//                             link.click();
//                             document.body.removeChild(link);
                            // pdfWindow.document.write("<a href='data:application/pdf;base64, " +
                            // encodeURI(dat) + "' download='agent.pdf' id='df'>dfd</a>")
                            // $("#df").click();
                        } else {
                            swal({
                                title: res.text,
                                text: "Click OK to exit",
                                type: "warning"
                            }, function (e) {
                                location.reload();
                            });
                        }
                    }
                });
            }
        });
    }

    return {
        getCustomerDetails: getCustomerDetails
    }
})();
$(document).ready(function () {
    dashboard.getCustomerDetails();

    var minOffset = 0,
        maxOffset = 20;

    var thisYear = new Date().getFullYear();
    var select = $('#year');

    for (var i = minOffset; i <= maxOffset; i++) {
        var year = thisYear - i;
        $('<option>', {value: year, text: year}).appendTo(select);
    }
});