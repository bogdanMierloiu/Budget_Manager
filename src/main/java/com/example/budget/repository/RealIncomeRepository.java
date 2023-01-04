package com.example.budget.repository;

import com.example.budget.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealIncomeRepository extends JpaRepository<Income, Integer> {
}
