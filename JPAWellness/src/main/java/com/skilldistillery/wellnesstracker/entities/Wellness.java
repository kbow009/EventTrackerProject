package com.skilldistillery.wellnesstracker.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wellness {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	

	private String activity;
	
	@Column(name="self_care_minutes")
	private Integer minutes;

	
	

	private String notes;

	@Column(name = "mood_before")
	private String moodBefore;

	@Column(name = "mood_after")
	private String moodAfter;
	private LocalDate date;

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wellness other = (Wellness) obj;
		return id == other.id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public Integer getMinutes() {
		return minutes;
	}


	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}


	


	
	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getMoodBefore() {
		return moodBefore;
	}


	public void setMoodBefore(String moodBefore) {
		this.moodBefore = moodBefore;
	}


	public String getMoodAfter() {
		return moodAfter;
	}


	public void setMoodAfter(String moodAfter) {
		this.moodAfter = moodAfter;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Wellness() {
		super();
	}


	@Override
	public String toString() {
		return "Wellness [id=" + id + ", activity=" + activity + ", minutes=" + minutes + ", notes=" + notes
				+ ", moodBefore=" + moodBefore + ", moodAfter=" + moodAfter + ", date=" + date + "]";
	}
}
	