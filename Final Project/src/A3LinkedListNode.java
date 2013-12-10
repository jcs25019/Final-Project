public class A3LinkedListNode <T>
{
	T data;
	A3LinkedListNode <T> next;

	public A3LinkedListNode(T data)
	{
		this.data = data;
		this.next = null;
	}
	public T getData()
	{
		return data;
	}
	public A3LinkedListNode <T> getNext()
	{
		return next;
	}
	public void setNext(A3LinkedListNode <T>Next)
	{
		this.next = Next;
	}
}