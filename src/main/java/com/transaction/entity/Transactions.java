package com.transaction.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transactions {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionid;
	
	@Column(name="accountnum")
    private Long accountnum;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="transdate")
	private Date transdate;
	
	@Column(name="transtype")
	private String transtype;

	public Long getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}

	public Long getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(Long accountnum) {
		this.accountnum = accountnum;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTransdate() {
		return transdate;
	}

	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

	public String getTranstype() {
		return transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	
	
}
