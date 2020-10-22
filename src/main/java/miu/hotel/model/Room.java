package miu.hotel.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
  private long id;
  private String roomNo;
  private String type;
  private float price;
  private int guestNum;
  private boolean isAvailable;
  private List<Menu> orderedItems = new ArrayList<>();

  private boolean active; // false when room in active

  public Room(){
    super();
  }
  public Room(String roomNo, String type, float price, int guestNum){
    this.roomNo = roomNo;
    this.type = type;
    this.price = price;
    this.guestNum = guestNum;
  }

  public boolean isActive() {
    return active;
  }

  public boolean isBooked() { return !active && isAvailable; }

  public void setActive(boolean active) {
    this.active = active;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public void setType(String type) {
    this.type = type;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getGuestNum() {
    return guestNum;
  }

  public void setGuestNum(int guestNum) {
    this.guestNum = guestNum;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public List<Menu> getOrderedItems() {
    return orderedItems;
  }

  public void resetOrderedItems() {
    this.orderedItems = new ArrayList<>();
  }
}
