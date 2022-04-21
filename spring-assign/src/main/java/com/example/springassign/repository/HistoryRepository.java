package com.example.springassign.repository;

import com.example.springassign.entity.History;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {

}