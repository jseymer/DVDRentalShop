package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Language")
public class Language {
	
	@Id
	@Column(name = "language_id")
	private long LangId;
	@Column(name = "name")
	private String name;
	
	
	public Language(long langId, String name) {
		super();
		LangId = langId;
		this.name = name;
	}
	public long getLangId() {
		return LangId;
	}
	public void setLangId(long langId) {
		LangId = langId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Language: " + this.getName();
	}

}
