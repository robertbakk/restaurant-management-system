package BusinessLayer;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private static int orderNo = 1;
    private int orderID;
    private Date date;
    private int table;

    public Order(Date date, int table) {
        this.orderID = orderNo;
        orderNo++;
        this.date = date;
        this.table = table;
    }

    public int getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public int getTable() {
        return table;
    }

    public static void setOrderNo(int orderNo) {
        Order.orderNo = orderNo;
    }

    @Override
    public int hashCode() {
        return orderID;
    }
}
