package model;
import java.util.Calendar;
public class Song extends Audio {
	private String album;
	private double value;
	private int unitsSold;
	private MusicGender genderofmusic;
	/**
	*name: Song
	*builder of Song
	*@param name a String will save de identifier of the Song
	*@param durationtime double  with the duration  of the song
	*@param album String will save the album  of the song
	*@param coverpage Srting will save the photo of the Song
	*@param numberOfReproduction an int will save de number of visualizations of a Song
	*@param value is a double  will save the exactly cost of the Song
	*@param unitsSold is a int will save the number of units sod
	*@param gender is the desicion to know what is the gender od the song
	*/
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