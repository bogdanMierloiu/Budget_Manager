package com.example.budget.repository;

import com.example.budget.entity.ExpectedExpense;
import com.example.budget.entity.ExpectedIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpectedExpenseRepository extends JpaRepository<ExpectedExpense, Integer> {

    @Query("select t from ExpectedExpense t where t.startDate = :startDate AND t.endDate = :endDate")
    List<ExpectedExpense> getAllForPeriod(
            @Param("startDate") LocalDate dateFrom,
            @Param("endDate") LocalDate dateTo);
}
