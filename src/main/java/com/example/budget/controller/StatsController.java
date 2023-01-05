package com.example.budget.controller;

import com.example.budget.mapper.model.PeriodRequest;
import com.example.budget.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stats")
@RequiredArgsConstructor
public class StatsController {
    private final StatsService statsService;

    @GetMapping("worth")
    public Double netWorth(@RequestBody PeriodRequest request) {
        return statsService.netWorth(request);
    }
}
