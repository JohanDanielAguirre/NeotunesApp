package model;
import java.util.Calendar;
import java.util.ArrayList;
public class Premium extends Consumer implements Buyable, Reproductionable{
	private ArrayList<Reproductionlist> Createdlist; 
	private ArrayList<Artist> songuser;
	private ArrayList<CreatorContent> podcastuser;
	private ArrayList<Song> songreproduced;
	private ArrayList<Podcast> podcastreproduced;
	public Premium(String id,String nickname,double podcasttimereproduced,double songtimereproduced,String mostlistenpodcastuser,String mostlistensonguser,String mostlistenpodcast,String mostlistensong,Calendar vinculationdate){
		super(id,nickname, podcasttimereproduced, songtimereproduced, mostlistenpodcastuser, mostlistensonguser, mostlistenpodcast, mostlistensong, vinculationdate);
		this.Createdlist= new ArrayList<Reproductionlist>();
		this.songuser=new ArrayList<Artist>();
		this.podcastuser=new ArrayList<CreatorContent>();
		this.songreproduced=new ArrayList<Song>();
		this.podcastreproduced=new ArrayList<Podcast>();
	}
	public ArrayList getCreatedlist(){
		return Createdlist;
	}
	public String buysong(){
		String a="";
		return a;
	}
	public String reproductionpodcast(Podcast podcast,CreatorContent creator){
		double d=0;
		int a=0,b=0;
		d=(double)super.getpodcasttimereproduced()+podcast.getdurationtime();
		super.setpodcasttimereproduced(d);
		podcastuser.add(creator);
		podcastreproduced.add(podcast);
		for(int r=0;r<podcastreproduced.size();r++){
			if(podcast.equals(podcastreproduced.get(r))){
				a++;
			}
		}
		super.setmostlistenpodcast(podcast.getname());
		for(int i=0;i<podcastreproduced.size();i++){
			b=0;
			for(int j=0;j<podcastreproduced.size();j++){
				if(podcastreproduced.get(i).equals(podcastreproduced.get(j))){
					b++;
				}
				if(b>a){
					super.setmostlistenpodcast(podcastreproduced.get(i).getname());
				}
			}
		}
		a=0;b=0;
		for(int r=0;r<podcastuser.size();r++){
			if(creator.equals(podcastuser.get(r))){
				a++;
			}
		}
		super.setmostlistenpodcastuser(creator.getname());
		for(int i=0;i<podcastuser.size();i++){
			b=0;
			for(int j=0;j<podcastuser.size();j++){
				if(podcastuser.get(i).equals(podcastuser.get(j))){
					b++;
				}
				if(b>a){
					super.setmostlistenpodcastuser(podcastuser.get(i).getname());
				}
			}
		}
		String message="reproduciendo podcast.....";
		return message;
	}
	public String reproductionsong(Song song,Artist creator	){
		double d=0;
		int a=0,b=0;
		d=(double)super.getsongtimereproduced()+song.getdurationtime();
		super.setsongtimereproduced(d);
		songuser.add(creator);
		songreproduced.add(song);
		for(int r=0;r<songreproduced.size();r++){
			if(song.equals(songreproduced.get(r))){
				a++;
			}
		}
		super.setmostlistensong(song.getname());
		for(int i=0;i<songreproduced.size();i++){
			b=0;
			for(int j=0;j<songreproduced.size();j++){
				if(songreproduced.get(i).equals(songreproduced.get(j))){
					b++;
				}
				if(b>a){
					super.setmostlistensong(songreproduced.get(i).getname());
				}
			}
		}
		a=0;b=0;
		for(int r=0;r<podcastuser.size();r++){
			if(creator.equals(podcastuser.get(r))){
				a++;
			}
		}
		super.setmostlistensonguser(creator.getname());
		for(int i=0;i<songuser.size();i++){
			b=0;
			for(int j=0;j<songuser.size();j++){
				if(songuser.get(i).equals(songuser.get(j))){
					b++;
				}
				if(b>a){
					super.setmostlistensonguser(songuser.get(i).getname());
				}
			}
		}
		String message="reproduciendo cancion......";
		return message;
	}
	public String addReproductionlists(String listname,int listcode){
		String message="la lista de reproduccion fue registrada correctamente";
		Createdlist.add(new Reproductionlist(listname,listcode));
		return message;
	}
	public void addaudiostoReproductionlists(int listselected,Song newsong){
		Createdlist.get(listselected).createAudio(newsong);
	}
	public void addaudiostoReproductionlists(int listselected,Podcast newpodcast){
		Createdlist.get(listselected).createAudio(newpodcast);
	}
	public  String showlists(){
		String message="",nameoflist="";
		for(int i=0;i<Createdlist.size();i++){
			nameoflist=Createdlist.get(i).getname();
			message=message+i+" "+nameoflist+"\n";
		}
		return message;
	}
	public String showaudiostoReproductionlists(int selection){
		String message="";
		message=Createdlist.get(selection).showaudios();
		return message;
	}
	public void deleteaudiostoReproductionlists(int listselected,int numberofaudiotodelete){
		Createdlist.get(listselected).removeaudio(numberofaudiotodelete);
	}
	
}