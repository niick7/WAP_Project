package miu.hotel.service;

import miu.hotel.database.Rooms;
import miu.hotel.model.Room;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoomService {
  public static Optional<Room> findRoomByRoomNum(String roomNo) {
    return Rooms.roomList.stream()
        .filter(room -> room.getRoomNo().equals(roomNo))
        .findFirst();
  }

  public static boolean add(Room room) {
    room.setAvailable(true);
    room.setActive(true);
    Rooms.roomList.add(room);
    return true;
  }

  public static boolean edit(Room room) {
    findRoomByRoomNum(room.getRoomNo()).ifPresent(r -> {
      r.setType(room.getType());
      r.setPrice(room.getPrice());
      r.setGuestNum(room.getGuestNum());
    });
    return true;
  }

  public static boolean delete(String roomNo) {
    findRoomByRoomNum(roomNo)
        .ifPresent(r -> r.setActive(false));
    return true;
  }

  public static List<Room> getAllRoom() {
    return Rooms.roomList;
  }

  public static List<Room> getActiveRoom() {
    return Rooms.roomList.stream()
        .filter(Room::isActive)
        .collect(Collectors.toList());
  }
}
