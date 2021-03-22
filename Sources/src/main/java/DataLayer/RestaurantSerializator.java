package DataLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantSerializator {
private ArrayList<MenuItem> menuItems = new ArrayList<>();
private HashMap<Order,ArrayList<MenuItem>> orders = new HashMap<>();
private int[][] quantities = new int[50][50];
private String path;

    public RestaurantSerializator (String path) {
        try {
            this.path = path;
            deserialize(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deserialize(String path) throws IOException, ClassNotFoundException {
        File f = new File(path);
        if (f.exists()) {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            if (fileIn.available() != 0)
                menuItems = (ArrayList<MenuItem>) in.readObject();
            if (fileIn.available() != 0) {
                orders = (HashMap<Order, ArrayList<MenuItem>>) in.readObject();
                Order.setOrderNo(orders.size() + 1);
            }
            if (fileIn.available() != 0)
                quantities = (int[][]) in.readObject();
            in.close();
            fileIn.close();
        }
    }

    public void serialize(Restaurant restaurant) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(restaurant.getMenuItems());
            out.writeObject(restaurant.getOrders());
            out.writeObject(restaurant.getQuantities());
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public HashMap<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    public int[][] getQuantities() {
        return quantities;
    }

}
