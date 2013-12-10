
import java.io.PrintWriter;

public class A2CategoryNode
{
	private String Name;
	private A2LinkedList<A2FoodItem> foodItems = new A2LinkedList<A2FoodItem>();
	
	public A2CategoryNode(String Name)
	{
		this.Name = Name;
	}
	
	public void AddFoodItem(A2FoodItem Item)
	{
		
		A2FoodItem node = foodItems.getNode(Item);
		if (node == null)
		{
			foodItems.add(Item);
		}

	}
	
	public void DeleteFoodItem(A2FoodItem Item)
	{
		foodItems.delete(Item);
	}

	public boolean hasFoodItem(A2FoodItem Item)
	{
		return (foodItems.contains(Item));
	}
	
	public void UpdateFoodItem(A2FoodItem Item)
	{
		A2FoodItem item = foodItems.getNode(Item);
		if (item == null)
		{
			item = new A2FoodItem(Item.getName());
		}
		item.update(Item.getPrice(), Item.getQuantity(), Item.getDescription(), Item.getSize(), Item.getSpecialOrder());
		
	}
	
	public A2FoodItem getFoodItem(A2FoodItem Item)
	{
		
		A2FoodItem item = foodItems.getNode(Item);
		if (item != null)
		{
			return item;
		}
		else 
		{
			return null;
		}
		
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String toString()
	{
		StringBuilder strBuilder = new StringBuilder("Category: ");
		strBuilder.append(Name + "\n\n");
		strBuilder.append(foodItems.toString());
		return strBuilder.toString();
	}
	
	public void writeData(PrintWriter outputStream)
	{

		outputStream.print(Name);
		outputStream.print("\n");
		A2LinkedListNode<A2FoodItem> node = foodItems.getFirst();
		while (node != null)
		{
			A2FoodItem data = node.getData();
			data.writeData(outputStream);
			node = node.getNext();
		}
	}
	
	
	public boolean equals(Object obj)
	{
	   boolean same = false;
	   if (obj != null)
	   {
		   if (obj instanceof A2CategoryNode){
			  A2CategoryNode otherNode = (A2CategoryNode)obj;
		      same = (Name.equals(otherNode.Name));
		   }
	   }
	   return same;
	}
}
