package model;
import java.util.Calendar;
public class Audio {
	private String name;
	private String coverpage;
	private double durationtime;
	private int numberOfReproduction;
	public Audio(String name, String coverpage, double durationtime, int numberOfReproduction){
		this.name = name;
		this.coverpage = coverpage;
		this.durationtime = durationtime;
		this.numberOfReproduction = numberOfReproduction;
	}
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
	public String getcoverpage(){
		return coverpage;
	}
	public void setcoverpage(String coverpage){
		this.coverpage = coverpage;
	}
	public double getdurationtime(){
		return durationtime;
	}
	public void setdurationtime(double durationtime){
		this.durationtime = durationtime;
	}
	public int getnumberOfReproduction(){
		return numberOfReproduction;
	}
	public void setnumberOfReproduction(int numberOfReproduction){
		this.numberOfReproduction = numberOfReproduction;
	}
}