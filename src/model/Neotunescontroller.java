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
	/**
	*name:addReproductionlists
	*@param list name is the name of the list will be created
	*@param usernickname is the nickname of the user will be associated the list
	*@param list code is the code of the list have utility in the time of share
	*@return message with confirmation
	*/
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
	/**
	*name: showlists
	*@param nickname the nickname of the user who wants to make the inquiry
	*@return message a String  with the information about all the playlist
	*/
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
	/**
	*name: showaudios
	*@return message a String  with the information about all the audios
	*/
	public String showaudios(){
		String message="";
		for(int i=0;i<audiocollection.size();i++){
			message=message + i+audiocollection.get(i).getname()+ "\n";
		}
		return message;
	}
	/**
	*name:addReproductionlists
	*@param list name is the name of the list will be selected
	*@param nickname is the nickname of the user will be associated the list
	*@param position is the code of the audio to be added
	*@return message with confirmation
	*/
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
	/**
	*name:showaudiosinalist
	*@param selection is the number of the audio will be selected
	*@param nickname is the nickname of the user will be associated the list
	*@return message with the audios in the list
	*/
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
	/**
	*name:removeAudiostoreproductionlits
	*@param position is the number of the audio will be selected
	*@param nickname is the nickname of the user will be associated the list
	*@param listselected is the number of the list will be remove an audio
	*@return message with the confirmation
	*/
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
	/**
	*name:sponsor
	*@param audionumber is the number of the audio will be selected
	*@param nickname is the nickname of the user will be associated the audio and the sponsors
	*@return message with the sponsor in the pertinent case
	*/
	public String sponsor(String nickname,int audionumber){
		String message="";
		for(int i=0;i<users.size();i++){
			if((!(users.get(i) instanceof Producer)) && users.get(i).getnickname().equalsIgnoreCase(nickname)){
				Consumer user=(Consumer) users.get(i);
				if(user instanceof Standar){
					Standar userp=(Standar) user;
					if(audiocollection.get(audionumber) instanceof Song && (userp.getnumberofsongsreproduced()%2)==0){
						message=userp.generatesponsor();
						userp.setnumberofsongsreproduced(userp.getnumberofsongsreproduced()+1);
					}
					if(audiocollection.get(audionumber) instanceof Podcast){
						message=userp.generatesponsor();
					}
				}
			}
		}
		return message;
	}
	/**
	*name:reproduce
	*@param audionumber is the number of the audio will be selected
	*@param nickname is the nickname of the user will be associated the audio and the sponsors
	*@return message with the sponsor in the pertinent case
	*/
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
	/**
	*name:timesponsor
	*@param numberofsponsor is the number of the sponsor will be selected
	*@param nickname is the nickname of the user will be associated with the sponsors
	*@return numberofsponsor with the time of the sponsor sponsor in the pertinent case
	*/
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
/**
	*name:sharematrix
	*@param matrix is the matrix to be determinate the code of the list
	*@return messagewith the matrix
	*/
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
	/**
	*name:sharelist
	*@param nickname is the nickname of the user will be associated the list
	*@param codification is the matrix with the code
	*@param listselected is the number of the list will be share
	*@return message with the final code
	*/
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
	/**
	*name:buysong
	*@param audionumber is the number of the audio will be sell
	*@param nickname is the nickname of the user will be associated the audio 
	*@return message with the confirmation
	*/
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
/**
	*name:generateinform
	*@param nickname is the nickname of the user will be inform
	*@return message with the inform
	*/
	public String generateinform(String nickname){
		String message="",gpodcast="",gsongs="",message2="",nametop1="",nametop2="",nametop3="",nametop4="",nametop5="";
		int rpodcast=0,rsongs=0,agm=0,bgm=0,cgm=0,dgm=0,apc=0,bpc=0,cpc=0,dpc=0,asongs=0,bsongs=0,csongs=0,dsongs=0,apodcast=0,bpodcast=0,cpodcast=0,dpodcast=0,mostAudio=0;
		int top1=0,top2=0,top3=0,top4=0,top5=0,a=0;
		ArrayList<Artist> artists=new ArrayList<Artist>();
		ArrayList<CreatorContent> creatorofcontent=new ArrayList<CreatorContent>();
		ArrayList<Song> songs=new ArrayList<Song>();
		ArrayList<Podcast> podcasts=new ArrayList<Podcast>();
		for(int i=0;i<users.size();i++){
			if(users.get(i) instanceof Consumer && users.get(i) instanceof Premium){
				Premium user=(Premium) users.get(i);
				rsongs=user.listensongs();
				rpodcast=user.listenpodcast();
			}else if(users.get(i) instanceof Consumer && users.get(i) instanceof Standar){
				Standar user=(Standar) users.get(i);
				rsongs=user.listensongs();
				rpodcast=user.listenpodcast();
			}
		}
		message=message+"el numero total de reproducciones son \n"
		+"para las canciones " + rsongs + " para los podcasts "+ rpodcast;
		message=" \n";
		for(int i=0;i<users.size();i++){
			if(users.get(i).getnickname().equalsIgnoreCase(nickname) && users.get(i) instanceof Consumer){
				if(users.get(i) instanceof Premium){
					Premium user=(Premium)users.get(i);
					message=message+"el usuario "+nickname+ " tiene como genero musical mas visto "+ user.gendermusic() + " y lo ha escuchado "+user.numbergendermusic() +" veces";
					message=message+"\n";
					message=message+"el usuario "+nickname+ " tiene como genero de podcast mas visto "+ user.genderpodcast() + " y lo ha escuchado "+user.numbergenderpodcast() +" veces";
					message=message+"\n";
				}else{
					Standar user=(Standar)users.get(i);
				}
			}
		}
		for(int i=0;i<users.size();i++){
			if(users.get(i) instanceof Consumer && users.get(i) instanceof Premium){
				Premium user=(Premium) users.get(i);
				gsongs=user.gendermusic();
				switch(gsongs){
					case "Rock":
					agm++;
					asongs=user.numbergendermusic();
					break;
					case "Pop":
					bgm++;
					bsongs=user.numbergendermusic();
					break;
					case "Trap":
					cgm++;
					csongs=user.numbergendermusic();
					break;
					case "House":
					dgm++;
					dsongs=user.numbergendermusic();
					break;
				}
				gpodcast=user.genderpodcast();
				switch(gsongs){
					case "Politics":
					apc++;
					apodcast=user.numbergenderpodcast();
					break;
					case "Entertaiment":
					bpc++;
					bpodcast=user.numbergenderpodcast();
					break;
					case "Videogames":
					cpc++;
					cpodcast=user.numbergenderpodcast();
					break;
					case "Fashion":
					dpc++;
					dpodcast=user.numbergenderpodcast();
					break;
				}
			}else if(users.get(i) instanceof Consumer && users.get(i) instanceof Standar){
				Standar user=(Standar) users.get(i);
				
				gsongs=user.gendermusic();
				switch(gsongs){
					case "Rock":
					agm++;
					asongs=user.numbergendermusic();
					break;
					case "Pop":
					bgm++;
					bsongs=user.numbergendermusic();
					break;
					case "Trap":
					cgm++;
					csongs=user.numbergendermusic();
					break;
					case "House":
					dgm++;
					dsongs=user.numbergendermusic();
					break;
				}	
				gpodcast=user.genderpodcast();
				switch(gpodcast){
					case "Politics":
					apc++;
					apodcast=user.numbergenderpodcast();
					break;
					case "Entertaiment":
					bpc++;
					bpodcast=user.numbergenderpodcast();
					break;
					case "Videogames":
					cpc++;
					cpodcast=user.numbergenderpodcast();
					break;
					case "Fashion":
					dpc++;
					dpodcast=user.numbergenderpodcast();
					break;
				}
			}
			if(users.get(i) instanceof Producer && users.get(i) instanceof Artist){
				artists.add((Artist)users.get(i));
			}else if(users.get(i) instanceof Producer && users.get(i) instanceof CreatorContent){
				creatorofcontent.add((CreatorContent)users.get(i));
			}
		}
		if(agm>bgm & agm>cgm & agm>dgm){
			gsongs="Rock";
		}else if(bgm>cgm & bgm>dgm){
			gsongs="Pop";
		}else if(cgm>dgm){
			gsongs="Trap";
		}else{
			gsongs="House";
		}
		if(asongs>bsongs & asongs>csongs & asongs>dsongs){
			mostAudio=asongs;
		}else if(bsongs>csongs & bsongs>dsongs){
			mostAudio=bsongs;
		}else if(csongs>dsongs){
			mostAudio=csongs;
		}else{
			mostAudio=dsongs;
		}
		message=message+"la categoria musical mas escuchada por los usuarios es "+gsongs +" y su cantidad de reproducciones es "+ mostAudio;
		message=message+ "\n";
		if(apc>bpc & apc>cpc & apc>dpc){
			gpodcast="Politics";
		}else if(bpc>cpc & bpc>dpc){
			gpodcast="Entertaiment";
		}else if(cpc>dpc){
			gpodcast="Videogames";
		}else{
			gpodcast="Fashion";
		}
		if(apodcast>bpodcast & apodcast>cpodcast & apodcast>dpodcast){
			mostAudio=apodcast;
		}else if(bpodcast>cpodcast & bpodcast>dpodcast){
			mostAudio=bpodcast;
		}else if(cpodcast>dpodcast){
			mostAudio=cpodcast;
		}else{
			mostAudio=dpodcast;
		}
		message=message+("la categoria musical mas escuchada por los usuarios es "+gpodcast +" y su cantidad de reproducciones es "+ mostAudio);
		message=message+"\n";
		message=message+"el top 5 de artistas esta compuesto por \n"
		+"";
		for(int i=0;i<users.size();i++){
			if(users.get(i) instanceof Premium){
				Premium user=(Premium) users.get(i);
				for(int r=0;r<user.getsonguser().size();r++){
					for(int p=0;p<user.getsonguser().size();p++){
						if(user.getsonguser().get(r).equals(user.getsonguser().get(p))){
							a++;
						}
					}
					if(a>top1){
						Artist artist=(Artist)user.getsonguser().get(r);
						
						top2=top1;
						nametop2=nametop1;
						top3=top2;
						nametop3=nametop2;
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top1=a;
						nametop1=artist.getname();
					}else if(a>top2){
						Artist artist=(Artist)user.getsonguser().get(r);
						
						top3=top2;
						nametop3=nametop2;
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top2=a;
						nametop2=artist.getname();
					}
					else if(a>top3){
						Artist artist=(Artist)user.getsonguser().get(r);
						
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top3=a;
						nametop3=artist.getname();
					}
					else if(a>top4){
						Artist artist=(Artist)user.getsonguser().get(r);
						
						top5=top4;
						nametop5=nametop4;
						top4=a;
						nametop4=artist.getname();
					}else if(a>top5){
						Artist artist=(Artist)user.getsonguser().get(r);
						top5=a;
						nametop5=artist.getname();
					}
					
				}
			}else if(users.get(i) instanceof Standar){
				Standar user=(Standar) users.get(i);
						for(int r=0;r<user.getsonguser().size();r++){
					for(int p=0;p<user.getsonguser().size();p++){
						if(user.getsonguser().get(r).equals(user.getsonguser().get(p))){
							a++;
						}
					}
					if(a>top1){
						Artist artist=(Artist)user.getsonguser().get(r);
						
						top2=top1;
						nametop2=nametop1;
						top3=top2;
						nametop3=nametop2;
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top1=a;
						nametop1=artist.getname();
					}else if(a>top2){
						Artist artist=(Artist)user.getsonguser().get(r);
						
						top3=top2;
						nametop3=nametop2;
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top2=a;
						nametop2=artist.getname();
					}
					else if(a>top3){
						Artist artist=(Artist)user.getsonguser().get(r);
						
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top3=a;
						nametop3=artist.getname();
					}
					else if(a>top4){
						Artist artist=(Artist)user.getsonguser().get(r);
						
						top5=top4;
						nametop5=nametop4;
						top4=a;
						nametop4=artist.getname();
					}else if(a>top5){
						Artist artist=(Artist)user.getsonguser().get(r);
						top5=a;
						nametop5=artist.getname();
					}
					
				}
			}
		}
		message=message+ "el top 5 de los mejores artistas es \n"
		+"top1:"+ nametop1+" con "+top1
		+"\n"
		+"top2:"+ nametop2+" con "+top2
		+"\n"
		+"top3:"+ nametop3+" con "+top3
		+"\n"
		+"top4:"+ nametop4+" con "+top4
		+"\n"
		+"top5:"+ nametop5+" con "+top5
		+"\n";
		
		for(int i=0;i<users.size();i++){
			if(users.get(i) instanceof Premium){
				Premium user=(Premium) users.get(i);
				for(int r=0;r<user.getpodcastuser().size();r++){
					for(int p=0;p<user.getpodcastuser().size();p++){
						if(user.getpodcastuser().get(r).equals(user.getpodcastuser().get(p))){
							a++;
						}
					}
					if(a>top1){
						CreatorContent artist=(CreatorContent)user.getpodcastuser().get(r);
						
						top2=top1;
						nametop2=nametop1;
						top3=top2;
						nametop3=nametop2;
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top1=a;
						nametop1=artist.getname();
					}else if(a>top2){
						CreatorContent artist=(CreatorContent)user.getpodcastuser().get(r);
						
						top3=top2;
						nametop3=nametop2;
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top2=a;
						nametop2=artist.getname();
					}
					else if(a>top3){
						CreatorContent artist=(CreatorContent)user.getpodcastuser().get(r);
						
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top3=a;
						nametop3=artist.getname();
					}
					else if(a>top4){
						CreatorContent artist=(CreatorContent)user.getpodcastuser().get(r);
						
						top5=top4;
						nametop5=nametop4;
						top4=a;
						nametop4=artist.getname();
					}else if(a>top5){
						CreatorContent artist=(CreatorContent)user.getpodcastuser().get(r);
						top5=a;
						nametop5=artist.getname();
					}
					
				}
			}else if(users.get(i) instanceof Standar){
				Standar user=(Standar) users.get(i);
						for(int r=0;r<user.getpodcastuser().size();r++){
					for(int p=0;p<user.getpodcastuser().size();p++){
						if(user.getpodcastuser().get(r).equals(user.getpodcastuser().get(p))){
							a++;
						}
					}
					if(a>top1){
						CreatorContent creator=(CreatorContent)user.getpodcastuser().get(r);
						
						top2=top1;
						nametop2=nametop1;
						top3=top2;
						nametop3=nametop2;
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top1=a;
						nametop1=creator.getname();
					}else if(a>top2){
						CreatorContent creator =(CreatorContent)user.getpodcastuser().get(r);
					
						top3=top2;
						nametop3=nametop2;
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
							top2=a;
						nametop2=creator.getname();
					}
					else if(a>top3){
						CreatorContent creator =(CreatorContent)user.getpodcastuser().get(r);
						
						top4=top3;
						nametop4=nametop3;
						top5=top4;
						nametop5=nametop4;
						top3=a;
						nametop3=creator.getname();
					}
					else if(a>top4){
						CreatorContent creator =(CreatorContent)user.getpodcastuser().get(r);
						top5=top4;
						nametop5=nametop4;
						top4=a;
						nametop4=creator.getname();
					}else if(a>top5){
						CreatorContent creator =(CreatorContent)user.getpodcastuser().get(r);
						top5=a;
						nametop5=creator.getname();
					}
					
				}
			}
		}
		message=message+"el top 5 de los mejores creadores de contenido  es \n"
		+"top1:"+ nametop1+" con "+top1
		+"\n"
		+"top2:"+ nametop2+" con "+top2
		+"\n"
		+"top3:"+ nametop3+" con "+top3
		+"\n"
		+"top4:"+ nametop4+" con "+top4
		+"\n"
		+"top5:"+ nametop5+" con "+top5
		+"\n";
		
		int top6=0,top7=0,top8=0,top9=0,top10=0;
		String nametop6="",nametop7="",nametop8="",nametop9="",nametop10="";
		String cat1="",cat2="",cat3="",cat4="",cat5="",cat6="",cat7="",cat8="",cat9="",cat10="";
		
		for(int i=0;i<users.size();i++){
			if(users.get(i) instanceof Premium){
				Premium user=(Premium) users.get(i);
			for(int r=0;r<user.getpodcastreproduced().size();r++){
					for(int p=0;p<user.getpodcastreproduced().size();p++){
						if(user.getpodcastreproduced().get(r).equals(user.getpodcastreproduced().get(p))){
							a++;
						}
					}
					if(a>top1){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						
						top2=top1;
						nametop2=nametop1;
						cat2=cat1;
						
						top3=top2;
						nametop3=nametop2;
						cat3=cat2;
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top1=a;
						cat1=art.getcategory().name();
						nametop1=art.getname();
					}else if(a>top2){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						
						top3=top2;
						nametop3=nametop2;
						cat3=cat2;
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top2=a;
						cat2=art.getcategory().name();
						nametop2=art.getname();
					}else if(a>top3){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top3=a;
						cat3=art.getcategory().name();
						nametop3=art.getname();
					}else if(a>top4){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top4=a;
						cat4=art.getcategory().name();
						nametop4=art.getname();
					}else if(a>top5){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top5=a;
						cat5=art.getcategory().name();
						nametop5=art.getname();
					}else if(a>top6){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top6=a;
						cat6=art.getcategory().name();
						nametop6=art.getname();
					}else if(a>top7){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top7=a;
						cat7=art.getcategory().name();
						nametop7=art.getname();
					}else if(a>top8){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top8=a;
						cat8=art.getcategory().name();
						nametop8=art.getname();
					}else if(a>top9){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top9=a;
						cat9=art.getcategory().name();
						nametop9=art.getname();
					}else if(a>top10){
						Podcast art=(Podcast)user.getpodcastreproduced().get(r);
						
						top10=a;
						cat10=art.getcategory().name();
						nametop10=art.getname();
					}
			else if(users.get(i) instanceof Standar){
				Standar userr=(Standar) users.get(i);
				for(int z=0;z<userr.getpodcastreproduced().size();r++){
					for(int p=0;p<userr.getpodcastreproduced().size();p++){
						if(user.getpodcastreproduced().get(z).equals(user.getpodcastreproduced().get(p))){
							a++;
						}
					}
						if(a>top1){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						
						top2=top1;
						nametop2=nametop1;
						cat2=cat1;
						
						top3=top2;
						nametop3=nametop2;
						cat3=cat2;
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top1=a;
						cat1=art.getcategory().name();
						nametop1=art.getname();
					}else if(a>top2){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						
						top3=top2;
						nametop3=nametop2;
						cat3=cat2;
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top2=a;
						cat2=art.getcategory().name();
						nametop2=art.getname();
					}
					else if(a>top3){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top3=a;
						cat3=art.getcategory().name();
						nametop3=art.getname();
					}
					else if(a>top4){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top4=a;
						cat4=art.getcategory().name();
						nametop4=art.getname();
					}else if(a>top5){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top5=a;
						cat5=art.getcategory().name();
						nametop5=art.getname();
					}else if(a>top6){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top6=a;
						cat6=art.getcategory().name();
						nametop6=art.getname();
					}else if(a>top7){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top7=a;
						cat7=art.getcategory().name();
						nametop7=art.getname();
					}
					
				else if(a>top8){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top8=a;
						cat8=art.getcategory().name();
						nametop8=art.getname();
					}else if(a>top9){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(r);
						
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top9=a;
						cat9=art.getcategory().name();
						nametop9=art.getname();
					}else if(a>top10){
						Podcast art=(Podcast)userr.getpodcastreproduced().get(z);
						
						top10=a;
						cat10=art.getcategory().name();
						nametop10=art.getname();
					}
				}
					
			}
	}	
			}
		}
		message=message+ "el top 10 de los mejores podcast  es \n"
		+"top1:"+ cat1 +" "+nametop1+" "+ top1
		+"\n"
		+"top2:"+ cat2 +" "+nametop2+" "+ top2
		+"\n"
		+"top3:"+ cat3 +" "+nametop3+" "+ top3
		+"\n"
		+"top4:"+ cat4 +" "+nametop4+" "+ top4
		+"\n"
		+"top5:"+ cat5 +" "+nametop5+" "+ top5
		+"\n"
		+"top6:"+ cat6 +" "+nametop6+" "+ top6
		+"\n"
		+"top7:"+ cat7 +" "+nametop7+" "+ top7
		+"\n"
		+"top8:"+ cat8 +" "+nametop8+" "+ top8
		+"\n"
		+"top9:"+ cat9 +" "+nametop9+" "+ top9
		+"\n"
		+"top10:"+ cat10 +" "+nametop10+" "+ top10
		+"\n";
		
		
		for(int i=0;i<users.size();i++){
			if(users.get(i) instanceof Premium){
				Premium user=(Premium) users.get(i);
			for(int r=0;r<user.getsongreproduced().size();r++){
					for(int p=0;p<user.getsongreproduced().size();p++){
						if(user.getsongreproduced().get(r).equals(user.getsongreproduced().get(p))){
							a++;
						}
					}
					if(a>top1){
						Song art=(Song)user.getsongreproduced().get(r);
						
						
						top2=top1;
						nametop2=nametop1;
						cat2=cat1;
						
						top3=top2;
						nametop3=nametop2;
						cat3=cat2;
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top1=a;
						cat1=art.getgenderofmusic().name();
						nametop1=art.getname();
					}else if(a>top2){
						Song art=(Song)user.getsongreproduced().get(r);
						
						
						top3=top2;
						nametop3=nametop2;
						cat3=cat2;
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top2=a;
						cat2=art.getgenderofmusic().name();
						nametop2=art.getname();
					}else if(a>top3){
						Song art=(Song)user.getsongreproduced().get(r);
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top3=a;
						cat3=art.getgenderofmusic().name();
						nametop3=art.getname();
					}else if(a>top4){
						Song art=(Song)user.getsongreproduced().get(r);
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top4=a;
						cat4=art.getgenderofmusic().name();
						nametop4=art.getname();
					}else if(a>top5){
						Song art=(Song)user.getsongreproduced().get(r);
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top5=a;
						cat5=art.getgenderofmusic().name();
						nametop5=art.getname();
					}else if(a>top6){
						Song art=(Song)user.getsongreproduced().get(r);
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top6=a;
						cat6=art.getgenderofmusic().name();
						nametop6=art.getname();
					}else if(a>top7){
						Song art=(Song)user.getsongreproduced().get(r);
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top7=a;
						cat7=art.getgenderofmusic().name();
						nametop7=art.getname();
					}else if(a>top8){
					Song art=(Song)user.getsongreproduced().get(r);
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top8=a;
						cat8=art.getgenderofmusic().name();
						nametop8=art.getname();
					}else if(a>top9){
						Song art=(Song)user.getsongreproduced().get(r);
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top9=a;
						cat9=art.getgenderofmusic().name();
						nametop9=art.getname();
					}else if(a>top10){
						Song art=(Song)user.getsongreproduced().get(r); 	
						top10=a;
						cat10=art.getgenderofmusic().name();
						nametop10=art.getname();
					}
			else if(users.get(i) instanceof Standar){
				Standar userr=(Standar) users.get(i);
				for(int z=0;z<userr.getsongreproduced().size();r++){
					for(int p=0;p<userr.getsongreproduced().size();p++){
						if(user.getsongreproduced().get(z).equals(user.getsongreproduced().get(p))){
							a++;
						}
					}
						if(a>top1){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						
						top2=top1;
						nametop2=nametop1;
						cat2=cat1;
						
						top3=top2;
						nametop3=nametop2;
						cat3=cat2;
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top1=a;
						cat1=art.getgenderofmusic().name();
						nametop1=art.getname();
					}else if(a>top2){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						
						top3=top2;
						nametop3=nametop2;
						cat3=cat2;
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top2=a;
						cat2=art.getgenderofmusic().name();
						nametop2=art.getname();
					}
					else if(a>top3){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						
						cat4=cat3;
						top4=top3;
						nametop4=nametop3;
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top3=a;
						cat3=art.getgenderofmusic().name();
						nametop3=art.getname();
					}
					else if(a>top4){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						
						cat5=cat4;
						top5=top4;
						nametop5=nametop4;
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top4=a;
						cat4=art.getgenderofmusic().name();
						nametop4=art.getname();
					}else if(a>top5){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						top6=top5;
						nametop6=nametop5;
						cat6=cat5;
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top5=a;
						cat5=art.getgenderofmusic().name();
						nametop5=art.getname();
					}else if(a>top6){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						
						top7=top6;
						nametop7=nametop6;
						cat7=cat6;
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top6=a;
						cat6=art.getgenderofmusic().name();
						nametop6=art.getname();
					}else if(a>top7){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						
						cat8=cat7;
						top8=top7;
						nametop8=nametop7;
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top7=a;
						cat7=art.getgenderofmusic().name();
						nametop7=art.getname();
					}
					
				else if(a>top8){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						cat9=cat8;
						top9=top8;
						nametop9=nametop8;
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top8=a;
						cat8=art.getgenderofmusic().name();
						nametop8=art.getname();
					}else if(a>top9){
						Song art=(Song)userr.getsongreproduced().get(z);
						
						
						cat10=cat9;
						top10=top9;
						nametop10=nametop9;
						
						top9=a;
						cat9=art.getgenderofmusic().name(); 
						nametop9=art.getname();
					}else if(a>top10){
						Song art=(Song)userr.getsongreproduced().get(z);
						top10=a;
						cat10=art.getgenderofmusic().name();
						nametop10=art.getname();
					}
				}
					
			}
	}	
			}
		}
		message=message+ "el top 10 de las mejores canciones  es \n"
		+"top1:"+ cat1 +" "+nametop1+" "+ top1
		+"\n"
		+"top2:"+ cat2 +" "+nametop2+" "+ top2
		+"\n"
		+"top3:"+ cat3 +" "+nametop3+" "+ top3
		+"\n"
		+"top4:"+ cat4 +" "+nametop4+" "+ top4
		+"\n"
		+"top5:"+ cat5 +" "+nametop5+" "+ top5
		+"\n"
		+"top6:"+ cat6 +" "+nametop6+" "+ top6
		+"\n"
		+"top7:"+ cat7 +" "+nametop7+" "+ top7
		+"\n"
		+"top8:"+ cat8 +" "+nametop8+" "+ top8
		+"\n"
		+"top9:"+ cat9 +" "+nametop9+" "+ top9
		+"\n"
		+"top10:"+ cat10 +" "+nametop10+" "+ top10
		+"\n";
		int counter1=0, counter2=0, counter3=0, counter4=0;
		double countermoney1=0,countermoney2=0,countermoney3=0,countermoney4=0;
				for(int i=0;i<users.size();i++)
					{
						if(users.get(i) instanceof Premium){
							Premium user=(Premium)users.get(i);
							for(int l=0;l<user.getbuyedsong().size();l++){
								Song song =(Song)user.getbuyedsong().get(l);
								message2=song.getgenderofmusic().name();
								switch(message2){
									case "ROCK":
										counter1++;
										countermoney1=countermoney1+song.getvalue();
									break;
									case "POP":
										counter2++;
										countermoney2=countermoney1+song.getvalue();
									break;
									case "TRAP":
										counter3++;
										countermoney3=countermoney1+song.getvalue();
									break;
									case "HOUSE":
										counter4++;
										countermoney4=countermoney1+song.getvalue();
									break;
								}
							}
						}else if(users.get(i) instanceof Standar){
							Standar user=(Standar)users.get(i);
							for(int l=0;l<user.getbuyedsong().size();l++){
								Song song =(Song)user.getbuyedsong().get(l);
								message2=song.getgenderofmusic().name();
								switch(message2){
									case "ROCK":
										counter1++;
										countermoney1=countermoney1+song.getvalue();
									break;
									case "POP":
										counter2++;
										countermoney2=countermoney1+song.getvalue();
									break;
									case "TRAP":
										counter3++;
										countermoney3=countermoney1+song.getvalue();
									break;
									case "HOUSE":
										counter4++;
										countermoney4=countermoney1+song.getvalue();
									break;
								}
							}
							
						}
					}			
				message=message+"las ventas por genero fueron las siguientes"
				+"\n"
				+"Rock "+ counter1+ " valor de las ventas "+ countermoney1
				+"\n"
				+"Pop "+ counter2+ " valor de las ventas "+ countermoney2
				+"\n"
				+"Trap "+ counter3+ " valor de las ventas "+ countermoney3
				+"\n"
				+"House "+ counter4+ " valor de las ventas "+ countermoney4
				+"\n";
				int counter=0,number=0;
				double values=0;
				String songname="";
				for(int i=0;i<audiocollection.size();i++){
					counter=0;
					if(audiocollection.get(i) instanceof Song){
						Song song=(Song) audiocollection.get(i);
						for(int k=0;k<users.size();k++){
						if(users.get(k) instanceof Premium){
							Premium user=(Premium) users.get(k);
							for(int m=0;m<user.getbuyedsong().size();m++){
								Song buysong=(Song) user.getbuyedsong().get(m);
								if(song.equals(buysong)){
									counter++;
									
								}
							}
							
						}else if(users.get(k) instanceof Standar){
							Standar user=(Standar) users.get(k);
							for(int m=0;m<user.getbuyedsong().size();m++){
								Song buysong=(Song) user.getbuyedsong().get(m);
								if(song.equals(buysong)){
									counter++;
									
								}
							}
						}
						if(counter>number){
							number=counter;
							values=song.getvalue();
						}
					}
					}
				}
				message=message+"la cancion mas vendida tuvo en su haber "+number +" ventas y su valor final fue de "+ (values*number);
		return message;
	}
	
}