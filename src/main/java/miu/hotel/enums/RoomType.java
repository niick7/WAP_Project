package miu.hotel.enums;

public enum RoomType {
  SUPERIOR("Superior"),
  DELUXE("Deluxe") ,
  DELUXE_VILLA("Deluxe Villa"),
  FAMILY_ROOM("Family Room");

  private String name;

  RoomType (String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
