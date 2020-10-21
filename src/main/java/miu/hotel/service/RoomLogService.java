package miu.hotel.service;

import miu.hotel.database.RoomLogs;
import miu.hotel.database.Rooms;
import miu.hotel.model.Room;
import miu.hotel.model.RoomLog;

public class RoomLogService {
  public static boolean add(RoomLog roomLog) {
    RoomLogs.roomList.add(roomLog);
    return true;
  }
}
