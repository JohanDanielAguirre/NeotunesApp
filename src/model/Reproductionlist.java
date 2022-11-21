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
	
	public int determinatematrix(int [][] code){
		//resultado = Integer.parseInt(res);
		String number1="";
		int determinate=0,a=0,b=0;
		for(int i=0;i<Saveaudio.size();i++){
			if(Saveaudio.get(i) instanceof Song){
				a=1;
			}else{
				b=1;
			}
		}
		if(a==1 && b==1){
			for (int i = code.length -1; i >= 0; i--) {
				for (int j = code.length -1; j >= 0 ; j--) {
					if (((i + j) % 2 != 0) && ((i + j) > 1)) {
						number1=number1+String.valueOf(code[i][j]);
					}
				}
			}	
		}else if(a==1){
			for(int i=code[0].length-1; i>-1;i--){
				number1=number1+String.valueOf(code[i][0]);
			}for(int i=1; i<5;i++){
				number1=number1+String.valueOf(code[i][i]);
			}for(int i=code[0].length-1;i>-1;i--){
				number1=number1+String.valueOf(code[i][5]);
			}
		}else if(b==1){
			for (int j=0;j<code.length-4;j++) { 
				number1=number1+String.valueOf(code[0][j]);
			}
			for (int i=0; i<code.length;i++) { 
				number1=number1+String.valueOf(code[i][2]);
			}
			for (int i=0;code.length>i; i++) { 
				number1=number1+String.valueOf(code[i-1][3]);
			}
			for (int j=code.length -2; j<code.length; j++ ) { 
				number1=number1+String.valueOf(code[0][j]);
			}
		}
		determinate=Integer.parseInt(number1);
		this.code=determinate;
		return determinate;
	}
}