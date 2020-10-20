package miu.hotel.model;

public class Room {
  private String roomNo;
  private String type;
  private float price;
  private int guestNum;

  public Room(){
    super();
  }
  public Room(String roomNo, String type, float price, int guestNum){
    this.roomNo = roomNo;
    this.type = type;
    this.price = price;
    this.guestNum = guestNum;
  }

  public String getRoomNo() {
    return roomNo;
  }

  public void setRoomNo(String roomNo) {
    this.roomNo = roomNo;
  }

  public String getType() {
    return type;
  }

  private boolean isAvailable;

  
}
