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
          "<td>" + (index + 1) + "</td>" +
          "<td>" + menu.item_name + "</td>" +
          "<td>" + menu.price.toFixed(2) + "</td>" +
          "<td>" + "</td>" +
          "</tr>"
        );
      })
    }).fail(function(xhr, status, exception){
      console.log(xhr, status, exception);
    })
  })
})