package model;
import java.util.Calendar;
import java.util.ArrayList;
public class CreatorContent extends Producer {
	private ArrayList<Podcast> CreatedPodcast; 
	public CreatorContent(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
		this.CreatedPodcast= new ArrayList<Podcast>();
	}
	/**
	*name: addsong
	*@param name a String will save de identifier of the Song
	*@param durationtime double  with the duration  of the song
	*@param coverpage Srting will save the photo of the Song
	*@param numberOfReproduction an int will save de number of visualizations of a Song
	*@param  description is a Srting will save the description of the podcast
	*@param category is the desicion to know what is the category of the podcast
	*/
	public void addpodcast(String name,String coverpage,double durationtime,int numberOfReproduction,String description, int category){
		CreatedPodcast.add(new Podcast(name,coverpage,durationtime,numberOfReproduction,description,category));
	}
	/**
	*name: validatecreator
	*@param song is the song to be evaluated
	*@return comprobant a boolean will able to say is the creator or not
	*/
	public boolean validatecreator(Podcast podcast){
		boolean comprobant=false;
		for(int i=0;i<CreatedPodcast.size();i++){
			if(CreatedPodcast.get(i).getname().equalsIgnoreCase(podcast.getname())){
				comprobant=true;
			}
		}
		return comprobant;
	}
}