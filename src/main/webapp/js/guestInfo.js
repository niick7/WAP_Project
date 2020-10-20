$(document).ready(function() {
    $("#btnInsertGuest").click(insertGuest);
});

function insertGuest() {

    var guestid = $("#guestid").val();
    var firstname=$("#guestfirstname").val();
    var lastname=$("#guestlastname").val();
    var address = $("#guestaddress").val();
    var guestid = $("#guestid").val();
    var dob =$("#dob").val();
    var gender = $("#gender").val();


  //  alert(firstname +" " +lastname +" " + address +" "+ guestid +" "+ dob + " "+ gender);
    $.ajax("GuestServlet.ajax", {
        type: "post",
        data: {
            firstname: firstname,
            lastname: lastname,
            dob: dob,
            guestid: guestid,
            address: address,
            gender: gender
        }
    }).done(displayGuestInfo);
}


function displayGuestInfo(response) {
    // const ul = $('ul#guests');
    // ul.find("li").remove();
    const body = $("tbody");
    body.empty();

    $.each (response, function (key, value) {
       //ul.append("<li>" + value.firstName + "</li>");
       //  ul.append( value.firstName  );
        let tr =
            "<tr>" +
                "<td>" + value.id + "</td>" +
                "<td>" + value.firstName + "</td>" +
                "<td>" + value.lastName + "</td>" +
                "<td>" + value.dob + "</td>" +
                 "<td>" + value.gender + "</td>" +
                "<td>" + value.address + "</td>" +
            "</tr>";
        // tr.append("<td>" + value.firstName + "</td>");
        // tr.append("<td>" + value.lastName + "</td>");
        body.append(tr);
    });
    // ul.append("</table>");
    // $("#guestdisplay").html(str);

}