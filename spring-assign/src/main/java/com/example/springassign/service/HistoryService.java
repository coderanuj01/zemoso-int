package com.example.springassign.service;

import com.example.springassign.entity.History;

import java.util.List;

public interface HistoryService {

    List<History> getHistory();

    History addHistory(History theHistory);

}
