package miu.hotel.database;

import miu.hotel.enums.RoomType;
import miu.hotel.model.Room;

import java.util.ArrayList;
import java.util.List;

public class Rooms {

  public static List<Room> roomList = new ArrayList<>();

  static {
    Room r = new Room();
    r.setRoomNo("001");
    r.setType(RoomType. SUPERIOR.getName());
    r.setPrice(1000);

    r.setActive(true);

    roomList.add(r);
  }
}
