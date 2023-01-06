package com.example.budget.mapper;

import com.example.budget.entity.Period;
import com.example.budget.mapper.model.period.PeriodRequest;
import com.example.budget.mapper.model.period.PeriodResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PeriodMapper {

    Period map(PeriodRequest request);

    PeriodResponse map(Period period);

    List<PeriodResponse> map(List<Period> all);
}
