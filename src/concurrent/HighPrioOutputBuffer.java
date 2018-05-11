package concurrent;

public interface HighPrioOutputBuffer<E> extends OutputBuffer<E>{
	public boolean addHighPrio(E e);
	public boolean addLowPrio(E e);
}
