package com.hibernate.chap4;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * compoundkey class, must implement 
 * serializable interface, embeddable and also has a constructor
 * @author lokesh
 *
 */
@Embeddable
public class CompoundKey implements Serializable{
	
	private int accountId;
	private int userId;
	
	CompoundKey(int userId, int accountId){
		this.userId=userId;
		this.accountId = accountId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
