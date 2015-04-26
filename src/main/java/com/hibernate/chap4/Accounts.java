package com.hibernate.chap4;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Composite keys. Copy composite key fields into new class
 * mark it as serializable and a constructor.
 * @author lokesh
 *
 */

@Entity
@Table(name="accounts", schema="TESTSCHEMA")
public class Accounts {
	/*private int accountId;
	private int userId;*/

	//annotate the ref class as @Id
	@Id
	private CompoundKey compoundKey;
	private int accountBalance;
	public CompoundKey getCompoundKey() {
		return compoundKey;
	}
	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}



}
