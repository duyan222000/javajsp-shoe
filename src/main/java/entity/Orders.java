package entity;

import java.util.Date;
import java.util.List;

import java.sql.Timestamp;

public class Orders {
    private int orderID;
    private int userID;
    private String name;
    private String phone;
    private int couponID;
    private Timestamp orderDate;
    private double totalAmount;

    public Orders() {}
    
    public Orders(int orderID, int userID, String name, String phone, int couponID, Timestamp orderDate, double totalAmount) {
        this.orderID = orderID;
        this.userID = userID;
        this.name = name;
        this.phone = phone;
        this.couponID = couponID;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCouponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
