public class A4Node<T>
{
	private T data;
	private A4Node left;
	private A4Node right;
	
	public A4Node(T newData)
	{
		data = newData;
		left = null;
		right = null;
	}
	
	public A4Node()
	{
		data  = null;
		left = null;
		right = null;
	}
	
	public String toString()
	{
		return data.toString();
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setLeft (A4Node newLeft)
	{
		left = newLeft;
	}
	
	public A4Node getLeft()
	{
		return left;
	}
	
	public void setRight (A4Node newRight)
	{
		right = newRight;
	}
	
	public A4Node getRight()
	{
		return right;
	}
	
	public boolean equals(A4Node theOther)
	{
		return this.data.equals(theOther.data);
	}

	public int compareTo(A4Node c) {
		
		String str1 = this.getData().toString();
	
		if(str1.contains(" ")){
		  str1 = str1.substring(0, str1.indexOf(" ")); 
		}
		
		String str2 = c.getData().toString();
		if(str2.contains(" ")){
			  str2 = str2.substring(0, str2.indexOf(" ")); 
		}

		return str1.compareTo(str2);
	}
}
