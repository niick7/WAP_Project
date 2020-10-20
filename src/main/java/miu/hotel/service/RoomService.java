package miu.hotel.service;

import miu.hotel.database.Rooms;
import miu.hotel.model.Room;

import java.util.Optional;

public class RoomService {
  public static Optional<Room> findRoomByRoomNum (String roomNo) {
    return Rooms.roomList.stream()
        .filter(room -> room.getRoomNo().equals(roomNo))
        .findFirst();
  }
}
