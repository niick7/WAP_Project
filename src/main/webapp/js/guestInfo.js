$(document).ready(function() {
    $("#btnInsertGuest").click(insertGuest);
});

function insertGuest() {


    var firstname=$("#guestfirstname").val();
    var lastname=$("#guestlastname").val();
    var address = $("#guestaddress").val();
    var guestid = $("#guestid").val();
    var dob = "hanh";


   // alert(firstname +" " +lastname +" " + address +" "+ guestid +" "+ dob);
    $.ajax("GuestServlet.ajax", {
        type: "post",
        data: {
            firstname: firstname,
            lastname: lastname,
            dob: dob,
            guestid: guestid,
            address: address,
        }
    }).done(displayGuestInfo);
}


function displayGuestInfo(response) {

    $.each (response, function (key, value) {
        $("#guestdisplay").html.appendTo(str);
    });

}