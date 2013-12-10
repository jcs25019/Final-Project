import java.io.PrintWriter;

public class A4BinaryTree<T>
{
	private A4Node<T> root;
	
	public A4BinaryTree()
	{
		root = null;
	}
	
	public void inOrder(A4Node root)
	{
		if(root != null)
		{
			inOrder(root.getLeft());
			System.out.println(root);
			inOrder(root.getRight());
		}
	}

	public void inOrderPrint(A4Node root, PrintWriter txtFile)
	{
		if(root != null)
		{
			inOrderPrint(root.getLeft(), txtFile);
			txtFile.println(root.getData());
			inOrderPrint(root.getRight(), txtFile);
		}
	}
	
	public String inOrderString(A4Node root, String outputString)
	{
		if(root != null)
		{
			inOrderString(root.getLeft(), outputString);
			outputString = outputString + root.getData().toString();
			inOrderString(root.getRight(), outputString);
		}
		return outputString;
	}
	
	public boolean empty()
	{
		return (root == null);
	}
	
	public A4Node getRoot()
	{
		return root;
	}
	
	public void setRoot(A4Node newRoot)
	{
		root = newRoot;
	}
}