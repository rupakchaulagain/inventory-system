$(document).ready(function () {
    $("#productCategorySubmitBtn").click(function (e) {
        e.preventDefault();
        saveProductCategory();
    });
})

function saveProductCategory() {

    var productCategory = getProductCategoryFormData();

    // alert("product api call-----"+JSON.stringify(product));

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/v1/product-category",
        data: JSON.stringify(productCategory),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";

            console.log("SUCCESS : ", data);

            alertSuccessMessage();


            $("#tab_1").removeClass("active");  // this deactivates the home tab
            $("#tab_2").addClass("active");  // this activates the profile tab

        },
        error: function (e) {


            console.log("ERROR : ", e);

            alert(JSON.stringify(e, null, 4));

        }
    });

}

function getProductCategoryFormData() {
    var data = decodeURIComponent($("#saveProductCategoryForm").serialize());
    var formData = data.split("&");
    var product = {};

    for (var key in formData) {
        console.log(formData[key]);
        product[formData[key].split("=")[0]] = formData[key].split("=")[1];
    }


    product['status'] = 'Y';

    return product;


}

function alertSuccessMessage() {

    alert("suceess logic----");

    return "<div class=\"alert alert-success alert-dismissible\">\n" +
        "                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n" +
        "                    <h5><i class=\"icon fas fa-check\"></i> Alert!</h5>\n" +
        "                    Product Category is added Succesfully...\n" +
        "                </div>";

}


function alertFailureMessage() {

    return "<div class=\"alert alert-success alert-dismissible\">\n" +
        "                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n" +
        "                    <h5><i class=\"icon fas fa-check\"></i> Alert!</h5>\n" +
        "                    Product Category is added Succesfully...\n" +
        "                </div>";

}
