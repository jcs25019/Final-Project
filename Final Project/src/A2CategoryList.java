import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A2CategoryList
{
	private A2LinkedList<A2CategoryNode> categories = new A2LinkedList<A2CategoryNode>();
	public A2CategoryList()
	{
		
	}
	
	public void AddCategory(A2CategoryNode Item)
	{
		A2CategoryNode node = categories.getNode(Item);
		if (node == null)
		{
			categories.add(Item);
		}
	}
	
	public void DeleteCategory(A2CategoryNode node)
	{
		categories.delete(node);
	}
	
	public void AddFoodItemToCategory(A2CategoryNode category, A2FoodItem item)
	{
	  	A2CategoryNode categoryNode = categories.getNode(category);
	  	if (categoryNode == null)
	  	{
	  	    AddCategory(category);
	  	    categoryNode = category;
	  	}
	    categoryNode.AddFoodItem(item);
	}
	
	public void UpdateFoodItem(A2CategoryNode category, A2FoodItem item)
	{
	  	A2CategoryNode categoryNode = categories.getNode(category);
	  	if (categoryNode != null)
	  	{
	  		categoryNode.UpdateFoodItem(item);
	  	}	 	
	}

	public A2FoodItem getFoodItem(A2CategoryNode category, A2FoodItem item)
	{
		A2FoodItem foodItem = null;
	  	A2CategoryNode categoryNode = categories.getNode(category);
	  	if (categoryNode != null)
	  	{
	  	    foodItem = categoryNode.getFoodItem(item);
	  	}
	  	return foodItem;
	}
	
	public synchronized A2FoodItem getFoodItem(A2FoodItem item)
	{
		A2FoodItem foodItem = null;
		A2LinkedListNode<A2CategoryNode> categoryListNode = categories.getFirst();
		while(categoryListNode != null)
		{
			A2CategoryNode categoryNode = categoryListNode.data;
			if (categoryNode != null)
			{
				foodItem = categoryNode.getFoodItem(item);
				if(foodItem != null)
				{
					break;
				}
			}
			categoryListNode = categories.getNext();
		}
	  	return foodItem;
	}


	
	public void DeleteFoodItem(A2CategoryNode category, A2FoodItem item)
	{
	  	A2CategoryNode categoryNode = categories.getNode(category);
	  	if (categoryNode != null)
	  	{
	  	     categoryNode.DeleteFoodItem(item);
	  	}
	}
	
	public boolean isEmpty()
	{
		return categories.isEmpty();
	}
	
	public String toString()
	{
		return categories.toString();
	}
	
	public void writeData(String outfileName)
	{
		PrintWriter outputStream = null;
		try
		{
			outputStream = new PrintWriter(outfileName);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file " + outfileName);
			System.exit(0);
		}
		
		A2LinkedListNode<A2CategoryNode> node = categories.getFirst();
		while (node != null)
		{
			A2CategoryNode data = node.getData();
			data.writeData(outputStream);
			node = node.getNext();
		}
		outputStream.close();
	}
	
	public void readData(String infileName)
	{
		Scanner infile = null;
		try
		{
			infile = new Scanner (new File (infileName));
		}
		catch (FileNotFoundException ex)
		{
			System.out.println ("file not found");
			System.exit (0);
		}

		while (infile.hasNext())
		{
			
		}

		infile.close();
	}

}
