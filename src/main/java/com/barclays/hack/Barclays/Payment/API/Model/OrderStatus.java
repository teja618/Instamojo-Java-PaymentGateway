package com.barclays.hack.Barclays.Payment.API.Model;

public class OrderStatus {

    String orderID;
    String orderStatus;

    public String getID() {
        return orderID;
    }

    public void setID(String ID) {
        this.orderID=ID;
    }

    public String getStatus() {
        return orderStatus;
    }

    public void setStatus(String status) {
        orderStatus = status;
    }
}
