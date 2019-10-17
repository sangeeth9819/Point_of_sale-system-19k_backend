package com.comtech.POS.system.dto;

public class CustomerDTO {
    private long cid;
    private String cust_Name;
    private String address;
    private String tel;
    private Integer isEnable=1;

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getCust_Name() {
        return cust_Name;
    }

    public void setCust_Name(String cust_Name) {
        this.cust_Name = cust_Name;
    }this

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }
}
isEnable