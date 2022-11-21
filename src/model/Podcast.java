package model;
import java.util.Calendar;
public class Podcast extends Audio {
	private String description;
	private PodcastCategory category;
	public Podcast(String name, String coverpage, double durationtime, int numberOfReproduction, String description,int categoryselected){
		super(name, coverpage, durationtime, numberOfReproduction);
		this.description = description;
		switch(categoryselected){
			case 1:category=PodcastCategory.POLITICS;
			break;
			case 2:category=PodcastCategory.ENTERTAIMENT;
			break;
			case 3:category=PodcastCategory.VIDEOGAMES;
			break;
			case 4:category=PodcastCategory.FASHION;
			break;
		}
	}
	public PodcastCategory getcategory(){
		return category;
	}
	public String getdescription(){
		return description;
	}
	public void setdescription(String description){
		this.description = description;
	}
}