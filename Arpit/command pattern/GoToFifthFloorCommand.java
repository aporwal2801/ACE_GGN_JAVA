package command;

public class GoToFifthFloorCommand implements Command {

	private Lift lift;
	
	public GoToFifthFloorCommand(Lift lift) {
		this.lift=lift;
	}
	
	@Override
	public void execute() {
		this.lift.GoToFloor(Floors.FIFTH);
	}

}
