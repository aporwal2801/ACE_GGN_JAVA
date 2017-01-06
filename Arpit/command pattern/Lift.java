package command;

public class Lift {

	private Integer currentFloor;
	private Direction direction;
	
	
	public Lift() {
		
		this.currentFloor = Floors.GROUND.getFloor();
		this.direction = Direction.NONE;
	}
	
	
	public Integer getCurrentFloor() {
		return currentFloor;
	}

	public Direction getDirection() {
		return direction;
	}

	public void GoToFloor(Floors floor){
		
		//check for same floor
		
		if(this.isSameFloor(floor)){
			//open door
		} else {
			
			int tmpFloor = this.currentFloor;
			
			//calculate direction
			if(tmpFloor < floor.getFloor()){
				//moving up
				this.direction = Direction.UP;
				System.out.println("Going : UP");
				for(int i = tmpFloor; i < floor.getFloor(); i++){
					this.GoUP();
				}
			} else {
				this.direction = Direction.DOWN;
				System.out.println("Going : DOWN");
				for(int i = floor.getFloor(); i < tmpFloor; i++){
					this.GoDown();
				}
			}
		}
		
	}
	
	private void GoUP(){
		
		if( ! this.checkIfTopFloorReached()){
			this.currentFloor = this.currentFloor + 1;
			this.direction = Direction.UP;
			System.out.println("Floor Reached: " +  this.currentFloor);
		} else{
			//throw exception
		}
		
	}
	
	private void GoDown(){
		
		if( ! this.checkIfGroundFloorReached()){
			this.currentFloor = this.currentFloor - 1;
			this.direction = Direction.DOWN;
			System.out.println("Floor Reached: " +  this.currentFloor);
		} else{
			//throw exception
		}
		
	}
	
	private boolean isSameFloor(Floors floor){
		if(this.currentFloor == floor.getFloor()){
			return true;
		} 
		return false;
	}
	
	
	private boolean checkIfTopFloorReached(){
		if(Floors.getTopFloor() == this.currentFloor){
			return true;
		}
		return false;
	}
	
	private boolean checkIfGroundFloorReached(){
		if(Floors.getLowestFloor() == this.currentFloor){
			return true;
		}
		
		return false;
	}
	
}
