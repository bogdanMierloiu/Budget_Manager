package com.example.budget.controller.mvc;

import com.example.budget.mapper.model.IdRequest;
import com.example.budget.service.ExpectedIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/period")
public class PeriodWebController {

    private final ExpectedIncomeService expectedIncomeService;

    @GetMapping("/goToPeriodPage")
    public String goToPeriodPage(@ModelAttribute(value = "id") IdRequest request,
                                 Model model) {
        model.addAttribute("periodId", request.getId());
        model.addAttribute("allExpectedIncomeForPeriod",
                expectedIncomeService.getAllForPeriod(request.getId()));
        return "periodPage";
    }
}
