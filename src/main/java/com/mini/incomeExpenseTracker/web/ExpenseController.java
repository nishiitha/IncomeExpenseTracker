package com.mini.incomeExpenseTracker.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mini.incomeExpenseTracker.entities.Expense;
import com.mini.incomeExpenseTracker.repositories.ExpenseRepository;




@RestController
public class ExpenseController {
	@Autowired
	private ExpenseRepository expensesRepository;
	
	@RequestMapping(value="/saveExpenses",method=RequestMethod.POST)
	public Expense saveExpenses(Principal principal,@RequestBody Expense expense)
	{
		expense.setUsermail(principal.getName());
		return expensesRepository.save(expense);
	}
	
	@GetMapping("/expense/{expenseId}")
	public Expense getEmployee(@PathVariable("expenseId") Integer expenseId) {
			System.out.println("Hello");
		return expensesRepository.findById(expenseId).get();
	}
	
	@DeleteMapping("/expense/{expenseId}")
	public String deleteEmployee(@PathVariable("expenseId") Integer expenseId) {
		expensesRepository.deleteById(expenseId);
		return "Expense Deleted";
	}

	@PostMapping("/expense/{expenseId}")
	public Expense updateEmployee(@PathVariable("expenseId") Integer expenseId, @RequestBody Expense expense) {
		Expense expenseFound = expensesRepository.findById(expenseId).get();
		expenseFound.setExpenditure(expense.getExpenditure());
		//expenseFound.setName(expense.getName());
		expenseFound.setDatee(expense.getDatee());
		return expensesRepository.save(expenseFound);
	}	
//	@GetMapping("/barChart")
//	public String getAllExpense(Model model) {
//		List<String> nameList=getAllEmployee().stream().map(x->x.getName()).collect(Collectors.toList());
//		List<Double> expList=getAllEmployee().stream().map(x->x.getExpenditure()).collect(Collectors.toList());
//		model.addAttribute("name", nameList);
//		model.addAttribute("expenditure", expList);
//		return "barChart";
//	}
	

	
	@GetMapping("/getSumExp")
	public int getSumExp(Principal principal)
	{
//		System.out.println(principal.getName());
		String usermail=principal.getName();
		return expensesRepository.getSumExp(usermail);
	}
	
	@GetMapping("/getMonthExp/{monthNum}")
	public String getMonthExp(@PathVariable("monthNum") Integer monthNum,Principal principal)
	{
//		System.out.println(principal.getName());
		String usermail=principal.getName();
		return expensesRepository.getMonthExp(monthNum,usermail);
	}
	
	@GetMapping("/getMonthlyExpenses/{monthName}")
	public List<Expense> getMonthlyExpenses(@PathVariable("monthName") Integer monthName,Principal principal){
		String usermail=principal.getName();
		List<Expense> exp=new ArrayList<Expense>();
		 exp=expensesRepository.getMonthlyExpenses(monthName,usermail);
		 for(int i=0;i<exp.size();i++)
		 {
			 System.out.println(exp.get(i).getName());
		 }
		return expensesRepository.getMonthlyExpenses(monthName,usermail);
		
	}
	@GetMapping("/all")
	public List<Expense> getAllEmployee(Principal principal) {
		String user=principal.getName();
		return expensesRepository.findByUsermail(user);
	}
	@GetMapping("/specific")
	public List<Expense> specific(Principal principal){
		String user=principal.getName();
		new ArrayList<Expense>();
		// exp=expensesRepository.specific(user);
		return expensesRepository.specific(user);
		
	}
	
	 
	
}