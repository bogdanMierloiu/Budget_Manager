package com.example.budget.repository;

import com.example.budget.entity.ExpectedMonthlyIncome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpectedIncomeRepository extends JpaRepository<ExpectedMonthlyIncome, Integer> {
}
