package com.example.budget.repository;

import com.example.budget.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Integer> {
    @Query("select t from Income t where t.period.id = :id")
    List<Income> getAllForPeriod(@Param("id") Integer id);
}
