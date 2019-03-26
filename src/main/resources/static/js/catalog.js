function Catalog() {
    // var base = this;
    this.initCatalog();
    setTimeout(function () {
        $("head").append($(" <link href='css/catalog.css' rel='stylesheet'/>"));
    }, 1);
}

Catalog.prototype = {
    initCatalog: function () {
        var url = "/getCatalog";
        var data = {};
        // data.url=
        $.get(url, data, function () {

        });
    },
    // loadCss: function () {
    //     console.log("----");
    //     // $("head").append($("<link rel='stylesheet' href='"+src+"' type='text/css' media='screen' />"));
    //     $("head").append($(" <link href='css/catalog.css' rel='stylesheet'/>"));
    // }

};
$(function () {
    new Catalog();
});