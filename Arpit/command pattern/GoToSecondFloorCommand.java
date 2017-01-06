package command;

public class GoToSecondFloorCommand implements Command {

	private Lift lift;
	
	public GoToSecondFloorCommand(Lift lift) {
		this.lift=lift;
	}
	
	@Override
	public void execute() {
		this.lift.GoToFloor(Floors.SECOND);
	}

}
