$(function (){
  $("#menus").submit(function(event){
    event.preventDefault();
    $.post("menus", {
      item_name: $("input[name='item_name']").val().trim(),
      price: $("input[name='price']").val().trim()
    }).done(function(data){
      $("input[name='item_name']").val("");
      $("input[name='price']").val("");
      $("#list_menus tbody").find("tr").remove();

      $.each(data, function(index, menu){
        $("#list_menus tbody").append(
          "<tr>" +
            "<td>" + menu.id + "</td>" +
            "<td>" + menu.item_name + "</td>" +
            "<td>" + menu.price.toFixed(2) + "</td>" +
            "<td>" +
              "<a href='edit_menu?id=" + menu.id + "' type='button' class='btn btn-warning'>Edit</a>" +
              "<a href='delete_menu?id=" + menu.id + "' type='button' class='btn btn-danger ml-1' onclick='confirm(\"Are you sure?\")'>Delete</a>" +
            "</td>" +
          "</tr>"
        );
      })
    }).fail(function(xhr, status, exception){
      console.log(xhr, status, exception);
    })
  })
})