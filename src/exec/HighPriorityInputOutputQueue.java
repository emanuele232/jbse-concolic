package exec;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import concurrent.OutputBuffer;
import jbse.mem.State;
import jbse.mem.exc.ThreadStackEmptyException;
import concurrent.InputBuffer;

public class HighPriorityInputOutputQueue<E> implements InputBuffer<E>, OutputBuffer<E>{
	private final LinkedBlockingQueue<E> highPrioQueue = new LinkedBlockingQueue<>();
	private final LinkedBlockingQueue<E> lowPrioQueue = new LinkedBlockingQueue<>();
	private final CoverageSet coverageSet;
	
	public HighPriorityInputOutputQueue(CoverageSet coverageSet) {
		this.coverageSet = coverageSet;
	}
	
	@Override
	public boolean add(E e) {
		State newState = ((JBSEResult)e).getFinalState();
		State preState = ((JBSEResult)e).getPreState();
		
		try {
			if(coverageSet.covers(newState.getCurrentMethodSignature().toString() + ":" + preState.getPC() + ":" + newState.getPC())) {
				 
				lowPrioQueue.add(e);
			}
			else {
				highPrioQueue.add(e);
			}
		} catch (ThreadStackEmptyException e1) {
			// TODO better exception needed!
			e1.printStackTrace();
		}
		
		return false;
	}
	
	//TODO this poll from the high prio queue first, then from the other one if necessary
	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		E obj = null;
		obj = highPrioQueue.poll((long) (timeout * 5), unit);
		if (obj == null) {
			obj = lowPrioQueue.poll((long) (timeout * 0.005), unit);
		}

		return obj;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
