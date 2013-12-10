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

public class OrderGUI extends JFrame implements ActionListener
{
	private JTextField foodItemField;
	private JLabel priceField;
	private JTextField quantityField;
	private JTextField descriptionField;
	private JTextField sizeField;
	private JTextField specialOrderField;
	private JLabel message;
	private JTextArea outputArea;
	
    private A2Restaurant restaurant;
    private A3CustomerInfo customer;

	public OrderGUI(A2Restaurant restaurant, A3CustomerInfo customer)
	{
		this.restaurant = restaurant;
		this.customer = customer;
		init();
		pack();
		setSize(700, 600);
	}
	    
	public void actionPerformed(ActionEvent e)
	{
		//action events for buttons
		Container contentPane = getContentPane();
		
		if (e. getActionCommand().equals("Search"))
		{
			A2FoodItem item = restaurant.searchFoodItem(foodItemField.getText());
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
			
			foodItemField.setText(" "); 
			priceField.setText(" ");
			quantityField.setText(" ");
			descriptionField.setText(" "); 
			sizeField.setText(" ");
			specialOrderField.setText(" ");
		}
		else if (e. getActionCommand().equals("Exit"))
		{
			this.setVisible(false);
		}
	}
	
	public void init()
	{
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new FlowLayout());
		
		//adding labels and entry fields to its own panel
		JPanel entryPanel = new JPanel();
		JLabel label = new JLabel("Customer Name: " + customer.toString());
		entryPanel.add(label);
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
		priceField = new JLabel();
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

		//adding the output text field
		outputArea = new JTextArea(15, 50);
		JScrollPane scroll = new JScrollPane(outputArea);
		outputArea.setEditable(false);
		contentPane.add(scroll);
	}
}