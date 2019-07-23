package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Actor {
	
	@Id
	@Column(name = "actor_id")
	private long actorId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	
	
	public Actor(long actorId, String firstName, String lastName) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public long getActorId() {
		return actorId;
	}
	public void setActorId(long actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
