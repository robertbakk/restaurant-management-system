package BusinessLayer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem {
    private String nume;
    private double pret;
    private ArrayList<MenuItem> productList = new ArrayList<>();

    public CompositeProduct(String nume) {
        this.nume = nume;
    }
    public double computePrice() {
        double pret = 0;
        for (MenuItem p: productList) {
            pret += p.computePrice();
        }
        return pret;
    }

    @Override
    public String getName() {
        return nume;
    }

    @Override
    public void setName(String newName) {
        nume = newName;
    }

    @Override
    public void setPrice(double newPrice) {
        pret = newPrice;
    }

    public void addProduct(MenuItem p) {
        productList.add(p);
    }

    public ArrayList<MenuItem> getProductList() {
        return productList;
    }
}
