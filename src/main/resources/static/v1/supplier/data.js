$(document).ready(function () {

    var searchKey = "Yamaha";
    var page = 1;
    var size = 10;

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

            // alert(JSON.stringify(data, null, 4));

        },
        error: function (e) {


            console.log("ERROR : ", e);
            alert(JSON.stringify(e, null, 4));

        }
    });


    function constructDataTable(data) {

        $.each(data.responseDTOList, function (i, supplier) {

            var customerRow = '<tr>' +
                '<td>' + supplier.supplierName + '</td>' +
                '<td>' + supplier.supplierAddress + '</td>' +
                '<td>' + supplier.supplierPanNumber + '</td>' +
                '<td>' + supplier.supplierPhoneNumber + '</td>' +
                '<td>' + "" + '</td>' +
                '</tr>';

            $('#supplier-data tbody').append(customerRow);

        });

    }


}
