import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class A2VendorGUI extends JFrame implements ActionListener
{
	private JTextField categoryField;
	private JTextField foodItemField;
	private JTextField priceField;
	private JTextField quantityField;
	private JTextField descriptionField;
	private JTextField sizeField;
	private JTextField specialOrderField;
	private JLabel message;
	private JTextArea outputArea;
	private JTextField foodField;
	private JTextField ingredientsField;
	
	FoodSearchDriver foodSearchDriver = new FoodSearchDriver();
	
    private A2Restaurant restaurant;
	
	public static void main(String[] args)
	{
		
	}

	public A2VendorGUI(A2Restaurant restaurant)
	{
		this.restaurant = restaurant;
		init();
		pack();
		setSize(700, 800);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//action events for buttons
		Container contentPane = getContentPane();
		if (e. getActionCommand().equals("Add Category"))
		{
			restaurant.addCategory(categoryField.getText());
			outputArea.setText("Results: \n" + restaurant.toString());
		}
		else if (e. getActionCommand().equals("Add Food Item"))
		{
			restaurant.addFoodItem(categoryField.getText(),foodItemField.getText(), 
					new Float(priceField.getText()), 
					new Integer(quantityField.getText()), 
					descriptionField.getText(), 
					sizeField.getText(), 
					specialOrderField.getText());
			outputArea.setText("Results: \n" + restaurant.toString());
		}
		else if (e. getActionCommand().equals("Delete Category"))
		{
			restaurant.deleteCategory(categoryField.getText());
			outputArea.setText("Results: \n" + restaurant.toString());
		}
		else if (e. getActionCommand().equals("Delete Food Item"))
		{
			restaurant.deleteFoodItem(categoryField.getText(), foodItemField.getText());
			outputArea.setText("Results: \n" + restaurant.toString());
		}
		else if (e. getActionCommand().equals("Update Food Item"))
		{
			restaurant.updateFoodItem(categoryField.getText(),foodItemField.getText(), 
					new Float(priceField.getText()), 
					new Integer(quantityField.getText()), 
					descriptionField.getText(), 
					sizeField.getText(), 
					specialOrderField.getText());
			outputArea.setText("Results: \n" + restaurant.toString());
		}
		else if (e. getActionCommand().equals("Search"))
		{
			A2FoodItem item = restaurant.searchFoodItem(categoryField.getText(),foodItemField.getText());
			if (item != null)
			{
				priceField.setText(item.getPrice().toString());
				quantityField.setText(item.getQuantity().toString());
				descriptionField.setText(item.getDescription());
				sizeField.setText(item.getSize());
				specialOrderField.setText(item.getSpecialOrder());
			}
			else 
			{
				priceField.setText(" ");
				quantityField.setText(" ");
				descriptionField.setText(" "); 
				sizeField.setText(" ");
				specialOrderField.setText(" ");
				
			}
			outputArea.setText("Results: \n" + restaurant.toString());
			
		}
		else if (e. getActionCommand().equals("Clear"))
		{
			categoryField.setText(" ");
			foodItemField.setText(" "); 
			priceField.setText(" ");
			quantityField.setText(" ");
			descriptionField.setText(" "); 
			sizeField.setText(" ");
			specialOrderField.setText(" ");
		}
		else if (e. getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		else if (e. getActionCommand().equals("Search For Food"))
		{
			
			outputArea.setText(foodSearchDriver.getDictionary());
		}
		else if (e. getActionCommand().equals("Add"))
		{
			foodSearchDriver.add(foodField.getText(),ingredientsField.getText());
			outputArea.setText(foodSearchDriver.getDictionary());
		}
	}
	
	public void init()
	{
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new FlowLayout());
		
		//adding labels and entry fields to its own panel
		JPanel entryPanel = new JPanel();
		JLabel label = new JLabel("Category: ");
		entryPanel.add(label);
		categoryField = new JTextField(50);
		entryPanel.add(categoryField);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		label = new JLabel("Food Item: ");
		entryPanel.add(label);
		foodItemField = new JTextField(50);
		entryPanel.add(foodItemField);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		label = new JLabel("Price: ");
		entryPanel.add(label);
		priceField = new JTextField(50);
		entryPanel.add(priceField);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		label = new JLabel("Quantity: ");
		entryPanel.add(label);
		quantityField = new JTextField(50);
		entryPanel.add(quantityField);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		label = new JLabel("Description: ");
		entryPanel.add(label);
		descriptionField = new JTextField(50);
		entryPanel.add(descriptionField);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		label = new JLabel("Size: ");
		entryPanel.add(label);
		sizeField = new JTextField(50);
		entryPanel.add(sizeField);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		label = new JLabel("Special Order: ");
		entryPanel.add(label);
		specialOrderField = new JTextField(50);
		entryPanel.add(specialOrderField);
		contentPane.add(entryPanel);
				
		entryPanel = new JPanel();
		
		//adding buttons for different actions
		JButton AddCategory = new JButton("Add Category");
		AddCategory.addActionListener(this);
		contentPane.add(AddCategory);
		JButton AddFoodItem = new JButton("Add Food Item");
		AddFoodItem.addActionListener(this);
		entryPanel.add(AddFoodItem);
		
		JButton DeleteCategory = new JButton("Delete Category");
		DeleteCategory.addActionListener(this);
		contentPane.add(DeleteCategory);
		JButton DeleteFoodItem = new JButton("Delete Food Item");
		DeleteFoodItem.addActionListener(this);
		entryPanel.add(DeleteFoodItem);
		
		JButton UpdateFoodItem = new JButton("Update Food Item");
		UpdateFoodItem.addActionListener(this);
		entryPanel.add(UpdateFoodItem);
		
		JButton Search = new JButton("Search");
		Search.addActionListener(this);
		entryPanel.add(Search);
		
		contentPane.add(entryPanel);

		entryPanel = new JPanel();
		
		JButton Clear = new JButton("Clear");
		Clear.addActionListener(this);
		entryPanel.add(Clear);
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(this);
		entryPanel.add(Exit);
		contentPane.add(entryPanel);
		
		JButton foodSearch = new JButton("Search For Food");
		foodSearch.addActionListener(this);
		entryPanel.add(foodSearch);
		contentPane.add(entryPanel);

		//adding the output text field
		entryPanel = new JPanel();
		outputArea = new JTextArea(15, 50);
		JScrollPane scroll = new JScrollPane(outputArea);
		outputArea.setEditable(false);
		entryPanel.add(scroll);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();		
		JLabel foodDictionary = new JLabel("Food Dictionary");
		entryPanel.add(foodDictionary);		
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		JLabel food = new JLabel("Food: ");
		entryPanel.add(food);
		foodField = new JTextField(20);
		entryPanel.add(foodField);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		JLabel ingredients = new JLabel("Ingredients: ");
		entryPanel.add(ingredients);
		ingredientsField = new JTextField(20);
		entryPanel.add(ingredientsField);
		contentPane.add(entryPanel);
		
		entryPanel = new JPanel();
		JButton add = new JButton("Add");
		add.addActionListener(this);
		entryPanel.add(add);
		contentPane.add(entryPanel);
		
	}
	

}