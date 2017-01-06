package command;

import java.util.LinkedList;
import java.util.Queue;

public class LiftProcessor {

	private Queue<Command> liftActionQueue = new LinkedList<Command>();
	
	private Lift lift;
	
	public LiftProcessor(Lift lift) {
		this.lift=lift;
	}
	
	public void accept(Command command){
		this.liftActionQueue.add(command);
	}
	
	public void process(){
		while(this.liftActionQueue.size() != 0){
			Command cmd = this.liftActionQueue.poll();
			cmd.execute();
		}
	}
	
}
