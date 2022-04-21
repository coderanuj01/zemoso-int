package com.example.springassign.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private int itemPrice;

    @Column(name = "seller_id")
    private int sellerId;

    @Column(name="is_deleted")
    private boolean isDeleted = true;

    public Item() {
    }

    public Item(int id, String itemName, int itemPrice, int sellerId, boolean isDeleted) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.sellerId = sellerId;
        this.isDeleted = isDeleted;
    }

    public Item(String itemName, int itemPrice, int sellerId, boolean isDeleted) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.sellerId = sellerId;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", sellerId=" + sellerId +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
