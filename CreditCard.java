
public class CreditCard {

	private double account_balance;
	public CreditCard()
	{
		account_balance =5000;
	}
	public double getBalance()
	{
	return account_balance;
	}
	
	public void withdraw(double a)
	{
		account_balance -= a;
	}
}
