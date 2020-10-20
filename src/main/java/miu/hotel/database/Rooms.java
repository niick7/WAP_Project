package miu.hotel.database;

import miu.hotel.model.Room;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
  List<Room> roomList = new ArrayList<>();

  public List<Room> getRoomList() {
    return roomList;
  }

  public void setRoomList(List<Room> roomList) {
    this.roomList = roomList;
  }
}
