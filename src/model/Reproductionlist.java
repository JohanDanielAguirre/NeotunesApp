package model;
import java.util.ArrayList;
public class Reproductionlist{
	private String name;
	private int code;
	private ArrayList<Audio> Saveaudio;
	/**
	*name: Reproductionlist <br>
	*builder of Reproductionlist<br>
	*@param name is a String that will be in charge of keeping the name of the list
	*@param code is an int that will be in charge of kepping the unique code to share the list
	* <b> post:</b> a Reproductionlist object will be created<br>
	*/
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
	/**
	*name: createAudio<br>
	*@param podcast the a podcast object to be added to the list
	*<b>pre:</b> the podcast will be exist
	*<b>post:</b> a podcast will be added to the list
	*/
	public void createAudio(Podcast podcast){
		Saveaudio.add(podcast);
	}
	/**
	*name: createAudio<br>
	*@param song the a song object to be added to the list
	*<b>pre:</b> the song will be exist
	*<b>post:</b> a song will be added to the list
	*/
	public void createAudio(Song song){
		Saveaudio.add(song);
	}
	/**
	*name: showaudios
	*<b>post:</b> a text will be deploy
	*@return message a String will save the message of the audio
	*/
	public String showaudios(){
		String message="",nameofaudio="";
		for(int i=0;i<Saveaudio.size();i++){
			nameofaudio=Saveaudio.get(i).getname();
			message=message+i+" "+nameofaudio+"\n";
		}
		return message;
	}
	/**
	*name: removeaudio
	*/
	public void removeaudio(int audioselected){
		Saveaudio.remove(audioselected);
	}
	/**
	*name: determinatematrix
	*@param code is the matrix to which the code will be generated.
	*@return determinaet a int with the respective code
	*/
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