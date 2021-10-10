package com.skilldistillery.wellnesstracker.entities;

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
	
	@Column(name="time_in_mintues")
	private int timeInMinutes;
	
	@Column(name="time_hours")
	private int timeInHours;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="video_url")
	private String videoUrl;
	
	private String notes;
	
	@Column(name="mood_before")
	private String moodBefore;
	
	@Column(name="mood_after")
	private String moodAfter;
	
	@Column(name="activity_day")
	private int activityDay;
	
	@Column(name="activity_month")
	private int activityMonth;
	
	@Column(name="activity_year")
	private int activityYear;
	
	
	
	public Wellness() {
		super();
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
	public int getTimeInMinutes() {
		return timeInMinutes;
	}

	public void setTimeInMinutes(int timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}

	public int getTimeInHours() {
		return timeInHours;
	}

	public void setTimeInHours(int timeInHours) {
		this.timeInHours = timeInHours;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
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

	public int getActivityDay() {
		return activityDay;
	}

	public void setActivityDay(int activityDay) {
		this.activityDay = activityDay;
	}

	public int getActivityMonth() {
		return activityMonth;
	}

	public void setActivityMonth(int activityMonth) {
		this.activityMonth = activityMonth;
	}

	public int getActivityYear() {
		return activityYear;
	}

	public void setActivityYear(int activityYear) {
		this.activityYear = activityYear;
	}


	@Override
	public String toString() {
		return "Wellness [id=" + id + ", activity=" + activity + ", timeInMinutes=" + timeInMinutes + ", timeInHours="
				+ timeInHours + ", imageUrl=" + imageUrl + ", videoUrl=" + videoUrl + ", notes=" + notes
				+ ", moodBefore=" + moodBefore + ", moodAfter=" + moodAfter + ", activityDay=" + activityDay
				+ ", activityMonth=" + activityMonth + ", activityYear=" + activityYear + "]";
	}

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
	
}
