function Catalog() {
    // var base = this;
    // this.initCatalog();
    setTimeout(function () {
        //延迟加载css文件
        $("head").append($(" <link href='css/catalog.css' rel='stylesheet'/>"));
        //延迟绑定a标签的松开鼠标的动作
        $(".container a").mouseup(function () {
            $(this).attr("href", "/getContent?url=" + $(this).attr("href"));
        });
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

};
$(function () {
    new Catalog();
});