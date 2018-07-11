/**
 * Created by hello on 2018/6/17.
 */
$(function () {
    var header = $("meta[name='_csrf_header']").attr("content");
    var token =$("meta[name='_csrf']").attr("content");
    var name = document.getElementById("title");
    var usename = name.text;
    $("#QueButton").click(function (e) {
        e.preventDefault();
        var key_word=$("#que_Key").val();
        var question=$("#que_Area").val();
        $("#que_Area").val("");
        $("#que_Key").val("");
       /* $("#Que_list").append("<div class='nav-item'><a class='nav-link' th:href='@{/track}' th:classappend='${title} == '"+key_word+"' ? 'active' : '''>"+key_word+"</a></div>");
        $("#Que_list").scrollTop($("#Que_list")[0].scrollHeight);*/
        $.ajax({
            type:"POST",
            url:"/saveQuestion",
            cache:"false",
            beforeSend:function (xhr) {
                xhr.setRequestHeader(header,token);
            },
            contentType: 'application/x-www-form-urlencoded;',
            dataType:"text",
            data:{
                "own":usename,
                "question_keyword":key_word,
                "question":question
            },
            success:function (e) {
                $("#Que_list").append("<div class='nav-item'><a id='"+e+"' class='nav-link'  th:classappend='${title} == '"+key_word+"' ? 'active' : '''>"+key_word+"</a></div>");
                $("#Que_list").scrollTop($("#Que_list")[0].scrollHeight);
            }
        })
/*
        console.log(key_word+question);
*/
    });
})