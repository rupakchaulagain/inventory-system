$(document).ready(function () {

    getSupplierActiveDropdown();
    getProductTableAPI();
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

        },
        error: function (e) {

            console.log("ERROR : ", e);
            alert(JSON.stringify(e, null, 4));

        }
    });

}

function getProductTableAPI() {

    var search = {
        supplierName: ""
    }

    var page="1";
    var size="10";

    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/api/v1/product/search?page=" + page + "&size=" + size,
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            constructDataTable(data);

            console.log("SUCCESS : ", data);

            // alert(JSON.stringify(data, null, 4));

        },
        error: function (e) {


            console.log("ERROR : ", e);
            alert(JSON.stringify(e, null, 4));

        }
    });

}


    function constructDataTable(data) {

        $.each(data.responseDTOList, function (i, product) {

            var customerRow = '<tr>' +
                '<td>' + (++i) + '</td>' +
                '<td>' + product.productName + '</td>' +
                '<td>' + product.productCategory + '</td>' +
                '<td>' + product.productType + '</td>' +
                '<td>' + product.productQuantity + '</td>' +
                '<td>' + product.costPrice + '</td>' +
                '<td>' + product.sellingPrice + '</td>' +
                '<td>' + constructActionButton(product.id) + '</td>' +
                '</tr>';

            $('#productdata tbody').append(customerRow);

        });

    }

    function constructActionButton(id){

    return "   <div class=\"btn-group\">\n" +
        "                    <button type=\"button\" class=\"btn btn-default\">Action</button>\n" +
        "                    <button type=\"button\" class=\"btn btn-default dropdown-toggle dropdown-icon\" data-toggle=\"dropdown\">\n" +
        "                      <span class=\"sr-only\">Toggle Dropdown</span>\n" +
        "                      <div class=\"dropdown-menu\" role=\"menu\">\n" +
        "                        <a class=\"dropdown-item\" href=\"#\">Edit</a>\n" +
        "                        <a class=\"dropdown-item\" href=\"#\">Delete</a>\n" +
        "                    </button>\n" +
        "                  </div> ";


    }



$(document).ready(function () {
    $("#productSubmitBtn").click(function () {

        saveProduct();
    });
})

function saveProduct() {

    var product= getProductFormData();

    // alert("product api call-----"+JSON.stringify(product));

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

            console.log("SUCCESS : ", data);

            $("#tab_1").removeClass("active");  // this deactivates the home tab
            $("#tab_2").addClass("active");  // this activates the profile tab

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
    var data = decodeURIComponent($("#saveProductForm").serialize());
    var formData = data.split("&");
    var product={};

    for(var key in formData)
    {
        console.log(formData[key]);
        product[formData[key].split("=")[0]] = formData[key].split("=")[1];
    }

    return product;



}