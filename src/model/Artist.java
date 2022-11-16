package model;
import java.util.Calendar;
public class Artist extends Producer {
	public Artist(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
	}
}