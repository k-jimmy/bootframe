function Catalog() {
    this.initCatalog();
}

Catalog.prototype = {
    initCatalog: function () {
        var url = "/getCatalog";
        var data = {};
        // data.url=
        $.get(url, data, function () {

        });
    }

};
$(function () {
    new Catalog();
});