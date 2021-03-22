package BusinessLayer;

import DataLayer.FileWriter;
import DataLayer.RestaurantSerializator;

import java.util.Observable;

import java.util.*;

/**
 * Clasa care se ocupa cu metodele specifice meniului si comenzilor restaurantului
 */
public class Restaurant extends Observable implements IRestaurantProcessing {
    /**
     * Lista produselor din meniu
     */
    private ArrayList<MenuItem> menuItems;
    /**
     * HashMap-ul de comenzi a restaurantului
     */
    private HashMap<Order,ArrayList<MenuItem>> orders;
    /**
     * Un tablou de cantitati de MenuItems din Orders
     */
    private int[][] quantities;
    private RestaurantSerializator serializator;

    /**
     * Meniul restaurantului este inlocuit cu cel primit de la Serializator
     * @param ser Serializator-ul
     */
    public Restaurant(RestaurantSerializator ser) {
        this.menuItems = ser.getMenuItems();
        this.orders = ser.getOrders();
        this.quantities = ser.getQuantities();
        this.serializator = ser;
    }

    /**
     * Metoda care adauga un obiect de tipul MenuItem la lista menuItems a clasei Restaurant
     * @param x obiectul de tipul MenuItem ce va fi adaugat la lista menuItems
     */
    @Override
    public void createMenuItem(MenuItem x) {
        assert x != null;
        assert isWellFormed();
        menuItems.add(x);
        serializator.serialize(this);
        assert menuItems != null;
        assert isWellFormed();
    }

    /**
     * Metoda care sterge un obiect de tipul MenuItem din lista menuItems a clasei Restaurant
     * @param x obiectul de tipul MenuItem ce va fi sters din lista menuItems
     */
    @Override
    public void deleteMenuItem(MenuItem x) {
        assert x != null;
        assert isWellFormed();
        menuItems.remove(x);
        serializator.serialize(this);
        assert isWellFormed();
    }

    /**
     * Metoda care modifica un obiect de tipul MenuItem din lista menuItems a clasei Restaurant, prin inlocuirea acestuia cu alt obiect de tipul MenuItem
     * @param a obiectul de tipul MenuItem ce va fi inlocuit
     * @param b obiectul de tipul MenuItem cu care se va face inlocuirea
     */
    @Override
    public void editMenuItem(MenuItem a, MenuItem b) {
        assert b != null;
        assert isWellFormed();
        for (MenuItem m : menuItems)
            if (m.equals(a)) {
                a = b;
            }
        serializator.serialize(this);
        assert menuItems != null;
        assert isWellFormed();
    }

    /**
     * Metoda care adauga un obiect de tipul Order la HashMap-ul clasei Restaurant
     * @param x obiectul de tipul Order ce va fi adaugat la HashMap-ul orders
     * @param items lista de MenuItems care va fi adaugata
     * @param quantities vectorul cu cantitatile obiectelor din items
     */
    @Override
    public void createOrder(Order x, ArrayList<MenuItem> items, int[] quantities) {
        assert x != null;
        assert isWellFormed();
        setChanged();
        orders.put(x,items);
        this.quantities[x.getOrderID()-1] = quantities;
        serializator.serialize(this);
        ArrayList<Object> a = new ArrayList<>();
        a.add(orders);
        a.add(quantities);
        notifyObservers(a);
        assert orders != null;
        assert isWellFormed();
    }


    /**
     * Metoda care genereaza un Bill pentru o anumita masa
     * @param table masa pentru care se va genera Bill-ul
     */
    @Override
    public void generateBill(int table) {
        assert table > 0;
        assert isWellFormed();
        FileWriter fw = new FileWriter();
        double price;
        int i;
        double totalPrice = 0;
        int order = 0;
        String s = "";
        for(HashMap.Entry<Order, ArrayList<MenuItem>> o : orders.entrySet()) {
            if (o.getKey().getTable() == table) {
                i = 0;
                s = "Order number " + o.getKey().getOrderID() + "\nTable " + table + "\n";
                totalPrice = 0;
                order = o.getKey().getOrderID();
                for (MenuItem m : o.getValue()) {
                    price = quantities[o.getKey().getOrderID() - 1][i] * m.computePrice();
                    s += quantities[o.getKey().getOrderID() - 1][i] + "x " + m.getName() + " " + price + "(unit price: " + m.computePrice() + ")\n";
                    totalPrice += price;
                    i++;
                }
                s += "Order date: " + o.getKey().getDate() + "\n";
                Date d = new Date();
                s += "Bill created on: " + d + "\n";
            }
        }
        s+="Total price: " + totalPrice;
        fw.createBill(s,table,order);
        assert totalPrice > 0;
        assert isWellFormed();
    }

    /**
     * Metoda care returneaza lista de MenuItems a restaurantului
     * @return lista de MenuItems
     */
    @Override
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * Metoda care returneaza HashMap-ul de Orders a restaurantului
     * @return HashMap-ul de Orders
     */
    @Override
    public HashMap<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    /**
     * Metoda care returneaza tabloul de cantitati din Order-urile restaurantului
     * @return tabloul de cantitati din Order-urile restaurantului
     */
    @Override
    public int[][] getQuantities() {
        return quantities;
    }

    /**
     * Metoda care returneaza faptul ca Restaurant e well formed sau nu
     * @return faptul ca Restaurant e well formed sau nu
     */
    @Override
    public boolean isWellFormed() {
        for (MenuItem m : menuItems)
            if (m == null)
                return false;
        for(HashMap.Entry<Order, ArrayList<MenuItem>> o : orders.entrySet())
            if (o == null)
                return false;
        return true;
    }

}
