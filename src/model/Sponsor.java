package model; 
public enum Sponsor{
	NIKE("hacelo wachin vos podes Just Do It 1",5),
	COCACOLA("Open Happiness 2",6),
	MYMS("Melts in Your Mouth, Not in Your Hands 3",10),
	PEPSICOLA("FOR THE LOVE OF IT?",4);
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
