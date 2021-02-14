package com.shivam.springboot.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shivam.springboot.user.UsersEntity;

@Entity
public class TransactionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "transaction_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long transactionId;
	private Long toUserId;
	private Long amount;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "fromUserId", referencedColumnName = "userId")
	private UsersEntity users;

	
	public TransactionEntity() {
		super();
	}

	public TransactionEntity(Long transactionId, Long toUserId, Long amount, UsersEntity users) {
		super();
		this.transactionId = transactionId;
		this.toUserId = toUserId;
		this.amount = amount;
		this.users = users;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public UsersEntity getUsers() {
		return users;
	}

	public void setUsers(UsersEntity users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "TransactionEntity [transactionId=" + transactionId + ", toUserId="
				+ toUserId + ", amount=" + amount + ", users=" + users + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((toUserId == null) ? 0 : toUserId.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionEntity other = (TransactionEntity) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (toUserId == null) {
			if (other.toUserId != null)
				return false;
		} else if (!toUserId.equals(other.toUserId))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

}