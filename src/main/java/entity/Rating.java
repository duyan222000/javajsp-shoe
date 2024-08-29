package entity;

public class Rating {
    private int id;
    private int productId;
    private int userId;
    private int rating;

    public Rating(int id, int productId, int userId, int rating) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

