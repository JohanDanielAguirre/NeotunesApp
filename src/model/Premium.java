package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Premium extends Consumer implements Buyable, Reproductionable{
	private ArrayList<Reproductionlist> Createdlist; 
	public Premium(String id,String nickname,double podcasttimereproduced,double songtimereproduced,String mostlistenpodcastuser,String mostlistensonguser,String mostlistenpodcast,String mostlistensong,Calendar vinculationdate){
		super(id,nickname, podcasttimereproduced, songtimereproduced, mostlistenpodcastuser, mostlistensonguser, mostlistenpodcast, mostlistensong, vinculationdate);
		this.Createdlist= new ArrayList<Reproductionlist>();
	}
	public String buysong(){
		String a="";
		return a;
	}
	public String reproduction(){
		String a="";
		return a;
	}
	public String addReproductionlists(String listname,int listcode){
		message="la lista de reproduccion fue registrada correctamente";
		Createdlist.add(new Reproductionlist(listname,listcode));
		return message;
	}
}