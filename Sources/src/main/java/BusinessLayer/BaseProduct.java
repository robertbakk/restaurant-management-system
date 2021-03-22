package BusinessLayer;

public class BaseProduct extends MenuItem {
    private String nume;
    private double pret;

    public BaseProduct(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public String getName() {
        return nume;
    }

    public void setName(String newName) {
        nume = newName;
    }

    public void setPrice(double newPrice) {
        pret = newPrice;
    }

    public double computePrice() {
        return pret;
    }

}
