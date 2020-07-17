$(document).ready(function () {

    getSupplierActiveDropdown();
})


function getSupplierActiveDropdown() {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/api/v1/supplier/active/min",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var s = '<option value="-1">Please Select a Supplier</option>';

            data.forEach(function (d) {

                s += '<option value="' + d.value + '">' + d.label + '</option>';

            })

            $("#supplier-dropdown").html(s);

            console.log("SUCCESS : ", data);

            // alert(JSON.stringify(data, null, 4));

        },
        error: function (e) {


            console.log("ERROR : ", e);


            // var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
            //     + e.responseText + "&lt;/pre&gt;";
            // $('#feedback').html(json);
            //
            // console.log("ERROR : ", e);
            // $("#btn-search").prop("disabled", false);

            alert(JSON.stringify(e, null, 4));

        }
    });


}