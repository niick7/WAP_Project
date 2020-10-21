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
    r.setType(RoomType.SUPERIOR.getName());
    r.setPrice(1000);
    r.setAvailable(true);
    r.setActive(true);
    roomList.add(r);

    r = new Room();
    r.setRoomNo("002");
    r.setType(RoomType.DELUXE.getName());
    r.setPrice(2000);
    r.setAvailable(false);
    r.setActive(true);
    roomList.add(r);

    r = new Room();
    r.setRoomNo("003");
    r.setType(RoomType.DELUXE_VILLA.getName());
    r.setPrice(3000);
    r.setAvailable(true);
    r.setActive(false);
    roomList.add(r);

    r = new Room();
    r.setRoomNo("004");
    r.setType(RoomType.FAMILY_ROOM.getName());
    r.setPrice(4000);
    r.setAvailable(false);
    r.setActive(false);
    roomList.add(r);
  }
}
