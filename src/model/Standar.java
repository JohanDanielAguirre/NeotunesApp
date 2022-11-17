package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Standar extends Consumer implements Buyable, Reproductionable{
	private int buyedsongs;
	private int albumscreated;
	private ArrayList<Reproductionlist> Createdlist; 
	public Standar(String id,String nickname,double podcasttimereproduced,double songtimereproduced,String mostlistenpodcastuser,String mostlistensonguser,String mostlistenpodcast,String mostlistensong,Calendar vinculationdate, int buyedsongs, int albumscreated){
		super(id,nickname, podcasttimereproduced, songtimereproduced, mostlistenpodcastuser, mostlistensonguser, mostlistenpodcast, mostlistensong, vinculationdate);
		this.buyedsongs = buyedsongs;
		this.albumscreated = albumscreated;
		this.Createdlist= new ArrayList<Reproductionlist>();
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
	public String addReproductionlists(String listname,int listcode){
		message="la lista de reproduccion no fue registrada correctamente dado que se le acabaron las listas de reproduccion disponibles";
		if(albumscreated>-1){
			albumscreated=albumscreated-1;
			Createdlist.add(new Reproductionlist(listname,listcode));
			message="la lista de reproduccion fue registrada correctamente";
		}
		return message;
	}
}
