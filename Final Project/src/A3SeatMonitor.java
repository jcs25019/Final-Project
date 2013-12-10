import java.util.Random;

public class A3SeatMonitor implements Runnable
{	
	A3CircularQueue<A3CustomerInfo> windowSeat;
	A3CircularQueue<A3CustomerInfo> boothSeat;
	A3CircularQueue<A3CustomerInfo> barSeat;

	public A3SeatMonitor(A3CircularQueue<A3CustomerInfo> windowSeat, A3CircularQueue<A3CustomerInfo> boothSeat, A3CircularQueue<A3CustomerInfo> barSeat)
	{
		this.windowSeat = windowSeat;
		this.boothSeat = boothSeat;
		this.barSeat = barSeat;
	}

	Random randomNumber = new Random();

	public boolean isBoothAvailable()
	{
		boolean availableSeats = false;

		Random randomNumber = new Random();
		int seatNumber = randomNumber.nextInt (10);
		if (seatNumber%2 == 0)
		{
			availableSeats = true;
			System.out.println(" Booth Seat is available.");
		}
		else
			System.out.println("Booth Seat is not available.");			

		return availableSeats;
	}

	public boolean isBarAvailable()
	{
		boolean availableSeats = false;

		Random randomNumber = new Random();
		int seatNumber = randomNumber.nextInt (10);
		if (seatNumber%2 == 0)
		{
			availableSeats = true;
			System.out.println(" Bar Seat is available.");
		}
		else
			System.out.println("Bar Seat is not available.");			

		return availableSeats;	
	}

	public boolean isWindowAvailable()
	{
		boolean availableSeats = false;

		Random randomNumber = new Random();
		int seatNumber = randomNumber.nextInt (10);
		if (seatNumber%2 == 0)
		{
			availableSeats = true;
			System.out.println(" Window Seat is available.");
		}
		else
			System.out.println("Window Seat is not available.");			

		return availableSeats;
	}

	public void run()
	{
		while(true)
		{
			if(isBoothAvailable())
			{
				try
				{
					A3CustomerInfo customer = boothSeat.dequeue();
					OrderGUI ordergui = new OrderGUI(A2Restaurant.getInstance(), customer);
					ordergui.setVisible(true);
					
				} catch (A3QueueUnderflowException e)
				{
				}
			}
			if(isBarAvailable())
			{
				try
				{
					A3CustomerInfo customer = barSeat.dequeue();
					OrderGUI ordergui = new OrderGUI(A2Restaurant.getInstance(), customer);
					ordergui.setVisible(true);
					
				} catch (A3QueueUnderflowException e)
				{
				}
			}
			if(isWindowAvailable())
			{
				try
				{
					A3CustomerInfo customer = windowSeat.dequeue();
					OrderGUI ordergui = new OrderGUI(A2Restaurant.getInstance(), customer);
					ordergui.setVisible(true);
					
				} catch (A3QueueUnderflowException e)
				{
				}
			}
			try
			{
				Thread.currentThread().sleep(10000);
			} catch (InterruptedException e)
			{
			}
		}
	}
}
