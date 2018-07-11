/**
 * Created by hello on 2018/4/11.
 */
$(function () {
    //开启通道
    var target = "ws://localhost:8080/talk/" + usename;
    var ws = new WebSocket(target);
    var name = document.getElementById("title");
    var usename = name.text;
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    var discuss_question=$(".question").first().attr("id");
    $("#title_show").text($(".question").first().text());
    $.ajax({
        url: "/allMessage",
        type: "POST",
        cache: "false",
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        contentType: 'application/x-www-form-urlencoded;',
        dataType: "json",
        data: {
            "question_id": discuss_question
        },
        success: function (e) {
                console.log($(e)[0].questionid);
                    $(e).each(function () {
                        add_message(this.own, usename == this.own ? "news_my" : "news_others", this.message, this.time);
                    })
        }
    });

    $(document).keydown(function (event) {
        if (event.ctrlKey && event.which == 13) {
            /*  e.preventDefault();*/
            var content = $("#textWord").val();
            $("#textWord").val("");
            var time = gettime();
            var object = {
                own: usename,
                msg: content,
                time: time,
                question_id: discuss_question
            };
            var str = JSON.stringify(object);
            ws.send(str);
            add_message(usename, "news_my", content, time);
            saveMessage(usename, "news_my", content, time);
        }
    });


    $("#send").click(function (e) {
        e.preventDefault();
        var content = $("#textWord").val();
        $("#textWord").val("");
        var time = gettime();
        var object = {
            own: usename,
            msg: content,
            time: time,
            question_id: discuss_question
        };
        var str = JSON.stringify(object);
        ws.send(str);
        add_message(usename, "news_my", content, time);
        saveMessage(usename, "news_my", content, time);
    });

    function add_message(nam, csss, conten, tim) {

        $("#msg").append("" +
            "<div class='messageMain'>" + "<div class='nameLL'>" + nam + " : </div>" +
            "<div class='messageContent'>" +
            "<font class='login_information1 ' size='1'>" + tim + "</font><br>" +
            "<li class='" + csss + "'>" + conten + "</li><br>" +
            "</div>" +
            "</div>");
        $("#msg").scrollTop($("#msg")[0].scrollHeight);


    }

    function saveMessage(nam, csss, conten, tim) {
        $.ajax({
            url: "/saveMessage",
            type: "POST",
            cache: "false",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            contentType: 'application/x-www-form-urlencoded;',
            dataType: "text",
            data: {
                "own": usename,
                "question_id": discuss_question,
                "message": conten,
                "time": tim
            },
            success: function (e) {
                console.log(e)
            }
        });
    }

    function gettime() {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;//js中是从0开始所以要加1
        var day = date.getDate();
        var hour = date.getHours();
        var minute = date.getMinutes();
        var second = date.getSeconds();
        var presentTime = year + '-' + month + '-' + day + '  ' + hour + ':' + minute;
        return presentTime;
    }

    $(".question").click(function () {
        console.log($(this).text());
        $("#title_show").text($(this).text());
        discuss_question = $(this).attr("id");
        document.getElementById("msg").innerHTML = "";
        $.ajax({
            url: "/allMessage",
            type: "POST",
            cache: "false",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            contentType: 'application/x-www-form-urlencoded;',
            dataType: "json",
            data: {
                "question_id": discuss_question
            },
            success: function (e) {
                    $(e).each(function () {
                        add_message(this.own, usename == this.own ? "news_my" : "news_others", this.message, this.time);
                    })
            }
        })
    });

    //接收消息
    ws.onmessage = function (event) {
        eval("var msg=" + event.data + ";");
        if(msg.questionid==discuss_question) {
            add_message(msg.own, "news_others", msg.msg, msg.time);
        }
    }
    /*if (undefined != msg.welcome) {
     $("#newsList").append("<font class='login_information text-center' size='1'>" + msg.welcome + "</font><br/>");
     }
     if (undefined != msg.usernames) {
     $("#userList").html("");
     $(msg.usernames).each(function () {
     $("#userList").append("<input type='checkbox' value='" + this + "'/>" + this + "<br/>");
     });
     }
     if (undefined != msg.content) {
     $("#newsList").append("<font class='login_information' size='1'>" + gettime() + "</font><br/><li class='news_my'>" + msg.content + "</li><br/><br/>");
     }*/

    //send后的的事件
    /*  $("#send").click(function () {
     var val = $("#dope").val();
     var size = $("#userList :checked").length;
     //
     var object = null;
     if (size == 0) {
     object = {
     msg: val,
     type: 1//1 广播
     }
     } else {
     var to = $("#userList :checked").val();
     object = {
     to: to,
     msg: val,
     type: 2//私聊
     }
     }
     var str = JSON.stringify(object);
     ws.send(str);
     $("#dope").val("");
     })*/
});
