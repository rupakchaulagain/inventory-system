function getSupplierDropdown(page, size, searchKey) {

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

$(document).ready(function () {
    $("#productSubmitBtn").click(function () {

        saveProduct();
    });
})

function saveProduct() {

    var product= getProductFormData();

    alert("product api call-----")

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/v1/product",
        data: JSON.stringify(product),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#supplier-data').html(json);

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
function getProductFormData(){
    var data = $("#saveProductForm").serialize();
    alert("date="+data);

    var formData = data.split("&");
    var obj={};
    for(var key in formData)
    {
        console.log(formData[key]);
        obj[formData[key].split("=")[0]] = formData[key].split("=")[1];
    }

    alert(JSON.stringify(obj));

    // var jsonString = JSON.stringify(data);
    // alert("jsonString="+jsonString);

    return obj;



}