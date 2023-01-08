package com.example.budget.controller.mvc;

import com.example.budget.service.PeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PeriodService periodService;

    @GetMapping("")
    public String viewIndexPage() {
        return "index";
    }

    @GetMapping("/start")
    public String startApp(Model model) {
        model.addAttribute("periods", periodService.getAll());
        return "allPeriodsPage";
    }
    @GetMapping("/goToAddPeriodPage")
    public String goToAddPeriodPage() {
        return "addPeriodPage";
    }
}
