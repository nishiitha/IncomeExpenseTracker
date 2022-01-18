package com.mini.incomeExpenseTracker.web;

import java.security.Principal;
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

import com.mini.incomeExpenseTracker.entities.Income;
import com.mini.incomeExpenseTracker.repositories.IncomeRepository;


@RestController
public class IncomeController {
	
	@Autowired
	public IncomeRepository incomeRepository;
	
	@RequestMapping(value="/addIncome",method=RequestMethod.POST)
	public Income addIncome(Principal principal,@RequestBody Income income)
	{
		income.setUsermail(principal.getName());
		return incomeRepository.save(income);
		
	}
	
	@GetMapping("/allIncomes")
	public List<Income> getAllIncome(Principal principal)
	{
		String usermail=principal.getName();
		return incomeRepository.findByUsermail(usermail);
	}

	@GetMapping("/income/{incomeId}")
	public Income getEmployee(@PathVariable("incomeId") Integer incomeId) {
		return incomeRepository.findById(incomeId).get();
	}
	@DeleteMapping("/income/{incomeId}")
	public String deleteIncome(@PathVariable("incomeId") Integer incomeId) {
		incomeRepository.deleteById(incomeId);
		return "Income Deleted";
	}

	@PostMapping("/income/{incomeId}")
	public Income updateIncome(@PathVariable("incomeId") Integer incomeId, @RequestBody Income income) {
		System.out.println("Hello");
		Income incomeFound = incomeRepository.findById(incomeId).get();
		incomeFound.setIncome(income.getIncome());
		incomeFound.setDatee(income.getDatee());
		return incomeRepository.save(incomeFound);
	}
	
	@GetMapping("/getMonthInc/{monthNum}")
	public String getMonthExp(@PathVariable("monthNum") Integer monthNum,Principal principal)
	{
		String usermail=principal.getName();
		return incomeRepository.getMonthInc(monthNum,usermail);
	}
	
	@GetMapping("/getMonthlyIncome/{monthName}")
	public List<Income> getMonthlyExpenses(@PathVariable("monthName") Integer monthName,Principal principal){
		System.out.println(principal.getName());
		String usermail=principal.getName();
		return incomeRepository.getMonthlyIncome(monthName,usermail);
		
	}
	
//	@GetMapping("/all")
//	public List<Income> getAllEmployee(Principal principal) {
//		String user=principal.getName();
//		return incomeRepository.findByUsermail(user);
//	}
//	
	

}