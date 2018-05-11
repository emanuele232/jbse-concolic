package exec;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import concurrent.HighPrioOutputBuffer;
import concurrent.InputBuffer;

public class HighPriorityInputOutputQueue<E> implements InputBuffer<E>, HighPrioOutputBuffer<E>{
	private final LinkedBlockingQueue<E> highPrioQueue = new LinkedBlockingQueue<>();
	private final LinkedBlockingQueue<E> lowPrioQueue = new LinkedBlockingQueue<>();
	
	@Override
	public boolean add(E e) {
		return false;
	}
	
	//TODO this poll from the high prio queue first, then from the other one if necessary
	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		E obj = null;
		obj = highPrioQueue.poll((long) (timeout * 10), unit);
		if (obj == null) {
			obj = lowPrioQueue.poll((long) (timeout * 0.005), unit);
			System.out.println("lowPrioPick");
		}
		else System.out.println("HighPrioPick");

		return obj;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean addHighPrio(E e) {
		return highPrioQueue.add(e);
	}
	
	public boolean addLowPrio(E e) {
		return lowPrioQueue.add(e);
	}
	
	public boolean isHighPrioEmpty() {
		return highPrioQueue.isEmpty();
	}

}
