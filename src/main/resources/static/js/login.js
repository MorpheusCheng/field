//dialog对话框
$(function () {
    // $("#dialog-form").css("position","fixed");

    $("#dialog-form").dialog(
        {
            autoOpen: false,
            width: 300,
            hight: 350,
            modal: true,
            position: {my: "top+20px", at: "top", of: window},
            draggable: false,
            resizable: false,
            buttons: {
                "登陆": function () {
                     /*   alert("登陆");
                        submit_login();*/
                $("#login_form").submit();
                },
                "取消": function () {
                    $(this).dialog("close");
                }
            }
        }
    );

    $("#login")
        .click(function () {
            $("#dialog-form").dialog("open");
        });


  /*  function submit_login() {
        var email = $("#email"),
            password = $("#password");
        var search = [];
        search["email"] = email.val();
        search["password"] = password.val();
        alert(email.val()+password.val());
        $.ajax(
            {
                type: "POST",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "/login",
                dataType: "json",
                cache: false,
                timeout: 60000,
                data:
                    {
                        "email":email.val(),
                        "password":password.val()
                    },
                success: function (data) {
                    alert('data');
                    if(JSON.stringify(data)=='true')
                    {
                        alert("登陆成功");
                    }else{
                        alert("登录失败");
                    }
                }, error: function (e) {
                   alert(e);
                }
            }
        )
    }*/


})