package com.smp.model;

/**
 * Created by Sergey_Stefoglo on 1/16/2017.
 */
public class StateStore {
    private String nomeclatureID;
    private Long orgId;
    private String name;
    private Integer min;
    private Integer max;
    private Integer fold;
    private Double cost;
    private Long providerId;
    private Boolean isSend;
    private Boolean isCheck;
    private Double count;
    private Provider provider;
    public StateStore() {
    }

    public StateStore(Long orgId, String nomeclatureID) {
        this.orgId = orgId;
        this.nomeclatureID = nomeclatureID;
    }

    public String getNomeclatureID() {
        return nomeclatureID;
    }

    public void setNomeclatureID(String nomeclatureID) {
        this.nomeclatureID = nomeclatureID;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getFold() {
        return fold;
    }

    public void setFold(Integer fold) {
        this.fold = fold;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Boolean getSend() {
        return isSend;
    }

    public void setSend(Boolean send) {
        isSend = send;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "StateStore{" +
                "nomeclatureID='" + nomeclatureID + '\'' +
                ", orgId=" + orgId +
                ", name='" + name + '\'' +
                ", min=" + min +
                ", max=" + max +
                ", fold=" + fold +
                ", cost=" + cost +
                ", providerId=" + providerId +
                ", isSend=" + isSend +
                ", isCheck=" + isCheck +
                ", count=" + count +
                '}';
    }
}
