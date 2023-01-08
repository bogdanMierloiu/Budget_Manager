package com.example.budget.controller.mvc;

import com.example.budget.entity.Period;
import com.example.budget.mapper.model.IdRequest;
import com.example.budget.mapper.model.income.IncomeRequest;
import com.example.budget.mapper.model.income.IncomeResponse;
import com.example.budget.mapper.model.period.PeriodRequest;
import com.example.budget.mapper.model.period.PeriodResponse;
import com.example.budget.service.ExpectedIncomeService;
import com.example.budget.service.IncomeService;
import com.example.budget.service.PeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/period")
public class PeriodWebController {

    private final ExpectedIncomeService expectedIncomeService;
    private final IncomeService incomeService;
    private final PeriodService periodService;

    @GetMapping("/goToPeriodPage")
    public String goToPeriodPage(@ModelAttribute("periodId") IdRequest request,
                                 Model model) {
        model.addAttribute("period", periodService.findById(request.getId()));
        model.addAttribute("allExpectedIncomesForPeriod",
                expectedIncomeService.getAllForPeriod(request.getId()));
        model.addAttribute("allIncomesForPeriod", incomeService.getAllForPeriod(request.getId()));
        return "periodPage";
    }

    @PostMapping("/addPeriod")
    public String add(@ModelAttribute("addPeriodRequest") PeriodRequest periodRequest, Model model) {
        periodService.add(periodRequest);
        model.addAttribute("periods", periodService.getAll());
        return "allPeriodsPage";
    }

    @GetMapping("/goToAddAnIncome")
    public String goToAddIncome(@ModelAttribute("periodId") IdRequest request, Model model) {
        model.addAttribute("periodId", request.getId());
        return "addIncomePage";
    }

    @PostMapping("/addAnIncome")
    public String add(@ModelAttribute("periodId") IncomeRequest request, Model model) {
        incomeService.addIncome(request);
        model.addAttribute("periodId", request.getPeriodId());
        model.addAttribute("allExpectedIncomesForPeriod",
                expectedIncomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allIncomesForPeriod", incomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("period", periodService.findById(request.getPeriodId()));
        return "periodPage";
    }

}
