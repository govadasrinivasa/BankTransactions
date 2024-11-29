package com.transaction.dto;

public class BankAccountDTO {

	   private Long accountNum;
		private String name;
		private Double amount;
		
		
		public Long getAccountNum() {
			return accountNum;
		}
		public void setAccountNum(Long accountNum) {
			this.accountNum = accountNum;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		
		
}
