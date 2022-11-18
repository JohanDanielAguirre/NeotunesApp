package model;
import java.util.ArrayList;
public class Reproductionlist{
	private String name;
	private int code;
	private ArrayList<Audio> Saveaudio; 
	public Reproductionlist(String name, int code){
		this.name=name;
		this.code=code;
		this.Saveaudio= new ArrayList<Audio>();
	}
	public String getname(){
		return name;
	}
	
	public void setname(String name){
		this.name = name;
	}
	public int getcode(){
		return code;
	}
	
	public void setcode(int code){
		this.code = code;
	}
	
	public int generateCode(){
		int a=0;
		return a;
	}
	public void createAudio(Podcast podcast){
		Saveaudio.add(podcast);
	}
	public void createAudio(Song song){
		Saveaudio.add(song);
	}
	public String showaudios(){
		String message="",nameofaudio="";
		for(int i=0;i<Saveaudio.size();i++){
			nameofaudio=Saveaudio.get(i).getname();
			message=message+i+" "+nameofaudio+"\n";
		}
		return message;
	}
	public void removeaudio(int audioselected){
		Saveaudio.remove(audioselected);
	}
}