public class A2LinkedList<T>
{
	A2LinkedListNode<T> first = null;
	A2LinkedListNode<T> cursor = null;
	
	public void add(T item)
	{

		A2LinkedListNode<T> node = new A2LinkedListNode<T>(item);
		if (first == null)
		{
			first = node;
		}
		else
		{
			cursor = first;
			while (true)
			{
				if (cursor.getNext() == null)
				{
					cursor.setNext(node);
					break;
				}
				else
				{
					cursor = cursor.getNext();
				}
			}
		}
	}
	
	public A2LinkedListNode<T> getFirst()
	{
		cursor = first;
		return first;
	}
	
	public A2LinkedListNode<T> getNext()
	{
		cursor = cursor.next;
		return cursor;
	}
	

	public void delete(T node)
	{
		cursor = first;
		A2LinkedListNode<T> previous = null;
		while (cursor != null)
		{
			if (cursor.getData().equals(node))
			{
				break;
			} 
			else 
			{
				previous = cursor;
				cursor = cursor.getNext();
			}
		}
		if (cursor != null)
		{
		   // delete it by reseting links
			if (previous == null)
			{
				// it was the first one, so reset first to its next
				first = cursor.getNext();
			}
			else
			{
				previous.setNext(cursor.getNext());
			}
			
		}		
	}
	
	public boolean contains (T node)
	{
		boolean found = false;
		cursor = first;
		
		while (cursor != null)
		{
			if (cursor.getData().equals(node))
			{
				found = true;
				break;
			}
			else 
			{
			    cursor = cursor.getNext();
			}
		}
		return found;
	}
	
	public T getNode (T node)
	{
		T foundNode = null;
		cursor = first;
		
		while (cursor != null)
		{
			
			if (cursor.getData().equals(node))
			{
				foundNode = cursor.getData();
				break;
			}
			else 
			{
			    cursor = cursor.getNext();
			}
		}
		
		return foundNode;
	}

	public String toString()
	{
		StringBuilder strBuilder = new StringBuilder();
		cursor = first;
		
		while (cursor != null)
		{
			strBuilder.append(cursor.data.toString());
			strBuilder.append("\n");
			cursor = cursor.getNext();
		}
		return strBuilder.toString();
	}

	public boolean isEmpty()
	{
		boolean result = (first == null);
		return result;
	}
			
}
