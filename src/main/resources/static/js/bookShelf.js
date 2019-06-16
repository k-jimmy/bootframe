function BookShelf() {
    var base = this;
    // setTimeout(function () {
    //     var book = $(".container .form-control").val();
    //     if (book) {
    //         $(".container .btn-danger").click();
    //     }
    // }, 1);
    // $(".container .btn-primary").hide();
    // //绑定回车
    // $(document).keydown(function (event) {
    //     if (event.keyCode === 13) {
    //         $(".container .btn-danger").click();
    //     }
    // });
    // //绑定搜索事件
    // $(".container .btn-danger").click(function () {
    //     var category = "novels";
    //     var value = $(".container .form-control").val();
    //     base.search(category, value);
    // })
    //
    // //切换搜索类型
    // $(".nav-pills li").click(function () {
    //     $(".nav-pills li").each(function () {
    //         $(this).removeClass("active");
    //     });
    //     $(this).addClass("active");
    // });
    // $(document).ready(function () {
        var trigger = $('.hamburger'),
            overlay = $('.overlay'),
            isClosed = false;

        trigger.click(function () {
            hamburger_cross();
        });

        function hamburger_cross() {

            if (isClosed == true) {
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
        }

        $('[data-toggle="offcanvas"]').click(function () {
            $('#wrapper').toggleClass('toggled');
        });
    // });
}

BookShelf.prototype = {

};
$(function () {
    new BookShelf();
});