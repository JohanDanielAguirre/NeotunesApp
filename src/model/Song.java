package model;
import java.util.Calendar;
public class Song extends Audio {
	private String album;
	private double value;
	private int unitsSold;
	public Song(String name, String coverpage, double durationtime, int numberOfReproduction, String album, double value, int unitsSold){
		super(name, coverpage, durationtime, numberOfReproduction);
		this.album = album;
		this.value = value;
		this.unitsSold = unitsSold;
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