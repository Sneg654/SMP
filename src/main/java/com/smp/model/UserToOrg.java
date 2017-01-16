package com.smp.model;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
public class UserToOrg {
    private Long id;
    private Long userId;
    private Long orgId;


    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
