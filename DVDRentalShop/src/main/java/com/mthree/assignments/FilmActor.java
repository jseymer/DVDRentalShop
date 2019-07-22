package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Film_Actor")
public class FilmActor {
	
	@Id
	@Column(name = "Actor_ID")
	private long actorID;
	
	@Column(name = "Film_ID")
	private long filmID;
	
	public FilmActor(long actorID, long filmID) {
		this.setActorID(actorID);
		this.setFilmID(filmID);
	}

	public long getActorID() {
		return actorID;
	}

	public void setActorID(long actorID) {
		this.actorID = actorID;
	}

	public long getFilmID() {
		return filmID;
	}

	public void setFilmID(long filmID) {
		this.filmID = filmID;
	}

}
