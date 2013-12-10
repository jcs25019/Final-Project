import java.util.Iterator;

public interface A3QueueInterface<T> extends Iterator<T> 
{
	public void enqueue(T element);
	
	public T dequeue() throws A3QueueUnderflowException;
	
	public boolean isEmpty();
	
	public int size();

	public boolean contains(Object element);

	public void remove(T element);
	
}
