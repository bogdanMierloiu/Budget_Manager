package com.example.budget.mapper;

import com.example.budget.entity.Income;
import com.example.budget.mapper.model.income.IncomeRequest;
import com.example.budget.mapper.model.income.IncomeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IncomeMapper {

    Income map(IncomeRequest request);

    IncomeResponse map(Income income);

    List<IncomeResponse> map(List<Income> all);
}
