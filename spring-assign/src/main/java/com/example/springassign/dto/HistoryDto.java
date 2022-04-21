package com.example.springassign.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryDto {
    private int id;
    private int itemId;
    private int studentId;
    private String buyerEnrollNo;
    private Date sellingDate;
}
