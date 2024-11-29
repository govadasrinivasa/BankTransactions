package com.transaction.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.transaction.entity.Transactions;

@Repository
public interface BankTransactionRepository extends JpaRepository<Transactions, Long> {

	@Query(
	        nativeQuery = true,
	        value
			="SELECT amount, accountnum, transactionid, transdate, transtype from transactions where accountnum=:accountNum")
	       List<Transactions> getTransactions(@Param("accountNum") Long accountNum);
}
