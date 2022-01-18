package com.mini.incomeExpenseTracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping({"/","/login"})
	public String login() {
		return "login";
	}

	@GetMapping({"/index_main"})
	public String home() {
		return "index_main";
	}
	@GetMapping("/addExpense")
	public String addExpense() {
		return "addExpense";
	}
	
	@GetMapping("/viewExpenses")
	public String viewExpenses()
	{
		return "viewExpenses";
	}
	
	@GetMapping("/drawCharts")
	public String drawCharts() {
		return "drawCharts";
	}
	
	@GetMapping("/layout-sidenav-light")
	public String layoutSideNavLightPage() {
		return "layout-sidenav-light";
	}
	
	@GetMapping("/addIncome")
	public String addIncome()
	{
		return "addIncome";
	}
	@GetMapping("/viewIncome")
		public String allIncomes() {
		return "viewIncome";
	}
	@GetMapping("/monthwise")
	public String monthwise() {
		return "monthwise";
	}
	@GetMapping("/monthwiseIncome")
	public String monthwiseIncome() {
		return "monthwiseIncome";
	}
}