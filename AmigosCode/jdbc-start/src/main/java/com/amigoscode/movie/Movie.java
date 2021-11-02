package com.amigoscode.movie;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.amigoscode.actor.Actor;

public class Movie {

	Integer id;
	String name;
	List<Actor> actors;
	LocalDate releaseDate;

	public Movie(Integer id, String name, List<Actor> actors, LocalDate releaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.actors = actors;
		this.releaseDate = releaseDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, id, name, releaseDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(releaseDate, other.releaseDate);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", actors=" + actors + ", releaseDate=" + releaseDate + "]";
	}

}
