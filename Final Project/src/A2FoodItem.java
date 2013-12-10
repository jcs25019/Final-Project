import java.io.PrintWriter;

public class A2FoodItem
{
	private String Name;
	private Float Price;
	private Integer Quantity;
	private String Description;
	private String Size;
	private String SpecialOrder;
	
	public A2FoodItem (String Name, Float Price, Integer Quantity, String Description, String Size, String SpecialOrder)
	{
		this.Name = Name;
		this.Price = Price;
		this.Quantity = Quantity;
		this.Description = Description;
		this.Size = Size;
		this.SpecialOrder = SpecialOrder;
	}
	public A2FoodItem(String Name)
	{
		this.Name = Name;
	}

	public String getName()
	{
		return Name;
	}
	
	public void update(Float Price, Integer Quantity, String Description, String Size, String SpecialOrder)
	{
		this.Price = Price;
		this.Quantity = Quantity;
		this.Description = Description;
		this.Size = Size;
		this.SpecialOrder = SpecialOrder;
	}

	public void writeData(PrintWriter outputStream)
	{
		outputStream.print(Name);
		outputStream.print("\n");
		outputStream.print(Price);
		outputStream.print("\n");
		outputStream.print(Quantity);
		outputStream.print("\n");
		outputStream.print(Description);
		outputStream.print("\n");
		outputStream.print(Size);
		outputStream.print("\n");
		outputStream.print(SpecialOrder);
		outputStream.print("\n");
	}

	public boolean equals(Object obj)
	{
	   boolean same = false;
	   if (obj != null)
	   {
		   if (obj instanceof A2FoodItem)
		   {
			   A2FoodItem otherNode = (A2FoodItem) obj;
		       same = (Name.equals(otherNode.Name));
		   }
	   }
	   return same;
	}
	
	public String toString()
	{
		StringBuilder strBuilder = new StringBuilder("Food Item Name: ");
		strBuilder.append(Name);
		strBuilder.append("\nPrice: " + Price);
		strBuilder.append("\nQuantity: " + Quantity);
		strBuilder.append("\nDescription: " + Description);
		strBuilder.append("\nSize: " + Size);
		strBuilder.append("\nSpecialOrder: " + SpecialOrder);
		strBuilder.append("\n");
		return strBuilder.toString();
	}
	public Float getPrice() {
		return Price;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public String getDescription() {
		return Description;
	}
	public String getSize() {
		return Size;
	}
	public String getSpecialOrder() {
		return SpecialOrder;
	}
}
