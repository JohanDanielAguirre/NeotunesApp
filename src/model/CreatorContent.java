package model;
import java.util.Calendar;
public class CreatorContent extends Producer {
	public CreatorContent(String id,String nickname,String name,String photo,int numvisualizations,Calendar vinculationdate){
		super(id, nickname, vinculationdate, name, photo, numvisualizations);
	}
}