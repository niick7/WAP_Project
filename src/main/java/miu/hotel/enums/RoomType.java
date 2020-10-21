package miu.hotel.enums;

import java.util.Arrays;

public enum RoomType {
  SUPERIOR("Superior"),
  DELUXE("Deluxe") ,
  DELUXE_VILLA("Deluxe Villa"),
  FAMILY_ROOM("Family Room");

  private String name;

  public static RoomType from(String name) {
    return Arrays.stream(RoomType.values())
        .filter(roomType -> roomType.equals(name))
        .findFirst()
        .orElse(SUPERIOR);
  }

  RoomType (String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
