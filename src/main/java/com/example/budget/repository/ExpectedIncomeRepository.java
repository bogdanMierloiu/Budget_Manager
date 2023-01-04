package com.example.budget.repository;

import com.example.budget.entity.ExpectedIncome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpectedIncomeRepository extends JpaRepository<ExpectedIncome, Integer> {
}
