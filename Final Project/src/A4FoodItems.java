import java.util.ArrayList;

public class A4FoodItems 
{
	private String foodItem = "";
	private ArrayList<String> Ingredients = new ArrayList<String>();
	
	public A4FoodItems(String pfoodItem)
	{
		foodItem = pfoodItem.trim();
	}
	
	public String getFoodItem()
	{
		return foodItem;
	}
	
	public void setFoodItem(String pfoodItem)
	{
		foodItem = pfoodItem;
	}
	
	public ArrayList<String> getIngredients()
	{
		return Ingredients;
	}
	
	public void setIngredients(String pIngredients)
	{
		Ingredients.add(pIngredients);
	}
	
	public String toString()
	{
		String str = foodItem + " \n";
		for (int i = 0; i < Ingredients.size(); i++)
		{
			str = str + Ingredients.get(i) + " \n";
		}
		return str;
	}


}
