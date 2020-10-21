package miu.hotel.service;

import miu.hotel.database.RoomLogs;
import miu.hotel.model.RoomLog;

public class RoomLogService {
  public static boolean add(RoomLog roomLog) {
    RoomLogs.roomList.add(roomLog);
    return true;
  }

  public static RoomLog getLatestRoomLogByRoomNo(String roomNo) {
    return RoomLogs.roomList
        .stream()
        .filter(roomLog -> roomLog.getRoomNo().equals(roomNo))
        .reduce((first, second) -> second)
        .orElse(null);
  }
}
