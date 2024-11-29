package com.transaction.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.transaction.BankAccountClient;
import com.transaction.dto.BankAccountDTO;
import com.transaction.dto.BankTransactionsDTO;
import com.transaction.entity.Transactions;
import com.transaction.repo.BankTransactionRepository;
import com.transaction.service.BankTransactionsService;

import jakarta.transaction.Transactional;

@Service
public class BankTransactionServiceImpl implements BankTransactionsService {

	@Autowired
    private ModelMapper mapper;
	
	@Autowired(required = true)
	private BankAccountClient bankAccountClient;
	@Autowired
	private BankTransactionRepository transactionRepository;
	
	@Override
	@Transactional
	public void withdrawFromAccount(BankTransactionsDTO transactionDTO) {
		ResponseEntity<BankAccountDTO> bankAccount = bankAccountClient.getAccount(transactionDTO.getAccountNum());
		BankAccountDTO bankAccountDTO = bankAccount.getBody();
		if(bankAccount.getBody() == null) {
			transactionDTO.setStatus("Invalid Account");
		} else if (transactionDTO.getAmount() > bankAccountDTO.getAmount()){
			transactionDTO.setStatus("Insufficient Funds");
		} else {
			bankAccountDTO.setAmount(bankAccountDTO.getAmount() - transactionDTO.getAmount());
			bankAccountClient.updateaccount(bankAccountDTO);
			Transactions transaction = mapper.map(transactionDTO, Transactions.class);
			transactionRepository.save(transaction);
		}
	}

	@Override
	@Transactional
	public void accountTransfer(BankTransactionsDTO transactionDTO) {
		ResponseEntity<BankAccountDTO> bankAccount = bankAccountClient.getAccount(transactionDTO.getAccountNum());
		BankAccountDTO bankAccountDTO = bankAccount.getBody();
		if(bankAccount.getBody() == null) {
			transactionDTO.setStatus("Invalid Account");
		} else {
			bankAccountDTO.setAmount(bankAccountDTO.getAmount() + transactionDTO.getAmount());
			bankAccountClient.updateaccount(bankAccountDTO);
			Transactions transaction = mapper.map(transactionDTO, Transactions.class);
			transactionRepository.save(transaction);
		}
	}

	@Override
	public List<BankTransactionsDTO> getTransactionsHistory(Long accountNum) {
		List<Transactions> transactions = transactionRepository.getTransactions(accountNum);
		List<BankTransactionsDTO> bankTransactionsDTOs = new ArrayList();;
		for (Transactions  transaction: transactions) {
            BankTransactionsDTO bankTransactionsDTO = mapper.map(transaction, BankTransactionsDTO.class);
            bankTransactionsDTOs.add(bankTransactionsDTO);
        }
		return bankTransactionsDTOs;
	}

}
