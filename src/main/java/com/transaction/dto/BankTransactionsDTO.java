package com.transaction.dto;

import java.util.Date;

public class BankTransactionsDTO {
	
	private String transactionNumber;
    private Long accountNum;
	private Double amount;
	private Date transDate;
	private String transType;
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

}
