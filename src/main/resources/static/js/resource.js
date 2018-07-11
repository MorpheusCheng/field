$(function () {
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");

    $(".Resources").click(function () {
        /*$.ajax({
            url:"/downloadFile",
            type:"post",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            data:{"fileName":$(this).attr('value')}
        });*/
        var url="/downloadFile";
        var fileName=$(this).attr('value');
        var form = $("<form></form>").attr("action", url).attr("method", "post");
        form.append($("<input></input>").attr("type", "hidden").attr("name", "fileName").attr("value", fileName));
        form.appendTo('body').submit().remove();

     console.log($(this).attr('value'));
    });

    /*  $("#submit").click(function () {
     $("#uploadify").uploadify("upload", "*");
     });*/

/*    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    var name=$("#uploadify").attr("name");
    var value=$("#uploadify").attr("value");*/
   /* console.log(name);
    console.log(value);*/
/*
    $("#submit").click(function () {
        $.ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
        $("#uploadify").uploadify("upload", "*");
    });*/



    //参数传不过去
    var name=$("#title").text();
    console.log(name);

    $("#uploadify").uploadify({
        'swf': "/js/uploadify/uploadify.swf",
        'uploader': '/myservlet',
        'queueID': 'fileQueue',
        'fileSizeLimit': '50MB',
        'buttonText': 'select',
        'simUploadLimit': 1,
        'method':'get',
        'queueSizeLimit': 1,
        'formData': {"owner": name},
        'auto': true,
        'fileExt': '*.jpg;*.gif;*.jpeg;*.png;*.pdf，*.pptx',
        onComplete: function (event, queueID, fileObj, response, data) {
            //转换为json对象
            /* var dataObj = eval("("+response+")");
             saveFile(dataObj);*/
            console.log("asd");
        },
        onSelect: function () {
        },
        onError: function (event, queueID, fileObj) {
            alert("文件:" + fileObj.name + "上传失败");
        }
    });



});



