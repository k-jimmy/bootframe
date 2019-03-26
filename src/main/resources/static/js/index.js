function Index() {
    var base = this;
    $(".container .btn-primary").hide();
    //绑定回车
    $(document).keydown(function (event) {
        if (event.keyCode === 13) {
            $(".container .btn-danger").click();
        }
    });
    //绑定搜索事件
    $(".container .btn-danger").click(function () {
        var category = "novels";
        var value = $(".container .form-control").val();
        base.search(category, value);
    })

    //切换搜索类型
    $(".nav-pills li").click(function () {
        $(".nav-pills li").each(function () {
            $(this).removeClass("active");
        });
        $(this).addClass("active");
    });
    $(".container").on("click", " h4", function() {
        base.toCatalog(this);
    })
    $(".container").on("click", " span", function() {
        base.newContent(this);
    })
}

Index.prototype = {
    search: function (category, value) {
        var data = {};
        data.url = "http://localhost:8080/v1/" + category + "/" + value + "/10";
        $.get("/searchBook", data, function (r) {
            console.log(r);
            if (r.info) {
                $(".container #searchList div").empty();
                Object.keys(r.info).forEach(function (key) {
                    var book = r.info[key];
                    console.log(book);
                    if (book) {
                        var a = "<div class=\"row\">\n" +
                            "<div class=\"col-sm-2 col-md-2\">\n" +
                            "                    <div class=\"thumbnail\">\n" +
                            "                        <img src=\"" + book.novel_cover + "\"\n" +
                            "                             alt=\"通用的占位符缩略图\">\n" +
                            "                    </div>\n" +
                            "                </div>\n" +
                            "                <div class=\"col-sm-10 col-md-10\">\n" +
                            "                    <div class=\"thumbnail\">\n" +
                            "                        <div class=\"caption\">\n" +
                            "                            <h4 class=\"text-primary\" data-url='https://www.bqg99.cc/book/2639610/'>" + book.novel_name + "</h4>" +
                            "                               <span><small> " + book.novel_author + "</small></span>" +
                            "                               <span><small> " + book.novel_type + "</small></span>" +
                            "                               <span class=\"text-primary\" data-url='https://www.bqg99.cc/book/2639610/554231232.html'><small>最新章节：" + book.novel_latest_chapter_name + "</small></span>\n" +
                            "                            <p><small>引言：" + book.novel_abstract + "</small></p>\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                </div>\n" +
                            "                </div>";
                        $(".container #searchList").append(a);
                    }
                });
            }
            var cla = $(".container #searchList").attr("class");
            if (cla === "collapse") {
                console.log(cla);
                $(".container .btn-primary").click();
            }
        });
    },

    toCatalog: function (index) {
        var data = {};
        data.url = $(index).attr("data-url");
        $.get("/getCatalog", data, function (r) {

        });
    },
    newContent: function (index) {
        var data = {};
        data.url = $(index).attr("data-url");
        $.get("/getContent", data, function (r) {

        });
    },

};
$(function () {
    new Index();
});