package com.mini.incomeExpenseTracker.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expenseTBL")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expenseId;
	private Double expenditure;
	private String name;
	private Date datee;
	private String usermail;
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	public Double getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(Double expenditure) {
		this.expenditure = expenditure;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDatee() {
		return datee;
	}
	public void setDatee(Date datee) {
		this.datee = datee;
	}
	public Expense() {
		
	}
	public Expense(Integer expenseId, Double expenditure, String name, Date datee, String usermail) {
		super();
		this.expenseId = expenseId;
		this.expenditure = expenditure;
		this.name = name;
		this.datee = datee;
		this.usermail = usermail;
	}
	public Expense(Double expenditure, Date datee) {
		super();
		
		this.expenditure = expenditure;
		
		this.datee = datee;
		
	}
	
	
}