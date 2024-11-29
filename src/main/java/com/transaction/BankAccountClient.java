package com.transaction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.transaction.dto.BankAccountDTO;

@FeignClient(name="bankaccount", url="http://localhost:8080", path="/account")
public interface BankAccountClient {

	@GetMapping("/Id/{id}")
	public ResponseEntity<BankAccountDTO> getAccount(@PathVariable("id") Long id);
	
	@PutMapping("/update")
	public void updateaccount(@RequestBody BankAccountDTO accountDTO);
}
