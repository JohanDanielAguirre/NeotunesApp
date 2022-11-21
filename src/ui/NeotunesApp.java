package ui;
import java.util.Scanner;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import model.Neotunescontroller;
public class NeotunesApp {
    public static Scanner sc= new Scanner(System.in);
	//relations 
	private Neotunescontroller Neo;
	public static final int MATRIX=6;
	/**
	*name: NeotunesApp <br>
	*builder of NeotunesApp<br>
	* <b> post:</b> a Neo object will be created<br>
	*/
	public NeotunesApp(){
		Neo= new Neotunescontroller();
	}
	/**
	*name: main <br>
	* main method of user interface <br>
	* <b>post:</b> should be directed to the method of execution <br>
	*/
    public static void main(String[] args) {
		NeotunesApp neotunes= new NeotunesApp();
        neotunes.menu();	
    }
	/**
	*<b>name:</b> menu <br>
	* eexecute the program <br>
	*<b>pre:</b> the object of type NeotunesApp must have been created<br>
	* <b>post:</b> directs the different sub-processes of the system<br>
	*/
	public  void menu() {
	 	int cuantity=0, i=0,position= 0,p=0,selection=0;
		double number1=0;
		String nickname="",id="",message="";
		char letter;
		int [][] codification= new int [MATRIX][MATRIX];
		System.out.println("|modo administrador|");
		do{
			System.out.println("menu de opciones\n"
		 +"si desea registrar  usuarios presione 1\n"
		 +"si desea registrar contenido presione 2\n"
		 +"si desea realizar acciones de una playlist presione 3\n"
		 +"si desea simular la reproduccion de contenido presione 4\n"
		 +"si desea comprar una cancion presione 5\n"
		 +"si desea generar un reporte de la aplicacion presione 6\n"
		 +"si desea salir presione 7");
			position= sc.nextInt();
			switch (position){
				case 1:
					i=0;
					System.out.println("ingrese la cantidad de usuarios a registrar");
					cuantity= sc.nextInt();
						do{
						registeruser();
						i++;
					}while(cuantity>=i);
				break;
				case 2:
					i=0;
					System.out.println("ingrese la cantidad de contenidos a registrar");
					cuantity= sc.nextInt();
						do{
							registercontent();
							i++;
						}while(cuantity>=i);
				break;
				case 3:
					i=0;
						System.out.println("ingrese el nickname del  usuario que desea realizar acciones con las playlist");
						nickname= sc.nextLine();
						nickname= sc.nextLine();
						System.out.println("ingrese el documento del  usuario que desea realizar acciones con las playlist");
						id= sc.nextLine();
					System.out.println("ingrese la funcion que desea realizar\n"
					+"1. agregar listas de reproduccion a un usuario\n"
					+"2. adicionar audios de la lista\n"
					+"3. eliminar audios de la lista\n"
					+"4. compartir una lista de reproduccion\n"
					+"5.salir");
					position= sc.nextInt();
					switch(position){
						case 1:
						System.out.println("ingrese la cantidad de listas de reproduccion modificar");
						cuantity= sc.nextInt();
						do{
							createlistOfReproduction(nickname);
							i++;
						}while(cuantity>=i);
						break;
						case 2:
						 i=0;
						 message=Neo.showlists(nickname);
						 System.out.println(message);
						 System.out.println("ingrese la lista a modificar");
						 selection=sc.nextInt();
						 message=Neo.showaudios();
						 System.out.println(message);
						 System.out.println("ingrese la cantidad de audios que desea registrar");
						 cuantity= sc.nextInt();
						 do{
							System.out.println("ingrese el numero del audio a registrar");
							p= sc.nextInt();
							Neo.addAudiostoreproductionlits(selection,p,nickname);
							i++;
						 }while(cuantity>=i);
						break;
						case 3:
						 message=Neo.showlists(nickname);
						 System.out.println(message);
						 System.out.println("ingrese la lista a modificar");
						 selection=sc.nextInt();
						 message=Neo.showaudiosinalist(nickname,selection);
						 System.out.println(message);
						 System.out.println("ingrese la cantidad de audios que desea eliminar");
						 cuantity= sc.nextInt();
						 do{
							System.out.println("ingrese el numero del audio a eliminar");
							p= sc.nextInt();
							Neo.removeAudiostoreproductionlits(selection,p,nickname);
							i++;
						 }while(cuantity>=i);
						break;
						case 4: 
						 message=Neo.showlists(nickname);
						 System.out.println(message);
						 System.out.println("ingrese la lista a compartir");
						 selection=sc.nextInt();
						 message=Neo.sharematrix(codification);
						 System.out.println(message);
						 i=Neo.sharelist(selection,nickname,codification);
						 System.out.println("su codigo para compartir la cancion es "+i);
						break;
						case 5:
						
						break;
					}
					
				break;
				case 4:
					i=0;
					do{
						System.out.println("ingrese el nickname del  usuario que desea  reproducir");
						nickname= sc.nextLine();
						nickname= sc.nextLine();
						System.out.println("ingrese el documento del  usuario que desea reproducir");
						id= sc.nextLine();
						if(!Neo.searchuser(nickname,id)){
							System.out.println("el usuario no existe");
						}
					}while(!Neo.searchuser(nickname,id));
						message=Neo.showaudios();
						 System.out.println(message);
						 System.out.println("ingrese la cantidad de audios que desea reproducr");
						 cuantity= sc.nextInt();
						 do{
							 try{
								System.out.println("ingrese el numero del audio a reproducir");
								p= sc.nextInt();
								message= Neo.sponsor(nickname,p);
								for (int z= 0; z < message.length(); z++) {
									letter = message.charAt(z);
									if (isnumber(letter)) {
										number1=(double) letter;
									}
								}
								TimeUnit.SECONDS.sleep((int) Neo.timesponsor(nickname,number1));
								message=Neo.reproduce(nickname,p);
								TimeUnit.SECONDS.sleep(10);
								i++;
							 }catch(Exception e){
								System.out.println(e); 
							 }
						 }while(cuantity>=i);
				break;
				case 5:
				do{
					System.out.println("ingrese el nickname del  usuario que desea comprar canciones");
					nickname= sc.nextLine();
					nickname= sc.nextLine();
					System.out.println("ingrese el documento del  usuario que comprar canciones");
					id= sc.nextLine();
					if(!Neo.searchuser(nickname,id)){
						System.out.println("el usuario no existe");
					}
				}while(!Neo.searchuser(nickname,id));
					message=Neo.showaudios();
					System.out.println(message);
					System.out.println("ingrese la el numero del  audio que desea comprar");
					cuantity= sc.nextInt();
					Neo.buysong(cuantity,nickname);
				break;
				case 6:
				do{
					System.out.println("ingrese el nickname del  usuario que desea comprar canciones");
					nickname= sc.nextLine();
					System.out.println("ingrese el documento del  usuario que comprar canciones");
					id= sc.nextLine();
					if(!Neo.searchuser(nickname,id)){
						System.out.println("el usuario no existe");
					}
				}while(Neo.searchuser(nickname,id));
					message=Neo.generateinform(nickname);
				break;
				case 7:
					System.out.println("over runtime.......\n" 
					+ "ending process...");
				break;
				default:
					System.out.println("ingrese una opcion valida");
				break;
			}
		}while(position!=7);
	}
	/**
	*<b>name:</b> registeruser<br>
	* data must be provided to create a produceruser of any type<br>
	* <b> post:</b> will be sent to the builder of the User and the respectives sons<br>
	*/
	public   void registeruser() {
		String id="",nickname ="",  name = "", message="",photo="",mostlistenpodcastuser="",mostlistensonguser="",mostlistenpodcast="",mostlistensong="";
		Calendar vinculationdate=Calendar.getInstance();
		double podcasttimereproduced=0,songtimereproduced=0;
		int option=0,numvisualizations=0;
		boolean comprobant=false;
		name=sc.nextLine();
		System.out.println("por favor escriba su nickname");
		nickname=sc.nextLine();
		System.out.println("por favor escriba su cedula");
		id=sc.nextLine();
		System.out.println("por favor diga el tipo de usuario a registrar/n"
		+"1.usuario consumidor/n"
		+"2.usuario productor");
		option=sc.nextInt();
		switch(option){
			case 1:
				do{
					System.out.println("por favor diga el tipo de usuario a registrar/n"
					+"1.estandar/n"
					+"2.premiun");
					option=sc.nextInt();
					if(option==1 || option==2){
						comprobant=true;
					}
					else{
						System.out.println("por favor digite una opcion valida");
					}
				}while(!comprobant);
				message=Neo.adduser(id,nickname,podcasttimereproduced,songtimereproduced,mostlistenpodcastuser,mostlistensonguser,mostlistenpodcast,mostlistensong,vinculationdate,option);
			break;
			case 2:
				System.out.println("por favor escriba su nombre real");
				name=sc.nextLine();
				name=sc.nextLine();
				System.out.println("por favor coloque su foto de perfil");
				photo=sc.nextLine();
				do{
					System.out.println("por favor diga el tipo de usuario a registrar/n"
					+"1.artista/n"
					+"2.creador de contenido");
					option=sc.nextInt();
					if(option==1 || option==2){
						comprobant=true;
					}
					else{
						System.out.println("por favor digite una opcion valida");
					}
				}while(!comprobant);
				message=Neo.adduser(id,nickname,name,photo,numvisualizations,vinculationdate,option);
			break;
		}
		System.out.println(message);
	}
	/**
	*<b>name: </b>registerTreasure<br>
	* data must be provided to create a Treasure<br>
	*<b>pre:</b> treasurelevel must be in valid range <br>
	*@param treasurelevel is int and this variable will store the data of the level selected by the user where the treasures will be created<br>
	* <b> post:</b> will be sent to the builder of the Tresure<br>
	*/
	public  void registercontent(){
		String message="",name="",nameuser="", coverpage="",description="",album="";
		int numvisualizations=0,option=0,unitssold=0,durationtime=0,numberOfReproduction=0,category=0;
		double value=0;
		boolean comprobant=false;
		System.out.println("ingrese el nombre del usuario que creo el contenido");
		nameuser= sc.nextLine();
		nameuser= sc.nextLine();
		System.out.println("ingrese el nombre del contenido");
		name= sc.nextLine();
		System.out.println("ingrese el URL de la foto de la portada");
		coverpage= sc.nextLine();
		System.out.println("ingrese la duracion");
		durationtime= sc.nextInt();
			do{
					System.out.println("por favor diga el tipo de contenido a registrar/n"
					+"1. cancion/n"
					+"2.podcast");
					option=sc.nextInt();
					if(option==1 || option==2){
						comprobant=true;
					}
					else{
						System.out.println("por favor digite una opcion valida");
					}
			}while(!comprobant);
			if(option==1){
				System.out.println("ingrese el album al que pertenece");
				album= sc.nextLine();
				album= sc.nextLine();
				System.out.println("ingrese el valor del album");
				value=sc.nextDouble();
				System.out.println("ingrese el tipo de cancion \n"
					+"1.rock \n"
					+"2.pop \n"
					+"3.trap \n"
					+"4.house \n");
					category= sc.nextInt();
				message=Neo.addcontent(nameuser,name,coverpage,durationtime,numberOfReproduction,album,value,unitssold,category);
			}
			if(option==2){
				System.out.println("ingrese la descripcion del podcast");
				description= sc.nextLine();
				System.out.println("ingrese el tipo de podcast \n"
					+"1.politica \n"
					+"2.entretenimiento \n"
					+"3.videojuegos \n"
					+"4.moda \n");
					category= sc.nextInt();
				message=Neo.addcontent(nameuser,name,coverpage,durationtime,numberOfReproduction,description,category);
			}
		System.out.println(message);
	}
	public void createlistOfReproduction(String nickname){
		String name="",message="";
		System.out.println("ingrese el nombre de la playlist");
		name= sc.nextLine();
		message=Neo.addreproductionlist(name,nickname,0);
	}
		/**
	*<b>name:</b>isnumber<br>
	*is in charge of searching if the letter is a number 
	*<b> post: </b>it will be determined the letter is a number or not <br>
	*@param  letter char is a letter of the brand	
	* @return  will send a determination as to whether or not the letter is a number. 
	*/
	public  boolean isnumber(char letter) {
		return "123456789".contains(String.valueOf(letter).toLowerCase());
	}
}