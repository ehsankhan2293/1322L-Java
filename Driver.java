

public class Driver {
	public static void main(String args[]){  
		CreditCard credit_card = new CreditCard();
		CardHolder card_holder = new CardHolder(credit_card);
        Thread t1 = new Thread(card_holder);
        Thread t2 = new Thread(card_holder);
        t1.setName("John");
        t2.setName("Mary");
        t1.start();
        t2.start();
	}
	
	
}
