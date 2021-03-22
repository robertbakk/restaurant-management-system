package BusinessLayer;

import java.util.ArrayList;
import java.util.HashMap;;

/**
 * Interfata in care se definesc metodele ce vor fi implementate in clasa Restaurant
 */
public interface IRestaurantProcessing {
    /**
     * Metoda care adauga un obiect de tipul MenuItem la lista menuItems a clasei Restaurant
     * @param x obiectul de tipul MenuItem ce va fi adaugat la lista menuItems
     */
    void createMenuItem(MenuItem x);
    /**
     * Metoda care sterge un obiect de tipul MenuItem din lista menuItems a clasei Restaurant
     * @param x obiectul de tipul MenuItem ce va fi sters din lista menuItems
     */
    void deleteMenuItem(MenuItem x);

    /**
     * Metoda care modifica un obiect de tipul MenuItem din lista menuItems a clasei Restaurant, prin inlocuirea acestuia cu alt obiect de tipul MenuItem
     * @param a obiectul de tipul MenuItem ce va fi inlocuit
     * @param b obiectul de tipul MenuItem cu care se va face inlocuirea
     */
    void editMenuItem(MenuItem a, MenuItem b);

    /**
     * Metoda care adauga un obiect de tipul Order la HashMap-ul clasei Restaurant
     * @param x obiectul de tipul Order ce va fi adaugat la HashMap-ul orders
     * @param items lista de MenuItems care va fi adaugata
     * @param quantities vectorul cu cantitatile obiectelor din items
     */
    void createOrder(Order x, ArrayList<MenuItem> items, int[] quantities);

    /**
     * Metoda care genereaza un Bill pentru o anumita masa
     * @param table masa pentru care se va genera Bill-ul
     */
    void generateBill(int table);

    /**
     * Metoda care returneaza lista de MenuItems a restaurantului
     * @return lista de MenuItems
     */
    ArrayList<MenuItem> getMenuItems();

    /**
     * Metoda care returneaza HashMap-ul de Orders a restaurantului
     * @return HashMap-ul de Orders
     */
    HashMap<Order, ArrayList<MenuItem>> getOrders();

    /**
     * Metoda care returneaza tabloul de cantitati din Order-urile restaurantului
     * @return tabloul de cantitati din Order-urile restaurantului
     */
    int[][] getQuantities();

    /**
     * Metoda care returneaza faptul ca Restaurant e well formed sau nu
     * @return faptul ca Restaurant e well formed sau nu
     */
    boolean isWellFormed();

}
