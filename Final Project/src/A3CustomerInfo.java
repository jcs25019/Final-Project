import java.util.Date;

public class A3CustomerInfo
{
	private String partyName;
	private String seatType;
	private int partySize;
	private Date date = new Date();
	
	public A3CustomerInfo(String partyName, String seatType, int partySize)
	{
		this.partyName = partyName;
		this.seatType = seatType;
		this.partySize = partySize;
	}
	public String toString()
	{
		String str = partyName + " Size of party: " + partySize + " " + seatType + " " + date.toString();
		return str;
	}
	
	public boolean equals(Object obj)
	{
	   boolean same = false;
	   if (obj != null)
	   {
		   if (obj instanceof A3CustomerInfo)
		   {
			   A3CustomerInfo otherNode = (A3CustomerInfo) obj;
		       same = (partyName.equals(otherNode.partyName) && (partySize == otherNode.partySize));
		   }
	   }
	   return same;
	}

}