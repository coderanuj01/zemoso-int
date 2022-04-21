package com.example.springassign.rest;


import com.example.springassign.entity.History;
import com.example.springassign.entity.HistoryData;
import com.example.springassign.entity.Item;
import com.example.springassign.entity.Student;
import com.example.springassign.service.HistoryService;
import com.example.springassign.service.ItemService;
import com.example.springassign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api")
public class HistoryRestController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StudentService studentService;

    // mapping to get all history ... get .... /history
    @GetMapping("/history")
    public String getHistory(Model theModel){

        List<History> historyList = historyService.getHistory();

        List<HistoryData> historyDataList = new ArrayList<>();

        for(History tempHistory : historyList){
            Item newItem = itemService.getItem(tempHistory.getItemId());
            Student newStudent = studentService.getStudent(tempHistory.getStudentId());

            HistoryData newHistory = new HistoryData();
            newHistory.setBuyerEnrollNo(tempHistory.getBuyerEnrollNo());
            newHistory.setItemName(newItem.getItemName());
            newHistory.setItemPrice(newItem.getItemPrice());
            newHistory.setSellerName(newStudent.getFirstName());
            newHistory.setSellingDate(tempHistory.getSellingDate());
            newHistory.setSellerEnrollNo(newStudent.getEnrollNo());

            historyDataList.add(newHistory);
        }

        theModel.addAttribute("historyModel",historyDataList);


        return "history";
    }

    @GetMapping("/showFormToAddHistory")
    public String showFormToAddHistory(@RequestParam("itemId") int theId,Model theModel){

        Item theItem = itemService.getItem(theId);

        History theHistory = new History();
        theHistory.setItemId(theId);
        theHistory.setStudentId(theItem.getSellerId());
        theHistory.getBuyerEnrollNo();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        theHistory.setSellingDate(date);

        theModel.addAttribute("history",theHistory);

        return "history-form";

    }

    // mapping to add a history ... post .... /history
    @PostMapping("/addHistory")
    public String addHistory(@ModelAttribute("history")  History theHistory){


        historyService.addHistory(theHistory);

        int delId = theHistory.getItemId();
        System.out.println(delId);
        itemService.setDeleted(delId);

        return "redirect:/api/item";
    }

}
