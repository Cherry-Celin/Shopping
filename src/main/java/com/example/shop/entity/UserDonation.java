package com.example.shop.entity;

import java.util.Date;

public class UserDonation {
    private int id;
    private User user;
    private Project project;
    private String amount;
    private String feedback;
    private String feedback_img;
    private Date create_time;

    public UserDonation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback_img() {
        return feedback_img;
    }

    public void setFeedback_img(String feedback_img) {
        this.feedback_img = feedback_img;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "UserDonation{" +
                "id=" + id +
                ", user=" + user +
                ", project=" + project +
                ", amount='" + amount + '\'' +
                ", feedback='" + feedback + '\'' +
                ", feedback_img='" + feedback_img + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
