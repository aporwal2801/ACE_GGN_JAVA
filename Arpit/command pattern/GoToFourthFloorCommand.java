package command;

public class GoToFourthFloorCommand implements Command {

	private Lift lift;
	
	public GoToFourthFloorCommand(Lift lift) {
		this.lift=lift;
	}
	
	@Override
	public void execute() {
		this.lift.GoToFloor(Floors.FOURTH);
	}
	
}
