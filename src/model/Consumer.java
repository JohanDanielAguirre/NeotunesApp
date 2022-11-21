package model;
import java.util.Calendar;
import java.util.ArrayList;
public abstract class  Consumer extends User{
	private double songtimereproduced;
	private double podcasttimereproduced;
	private String mostlistenpodcastuser;
	private String mostlistensonguser;
	private String mostlistenpodcast;
	private String mostlistensong;
	/**
	*name: Consumer
	*builder of Consumer
	*@param id a String will save de identifier of the artist
	*@param nickname String with the user name inside the platafform
	*@param podcasttimereproduced double will save the time  of the person wast watching podcast
	*@param songtimereproduced double will save the time  of the person wast earing	songs
	*@param mostlistenpodcastuser String will save the name  of the person user see more
	*@param mostlistensonguser String will save the name  of the person user see more
	*@param mostlistenpodcast String will save the name  of the podcast user see more
	*@param mostlistensong String will save the name  of the song user see more
	*@param vinculationdate is a calendar date will saev the exactly moment when the user will be register
	*/
	public Consumer(String id,String nickname,double podcasttimereproduced,double songtimereproduced,String mostlistenpodcastuser,String mostlistensonguser,String mostlistenpodcast,String mostlistensong,Calendar vinculationdate){
		super(id,nickname,vinculationdate);
		this.podcasttimereproduced=podcasttimereproduced;
		this.songtimereproduced=songtimereproduced;
		this.mostlistenpodcastuser=mostlistenpodcastuser;
		this.mostlistensonguser=mostlistensonguser;
		this.mostlistenpodcast=mostlistenpodcast;
		this.mostlistensong=mostlistensong;
	}
	public double getsongtimereproduced(){
		return songtimereproduced;
	}	
	public void setsongtimereproduced(double songtimereproduced){
		this.songtimereproduced = songtimereproduced;
	}
	public double getpodcasttimereproduced(){
		return podcasttimereproduced;
	}
	public void setpodcasttimereproduced(double podcasttimereproduced){
		this.podcasttimereproduced = podcasttimereproduced;
	}
	public String getmostlistenpodcastuser(){
		return mostlistenpodcastuser;
	}
	public void setmostlistenpodcastuser(String mostlistenpodcastuser){
		this.mostlistenpodcastuser = mostlistenpodcastuser;
	}
	public String getmostlistensonguser(){
		return mostlistensonguser;
	}
	
	public void setmostlistensonguser(String mostlistensonguser){
		this.mostlistensonguser = mostlistensonguser;
	}
	public String getmostlistenpodcast(){
		return mostlistenpodcast;
	}
	public void setmostlistenpodcast(String mostlistenpodcast){
		this.mostlistenpodcast = mostlistenpodcast;
	}
	public String getmostlistensong(){
		return mostlistensong;
	}
	public void setmostlistensong(String mostlistensong){
		this.mostlistensong = mostlistensong;
	}
	public abstract String addReproductionlists(String listname,int listcode);
	public abstract String showlists();
	public abstract void addaudiostoReproductionlists(int listselected,Song newsong);
	public abstract void addaudiostoReproductionlists(int listselected,Podcast newpodcast);
	public abstract String showaudiostoReproductionlists(int selection);
	public abstract void deleteaudiostoReproductionlists(int listselected,int numberofaudiotodelete);
}