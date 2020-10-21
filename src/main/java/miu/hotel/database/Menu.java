package miu.hotel.database;

public class Menu {
  private String item_name;
  private double price;

  public Menu(String item_name, double price) {
    this.item_name = item_name;
    this.price = price;
  }

  public String getItem_name() {
    return item_name;
  }

  public void setItem_name(String item_name) {
    this.item_name = item_name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
