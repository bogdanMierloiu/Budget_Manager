package com.example.budget.repository;

import com.example.budget.entity.CategoryOfExpense;
import com.example.budget.entity.ExpectedIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CategoryOfExpenseRepository extends JpaRepository<CategoryOfExpense, Integer> {

    @Query("select t from ExpectedIncome t where t.startDate = :startDate AND t.endDate = :endDate")
    List<ExpectedIncome> getAllForPeriod(
            @Param("startDate") LocalDate dateFrom,
            @Param("endDate") LocalDate dateTo);
}
