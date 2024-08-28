package entity;

public class Coupon {
    private int couponID;
    private String code;
    private double discount;

    public Coupon(int couponID, String code, double discount) {
        this.couponID = couponID;
        this.code = code;
        this.discount = discount;
    }

    // Getters and Setters
    public int getCouponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
