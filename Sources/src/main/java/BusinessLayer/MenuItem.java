package BusinessLayer;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    public abstract double computePrice();
    public abstract String getName();
    public abstract void setName(String newName);
    public abstract void setPrice(double newPrice);
}