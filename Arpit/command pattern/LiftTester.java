package command;

public class LiftTester {

	public static void main(String[] args) {

		Lift lift = new Lift();
		
		GoToGroundFloorCommand goToGroundFloorCommand = new GoToGroundFloorCommand(lift);
		GoToFirstFloorCommand toFirstFloorCommand = new GoToFirstFloorCommand(lift);
		GoToSecondFloorCommand goToSecondFloorCommand = new GoToSecondFloorCommand(lift);
		GoToThirdFloorCommand goToThirdFloorCommand = new GoToThirdFloorCommand(lift);
		GoToFourthFloorCommand goToFourthFloorCommand = new GoToFourthFloorCommand(lift);
		GoToFifthFloorCommand goToFifthFloorCommand = new GoToFifthFloorCommand(lift);
		
		LiftProcessor processor = new LiftProcessor(lift);
		
		processor.accept(goToThirdFloorCommand);
		processor.accept(goToFourthFloorCommand);
		processor.accept(goToFifthFloorCommand);
		processor.accept(goToFourthFloorCommand);
		processor.accept(toFirstFloorCommand);
		processor.accept(goToGroundFloorCommand);
		processor.accept(goToSecondFloorCommand);
		processor.accept(goToFifthFloorCommand);
		
		
		processor.process();
		
		
		
		
	}

}
