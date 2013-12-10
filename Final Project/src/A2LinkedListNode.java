public class A2LinkedListNode <T>
{
	T data;
	A2LinkedListNode <T> next;

	public A2LinkedListNode(T data)
	{
		this.data = data;
		this.next = null;
	}
	public T getData()
	{
		return data;
	}
	public A2LinkedListNode <T> getNext()
	{
		return next;
	}
	public void setNext(A2LinkedListNode <T>Next)
	{
		this.next = Next;
	}
}