function BookShelf() {
    var base = this;
    //加载书架
    this.loadHtml("bookShelf");

    //绑定侧边栏的选项事件
    $("#wrapper li").click(function () {
        var cla = $(this).attr("class");
        eval("base." + cla + "('" + cla + "')");
    });

    //加载侧边栏,绑定侧边栏打开关闭事件
    var trigger = $('.hamburger'),
        overlay = $('.overlay'),
        isClosed = false;

    trigger.click(function () {
        isClosed = base.hamburger_cross(trigger, overlay, isClosed);
    });

    $('[data-toggle="offcanvas"]').click(function () {
        console.log("----");
        $('#wrapper').toggleClass('toggled');
    });
}

BookShelf.prototype = {
    hamburger_cross: function (trigger, overlay, isClosed) {
        if (isClosed) {
            overlay.hide();
            trigger.removeClass('is-open');
            trigger.addClass('is-closed');
            isClosed = false;
        } else {
            overlay.show();
            trigger.removeClass('is-closed');
            trigger.addClass('is-open');
            isClosed = true;
        }
        return isClosed;
    },
    user: function (name) {
        this.loadHtml(name);
        $(".tittle").show();
    },
    bookShelf: function (name) {
        this.loadHtml(name);
        $(".tittle").show();
    },
    search: function (name) {
        this.loadHtml(name);
        $(".tittle").hide();
    },
    signal: function (name) {

    },
    config: function (name) {

    },
    content: function () {

    },
    loadHtml: function (html) {
        $(".container .loadContent").load(html);
        $('[data-toggle="offcanvas"]').click();
    }
};
$(function () {
    new BookShelf();
});