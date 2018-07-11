/**
 * Created by hello on 2018/3/23.
 */

$(function(){
    var header = $("meta[name='_csrf_header']").attr("content");
    var token =$("meta[name='_csrf']").attr("content");
    var ajax_retun_code="";
    //主界面的注册按钮点击了之后触发
    $("#signup").click(function(){
        $(location).attr("href","signup");
    })

    $("#bth-search").click(function (data) {
        data.preventDefault();
        ajax_submit();
    })

        $("#validate").dialog(
            {
                autoOpen:false,
                width:300,
                model:true,
                position:{my:"top+20px",at:"top",of:window},
                draggable:false,
                resizable:false,
                buttons:{
                    "ok":function () {
                         var validation=$("#validation").val();
                        // alert(data+"++"+validation);-
                        alert(validation+" "+" "+ajax_retun_code);

                        /*成功返回到zhu主界面
                        * 失败回滚数据*/
                     if($.trim(validation)==$.trim(ajax_retun_code))
                        {
                            alert("验证成功");
                            $(location).attr("href","/login");
                        }else{
                            alert("验证错误");
                            $.ajax({
                                async:"false",
                                type:"POST",
                                contentType:"application/json",
                                url:"/rollback",
                                cache:"false",
                                dataType:"text",
                                timeout:60000,
                                beforeSend:function (xhr) {
                                    xhr.setRequestHeader(header,token);
                                },
                                success:function (data) {
                                    alert("删除")
                                },
                                error:function (e) {
                                    
                                }
                            })
                            $(location).attr("href","/login");
                        }
                    },
                    concel:function(){
                        $(this).dialog("close");
                    }
                }
            })

    function equals(data1,data2){
        if(data1==data2)
            return true;
        else
            return false;
    }




//提交注册信息
    function   ajax_submit(){

        var options=$("#select option:selected"); //获取选中的项
        var search={};
        search["title"]=options.val();
        search["username"]=$("#username").val();
        search["password"]=$("#password").val();
        search["email"]=$("#email").val();
        var email,username,password;
        email=$("email");
        username=$("username");
        password=$("password");

        $("#btn-search").prop("disabled",true);
        $.ajax({
            async:"false",
            type:"POST",
            contentType:"application/json",
            url:"/register",
            cache:"false",
            dataType:"text",
            timeout:60000,
            beforeSend:function (xhr) {
                xhr.setRequestHeader(header,token);
            }
            ,data:JSON.stringify(search),
            success:function (data) {
                 /*  var json="<h4>Ajax Response</h4><pre>"
                 + JSON.stringify(data, null, 4) + "</pre>";

                 alert("验证码已经发送到您的邮箱，请先验证。");
                 */
                 alert(data);
               //  $('#feedback').html(json);
                 $("#validate").dialog("open");

                 console.log("success:"+data);
                $("#btn-search").prop("disabled",true);

                ajax_retun_code=data;


            },
            error:function(e){
                var json="<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $("#feedback").html(json);
             //   $("#validate").dialog("open");

                alert("error");
                //confirm("你好");

                $("#btn-search").prop("disabled",false);
                //$(location).prop("href","/");
            }
        })
    }
})


