package com.shivam.springboot.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.springboot.user.UsersEntity;
import com.shivam.springboot.user.UsersService;

@CrossOrigin("http://localhost:4200")
@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	UsersService usersService;

	@PostMapping("/createTransaction")
	public void createTransaction(@RequestBody TransactionDTO transactionDTO) {
		TransactionEntity transactionEntity = transactionDTO.getTransactionEntity();
		Optional<UsersEntity> optUsers = usersService.findUsersById(transactionDTO.getFromUserId());
		UsersEntity users = optUsers.get();
		transactionEntity.setUsers(users);
		transactionService.createTransaction(transactionEntity);
	}

	@GetMapping("/findTransactionById/{transactionId}")
	public Optional<TransactionEntity> findTransactionById(@PathVariable("transactionId") Long transactionId) {
		return transactionService.findTransactionById(transactionId);
	}

	@GetMapping("/findAllTransaction")
	public List<TransactionEntity> findAllTransaction() {
		return transactionService.findAllTransaction();
	}

	@PostMapping("/transferMoney")
	public boolean transferMoney(@RequestBody TransactionDTO transactionDTO) {
		boolean x = transactionService.transferMoney(transactionDTO.getFromUserId(), transactionDTO.getToUserId(), transactionDTO.getAmount());
		if (x == false)
			return false;
		else if (x == true) {
			createTransaction(transactionDTO);
		}
		return true;
	}
}
