function Index() {
    var base = this;
    $(".container .btn-primary").hide();
    $(document).keydown(function (event) {
        if (event.keyCode === 13) {
            $(".container .btn-danger").click();
        }
    });

    $(".container .btn-danger").click(function () {
        var value = $(".container .form-control").val();
        base.search(value);
    })
}

Index.prototype = {
    search: function (value) {
        // $.post("http://localhost:8080/v1/novels/牧神记/10", {}, function(r) {
        //     console.log(r);
        // }, "json");
        // $.get("http://localhost:8080/v1/novels/牧神记/10",function(data,status){
        //     alert("Data: " + data + "\nStatus: " + status);
        // });
        //  location.href=("http://localhost:8080/v1/novels/牧神记/10");
        // console.log(book);
        $.ajax({
            method: 'GET',
            url: 'http://localhost:8080/v1/novels/牧神记/10',
            headers:{'Content-Type': 'application/json',
                "Access-Control-Allow-Origin": "*",
                'Accept': 'application/json'}
        }).then(function successCallback(response) {
            // $scope.aStringOutput = response.data;
            console.log(response.data);
            console.log("--------1");
        }, function errorCallback(response) {
            // 请求失败执行代码
            console.log("--------2");
        });
    }

};
$(function () {
    new Index();
});