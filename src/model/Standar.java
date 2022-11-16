package model;
import java.util.Calendar;
public class Standar extends Consumer implements Buyable, Reproductionable{
	private int buyedsongs;
	private int albumscreated;
	public Standar(String id,String nickname,double podcasttimereproduced,double songtimereproduced,String mostlistenpodcastuser,String mostlistensonguser,String mostlistenpodcast,String mostlistensong,Calendar vinculationdate, int buyedsongs, int albumscreated){
		super(id,nickname, podcasttimereproduced, songtimereproduced, mostlistenpodcastuser, mostlistensonguser, mostlistenpodcast, mostlistensong, vinculationdate);
		this.buyedsongs = buyedsongs;
		this.albumscreated = albumscreated;
	}
	public String buysong(){
		String  a="";
		return a;
	}
	public String reproduction(){
		String a="";
		return a;
	}
	public int getbuyedsongs(){
		return buyedsongs;
	}
	public int getalbumscreated(){
		return albumscreated;
	}
	public void setalbumscreated(int albumscreated){
		this.albumscreated = albumscreated;
	}
	public void setbuyeysongs(int buyedsongs){
		this.buyedsongs = buyedsongs;
	}
}
