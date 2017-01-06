package command;

public enum Floors {

	GROUND(0),
	FIRST(1),
	SECOND(2),
	THIRD(3),
	FOURTH(4),
	FIFTH(5);
	
	private Integer floor;
	
	Floors(int floor){
		this.floor=floor;
	}
	
	public int getFloor(){
		return this.floor;
	}
	
	public static int getTopFloor(){
		
//		for(Floors f : Floors.values()){
//			
//		}
	
		return Floors.FIFTH.getFloor();
	}
	
	public static int getLowestFloor(){
		
		return Floors.GROUND.getFloor();
	}
	
}
