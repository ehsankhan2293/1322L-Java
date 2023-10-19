
import java.lang.Thread;

public class CardHolder implements Runnable{
private CreditCard card;

public CardHolder(CreditCard c)
{	
	card = c;
}
public void run()
{
	for(int i = 0;i<6;i++)
	{
		makeWithdrawal (500);
	}
}

private synchronized void makeWithdrawal(double amount)
{
	if (card.getBalance()<amount )
	{
		System.out.println("Not enough in account for "+Thread.currentThread().getName()  +" to withdraw $" +amount);
	}
	else
	{
		System.out.println(Thread.currentThread().getName() + " Before withdrawing $" + amount + ", Balance" + card.getBalance());
		try {
		Thread.sleep(600);
		
		}
		catch(Exception e)
		{
			
		}
		card.withdraw(amount);
		System.out.println(Thread.currentThread().getName() +  " after withdrawing $" +amount + " Balance, " + card.getBalance());

	}
	
}
}
