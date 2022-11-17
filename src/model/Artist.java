package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Artist extends Producer {
	private ArrayList<Song> Createdsongs; 
	public Artist(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
		 this.Createdsongs= new ArrayList<Song>();
	}
	public void addsong(String name,String coverpage,double durationtime,int numberOfReproduction,String album,double value,int unitssold){
		Createdsongs.add(new Song(name,coverpage,durationtime,numberOfReproduction,album,value,unitssold));
	}
}