package com.example.budget.repository;

import com.example.budget.entity.ExpectedMonthlyIncome;
import com.example.budget.entity.RealMonthlyIncome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealIncomeRepository extends JpaRepository<RealMonthlyIncome, Integer> {
}
