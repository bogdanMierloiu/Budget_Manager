package com.example.budget.repository;

import com.example.budget.entity.ExpectedExpense;
import com.example.budget.entity.ExpectedIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpectedExpenseRepository extends JpaRepository<ExpectedExpense, Integer> {

    @Query("select t from ExpectedExpense t where t.period.id = :id")
    List<ExpectedExpense> getAllForPeriod(
            @Param("id") Integer id);
}
