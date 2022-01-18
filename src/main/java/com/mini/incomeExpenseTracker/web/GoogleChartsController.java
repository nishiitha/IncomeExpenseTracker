package com.mini.incomeExpenseTracker.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mini.incomeExpenseTracker.entities.Expense;
import com.mini.incomeExpenseTracker.entities.Income;
import com.mini.incomeExpenseTracker.repositories.ExpenseRepository;
import com.mini.incomeExpenseTracker.repositories.IncomeRepository;



@Controller
public class GoogleChartsController {
	
	@Autowired
	private ExpenseRepository expensesRepository;
	
	@Autowired
	private IncomeRepository incomeRepository;
	
    @GetMapping("/expenseChart")
    public String getPieChartexpense(Model model,Principal principal) {
        Map<String, Double> graphData = new TreeMap<>();
        
        String usermail=principal.getName();
        List<Expense> exp=new ArrayList<Expense>();
		exp=expensesRepository.specific(usermail);
		//System.out.println(exp.size());
		 for(int i=0;i<exp.size();i++)
		 {
			 Double x=exp.get(i).getExpenditure();
			 Double y=0.0;
			 if(graphData.containsKey(exp.get(i).getName()))
			 {
				 y=graphData.get(exp.get(i).getName());
			 }
			 graphData.put(exp.get(i).getName(), x+y);
			 
		 }
        model.addAttribute("chartData", graphData);
        return "google-charts";
    }
    @GetMapping("/incomeChart")
    public String getPieChartincome(Model model,Principal principal) {
        Map<String, Double> graphData = new TreeMap<>();
        
        String usermail=principal.getName();
        List<Income> exp=new ArrayList<Income>();
		exp=incomeRepository.incomeforChart(usermail);
		 for(int i=0;i<exp.size();i++)
		 {
			 Double x=exp.get(i).getIncome();
			 Double y=0.0;
			 if(graphData.containsKey(exp.get(i).getIname()))
			 {
				 y=graphData.get(exp.get(i).getIname());
			 }
			 graphData.put(exp.get(i).getIname(), x+y);
			 
		 }
        model.addAttribute("chartData", graphData);
        return "incomeChart";
    }
}
