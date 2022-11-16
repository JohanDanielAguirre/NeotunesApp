package model;
import java.util.Calendar;
public class  Consumer extends User{
	private double songtimereproduced;
	private double podcasttimereproduced;
	private String mostlistenpodcastuser;
	private String mostlistensonguser;
	private String mostlistenpodcast;
	private String mostlistensong;
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
}