$(document).ready(function() {
    $("#btnGuestReport").click(getNewGuest30Days);
});

function getNewGuest30Days(event) {
    event.preventDefault();
    var from =$("#from").val();
    var to =$("#to").val();
    $.ajax("GuestReportServlet.ajax", {
        type: "post",
        data: {
            from:from,
            to:to
        }
    }).done(displayGuestReportInfo);
}

function displayGuestReportInfo(response) {

    const body = $("tbody");
    body.empty();
   $.each (response, function (key, value) {

        let tr =
            "<tr>" +
            "<td>" + value.id + "</td>" +
            "<td>" + value.firstName + "</td>" +
            "<td>" + value.lastName + "</td>" +
           "<td>" + value.dob.month +"-" + value.dob.day +"-"+value.dob.year + "</td>" +
            "<td>" + value.gender + "</td>" +
            "<td>" + value.address + "</td>" +
            "<td>" + value.createdDate.month +"-" + value.createdDate.day +"-"+value.createdDate.year + "</td>" +

            "</tr>";
        console.log(tr);
        body.append(tr);
    });


}

