package ui;
import java.util.Scanner;
import java.util.Calendar;
import model.Neotunescontroller;
public class NeotunesApp {
    public static Scanner sc= new Scanner(System.in);
	//relations 
	private Neotunescontroller Neo;
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
	 	int cuantity=0, i=0,position= 0; 
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
					System.out.println("ingrese la cantidad de listas de reproduccion modificar");
					cuantity= sc.nextInt();
						do{
							createlistOfReproduction();
							i++;
						}while(cuantity>=i);
				break;
				case 4:
					//more code
				break;
				case 5:
					//more code
				break;
				case 6:
					//more code
				break;
				case 7:
					System.out.println("over runtime.......\n" 
					+ "ending process...");
				break;
				default:
					System.out.println("ingrese una opcion valida");
				break;
			}
		}while(position!=10);
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
		int numvisualizations=0,option=0,unitssold=0,durationtime=0,numberOfReproduction=0;
		double value=0;
		boolean comprobant=false;
		System.out.println("ingrese el nombre del usuario que creo el contenido");
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
				System.out.println("ingrese el valor del album");
				value=sc.nextDouble();
				Neo.addcontent(nameuser,name,coverpage,durationtime,numberOfReproduction,album,value,unitssold);
			}
			if(option==2){
				System.out.println("ingrese la descripcion del podcast");
				description= sc.nextLine();
				Neo.addcontent(nameuser,name,coverpage,durationtime,numberOfReproduction,description);
			}
		System.out.println(message);
	}
	public void createlistOfReproduction(){
		
	}
}