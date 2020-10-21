<%--
  Created by IntelliJ IDEA.
  User: hanhnguyen
  Date: 10/21/20
  Time: 2:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
a<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Online Shopping Mall</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/main.css" />
    <script src="https://maps.googleapis.com/maps/api/js"></script>
    <script>

        var map;
        function initialize() {
            var mapOptions = {
                zoom: 18,
                center: {lat: 1.29726, lng: 103.85531}
            };
            map = new google.maps.Map(document.getElementById('map_canvas'),
                mapOptions);

            var marker = new google.maps.Marker({
                position: {lat: 1.29726, lng: 103.85531},
                map: map
            });

            var infowindow = new google.maps.InfoWindow({
                content: '<p>Marker Location:' + marker.getPosition() + '</p>'
            });

            google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map, marker);
            });
        }

        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>
<body>

<div class="container">

    <?php include 'header.php';?>

    <?php include 'navigation.php';?>

    <div class="content">

        <div class="helpframe">
            <div class="helpheader"><h2>Contact Us</h2></div>
            <div class="helpcontent">
                <p style="margin:0px;"> <img alt="" src="/eshop3/upload/help.jpg" width=850px height=90px margin=0/> </p>

                <p class="p0">
					<span style="font-size:12pt;font-family:'Arial';">
					We look forward to assisting you with any of your shopping queries. Our working hours are between 9:00&nbsp;Monday to 18:00 Friday (EST time).
					</span>
                </p>

                <div class="contactustab_div">
                    <table class="contactustab">
                        <tr>
                            <th width="30%">Email</th>
                            <th>Enquiry</th>
                        </tr>

                        <tr>
                            <td>hanhduy.nguyen@gmail.com</td>
                            <td>
                                <ul>
                                    <li>Promotion Enquiries</li>
                                    <li>Product Enquiries</li>
                                    <li>Shipping & Delivery Enquiries</li>
                                    <li>Cooperation Inquiry</li>
                                </ul>
                            </td>
                        </tr>
                    </table>
                </div>
                <br><hr>
                <b>Eshop Online shopping team</b> <br>

                45 Middle Road<br>
                Singapore 188954<br>
                <div id="map_canvas"></div>
                <section id="google-map"></section>
                <script>
                    $(document).ready(function($) {
                        $('#google-map').gMap({
                            address: '45 Middle Road, Singapore 188954',
                            zoom: 15,
                            markers: [{ 'address' : '45 Middle Road, Singapore 188954' }, ]

                        });
                    });
                </script>
            </div>
        </div>

    </div>
</div>
<?php include 'footer.html';?>
</body>
</html>
</body>
</html>
