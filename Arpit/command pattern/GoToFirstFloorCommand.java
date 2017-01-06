package command;

public class GoToFirstFloorCommand implements Command {

	private Lift lift;
	
	public GoToFirstFloorCommand(Lift lift) {
		this.lift=lift;
	}
	
	@Override
	public void execute() {
		this.lift.GoToFloor(Floors.FIRST);
	}

}
