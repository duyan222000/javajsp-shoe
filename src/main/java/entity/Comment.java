package entity;

import java.sql.Timestamp;

public class Comment {
    private int id;
    private int productId;
    private int userId;
    private String comment;
    private Timestamp createdDate;

    public Comment(int id, int productId, int userId, String comment, Timestamp createdDate) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.comment = comment;
        this.createdDate = createdDate;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}

