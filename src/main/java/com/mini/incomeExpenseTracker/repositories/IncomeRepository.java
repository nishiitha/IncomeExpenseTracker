package com.mini.incomeExpenseTracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mini.incomeExpenseTracker.entities.Income;


public interface IncomeRepository extends JpaRepository<Income, Integer>{

	List<Income> findByUsermail(String usermail);

	
	@Query("SELECT SUM(e.income) FROM Income e WHERE MONTH(e.datee)=?1 and e.usermail=?2")
	String getMonthInc(Integer monthNum, String usermail);

	@Query("SELECT e FROM Income e WHERE MONTH(e.datee)=?1 and e.usermail=?2")
	List<Income> getMonthlyIncome(Integer monthName, String usermail);
	
	@Query("SELECT e FROM Income e where e.usermail=:user")
	List<Income> incomeforChart(@Param("user") String user);

}
