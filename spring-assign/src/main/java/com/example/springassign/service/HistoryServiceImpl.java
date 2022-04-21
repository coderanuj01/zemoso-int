package com.example.springassign.service;

import com.example.springassign.entity.History;
import com.example.springassign.repository.HistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    @Transactional
    public List<History> getHistory() {
        return historyRepository.findAll();
    }

    @Override
    @Transactional
    public History addHistory(History theHistory) {
        historyRepository.save(theHistory);
        return theHistory;
    }
}
