package com.example.budget.controller.mvc;

import com.example.budget.mapper.model.IdRequest;
import com.example.budget.mapper.model.IdRequestForCategory;
import com.example.budget.mapper.model.expense.ExpectedExpenseRequest;
import com.example.budget.mapper.model.expense.ExpenseRequest;
import com.example.budget.mapper.model.income.ExpectedIncomeRequest;
import com.example.budget.mapper.model.income.IncomeRequest;
import com.example.budget.mapper.model.period.PeriodRequest;
import com.example.budget.mapper.model.period.PeriodResponse;
import com.example.budget.service.*;
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
    private final ExpenseService expenseService;
    private final ExpectedExpenseService expectedExpenseService;
    private final CategoryOfExpenseService categoryOfExpenseService;
    private final StatsService statsService;

    @GetMapping("/goToPeriodPage")
    public String goToPeriodPage(@ModelAttribute("periodId") IdRequest request,
                                 Model model) {
        PeriodResponse period = periodService.findById(request.getId());
        model.addAttribute("period", period);
        model.addAttribute("allExpectedIncomesForPeriod",
                expectedIncomeService.getAllForPeriod(request.getId()));
        model.addAttribute("allIncomesForPeriod", incomeService.getAllForPeriod(request.getId()));
        model.addAttribute("amountIncomeForPeriod", incomeService.calculateAmountForPeriod(request.getId()));
        model.addAttribute("amountExpenseForPeriod", expenseService.calculateAmountForPeriod(request.getId()));
        model.addAttribute("allCategoryOfExpense", categoryOfExpenseService.getAll());
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
        model.addAttribute("period", periodService.findById(request.getId()));
        return "addIncomePage";
    }

    @GetMapping("/goToAddAnExpectedIncome")
    public String goToAddExpectedIncome(@ModelAttribute("periodId") IdRequest request, Model model) {
        model.addAttribute("periodId", request.getId());
        model.addAttribute("period", periodService.findById(request.getId()));
        return "addExpectedIncomePage";
    }

    @GetMapping("/goToExpenseCategory")
    public String goToCategory(@ModelAttribute("periodId") IdRequest periodId,
                               @ModelAttribute("categoryId") IdRequestForCategory categoryId,
                               Model model) {
        model.addAttribute("period", periodService.findById(periodId.getId()));
        model.addAttribute("category", categoryOfExpenseService.findById(categoryId.getCategoryId()));
        model.addAttribute("allExpenses",
                expenseService.getAllForCategory(periodId.getId(), categoryId.getCategoryId()));
        model.addAttribute("amountForCategory", statsService.amountExpenseForCategory(categoryId.getCategoryId(), periodId.getId()));
        return "categoryExpensePage";
    }

    @GetMapping("/planing")
    public String startPlaning(@ModelAttribute("periodId") IdRequest periodId, Model model) {
        PeriodResponse period = periodService.findById(periodId.getId());
        model.addAttribute("period", period);
        model.addAttribute("allExpectedIncomesForPeriod",
                expectedIncomeService.getAllForPeriod(periodId.getId()));
        model.addAttribute("allExpectedExpenses", expectedExpenseService.getAllForPeriod(periodId.getId()));
        model.addAttribute("allCategoryOfExpense", categoryOfExpenseService.getAll());
        return "planingPage";
    }


    @GetMapping("/goToAddAnExpectedExpense")
    public String goToAddAnExpectedExpense(@ModelAttribute("periodId") IdRequest period, Model model) {
        model.addAttribute("periodIdd", period.getId());
        model.addAttribute("period", periodService.findById(period.getId()));
        model.addAttribute("allCategoryOfExpense", categoryOfExpenseService.getAll());
        return "addExpectedExpensePage";
    }

    @GetMapping("/goToAddAnExpense")
    public String goToAddAnExpense(@ModelAttribute("periodId") IdRequest period, Model model) {
        model.addAttribute("periodIdd", period.getId());
        model.addAttribute("period", periodService.findById(period.getId()));
        model.addAttribute("allCategoryOfExpense", categoryOfExpenseService.getAll());
        return "addExpensePage";
    }


    @PostMapping("/addAnExpectedIncome")
    public String addExpectedIncome(@ModelAttribute("periodId") ExpectedIncomeRequest request, Model model) {
        expectedIncomeService.addIncome(request);
        model.addAttribute("periodId", request.getPeriodId());
        model.addAttribute("allExpectedIncomesForPeriod",
                expectedIncomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allIncomesForPeriod", incomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("period", periodService.findById(request.getPeriodId()));
        model.addAttribute("allExpenses", expenseService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allExpectedExpenses", expectedExpenseService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allCategoryOfExpense", categoryOfExpenseService.getAll());
        return "planingPage";
    }

    @PostMapping("/addAnIncome")
    public String addIncome(@ModelAttribute("periodId") IncomeRequest request, Model model) {
        incomeService.addIncome(request);
        model.addAttribute("periodId", request.getPeriodId());
        model.addAttribute("allExpectedIncomesForPeriod",
                expectedIncomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allIncomesForPeriod", incomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("period", periodService.findById(request.getPeriodId()));
        model.addAttribute("allExpenses", expenseService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allExpectedExpenses", expectedExpenseService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allCategoryOfExpense", categoryOfExpenseService.getAll());
        model.addAttribute("amountIncomeForPeriod", incomeService.calculateAmountForPeriod(request.getPeriodId()));
        model.addAttribute("amountExpenseForPeriod", expenseService.calculateAmountForPeriod(request.getPeriodId()));
        return "periodPage";
    }

    @PostMapping("/addAnExpectedExpense")
    public String addExpense(@ModelAttribute("expectedExpenseRequest") ExpectedExpenseRequest request, Model model) {
        expectedExpenseService.add(request);
        model.addAttribute("periodId", request.getPeriodId());
        model.addAttribute("allExpectedIncomesForPeriod",
                expectedIncomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allIncomesForPeriod", incomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("period", periodService.findById(request.getPeriodId()));
        model.addAttribute("allExpectedExpenses", expectedExpenseService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allCategoryOfExpense", categoryOfExpenseService.getAll());
        return "periodPage";
    }

    @PostMapping("/addAnExpense")
    public String addExpense(@ModelAttribute("ExpenseRequest") ExpenseRequest request, Model model) {
        expenseService.add(request);
        model.addAttribute("periodId", request.getPeriodId());
        model.addAttribute("allExpectedIncomesForPeriod",
                expectedIncomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allIncomesForPeriod", incomeService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("period", periodService.findById(request.getPeriodId()));
        model.addAttribute("allExpenses", expenseService.getAllForPeriod(request.getPeriodId()));
        model.addAttribute("allCategoryOfExpense", categoryOfExpenseService.getAll());
        model.addAttribute("amountIncomeForPeriod", incomeService.calculateAmountForPeriod(request.getPeriodId()));
        model.addAttribute("amountExpenseForPeriod", expenseService.calculateAmountForPeriod(request.getPeriodId()));
        return "periodPage";
    }

}
