package model;
import java.util.Calendar;
public class Premium extends Consumer implements Buyable, Reproductionable{
	
	public Premium(String id,String nickname,double podcasttimereproduced,double songtimereproduced,String mostlistenpodcastuser,String mostlistensonguser,String mostlistenpodcast,String mostlistensong,Calendar vinculationdate){
		super(id,nickname, podcasttimereproduced, songtimereproduced, mostlistenpodcastuser, mostlistensonguser, mostlistenpodcast, mostlistensong, vinculationdate);
	}
	public String buysong(){
		String a="";
		return a;
	}
	public String reproduction(){
		String a="";
		return a;
	}
	
}