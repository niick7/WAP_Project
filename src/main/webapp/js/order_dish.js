$(function (){
  $(".order_dish").one("submit", function (event){
    event.preventDefault();
    const roomNo = $(this).find("input[name='room_no']").val();
    const menuId = $("#select_" + roomNo).val();
    $(this).find("input[name='menu_id']").val(menuId);
    $(this).submit();
  })
})