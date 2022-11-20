package model;
import java.util.Calendar;
import java.util.ArrayList;
public class CreatorContent extends Producer {
	private ArrayList<Podcast> CreatedPodcast; 
	public CreatorContent(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
		this.CreatedPodcast= new ArrayList<Podcast>();
	}
	public void addpodcast(String name,String coverpage,double durationtime,int numberOfReproduction,String description, int category){
		CreatedPodcast.add(new Podcast(name,coverpage,durationtime,numberOfReproduction,description,category));
	}
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