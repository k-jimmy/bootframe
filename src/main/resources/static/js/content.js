function Content() {
    var base = this;
    //右侧上下监听
    $(".content-move>div").click(this.move);
    //上一章下一章监听
    $(".content-pre").on("click", " span", function () {
        base.getContent(this);
        base.move(this);
    });
    //方向键监听
    $(document).keydown(function (event) {
        var keyNum = event.which;
        switch (keyNum) {
            case 37:
                $(".content-pre span:first").click();
                break;
            case 39:
                $(".content-pre span:last").click();
                break;
            case 13:
                base.toIndex();
        }
    });
    //左侧边栏监听

}

Content.prototype = {
    timer: null,
    getContent: function (index) {
        var url = "/getContent";
        var data = {};
        data.url = $(index).attr("data-url");
        $.post(url, data, function (r) {
            $(".content-title .title").text(r.title);
            $(".content-book").html(r.content);
            $(".content-pre span:first").attr("data-url", r.pre);
            $(".content-pre span:last").attr("data-url", r.next);
        });
    },
    move: function (index) {
        cancelAnimationFrame(this.timer);
        var startTime = new Date();
        var b = document.body.scrollTop || document.documentElement.scrollTop;
        var d = 500;
        var c;
        var cla = $(this).attr("class");
        if (!cla) {
            cla = $(index).attr("class");
        }
        if (cla === "move-up") {
            c = b
        } else {
            c = document.documentElement.scrollHeight;
        }
        this.timer = requestAnimationFrame(function func() {
            var t = d - Math.max(0, startTime - (+new Date()) + d);
            if (cla === "move-up") {
                document.documentElement.scrollTop = document.body.scrollTop = t * (-c) / d + b;
            } else {
                document.documentElement.scrollTop = document.body.scrollTop = t * (c) / d;
            }
            this.timer = requestAnimationFrame(func);
            if (t === d) {
                cancelAnimationFrame(this.timer);
            }
        });
    },
    toIndex: function () {
        var bookName = $(".search-input").val();
        location.href = "http://localhost:8082/?bookName=" + bookName;
    }

};
$(function () {
    new Content();
});