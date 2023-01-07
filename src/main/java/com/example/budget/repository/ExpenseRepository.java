package com.example.budget.repository;

import com.example.budget.entity.CategoryOfExpense;
import com.example.budget.entity.ExpectedIncome;
import com.example.budget.entity.Expense;
import com.example.budget.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    @Query("select t from Expense t where t.period.id = :id")
    List<Expense> getAllForPeriod(
            @Param("id") Integer id);
}
