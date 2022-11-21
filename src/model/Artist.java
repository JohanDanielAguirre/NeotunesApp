package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Artist extends Producer {
	private ArrayList<Song> Createdsongs; 
	/**
	*name: Artist
	*builder of Artist
	*@param id a String will save de identifier of the artist
	*@param nickname String with the user name inside the platafform
	*@param name String will save the real name of the person
	*@param photo Srting will save the photo of the user
	*@param numvisualizations an int will save de number of visualizations of an Artist
	*@param vinculationdate is a calendar date will saev the exactly moment when the user will be register
	*/
	public Artist(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
		 this.Createdsongs= new ArrayList<Song>();
	}
	public ArrayList Createdsongs(){
		return Createdsongs;
	}
	/**
	*name: addsong
	*@param name a String will save de identifier of the Song
	*@param durationtime double  with the duration  of the song
	*@param album String will save the album  of the song
	*@param coverpage Srting will save the photo of the Song
	*@param numberOfReproduction an int will save de number of visualizations of a Song
	*@param value is a double  will save the exactly cost of the Song
	*@param unitsSold is a int will save the number of units sod
	*@param gender is the desicion to know what is the gender od the song
	*/
	public void addsong(String name,String coverpage,double durationtime,int numberOfReproduction,String album,double value,int unitssold,int category){
		Createdsongs.add(new Song(name,coverpage,durationtime,numberOfReproduction,album,value,unitssold,category));
	}
	/**
	*name: validatecreator
	*@param song is the song to be evaluated
	*@return comprobant a boolean will able to say is the creator or not
	*/
	public boolean validatecreator(Song song){
		boolean comprobant=false;
		for(int i=0;i<Createdsongs.size();i++){
			if(Createdsongs.get(i).getname().equalsIgnoreCase(song.getname())){
				comprobant=true;
			}
		}
		return comprobant;
	}
}