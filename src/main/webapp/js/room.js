$(document).ready(function(){
    $("#submitroom").click(function (event){
        var roomNo = $("#roomno").val();
        var roomType = $("#roomtype").val();
        var roomPrice = $("#roomprice").val();
        var maxGuest = $("#maxguest").val();
        console.log("....: " + roomNo)
        $.post("RoomServlet", {
            "roomno": roomNo,
            "roomtype": roomType,
            "roomprice": roomPrice,
            "maxguest": maxGuest
        }).done(function(responseJson){
            var str = "<table>";
            $.each(responseJson, function(key, value){
                if(key == 0){
                    str += "<tr>";
                    str += "<th>" + "RoomNo" + "</th>"
                    str += "<th>" + "Type" + "</th>"
                    str += "<th>" + "Price" + "</th>"
                    str += "<th>" + "Max Guest" + "</th>"
                    str += "<th>" + "Max Guest" + "</th>"
                    str += "<th>" + "Action" + "</th>"
                    str += "</tr>";
                }

                str += "<tr>";
                str += "<td>" + value.roomNo + "</td>";
                str += "<td>" + value.type + "</td>";
                str += "<td>" + value.price + "</td>";
                str += "<td>" + value.guestNum + "</td>";
                str += "<td>" + "<a href='url'>" + "Delete" + "</a>" + "<a href='url'>" + "Delete" + "</a>" + "</td>";
                str += "</tr>";
            });
            // alert(str);
            $("#listroom").html(str);
        });
    });
})