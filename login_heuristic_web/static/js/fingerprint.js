/**
 * Created by joshua on 11/03/17.
 */

var keyEvents = [];
var mouseMove = [];

setTimeout(function () {

    $.get("/requestid/", function (data) {
        var reqId = data;
        new Fingerprint2().get(function (result, components) {
            // console.log(result); //a hash, representing your device fingerprint
            // console.log(components); // an array of FP components
            // console.log(keyEvents);
            // console.log(mouseMove);

            $.ajax({
                type: "POST",
                url: "/loginreq/",
                data: JSON.stringify({"requestid": reqId, "components": components,
                    "keyEvents": keyEvents,
                    "mouseEvents": mouseMove}),
                success: function () {
                    console.log("Success");
                }
            });
        });
    });


}, 5000);

$(document).on('keypress', function (e) {
    keyEvents.push(e.timeStamp);
});

$(document).mousemove(function (event) {
    mouseMove.push(event.screenX + ", " + event.screenY + ", " + event.timeStamp);
});