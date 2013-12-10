public class A2Restaurant
{

	A2CategoryList restaurantCategories = new A2CategoryList();
	String FILENAME = "myFood.txt";

	static A2Restaurant instance = null;
	
	public static void main(String[] args)
	{
		
		A2Restaurant myRestaurant = new A2Restaurant();
		
		// OR
		// Restaurant myRestaurant = new Restaurant(FILENAME);

	}
	
	public static A2Restaurant getInstance()
	{
		if (instance == null)
		{
			instance = new A2Restaurant("myFood.txt");		
		}
		return instance;
	}
	
	// constructor to read the data in from the file
	private A2Restaurant(String filename)
	{
	   // restaurantCategories.readData(filename);	
		
		A2CategoryNode node = new A2CategoryNode("Sandwiches");
		restaurantCategories.AddCategory(node);
		
		A2FoodItem hamburgers = new A2FoodItem("hamburger", new Float (2.50), 12, "Meat on a bun", "Medium", "   ");
		node.AddFoodItem(hamburgers);
		
		A2FoodItem turkey = new A2FoodItem("turkey", new Float (2.75), 4, "Turkey on a bun", "large", "   ");
		node.AddFoodItem(turkey);
		
		node = new A2CategoryNode("Soups");
		restaurantCategories.AddCategory(node);
		
		A2FoodItem chickenSoup = new A2FoodItem("chicken soup", new Float (2.25), 4, "Chicken Soup", "medium", "   ");
		node.AddFoodItem(chickenSoup);
		
		A2FoodItem tomatoSoup = new A2FoodItem("tomato soup", new Float (2.25), 4, "Tomato Soup", "medium", "   ");
		node.AddFoodItem(tomatoSoup);
		
		node = new A2CategoryNode("Salad");
		restaurantCategories.AddCategory(node);
		
		A2FoodItem houseSalad = new A2FoodItem("house salad", new Float (3.00), 4, "House Salad", "small", "   ");
		node.AddFoodItem(houseSalad);


		
		
//		A2CategoryNode badnode = new A2CategoryNode("BadGuy");
//		restaurantCategories.AddCategory(badnode);
//		A2FoodItem badFood = new A2FoodItem("badFood", new Float (2.50), 12, "gross", "Medium", "   ");
//		badnode.AddFoodItem(badFood);
//		System.out.println(restaurantCategories.toString());		
		
//		restaurantCategories.DeleteFoodItem(badnode, badFood);
//		System.out.println(restaurantCategories.toString());	
//		
//		restaurantCategories.DeleteCategory(badnode);
		
		System.out.println(restaurantCategories.toString());
}
	
	// constructor to use a gui
	public A2Restaurant()
	{
		A2VendorGUI gui = new A2VendorGUI(this);
		gui.setVisible(true);
	}
	
	
	//methods that the action listeners call
	public void addCategory(String name)
	{
		A2CategoryNode node = new A2CategoryNode(name);
		restaurantCategories.AddCategory(node);
		restaurantCategories.writeData(FILENAME);
	}
	
	public void addFoodItem(String CategoryName, String Name, Float Price, Integer Quantity, String Description, String Size, String SpecialOrder)
	{
		A2CategoryNode node = new A2CategoryNode(CategoryName);
		A2FoodItem foodItem = new A2FoodItem(Name, Price, Quantity, Description, Size, SpecialOrder);
		restaurantCategories.AddFoodItemToCategory(node, foodItem);
		restaurantCategories.writeData(FILENAME);
	}
	public void deleteCategory(String name)
	{
		A2CategoryNode node = new A2CategoryNode(name);
		restaurantCategories.DeleteCategory(node);
		restaurantCategories.writeData(FILENAME);
	}
	public void deleteFoodItem(String categoryName, String name)
	{
		A2CategoryNode node = new A2CategoryNode(categoryName);
		A2FoodItem foodItem = new A2FoodItem(name);
		restaurantCategories.DeleteFoodItem(node,foodItem);
		restaurantCategories.writeData(FILENAME);
	}
	public void updateFoodItem(String CategoryName, String Name, Float Price, Integer Quantity, String Description, String Size, String SpecialOrder)
	{
		A2CategoryNode node = new A2CategoryNode(CategoryName);
		A2FoodItem foodItem = new A2FoodItem(Name, Price, Quantity, Description, Size, SpecialOrder);
		restaurantCategories.UpdateFoodItem(node, foodItem);
		restaurantCategories.writeData(FILENAME);
	}
	public A2FoodItem searchFoodItem(String CategoryName, String Name)
	{
		A2FoodItem item = null;
		A2CategoryNode node = new A2CategoryNode(CategoryName);
		A2FoodItem foodItem = new A2FoodItem(Name);
		item = restaurantCategories.getFoodItem(node, foodItem);
		
		return item;
	}
	public A2FoodItem searchFoodItem(String foodItemName)
	{
		//loop through all categories looking for the food item if found return the food item if not found return null
		A2FoodItem item = null;
		A2FoodItem foodItem = new A2FoodItem(foodItemName);
		item = restaurantCategories.getFoodItem(foodItem);
		
		return item;
	}


	public String toString(){
		return restaurantCategories.toString();
	}

}
