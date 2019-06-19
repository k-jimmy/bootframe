function Search() {
    var base = this;
    //绑定搜索事件
    $(".search .search-search").click(function () {
        var category = "novels";
        var value = $(".search .search-val").val();
        base.search(category, value);
    });
}

Search.prototype = {
    search: function (category, value) {
        var data = {};
        data.url = "http://localhost:8080/v1/" + category + "/" + value + "/10";
        $.get("/searchBook", data, function (r) {
            if (r.info) {
                $("#search-content #searchList div").empty();
                Object.keys(r.info).forEach(function (key) {
                    var book = r.info[key];
                    console.log(book);
                    if (book) {
                        var b = "<div class=\"col-xs-2 col-md-2\">\n" +
                            "        <img src=\"" + book.novel_cover + "\"\n" +
                            "             alt=\"通用的占位符缩略图\">\n" +
                            "    </div>\n" +
                            "    <div class=\"col-xs-10 col-md-10 content\">\n" +
                            "        <div class=\"col-xs-12 col-md-12 bookName\">\n" +
                            "            <span>"+ book.novel_name +"</span>\n" +
                            "        </div>\n" +
                            "        <div class=\"col-xs-12 col-md-12 bookAuthor\">\n" +
                            "            <span>"+ book.novel_author +"</span>\n" +
                            "        </div>\n" +
                            "        <div class=\"col-xs-12 col-md-12 star\">\n" +
                            "            <span\>" + book.novel_abstract + "\"</span>\n" +
                            "        </div>\n" +
                            "    </div>";
                        // var a = "<div class=\"row\">\n" +
                        //     "<div class=\"col-xs-2 col-md-2\">\n" +
                        //     "                    <div class=\"thumbnail\">\n" +
                        //     "                        <img src=\"" + book.novel_cover + "\"\n" +
                        //     "                             alt=\"通用的占位符缩略图\">\n" +
                        //     "                    </div>\n" +
                        //     "                </div>\n" +
                        //     "                <div class=\"col-xs-10 col-md-10\">\n" +
                        //     "                    <div class=\"thumbnail\">\n" +
                        //     "                        <div class=\"caption\">\n" +
                        //     "                            <a href='/getCatalog?url=" + book.novel_url + "'><h4 class=\"text-primary\" >" + book.novel_name + "</h4></a>" +
                        //     "                               <span><small> " + book.novel_author + "</small></span>" +
                        //     "                               <span><small> " + book.novel_type + "</small></span>" +
                        //     "                             <a href='/getContent?url=" + book.novel_latest_chapter_url + "'>  <span class=\"text-primary\"><small>最新章节：" + book.novel_latest_chapter_name + "</small></span></a>\n" +
                        //     "                            <p><small>引言：" + book.novel_abstract + "</small></p>\n" +
                        //     "                        </div>\n" +
                        //     "                    </div>\n" +
                        //     "                </div>\n" +
                        //     "                </div>";
                        $("#search-content #searchList").append(b);
                    }
                });
            }
            var cla = $(".search #searchList").attr("class");
            if (cla === "collapse") {
                console.log(cla);
                $(".search .btn-primary").click();
            }
        });
    }
};
$(function () {
    new Search();
});