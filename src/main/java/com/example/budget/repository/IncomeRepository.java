package com.example.budget.repository;

import com.example.budget.entity.ExpectedIncome;
import com.example.budget.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Integer> {
    @Query("select t from Income t where t.date BETWEEN :startDate AND :endDate")
    List<Income> getAllForPeriod(
            @Param("startDate") LocalDate dateFrom,
            @Param("endDate") LocalDate dateTo);
}
