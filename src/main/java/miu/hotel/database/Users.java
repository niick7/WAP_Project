package miu.hotel.database;

import miu.hotel.model.User;

import java.util.ArrayList;
import java.util.List;

public class Users {
  public static List<User> userList = new ArrayList<>();

  static {
    User u = new User();
    u.setUserName("staff");
    u.setPassword("staff");
    userList.add(u);
  }
}
