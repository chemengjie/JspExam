package com.hand.entity;

public class Film extends language_identity{
	private Long film_id;
	private String title;
	private String description;
	
	public Long getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Long film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + "]";
	}
}
