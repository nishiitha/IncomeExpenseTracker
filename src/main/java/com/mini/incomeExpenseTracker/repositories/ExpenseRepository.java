package com.mini.incomeExpenseTracker.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mini.incomeExpenseTracker.entities.Expense;



public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

	
	List<Expense> findByUsermail(String usermail);

	
	@Query("SELECT SUM(e.expenditure) FROM Expense e where e.usermail=:user")
	int getSumExp(@Param("user") String user);


	@Query("SELECT SUM(e.expenditure) FROM Expense e WHERE MONTH(e.datee)=?1 and e.usermail=?2")
	String getMonthExp(Integer num,String user);


	
	@Query("SELECT e FROM Expense e WHERE MONTH(e.datee)=?1 and e.usermail=?2")
	List<Expense> getMonthlyExpenses(Integer monthN, String usermail);


	@Query("SELECT e FROM Expense e where e.usermail=:user")
	List<Expense> specific(@Param("user") String user);


//	@Query("SELECT e FROM Expense e")
//	List<Expense> getSumExp();

	

//	int getSum();

	
	

}
