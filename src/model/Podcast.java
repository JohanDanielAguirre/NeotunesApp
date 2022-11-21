package model;
import java.util.Calendar;
public class Podcast extends Audio {
	private String description;
	private PodcastCategory category;
	/**
	*name: Song
	*builder of Song
	*@param name a String will save de identifier of the Podcast
	*@param durationtime double  with the duration  of the Podcast
	*@param album String will save the album  of the Podcast
	*@param coverpage Srting will save the photo of the Podcast
	*@param numberOfReproduction an int will save de number of visualizations of a Podcast
	*@param description is a String  will save a description about the content of the podcast
	*@param categoryselected is the desicion to know what is the category of the Podcast
	*/
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