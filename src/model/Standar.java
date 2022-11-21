package model;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class Standar extends Consumer implements Buyable, Reproductionable{
	private int buyedsongs;
	private int albumscreated;
	private int numberofsongsreproduced;
	private Sponsor sponsors;
	private ArrayList<Reproductionlist> Createdlist; 
	private ArrayList<Artist> songuser;
	private ArrayList<CreatorContent> podcastuser;
	private ArrayList<Song> songreproduced;
	private ArrayList<Podcast> podcastreproduced;
	private ArrayList <Song> buyedsong;
	private ArrayList <Calendar> dateofbuyedsong;
	/**
	*/
	public Standar(String id,String nickname,double podcasttimereproduced,double songtimereproduced,String mostlistenpodcastuser,String mostlistensonguser,String mostlistenpodcast,String mostlistensong,Calendar vinculationdate, int buyedsongs, int albumscreated,int numberofsongsreproduced){
		super(id,nickname, podcasttimereproduced, songtimereproduced, mostlistenpodcastuser, mostlistensonguser, mostlistenpodcast, mostlistensong, vinculationdate);
		this.buyedsongs = buyedsongs;
		this.albumscreated = albumscreated;
		this.numberofsongsreproduced=numberofsongsreproduced;
		this.Createdlist= new ArrayList<Reproductionlist>();
		this.songuser=new ArrayList<Artist>();
		this.podcastuser=new ArrayList<CreatorContent>();
		this.songreproduced=new ArrayList<Song>();
		this.podcastreproduced=new ArrayList<Podcast>();
		this.buyedsong=new ArrayList<Song>();
		this.dateofbuyedsong= new ArrayList<Calendar>();
	}
	public ArrayList getCreatedlist(){
		return Createdlist;
	}
	public String buysong(Song song){
		String a="cancion comprada correctamente";
		if(buyedsong.size()<101){
			buyedsong.add(song);
			dateofbuyedsong.add(Calendar.getInstance());
		}else{
			a="se supero el limite de canciones a comprar pasate por favor a premium pasar gozar de este y mas beneficios";
		}
		return a;
	}
	public String generatesponsor(){
		String message="";
		int a=0;
		a=(int)Math.random()*3+1;
		switch(a){
			case 1:message= Sponsor.NIKE.getbrand();
			break;
			case 2:message= Sponsor.COCACOLA.getbrand();
			break;
			case 3:message= Sponsor.MYMS.getbrand();
			break;
			default:message= Sponsor.PEPSICOLA.getbrand();
			break;
		}
		return message;
	}
	public double timesponsors(double sponsor){
		int number=0;
		number=(int) sponsor;
		switch(number){
			case 1:sponsor=Sponsor.NIKE.getduration();
			break;
			case 2:sponsor=Sponsor.COCACOLA.getduration();
			break;
			case 3:sponsor=Sponsor.MYMS.getduration();
			break;
			case 4:sponsor=Sponsor.PEPSICOLA.getduration();
			break;
		}
		return sponsor;
	}
	public String reproductionpodcast(Podcast podcast,CreatorContent creator){
		String message="reproduciendo podcast.....";
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
		return message;
	}
	
	public String reproductionsong(Song song,Artist creator){
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
	public int getnumberofsongsreproduced(){
		return numberofsongsreproduced;
	}
	public void setnumberofsongsreproduced(int numberofsongsreproduced){
		this.numberofsongsreproduced = numberofsongsreproduced;
	}
	public String addReproductionlists(String listname,int listcode){
		String message="la lista de reproduccion no fue registrada correctamente dado que se le acabaron las listas de reproduccion disponibles";
		if(albumscreated<=20){
			albumscreated=albumscreated+1;
			Createdlist.add(new Reproductionlist(listname,listcode));
			message="la lista de reproduccion fue registrada correctamente";
		}
		return message;
	}
	public  String showlists(){
		String message="",nameoflist="";
		for(int i=0;i<Createdlist.size();i++){
			nameoflist=Createdlist.get(i).getname();
			message=message+i+" "+nameoflist+"\n";
		}
		return message;
	}
	public void addaudiostoReproductionlists(int listselected,Song newsong){
		Createdlist.get(listselected).createAudio(newsong);
	}
	public void addaudiostoReproductionlists(int listselected,Podcast newpodcast){
		Createdlist.get(listselected).createAudio(newpodcast);
	}
	public String showaudiostoReproductionlists(int selection){
		String message="";
		message=Createdlist.get(selection).showaudios();
		return message;
	}
	public void deleteaudiostoReproductionlists(int listselected,int numberofaudiotodelete){
		Createdlist.get(listselected).removeaudio(numberofaudiotodelete);
	}
	/**
	*/
	public int listensongs(){
		int a=0;
		for(int u=0;u<songreproduced.size();u++){
			a++;
		}
		return a;
	}
	/**
	*/
	public int listenpodcast(){
		int a=0;
		for(int u=0;u<podcastreproduced.size();u++){
			a++;
		}
		return a;
	}
	/**
	*/
	public String gendermusic(){
		int a=0,b=0,c=0,d=0;
		String gender="";
		for(int u=0;u<songreproduced.size();u++){
			gender=songreproduced.get(u).getgenderofmusic().name();
			switch(gender){
				case "ROCK":
				a++;
				break;
				case "POP":
				b++;
				break;
				case "TRAP":
				c++;
				break;
				case "HOUSE":
				d++;
				break;
			}
		}
		if(a>b & a>c & a>d){
			gender="Rock";
		}else if(b>c & b>d){
			gender="Pop";
		}else if(c>d){
			gender="Trap";
		}else{
			gender="House";
		}
		return gender;
	}
	/**
	*/
	public String genderpodcast(){
		int a=0,b=0,c=0,d=0;
		String gender="";
		for(int u=0;u<podcastreproduced.size();u++){
			gender=podcastreproduced.get(u).getcategory().name();
			switch(gender){
				case "POLITICS":
				a++;
				break;
				case "ENTERTAIMENT":
				b++;
				break;
				case "VIDEOGAMES":
				c++;
				break;
				case "FASHION":
				d++;
				break;
			}
		}
		if(a>b & a>c & a>d){
			gender="Politics";
		}else if(b>c & b>d){
			gender="Entertaiment";
		}else if(c>d){
			gender="Videogames";
		}else{
			gender="Fashion";
		}
		return gender;
	}
	/**
	*/
	public int numbergendermusic(){
		int a=0,b=0,c=0,d=0,listencategory=0;
		String gender="";
		for(int u=0;u<songreproduced.size();u++){
			gender=songreproduced.get(u).getgenderofmusic().name();
			switch(gender){
				case "ROCK":
				a++;
				break;
				case "POP":
				b++;
				break;
				case "TRAP":
				c++;
				break;
				case "HOUSE":
				d++;
				break;
			}
		}
		if(a>b & a>c & a>d){
			listencategory=a;
		}else if(b>c & b>d){
			listencategory=b;
		}else if(c>d){
			listencategory=c;
		}else{
			listencategory=d;
		}
		return listencategory;
	}
	/**
	*/
	public int numbergenderpodcast(){
		int a=0,b=0,c=0,d=0,listencategory=0;
		String gender="";
		for(int u=0;u<podcastreproduced.size();u++){
			gender=podcastreproduced.get(u).getcategory().name();
			switch(gender){
				case "POLITICS":
				a++;
				break;
				case "ENTERTAIMENT":
				b++;
				break;
				case "VIDEOGAMES":
				c++;
				break;
				case "FASHION":
				d++;
				break;
			}
		}
		if(a>b & a>c & a>d){
			listencategory=a;
		}else if(b>c & b>d){
			listencategory=b;
		}else if(c>d){
			listencategory=c;
		}else{
			listencategory=d;
		}
		return listencategory;
	}
}
