$(document).ready(function () {
    $("#button").click(function () {

        // var searchKey = document.getElementById('searchKey').value;
        var page = 1;
        var size = 10;

        getSupplierAPI(page, size, searchKey);
    });
})

function getSupplierAPI(page, size, searchKey) {

    var search = {
        supplierName: ""
    }

    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/api/v1/supplier/search?page=" + page + "&size=" + size,
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#supplier-data').html(json);

            console.log("SUCCESS : ", data);

            alert(JSON.stringify(data, null, 4));

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