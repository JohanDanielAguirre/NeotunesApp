package model;
import java.util.Calendar;
public class Song extends Audio {
	private String album;
	private double value;
	private int unitsSold;
	private MusicGender genderofmusic;
	public Song(String name, String coverpage, double durationtime, int numberOfReproduction, String album, double value, int unitsSold,int gender){
		super(name, coverpage, durationtime, numberOfReproduction);
		this.album = album;
		this.value = value;
		this.unitsSold = unitsSold;
		switch(gender){
			case 1:genderofmusic=MusicGender.ROCK;
			break;
			case 2:genderofmusic=MusicGender.POP;
			break;
			case 3:genderofmusic=MusicGender.TRAP;
			break;
			case 4:genderofmusic=MusicGender.HOUSE;
			break;
		}
	}
	public MusicGender getgenderofmusic(){
		return genderofmusic;
	}
	public String getalbum(){
		return album;
	}
	public void setalbum(String album){
		this.album = album;
	}
	public double getvalue(){
		return value;
	}
	public void setvalue(double value){
		this.value = value;
	}
	public int getunitsSold(){
		return unitsSold;
	}
	public void setunitsSold(int unitsSold){
		this.unitsSold = unitsSold;
	}
}