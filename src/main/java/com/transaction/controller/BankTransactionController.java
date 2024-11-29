package com.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.dto.BankTransactionsDTO;
import com.transaction.service.impl.BankTransactionServiceImpl;

@RestController
@RequestMapping("/transaction")
public class BankTransactionController {

	@Autowired
	BankTransactionServiceImpl transactionMgmtService;
	
	@PostMapping("/transfer")
	public void transfer(@RequestBody BankTransactionsDTO bankTransactionDTO) {
		transactionMgmtService.accountTransfer(bankTransactionDTO);
	}
	
	@PostMapping("/withdraw")
	public void withdraw(@RequestBody BankTransactionsDTO bankTransactionDTO) {
		transactionMgmtService.withdrawFromAccount(bankTransactionDTO);
	}
	
	@GetMapping("/history")
	public List<BankTransactionsDTO> getTransactionHistory(String accountNum){
		List<BankTransactionsDTO> bankTransactionsDTO = transactionMgmtService.getTransactionsHistory(Long.valueOf(accountNum));
		return bankTransactionsDTO;
	}
}
