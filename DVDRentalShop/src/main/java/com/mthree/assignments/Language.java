package com.mthree.assignments;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Language")
public class Language {
	
	@Id
	@Column(name = "language_id")
	private long LangId;
	@Column(name = "name")
	private String name;
	
	@OneToMany
	@JoinColumn(name = "language")
	private List<Film> films = new ArrayList<>();
	
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
