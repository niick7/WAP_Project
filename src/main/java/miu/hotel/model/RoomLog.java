package miu.hotel.model;

import java.time.LocalDate;

public class RoomLog {
  private long id;
  private String roomNo;
  private String type;
  private float price;
  private int guestNum;
  private String guestId;
  private LocalDate dateUsing;

  private String customerId;
  private double serviceFee;

  private boolean active; // false when room in active

  public RoomLog(){
    super();
  }
  public RoomLog(String roomNo, String type, float price, int guestNum){
    this.roomNo = roomNo;
    this.type = type;
    this.price = price;
    this.guestNum = guestNum;
  }

  public String getGuestId() {
    return guestId;
  }

  public void setGuestId(String guestId) {
    this.guestId = guestId;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public double getServiceFee() {
    return serviceFee;
  }

  public void setServiceFee(double serviceFee) {
    this.serviceFee = serviceFee;
  }

  public boolean isActive() {
    return active;
  }

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

  public LocalDate getDateUsing() {
    return dateUsing;
  }

  public void setDateUsing(LocalDate dateUsing) {
    this.dateUsing = dateUsing;
  }
}
