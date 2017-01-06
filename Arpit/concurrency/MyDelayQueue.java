package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyDelayQueue {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<DelayedElement> blockingQueue = new DelayQueue<DelayedElement>();

        try {
        	blockingQueue
            .put(new DelayedElement(9000, "Message with delay 9s"));
            blockingQueue
                    .put(new DelayedElement(4000, "Message with delay 4s"));
            blockingQueue
                    .put(new DelayedElement(2000, "Message with delay 2s"));
        } catch (InterruptedException ie) {
        }

        while (!blockingQueue.isEmpty()) {
            try {
                System.out.println(">>" + blockingQueue.take());
            } catch (InterruptedException ie) {
            }

        }
	}

	static class DelayedElement implements Delayed{

		private long duration;
		private String message;
		
		public DelayedElement(long duration, String name) {
	        this.duration = System.currentTimeMillis() + duration;
	        this.message = name;
	    }
		
		@Override
		public int compareTo(Delayed o) {
			return (int) (this.duration - ((DelayedElement) o).getDuration());
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long diff = duration - System.currentTimeMillis();
	        return unit.convert(diff, TimeUnit.MILLISECONDS);
		}
		
		public long getDuration() {
	        return duration;
	    }
		
		public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    @Override
	    public String toString() {
	        return "DelayedElement [duration=" + duration + ", message=" + message
	                + "]";
	    }
		
	}
}
