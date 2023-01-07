package com.example.budget.controller;

import com.example.budget.mapper.model.period.PeriodRequest;
import com.example.budget.mapper.model.period.PeriodResponse;
import com.example.budget.repository.PeriodRepository;
import com.example.budget.service.PeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("period")
@RequiredArgsConstructor
public class PeriodController {
    private final PeriodService periodService;

    @PostMapping("/add")
    public PeriodResponse add(@RequestBody PeriodRequest periodRequest) {
        return periodService.add(periodRequest);
    }

    @GetMapping("/all")
    public List<PeriodResponse> getAll() {
        return periodService.getAll();
    }

    @GetMapping("find/{id}")
    public PeriodResponse findById(@PathVariable Integer id) {
        return periodService.findById(id);
    }
}
