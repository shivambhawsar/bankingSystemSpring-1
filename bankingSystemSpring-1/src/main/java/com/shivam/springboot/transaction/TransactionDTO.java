package com.shivam.springboot.transaction;

public class TransactionDTO {

	private Long transactionId;
	private Long toUserId;
	private Long amount;
	private Long fromUserId;

	public TransactionDTO(Long transactionId, Long toUserId, Long amount, Long fromUserId) {
		super();
		this.transactionId = transactionId;
		this.toUserId = toUserId;
		this.amount = amount;
		this.fromUserId = fromUserId;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public TransactionEntity getTransactionEntity() {
		TransactionEntity transactionEntity = new TransactionEntity(transactionId, toUserId, amount, null);
		return transactionEntity;
	}

	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", toUserId=" + toUserId + ", amount=" + amount
				+ ", fromUserId=" + fromUserId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((fromUserId == null) ? 0 : fromUserId.hashCode());
		result = prime * result + ((toUserId == null) ? 0 : toUserId.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
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
		TransactionDTO other = (TransactionDTO) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (fromUserId == null) {
			if (other.fromUserId != null)
				return false;
		} else if (!fromUserId.equals(other.fromUserId))
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
		return true;
	}

	
}
