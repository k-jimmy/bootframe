function Search() {
    var base = this;
    //绑定搜索事件
    $(".search .search-search").click(function () {
        var value = $(".search .search-val").val();
        base.search(value);
    });
    $(".search .search-callback").click(function () {
        $("#wrapper .bookShelf").click();
    });
    $(".search #searchList").on("click"," .row",function () {
        var novel_img = $(this).find("img").attr("src");
        var novel_name = $(this).find(".bookName span").text();
        var novel_author = $(this).find(".bookAuthor span").text();

    })

}

Search.prototype = {
    searchNovelDetail: function (novel_img,novel_name,novel_author) {
        var data = {};
    },
    search: function (value) {
        var data = {};
        data.url = "http://localhost:8082/novelName?novelName=" +value;
        $.get("/searchBook", data, function (r) {
                console.log(r);
            if (r) {
                $("#search-content #searchList").empty();
                Object.keys(r).forEach(function (key) {
                    var book = r[key];
                    if (book) {
                        var b = "<div class='row'><div class=\"col-xs-2 col-md-2\">\n" +
                            "        <img src=\"" + book.novel_img + "\"\n" +
                            "             onerror=\"this.src='image/none-book.jpg'\">\n" +
                            "    </div>\n" +
                            "    <div class=\"col-xs-10 col-md-10 content\">\n" +
                            "        <div class=\"col-xs-12 col-md-12 bookName\">\n" +
                            "            <span>"+ book.novel_name +"</span>\n" +
                            "        </div>\n" +
                            "        <div class=\"col-xs-12 col-md-12 bookAuthor\">\n" +
                            "            <span>"+ book.novel_author +"</span>\n" +
                            "        </div>\n" +
                            "        <div class=\"col-xs-12 col-md-12 star\">\n" +
                            "            <span\>" + book.novel_intro + "\"</span>\n" +
                            "        </div>\n" +
                            "    </div></div>";
                        $("#search-content #searchList").append(b);
                    }
                });
            }
            var cla = $(".search #searchList").attr("class");
            if (cla === "collapse") {
                console.log(cla);
                $(".search .btn-primary").click();
            }
        },"json");
    }
};
$(function () {
    new Search();
});