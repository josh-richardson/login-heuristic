/**
 * Created by joshua on 11/03/17.
 */

function fingerprintBrowser() {
    var offset = new Date().getTimezoneOffset();
    new Fingerprint2().get(function (result, components) {
        console.log(result); //a hash, representing your device fingerprint
        console.log(components); // an array of FP components
    });

}