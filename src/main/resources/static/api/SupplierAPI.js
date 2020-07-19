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

        },
        error: function (e) {

            console.log("ERROR : ", e);
            alert(JSON.stringify(e, null, 4));

        }
    });

}


$(document).ready(function () {
    $("#supplierSubmitBtn").click(function () {

        saveSupplier();
    });
})


function saveSupplier() {

    var supplier = getSupplierFormData();

    alert(JSON.stringify(supplier));

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/v1/supplier",
        data: JSON.stringify(supplier),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            alert(JSON.stringify(data));

            // var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
            //     + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";

            console.log("SUCCESS : ", data);

            $("#tab_1").removeClass("active");  // this deactivates the home tab
            $("#tab_2").addClass("active");  // this activates the profile tab


        },
        error: function (e) {


            console.log("ERROR : ", e);

            alert(JSON.stringify(e, null, 4));

        }
    });

}


function getSupplierFormData() {


    var data = decodeURIComponent($("#saveSupplierForm").serialize());
    var formData = data.split("&");
    var supplier = {};

    for (var key in formData) {
        console.log(formData[key]);
        supplier[formData[key].split("=")[0]] = formData[key].split("=")[1];
    }

    supplier["status"] = 'Y';

    return supplier;


}


$(document).ready(function () {

    var searchKey = "Yamaha";
    var page = 1;
    var size = 30;

    getSupplierTableAPI(page, size, searchKey);
})

function getSupplierTableAPI(page, size, searchKey) {

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

            constructDataTable(data);

            console.log("SUCCESS : ", data);

        },
        error: function (e) {


            console.log("ERROR : ", e);
            alert(JSON.stringify(e, null, 4));

        }
    });

}


function constructDataTable(data) {

    $.each(data.responseDTOList, function (i, supplier) {

        var customerRow = '<tr>' +
            '<td>' + (++i) + '</td>' +
            '<td>' + supplier.supplierName + '</td>' +
            '<td>' + supplier.supplierAddress + '</td>' +
            '<td>' + supplier.supplierPanNumber + '</td>' +
            '<td>' + supplier.supplierPhoneNumber + '</td>' +
            '<td>' + constructActionButton(supplier.id) + '</td>' +
            '</tr>';

        $('#supplier-data tbody').append(customerRow);

    });

}


function constructActionButton(id) {

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