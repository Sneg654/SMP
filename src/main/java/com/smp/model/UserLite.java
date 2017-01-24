package com.smp.model;

/**
 * Created by Sergey_Stefoglo on 1/24/2017.
 */
public class UserLite {
    private Long userId;
    private String name;
    private Boolean added;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdded() {
        return added;
    }

    public void setAdded(Boolean added) {
        this.added = added;
    }


    @Override
    public String toString() {
        return "UserLite{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", added=" + added +
                '}';
    }
}
