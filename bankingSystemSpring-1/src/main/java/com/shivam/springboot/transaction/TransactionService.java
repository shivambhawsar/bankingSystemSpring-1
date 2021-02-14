package com.shivam.springboot.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.springboot.user.UsersEntity;
import com.shivam.springboot.user.UsersService;

@Service
public class TransactionService {

	@Autowired
	private UsersService usersService;

	@Autowired
	private TransactionRepository transactionRepository;

	public void createTransaction(TransactionEntity transactionEntity) {
		transactionRepository.save(transactionEntity);
	}

	public Optional<TransactionEntity> findTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId);
	}

	public List<TransactionEntity> findAllTransaction() {
		return transactionRepository.findAll();
	}

	public boolean transferMoney(Long fromUserId, Long toUserId, Long amount) {
		Optional<UsersEntity> fromUser = usersService.findUsersById(fromUserId);
		UsersEntity frmUser = fromUser.get();
		if (frmUser.getBalance() < amount)
			return false;
		else {
			Optional<UsersEntity> toUser = usersService.findUsersById(toUserId);
			UsersEntity tUser = toUser.get();
			frmUser.setBalance(frmUser.getBalance() - amount);
			tUser.setBalance(tUser.getBalance() + amount);
		}
		return true;
	}
}
