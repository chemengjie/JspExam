package com.hand.entity;

import java.sql.Date;

public class City {
	private Long city_id;
	private String city;
	private Long country_id;
	private Date last_update;
	public Long getCity_id() {
		return city_id;
	}
	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getCountry_id() {
		return country_id;
	}
	public void setCountry_id(Long country_id) {
		this.country_id = country_id;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", country_id=" + country_id + ", last_update=" + last_update + "]";
	}
}
