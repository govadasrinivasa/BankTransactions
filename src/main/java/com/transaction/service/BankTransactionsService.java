package com.transaction.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.transaction.dto.BankTransactionsDTO;

public interface BankTransactionsService {
	
	public void withdrawFromAccount(@RequestBody BankTransactionsDTO bankTransactionDTO);
	
	public void accountTransfer(@RequestBody BankTransactionsDTO bankTransactionDTO);
	
	public List<BankTransactionsDTO> getTransactionsHistory(Long accountNum);
	
}
