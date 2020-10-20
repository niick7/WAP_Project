$(document).ready(function(){
    $("submitroom").click(function (event){
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
                str += "<tr>";
                    str += "<td>" + value + "</td>";
                str += "</tr>";
            });
            $("listroom").html(str);
        });
    });
})