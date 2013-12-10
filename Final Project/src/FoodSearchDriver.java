import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Random;

public class FoodSearchDriver 
{
	private A4BinarySearchTree<A4FoodItems> foodDictionary;
	private Scanner inFile;

	Scanner kbd = new Scanner(System.in);

	public static void main(String[] args)
	{
		FoodSearchDriver Dictionary = new FoodSearchDriver ();
		Random gen = new Random ();
		Dictionary.readFile("foodList.txt");
		System.out.println(Dictionary);
		int what = 0;

		do
		{
			what = gen.nextInt (20);
			if (what % 1 == 0)
				Dictionary.arrival ();
			else if (what == 17)
				break;
		} while (true);

		Dictionary.saveDictionary  ("foodList.txt");
	}

	public FoodSearchDriver()
	{
		foodDictionary = new A4BinarySearchTree<A4FoodItems>();
		add("hamburger", "meat");
		inFile = null;
	}

	public void readFile (String fileName)
	{
		try
		{
			inFile = new Scanner (new File (fileName));
		}
		catch (FileNotFoundException ex)
		{
			System.out.println ("file not found");
			System.exit(0);
		}

		inFile.close ();
	}

	public void saveDictionary (String outfileName)
	{

		PrintWriter outfile = null;

		try
		{
			outfile = new PrintWriter (outfileName);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println ("fail to open file");
			System.exit (0);
		}
		foodDictionary.TraverseAndPrint(outfile);
		outfile.close ();
	}
	
	public String getDictionary()
	{
		String str = new String();
		str = foodDictionary.TraverseAndString(str);
		return str;
	}


	public void append (A4FoodItems nDictionary)
	{
		System.out.println("\n\nNew Food Added.......\n");
		saveDictionary("foodList.txt");
	}

	private int menu()
	{
		String instring = "";

		do
		{
			System.out.println ("\n\n  Welcome to the Food Dictionary: \n\n" +
					"menu:\n" +
					"1: Search for Food Item\n" +
					"2: Exit\n\n" +
					"enter your choice: ");

			instring = kbd.nextLine ();
			if ((!instring.equals ("1")) && (!instring.equals ("2")))
				System.out.println ("illegal input");
			else
				break;
		} while (true);

		return Integer.parseInt (instring);
	}

	public void arrival ()
	{
		int choice = menu ();

		switch (choice)
		{
		case 1: 
			search (); 
			break;
		case 2: 
			saveDictionary  ("foodList.txt");
			exit (); 
		}
	}

	public void search()
	{
		System.out.println("Please enter a Food Item to search for: ");
		String searchedFoodItem = kbd.nextLine();
		A4FoodItems a = new A4FoodItems(searchedFoodItem);
		A4Node<A4FoodItems> b = new A4Node<A4FoodItems>(a);
		A4Node<A4FoodItems> foundNode = foodDictionary.binarySearch(b);
		if (foundNode != null)
		{
			ArrayList<String> Ingredients = foundNode.getData().getIngredients();
			System.out.println(Ingredients);
			System.out.println("Would you like to add another Ingredient?");
			System.out.println("If yes, type 1 and press enter");
			System.out.println("If no, type 2 and press enter");
			String x = kbd.nextLine();
			int answer = Integer.parseInt(x);
			if(answer == 1)
			{
				System.out.println("Please enter Ingredient of the Food Item: ");
				String nIngredient = kbd.nextLine().toLowerCase();
				a.setIngredients(nIngredient);
				System.out.println("Would you like to add another Ingredient?");
				System.out.println("If yes, type 1 and press enter");
				System.out.println("If no, type 2 and press enter");
				String d = kbd.nextLine();
				int answer1 = Integer.parseInt(d);
				while(foodDictionary.add(a))
				{
					if(answer1 == 1)
					{
						System.out.println("Please enter Ingredient of the Food Item: ");
						String newIngredient1 = kbd.nextLine().toLowerCase();
						a.setIngredients(newIngredient1);
						foodDictionary.add(a);
					}
					else if (answer1 == 2)
					{
						
					}
				}
			}
		}
		else
		{
			System.out.println("Food Item not found.");
			System.out.println("Would you like to add the Food Item?");
			System.out.println("If yes, type 1 and press enter");
			System.out.println("If no, type 2 and press enter");
			String c = kbd.nextLine();
			int answer2 = Integer.parseInt(c);
			if (answer2 == 1)
			{
				a.setFoodItem(searchedFoodItem);
				System.out.println("Please enter Ingredient of the Food Item: ");
				String newIngredient = kbd.nextLine().toLowerCase();
				a.setIngredients(newIngredient);
				System.out.println("Would you like to add another Ingredient?");
				System.out.println("If yes, type 1 and press enter");
				System.out.println("If no, type 2 and press enter");
				String d = kbd.nextLine();
				int answer3 = Integer.parseInt(d);
				while(foodDictionary.add(a))
				{
					if(answer3 == 1)
					{
						System.out.println("Please enter Ingredient of the Food Item: ");
						String newIngredient1 = kbd.nextLine().toLowerCase();
						a.setIngredients(newIngredient1);
						foodDictionary.add(a);
					}
					else if (answer3 == 2)
					{
						
					}
				}
			}
			else if (answer2 == 2);
			{
				
			}
		}
	}
	
	public void add(String foodItem, String ingredient)
	{
		
		A4FoodItems a = new A4FoodItems(foodItem);
		A4Node<A4FoodItems> b = new A4Node<A4FoodItems>(a);
		A4Node<A4FoodItems> foundNode = foodDictionary.binarySearch(b);
		if (foundNode != null)
		{
			ArrayList<String> Ingredients = foundNode.getData().getIngredients();
			a.setIngredients(ingredient);
		}
		else
		{
			a.setFoodItem(foodItem);
			a.setIngredients(ingredient);
			foodDictionary.add(a);
		}	
	}

	public void exit()
	{
		System.out.println("Program Terminated");
		System.exit(0);
	}
}