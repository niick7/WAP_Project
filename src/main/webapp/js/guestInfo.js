$(document).ready(function() {
    $("#btnInsertGuest").click(insertGuest);
    $("#btnDeleteGuest").click(deleteGuest);

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


function deleteGuest() {
   // alert ("Home");
    var guestid = $("#guestid").val();


    //  alert(firstname +" " +lastname +" " + address +" "+ guestid +" "+ dob + " "+ gender);
    $.ajax("GuestDeleteServlet.ajax", {
        type: "post",
        data: {
            guestid: guestid
        }
    }).done(displayGuestInfo);
}


function displayGuestInfo(response) {
    // const ul = $('ul#guests');
    // ul.find("li").remove();
    const body = $("tbody");
    body.empty();

    if(response == "userexists") {

        $(".msg").html("Guest is already exists");

    }


    $.each (response, function (key, value) {
       //ul.append("<li>" + value.firstName + "</li>");
       //  ul.append( value.firstName  );
        let tr =
            "<tr>" +
                "<td>" + value.id + "</td>" +
                "<td>" + value.firstName + "</td>" +
                "<td>" + value.lastName + "</td>" +
         //       "<td>" + value.dob.month +"-" + value.dob.day +"-"+value.dob.year + "</td>" +
                 "<td>" + value.gender + "</td>" +
                "<td>" + value.address + "</td>" +
            "</tr>";
        body.append(tr);
    });
    // ul.append("</table>");
    // $("#guestdisplay").html(str);

}