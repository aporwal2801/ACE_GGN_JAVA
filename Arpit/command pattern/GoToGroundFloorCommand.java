package command;

public class GoToGroundFloorCommand implements Command {

	private Lift lift;
	
	public GoToGroundFloorCommand(Lift lift) {
		this.lift=lift;
	}
	
	@Override
	public void execute() {
		this.lift.GoToFloor(Floors.GROUND);
	}
}
