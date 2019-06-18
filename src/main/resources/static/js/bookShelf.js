function BookShelf() {
    var base = this;
    $("#wrapper li").click(function () {
        var cla = $(this).attr("class");
        eval("base." + cla + "()");
    });
    $("#wrapper .container .book .content").click(function () {
        
    });






    // var trigger = $('.hamburger'),
    //     overlay = $('.overlay'),
    //     isClosed = false;
    //
    // trigger.click(function () {
    //     hamburger_cross();
    // });
    //
    // function hamburger_cross() {
    //     if (isClosed == true) {
    //         overlay.hide();
    //         trigger.removeClass('is-open');
    //         trigger.addClass('is-closed');
    //         isClosed = false;
    //     } else {
    //         overlay.show();
    //         trigger.removeClass('is-closed');
    //         trigger.addClass('is-open');
    //         isClosed = true;
    //     }
    // }
    //
    // $('[data-toggle="offcanvas"]').click(function () {
    //     $('#wrapper').toggleClass('toggled');
    // });
}

BookShelf.prototype = {
    user: function () {
        console.log("user");
    },
    bookShelf:function () {
        console.log("bookShelf");
    },
    search:function () {
        
    },
    signal:function () {
        
    },
    config:function () {
        
    },
    content:function () {
        
    }
};
$(function () {
    new BookShelf();
});