import java.io.PrintWriter;

public class A4BinarySearchTree<T> extends A4BinaryTree<T>
{
	public A4BinarySearchTree()
	{
		super();
	}
	
	public boolean add (T newMember)
	{
		boolean success = true;
		A4Node<T> newNode = new A4Node<T>(newMember);
		if (empty())
			setRoot(newNode);
		else
		{
			A4Node p = null;
			A4Node c = getRoot();
			int compare = 0;
			
			while (c != null)
			{
				compare = newMember.toString().compareTo(c.getData().toString());
				if (compare == 0)
				{
					success = false;
					return success;
				}
				else
				{
					p = c;
					if(compare > 0)
						c = c.getRight();
					else
						c = c.getLeft();
				}
			}
			
			if (compare > 0)
				p.setRight(newNode);
			else
				p.setLeft(newNode);
		}
		return success;
		
	}
	
	public T delete(A4Node key)
	{
		T dataInDeleted = null;
		if (!empty())
		{
			A4Node p = null;
			A4Node c = getRoot();
			int compare = 0;
			
			while (c != null)
			{
				compare = key.compareTo(c);
				if (compare == 0)
					break;
				else
				{
					p = c;
					if (compare > 0)
						c = c.getRight();
					else
						c = c.getLeft();
				}
			}
			
			if (c == null)
			{
				System.out.println("not found");
				return dataInDeleted;
			}
			else
			{
				dataInDeleted = (T) c.getData();
				A4Node betweenPnC = null;
				
				if (c == getRoot())
					betweenPnC = getRoot();
				else if (c == p.getLeft())
					betweenPnC = p.getLeft();
				else
					betweenPnC = p.getRight();
				
				if (betweenPnC.getRight() == null)
					betweenPnC = betweenPnC.getLeft();
				else if (betweenPnC.getLeft() == null)
					betweenPnC = betweenPnC.getRight();
				
				A4Node px = c;
				A4Node pc = c.getRight();
				while (pc.getLeft() != null)
				{
					px = pc;
					pc = pc.getLeft();
				}
				
				c.setData((T) pc.getData());
				
				if (px == c)
					px.setRight(pc.getRight());
				else
					px.setLeft(pc.getRight());
			}
		}
		return dataInDeleted;
	}
	
	public void traverse()
	{
		A4Node startPoint = getRoot();
		inOrder(startPoint);
	}
	
	public void TraverseAndPrint(PrintWriter outputFile)
	{
		A4Node startPoint = getRoot();
		inOrderPrint(startPoint, outputFile);
	}
	
	public String TraverseAndString(String outputString)
	{
		A4Node startPoint = getRoot();
		return inOrderString(startPoint, outputString);
	}
	
	public A4Node binarySearch(A4Node key)
	{
		A4Node found = null;
		A4Node temp = getRoot();
		while (temp != null)
		{
			int x = key.compareTo(temp);
			if (x == 0)
			{
				found = temp;
				break;
			}
			else if (x < 0)
				temp = temp.getLeft();
			else
				temp = temp.getRight();
		}
		return found;
	}
}