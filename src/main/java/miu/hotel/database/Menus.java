package miu.hotel.database;

import miu.hotel.model.Menu;
import java.util.ArrayList;
import java.util.List;

public class Menus {
    public static List<Menu> menuList = new ArrayList();
    static {
        menuList.add(new Menu("Coffee", 3.43));
        menuList.add(new Menu("Milk Coffee", 5.15));
        menuList.add(new Menu("Coca", 1.89));
        menuList.add(new Menu("Pepsi", 1.89));
        menuList.add(new Menu("Heineken", 3.23));
        menuList.add(new Menu("BudLight", 2.98));
        menuList.add(new Menu("Orange Juice", 4.53));
        menuList.add(new Menu("Lemon Juice", 3.68));
        menuList.add(new Menu("Pilau", 4.28));
        menuList.add(new Menu("Beef Rice", 10.32));
        menuList.add(new Menu("Beef Rice and Egg", 14.74));
        menuList.add(new Menu("Egg Rice", 5.15));
        menuList.add(new Menu("Soup Noodle", 3.48));
        menuList.add(new Menu("Beef Noodle", 8.23));
        menuList.add(new Menu("Beef Noodle and Egg", 10.23));
    }
}
