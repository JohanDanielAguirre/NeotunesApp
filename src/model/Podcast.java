package model;
import java.util.Calendar;
public class Podcast extends Audio {
	private String description;
	public Podcast(String name, String coverpage, double durationtime, int numberOfReproduction, String description){
		super(name, coverpage, durationtime, numberOfReproduction);
		this.description = description;
	}
	public String getdescription(){
		return description;
	}
	public void setdescription(String description){
		this.description = description;
	}
}