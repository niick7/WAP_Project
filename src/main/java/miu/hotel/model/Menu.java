package miu.hotel.model;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
  private static final AtomicInteger count = new AtomicInteger(0);
  private final int id;
  private String item_name;
  private double price;

  public Menu(String item_name, double price) {
    this.id = count.incrementAndGet();
    this.item_name = item_name;
    this.price = price;
  }

  public int getId() { return id; }

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
