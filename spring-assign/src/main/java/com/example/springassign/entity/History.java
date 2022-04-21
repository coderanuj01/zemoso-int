package com.example.springassign.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "buyer_enroll_no")
    private String buyerEnrollNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "selling_date")
    private Date sellingDate;

    public History() {
    }

    public History(int id, int itemId, int studentId, String buyerEnrollNo, Date sellingDate) {
        this.id = id;
        this.itemId = itemId;
        this.studentId = studentId;
        this.buyerEnrollNo = buyerEnrollNo;
        this.sellingDate = sellingDate;
    }

    public History(int itemId, int studentId, String buyerEnrollNo, Date sellingDate) {
        this.itemId = itemId;
        this.studentId = studentId;
        this.buyerEnrollNo = buyerEnrollNo;
        this.sellingDate = sellingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
        return "History{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", studentId=" + studentId +
                ", buyerEnrollNo='" + buyerEnrollNo + '\'' +
                ", sellingDate=" + sellingDate +
                '}';
    }
}
