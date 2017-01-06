package command;

public class GoToThirdFloorCommand implements Command {

	private Lift lift;
	
	public GoToThirdFloorCommand(Lift lift) {
		this.lift=lift;
	}
	
	@Override
	public void execute() {
		this.lift.GoToFloor(Floors.THIRD);
	}

}
