var StartBtn = document.querySelector('#StartBtn');

StartBtn.addEventListener('click', function() {


    var info = {
        id: "12",
        name: "Jack",
        age: "16"
    };

    $.ajax({
        url : "http://localhost:8080/test/body",
        type : "post",
        contentType : 'application/json',
        dataType: 'json',
        data: JSON.stringify(info),
        success:function(result){
            console.log('start success');
            alert("body:" + result.id + result.name + result.age);
        },error:function(info){
            alert(JSON.stringify(info));
        }
    });

    $.ajax({
        url : "http://localhost:8080/test/query",
        type : "post",
        contentType : 'application/x-www-form-urlencoded',
        data:{
            id: 12,
            name: "Jack",
            age: 17
        },

      success:function(result){
        console.log('start success');
        alert("query:" + result);
      }
    });

    $.ajax({
        url : "http://localhost:8080/test/path/12/Jack/18",
        type : "post",
        success:function(result){
            console.log('start success');
            alert("path:" + result);
        }
    });

    var formData = new FormData();
    formData.append("id","12");
    formData.append("name","Jack");
    formData.append("age","19");


    $.ajax({
        url : "http://localhost:8080/test/form_data",
        type : "post",
        data: formData,
        contentType: false,
        processData: false,
        success:function(result){
            console.log('start success');
            alert("form_data:" + result);
        }
    });




  }, false);