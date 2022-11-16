package model; 
public enum Sponsor{
	NIKE("hacelo wachin vos podes",5000),
	COCACOLA("un sabor pa'compartir",6800),
	MyMS("disfruta lo bueno",10000);
	private String brand;
	private int duration;
	Sponsor(String brand,int duration){
		this.brand=brand;
		this.duration=duration;
	}
	public  String getbrand(){
		return brand;
	}
	public int getduration(){
		return duration;
	}
}
