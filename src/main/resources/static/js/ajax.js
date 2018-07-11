/*
$(function(){
    $("#search-form").submit(function(data){
        data.preventDefault();
        ajax_submit();
    })

})


function ajax_submit(){
    var search={};
    search["username"]=$("#username").val();
    $("#btn-search").prop("disabled",true);

    $.ajax({
        type:"POST",
        contentType:"application/json",
        url:"/api/search",
        dataType:"json",
        cache:false,
        timeout:60000,
        data: JSON.stringify(search),
        success: function(data){
       var json="<h4>Ajax Response</h4><pre>"
           + JSON.stringify(data, null, 4) + "</pre>";
       $('#feedback').html(json);
       console.log("success:"+data);
       $("#btn-search").prop("disabled",true);
        },
        error:function(e){
        var json="<h4>Ajax Response</h4><pre>"
            + e.responseText + "</pre>";
        $("#feedback").html(json);
        $("#btn-search").prop("disabled",false);
        }
    })
}
*/
