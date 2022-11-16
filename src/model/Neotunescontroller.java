package model;
import java.util.ArrayList;
import java.util.Calendar; 
public class Neotunescontroller{
	//relations
	private ArrayList<Audio> audiocollection; 
	private ArrayList<User> users;
	//methods
	/**
	*name:NeotunesController <br> 
	* builder of NeotunesController<br>
	* <b> post:</b> a NeotunesController object will be created<br>
	*/
	public Neotunescontroller(){
	 this.audiocollection= new ArrayList<Audio>();
	 this.users= new ArrayList<User>();
	}
	/**
	*<b>name:</b> adduser<br>
	*  adds a consumer user to the user arraylist <br> 
	* <b> pre: </b> consumer user data must be different from null<br> 
	* <b> post: </b> the consumer user  shall be registered and saved in a position of the arraylist.<br> 
	* @param nickname is a String data type that serves as the unique identifier (id) of the user.
	* @return a message of the positive method result if it was recorded negative if it could not be recorded
	*/
	public String adduser(String id,String nickname,double podcasttimereproduced,double songtimereproduced,String mostlistenpodcastuser,String mostlistensonguser,String mostlistenpodcast,String mostlistensong,Calendar vinculationdate,int option){
		String message="";
		if(!searchuser(nickname,id)){
			if (option==1){
				 users.add(new Standar(id,nickname,podcasttimereproduced,songtimereproduced,mostlistenpodcastuser,mostlistensonguser,mostlistenpodcast,mostlistensong,vinculationdate,0,0));
			}else{
				 users.add(new Premium(id,nickname,podcasttimereproduced,songtimereproduced,mostlistenpodcastuser,mostlistensonguser,mostlistenpodcast,mostlistensong,vinculationdate));
			}
			message="el usuario fue registrado correctamente";
		}else{
			message="el usuario ya existe ";
		}
		return message;
	}
	
	/**
	*<b>name:</b> adduser<br>
	*  adds a consumer user to the user arraylist <br> 
	* <b> pre: </b> consumer user data must be different from null<br> 
	* <b> post: </b> the consumer user  shall be registered and saved in a position of the arraylist.<br> 
	* @param nickname is a String data type that serves as the unique identifier (id) of the user.
	* @return a message of the positive method result if it was recorded negative if it could not be recorded
	*/
	public String adduser(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate,int option){
		String message="";
		if(!searchuser(nickname,id)){
			if (option==1){
				 users.add(new Artist(id,nickname,name,photo,numvisualizations,vinculationdate));
			}else{
				 users.add(new CreatorContent(id,nickname,name,photo,numvisualizations,vinculationdate));
			}
			message="el usuario fue registrado correctamente";
		}else{
			message="el usuario ya existe ";
		}
		return message;
	}
	/**
	*<b>name:</b>searchuser<br> 
	* search if the user is repeated or not <br> 
	* <b> pre:</b> the player must exist<br> 
	* <b> post:</b> it will be determined whether the user is a repeat user or not. <br> 
	* @param nickname is a String that stores the id of the player that you want to know if it is repeated or not.
	* @return existuser will send a determination as to whether or not the player already exists. 
	*/
	public boolean searchuser(String nickname,String id){
	boolean existuser = false, comprobant=false; 
	for (int i=0; i<users.size() && !comprobant; i++){
			if(users.get(i).getnickname().equalsIgnoreCase(nickname) && users.get(i).getid().equalsIgnoreCase(id)){
				existuser=true;
				comprobant=true;
			}
	}
	return existuser;
	}
	/**
	*<b>name:</b> adduser<br>
	*  adds a consumer user to the user arraylist <br> 
	* <b> pre: </b> consumer user data must be different from null<br> 
	* <b> post: </b> the consumer user  shall be registered and saved in a position of the arraylist.<br> 
	* @param nickname is a String data type that serves as the unique identifier (id) of the user.
	* @return a message of the positive method result if it was recorded negative if it could not be recorded
	*/
	public String addcontent(String nameuser,String name,String coverpage,double durationtime,int numberOfReproduction,String album,double value,int unitssold){
		String message="";
			audiocollection.add(new Song(name,coverpage,durationtime,numberOfReproduction,album,value,unitssold));
			message="la cancion fue registrada correctamente";
		return message;
	}
	/**
	*<b>name:</b> adduser<br>
	*  adds a consumer user to the user arraylist <br> 
	* <b> pre: </b> consumer user data must be different from null<br> 
	* <b> post: </b> the consumer user  shall be registered and saved in a position of the arraylist.<br> 
	* @param nickname is a String data type that serves as the unique identifier (id) of the user.
	* @return a message of the positive method result if it was recorded negative if it could not be recorded
	*/
	public String addcontent(String nameuser,String name,String coverpage,double durationtime,int numberOfReproduction,String description){
		String message="";
			audiocollection.add(new Podcast(name,coverpage,durationtime,numberOfReproduction,description));
			message="el podcast fue registrada correctamente";
		return message;
	}
}