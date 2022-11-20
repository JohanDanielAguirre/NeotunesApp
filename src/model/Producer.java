package model;
import java.util.Calendar;
public  class  Producer extends User{
	private String name;
	private String photo;
	private int numvisualizations;
	public Producer(String id, String nickname, Calendar vinculationdate,String name, String photo, int numvisualizations){
		super(id,nickname,vinculationdate);
		this.name=name;
		this.photo=photo;
		this.numvisualizations=numvisualizations;
	}
	public String getname(){
		return name;
	}
	
	public void setname(String name){
		this.name = name;
	}
		public String getphoto(){
		return photo;
	}
	
	public void setphoto(String photo){
		this.photo = photo;
	}
		public int getnumvisualizations(){
		return numvisualizations;
	}
	
	public void setnumvisualizations(int numvisualizations){
		this.numvisualizations = numvisualizations;
	}
}