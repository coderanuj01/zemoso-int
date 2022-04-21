package com.example.springassign.entity;

import java.util.Date;

public class HistoryData {
    String itemName;
    String sellerName;
    int itemPrice;
    String sellerEnrollNo;
    String buyerEnrollNo;
    Date sellingDate;

    public HistoryData() {
    }

    public HistoryData(String itemName, String sellerName, int itemPrice, String sellerEnrollNo, String buyerEnrollNo, Date sellingDate) {
        this.itemName = itemName;
        this.sellerName = sellerName;
        this.itemPrice = itemPrice;
        this.sellerEnrollNo = sellerEnrollNo;
        this.buyerEnrollNo = buyerEnrollNo;
        this.sellingDate = sellingDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSellerEnrollNo() {
        return sellerEnrollNo;
    }

    public void setSellerEnrollNo(String sellerEnrollNo) {
        this.sellerEnrollNo = sellerEnrollNo;
    }

    public String getBuyerEnrollNo() {
        return buyerEnrollNo;
    }

    public void setBuyerEnrollNo(String buyerEnrollNo) {
        this.buyerEnrollNo = buyerEnrollNo;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "itemName='" + itemName + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", itemPrice=" + itemPrice +
                ", sellerEnrollNo='" + sellerEnrollNo + '\'' +
                ", buyerEnrollNo='" + buyerEnrollNo + '\'' +
                ", sellingDate=" + sellingDate +
                '}';
    }
}
