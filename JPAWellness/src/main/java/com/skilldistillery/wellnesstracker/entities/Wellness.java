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

	@Column(name = "self_care_minutes")
	private Integer durMins;

	@Column(name = "self_care_hours")
	private Integer durHours;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "video_url")
	private String videoUrl;

	private String notes;

	@Column(name = "mood_before")
	private String moodBefore;

	@Column(name = "mood_after")
	private String moodAfter;

	@Column(name = "activity_day")
	private Integer activityDay;

	@Column(name = "activity_month")
	private Integer activityMonth;

	@Column(name = "activity_year")
	private Integer activityYear;

	public Wellness() {
		super();
	}

	@Override
	public String toString() {
		return "Wellness [id=" + id + ", activity=" + activity + ", durMins=" + durMins + ", durHours=" + durHours
				+ ", imageUrl=" + imageUrl + ", videoUrl=" + videoUrl + ", notes=" + notes + ", moodBefore="
				+ moodBefore + ", moodAfter=" + moodAfter + ", activityDay=" + activityDay + ", activityMonth="
				+ activityMonth + ", activityYear=" + activityYear + "]";
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

	public int getDurMins() {
		return durMins;
	}

	public void setDurMins(int durMins) {
		this.durMins = durMins;
	}

	public int getDurHours() {
		return durHours;
	}

	public void setDurHours(int durHours) {
		this.durHours = durHours;
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
	public int hashCode() {
		return Objects.hash(activity, activityDay, activityMonth, activityYear, durHours, durMins, id, imageUrl,
				moodAfter, moodBefore, notes, videoUrl);
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
		return Objects.equals(activity, other.activity) && activityDay == other.activityDay
				&& activityMonth == other.activityMonth && activityYear == other.activityYear
				&& durHours == other.durHours && durMins == other.durMins && id == other.id
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(moodAfter, other.moodAfter)
				&& Objects.equals(moodBefore, other.moodBefore) && Objects.equals(notes, other.notes)
				&& Objects.equals(videoUrl, other.videoUrl);
	}
}