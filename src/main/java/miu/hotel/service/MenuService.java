package miu.hotel.service;

import miu.hotel.database.Menus;
import miu.hotel.model.Menu;

public class MenuService {
  public static Menu findById(Integer id) {
    return Menus.menuList.stream()
      .filter(x -> id.equals(x.getId()))
      .findAny()
      .orElse(null);
  }
}
