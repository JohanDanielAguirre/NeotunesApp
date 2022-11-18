package model; 
public enum Sponsor{
	NIKE("hacelo wachin vos podes 1",5),
	COCACOLA("un sabor pa'compartir 2",6),
	MYMS("disfruta lo bueno 3",10),
	PEPSICOLA("sabor para compartir",4);
	private String brand;
	private double duration;
	Sponsor(String brand,double duration){
		this.brand=brand;
		this.duration=duration;
	}
	public  String getbrand(){
		return brand;
	}
	public double getduration(){
		return duration;
	}
}
