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
				 users.add(new Standar(id,nickname,podcasttimereproduced,songtimereproduced,mostlistenpodcastuser,mostlistensonguser,mostlistenpodcast,mostlistensong,vinculationdate,0,0,0));
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
	public String addcontent(String nameuser,String name,String coverpage,double durationtime,int numberOfReproduction,String album,double value,int unitssold,int category){
		String message="no se pudo registrar la cancion por que el usuario no existe";
			for(int i=0;i<users.size();i++){
			if(users.get(i) instanceof Artist && searchuser(nameuser,users.get(i).getid())){
				Artist user= (Artist)users.get(i);
				audiocollection.add(new Song(name,coverpage,durationtime,numberOfReproduction,album,value,unitssold,category));
				message="la cancion fue registrada correctamente";
				user.addsong(name,coverpage,durationtime,numberOfReproduction,album,value,unitssold,category);
			}
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
	public String addcontent(String nameuser,String name,String coverpage,double durationtime,int numberOfReproduction,String description,int category){
		String message="no se pudo registrar el podcast por que el usuario no existe";
		for(int i=0;i<users.size();i++){
			if(users.get(i) instanceof CreatorContent && searchuser(nameuser,users.get(i).getid())){
				CreatorContent user= (CreatorContent)users.get(i);
				audiocollection.add(new Podcast(name,coverpage,durationtime,numberOfReproduction,description,category));
				message="el podcast fue registrada correctamente";
				user.addpodcast(name,coverpage,durationtime,numberOfReproduction,description,category);
			}
		}
		return message;
	}
	public String addreproductionlist(String listname,String usernickname,int listcode){
		String message="no se pudo registrar la lista de reproduccion por que el usuario es productor";
		for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(usernickname)){
				Consumer user=(Consumer) users.get(i);
				message=user.addReproductionlists(listname,listcode);
			}
		}
		return message;
	}
	
	public String showlists(String nickname){
		String message="";
		for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user=(Consumer) users.get(i);
				message=user.showlists();
			}		
		}
		return message;
	}
	public String showaudios(){
		String message="";
		for(int i=0;i<audiocollection.size();i++){
			message=message + i+audiocollection.get(i).getname()+ "\n";
		}
		return message;
	}
	public String addAudiostoreproductionlits(int listselected,int position,String nickname){
		String message="audio adicionado correctamente";
		if(audiocollection.get(position)!=null){
			if(audiocollection.get(position) instanceof Song){
				Song newsong= (Song) audiocollection.get(position);	
				for(int i=0;i<users.size();i++){
					if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
						Consumer user=(Consumer) users.get(i);
						user.addaudiostoReproductionlists(listselected,newsong);
					}		
				}
			}else{
				Podcast newpodcast= (Podcast) audiocollection.get(position);
				for(int i=0;i<users.size();i++){
					if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
						Consumer user=(Consumer) users.get(i);
						user.addaudiostoReproductionlists(listselected,newpodcast);
					}
				}
			}
		}
		return message;
	}
	public String showaudiosinalist(String nickname, int selection){
		String message="";
		for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user=(Consumer) users.get(i);
				message=user.showaudiostoReproductionlists(selection);
			}
		}
		return message;
	}
	public String removeAudiostoreproductionlits(int listselected,int position,String nickname){
		String message="audio removido correctamente";
		for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user=(Consumer) users.get(i);
				user.deleteaudiostoReproductionlists(listselected,position);
			}
		}
		return message;
	}
	public String sponsor(String nickname,int audionumber){
		String message="";
		for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user=(Consumer) users.get(i);
				if(user instanceof Standar){
					Standar userp=(Standar) user;
					if(audiocollection.get(audionumber) instanceof Song && (userp.getnumberofsongsreproduced()%2)==0){
						message=userp.generatesponsor();
					}
					if(audiocollection.get(audionumber) instanceof Podcast){
						message=userp.generatesponsor();
					}
				}
			}
		}
		return message;
	}
	public String reproduce(String nickname,int audionumber){
		String message="",nameofcreator="";
		boolean comprobant=false;
		for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user=(Consumer) users.get(i);
				if(user instanceof Premium){
					Premium novouser=(Premium) user;
					if(audiocollection.get(audionumber) instanceof Song){
						Song song= (Song)audiocollection.get(audionumber);
						for (int k=0;k<users.size() && comprobant;k++){
							if(users.get(k) instanceof Artist){
								Artist creator=(Artist) users.get(k);
								if(creator.validatecreator(song)){
									comprobant=true;
									message=novouser.reproductionsong(song,creator);
								}
							}
							
						}
						
					}else{
						Podcast podcast=(Podcast)audiocollection.get(audionumber);
						for (int k=0;k<users.size() && comprobant;k++){
							if(users.get(k) instanceof CreatorContent){
								CreatorContent creator=(CreatorContent) users.get(k);
								if(creator.validatecreator(podcast)){
									comprobant=true;
									message=novouser.reproductionpodcast(podcast,creator);
								}
							}
						}
							
					}
						
				}else{
					Standar novouser=(Standar) user;
					if(audiocollection.get(audionumber) instanceof Song){
						Song song= (Song)audiocollection.get(audionumber);
						for (int k=0;k<users.size() && comprobant;k++){
							if(users.get(k) instanceof Artist){
								Artist creator=(Artist) users.get(k);
								if(creator.validatecreator(song)){
									comprobant=true;
									message=novouser.reproductionsong(song,creator);
								}
							}
							
						}
						
					}else{
						Podcast podcast=(Podcast)audiocollection.get(audionumber);
						for (int k=0;k<users.size() && comprobant;k++){
							if(users.get(k) instanceof CreatorContent){
								CreatorContent creator=(CreatorContent) users.get(k);
								if(creator.validatecreator(podcast)){
									comprobant=true;
									message=novouser.reproductionpodcast(podcast,creator);
								}
							}
							
						}
						
					}
				}
			}
		}
		return message;
	} 
	public double timesponsor(String nickname,double numberofsponsor){
		if (numberofsponsor!=0){
			for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user=(Consumer) users.get(i);
				if(user instanceof Standar){
					Standar novouser=(Standar) user;
						numberofsponsor=novouser.timesponsors(numberofsponsor);
					}
				}
			}
		}
		return numberofsponsor;
	}
	public String sharematrix(int [][]matrix){
		String message="";
		int a=0;
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0; j<matrix[i].length;j++){
				a=(int)Math.random()*10;
				matrix[i][j] =a;
			}
		}	
		for (int i = 0; i < matrix.length; i++) { 
            for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]>10){
					message=(matrix[i][j] + " "+"/n");
				}else{
					message=(" "+matrix[i][j] + " "+"/n");
				}
            }
          
        }
		return message;
	
	}
	public int sharelist(int listselected,String nickname,int [][]codification){
		int message=0;
		for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user=(Consumer) users.get(i);
				if(user instanceof Standar){
					Standar novouser=(Standar) user;
					Reproductionlist repo=(Reproductionlist) novouser.getCreatedlist().get(listselected);
					 message=repo.determinatematrix(codification);
				}else{
					Premium novouser=(Premium) user;
					Reproductionlist repo=(Reproductionlist) novouser.getCreatedlist().get(listselected);
					message= repo.determinatematrix(codification);
				}
			}
		}
		return message;
	}
	public String buysong(int audionumber,String nickname){
		String message="";
		boolean comprobant=false;
		for(int i=0;i<users.size();i++){
			if(users.get(i).getnickname().equalsIgnoreCase(nickname)){
				comprobant=true;
				if(users.get(i) instanceof Premium){
					Premium user=(Premium)users.get(i);
					if(audiocollection.get(audionumber) instanceof Song){
						Song song=(Song)audiocollection.get(audionumber);
						message=user.buysong(song);
					}else{
						message="no se pueden comprar podcast";
					}
				}else{
					Standar user=(Standar)users.get(i);
					if(audiocollection.get(audionumber) instanceof Song){
					Song song=(Song)audiocollection.get(audionumber);
					message=user.buysong(song);
					}else{
						message="no se pueden comprar podcast";
					}
				}
				
			}
		}
		return message;
	}
}