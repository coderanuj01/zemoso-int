package com.example.springassign.service;

import com.example.springassign.entity.History;
import com.example.springassign.repository.HistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class HistoryServiceImplTest {

    @MockBean
    private HistoryRepository historyRepository;

    @Autowired
    private HistoryService historyServiceImpl;


//    @BeforeEach
//    void setUp() {
//        this.historyServiceImpl = new HistoryServiceImpl(historyRepository);
//    }

    @Test
    void getHistoryTest() {

        List<History> historyList = new ArrayList<>();

        History history = new History();

        historyList.add(history);

        when(historyRepository.findAll()).thenReturn(historyList);

        assertEquals(1,historyServiceImpl.getHistory().size());



    }


    @Test
    void addHistoryTest() {

        History history = new History();
        history.setItemId(2);
        history.setStudentId(3);
        history.setId(1);
        history.setBuyerEnrollNo("66545");
        history.setSellingDate(new Date());



        Mockito.when(historyRepository.save(history)).thenReturn(history);
        assertThat(historyServiceImpl.addHistory(history)).isEqualTo(history);

    }

}