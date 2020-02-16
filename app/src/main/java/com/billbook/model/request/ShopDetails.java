package com.billbook.model.request;

import com.billbook.model.request.Address;
import com.billbook.model.request.Branch;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopDetails {
    @SerializedName("shop Id")
    @Expose
    String shopId;
    @SerializedName("phone Number")
    @Expose
    long phoneNumber;
    @SerializedName("owner Name")
    @Expose
    String ownerName;
    @SerializedName("shop Name")
    @Expose
    String shopName;
    @SerializedName("address")
    @Expose
    Address address;
    @SerializedName("branchs")
    @Expose
    List<Branch> branchs;
    @SerializedName("modified By")
    @Expose
    String modifiedBy;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Branch> getBranchs() {
        return branchs;
    }

    public void setBranchs(List<Branch> branchs) {
        this.branchs = branchs;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
