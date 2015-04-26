package com.hibernate.chap8;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="TESTSCHEMA")
public class Event {
	
	@Id
	@GeneratedValue
	private int eventId;
	private String eventName;
	
	/**
	 * since we pick one column from each, we provide join and inverse.
	 * Some case there might be more than one column, where we create an array of columns.
	 */
	@ManyToMany
	@JoinTable(schema="TESTSCHEMA", name="JOIN_DELEGATE_EVENT", joinColumns={@JoinColumn(name="eventId")},
	inverseJoinColumns={@JoinColumn(name="delegateId")})
	private List<Delegate> delegates = new ArrayList<Delegate>();
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public List<Delegate> getDelegates() {
		return delegates;
	}
	public void setDelegates(List<Delegate> delegates) {
		this.delegates = delegates;
	}

}
