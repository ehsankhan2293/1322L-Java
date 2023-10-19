import java.util.*;

class Bank_Account {
    private String name;
    private int account_id;
    private static int number_of_accounts = 0;
    private String user_id;
    private String user_password;
    private double account_balance;

    public Bank_Account()
    {
        account_balance = 0.0;
    }

    public Bank_Account(String n, String id, String password)
    {
        name = n;
        user_id = id;
        user_password = password;
        number_of_accounts++;
        account_id = number_of_accounts;
    }
    public String getName()
    {
        return name;
    }
    public String getUserId()
    {
        return user_id;
    }
    public String getUserPassword()
    {
        return user_password;
    }
    public double getAccountBalance()
    {
        return account_balance;
    }
    public void setName(String n)
    {
        name = n;
    }
    public void setUserId(String id)
    {
        user_id = id;
    }
    public void setUserPassword(String password)
    {
        user_password = password;
    }
    public void setAccountBalance(double bal)
    {
        account_balance += bal;
    }
    public int getAccountId()
    {
        return account_id;
    }
    public static int getNumberOfAccounts()
    {
        return number_of_accounts;
    }
    public static void decrementNumberOfAccounts()
    {
        number_of_accounts--;
    }
}

  class Checking_Account extends Bank_Account{
     private double daily_withdrawal_limit;

     public Checking_Account(String name, String id, String password)
     {
         super(name, id, password);
         daily_withdrawal_limit = 300.00;
     }
     public double getDailyWithdrawalLimit()
     {
         return daily_withdrawal_limit;
     }
     public void setDailyWithdrawalLimit(double limit)
     {
         daily_withdrawal_limit = limit;
     }
 }

 class CustomerAccountNotFoundException extends Exception{
     public CustomerAccountNotFoundException(String s)
     {
         super(s);
     }
 }

  class InsufficientFundsException extends Exception{
     public InsufficientFundsException(String s)
     {
         super(s);
     }
 }

  class InvalidPasswordFormatException extends Exception{
     public InvalidPasswordFormatException(String s)
     {
         super(s);
     }
 }

 class NegativeDollarAmountException extends Exception{
    public NegativeDollarAmountException(String s)
    {
        super(s);
    }
}


public class Assignment9 {
     public static void main(String args[])
     {
         Scanner sc = new Scanner(System.in);
         ArrayList<Checking_Account> list = new ArrayList<>();

         while(true)
         {
             System.out.println("1 - Create An Account");
             System.out.println("2 - Delete An Account");
             System.out.println("3 - Make An Account Deposit");
             System.out.println("4 - Make An Account Withdrawal");
             System.out.println("5 - Check An Account Balance");
             System.out.println("6 - Exit\n");

             System.out.print("Enter Choice: ");
             int choice = sc.nextInt();

             if(choice == 1)
             {
                 try{
                     System.out.print("\nEnter customer name: ");
                     String fname = sc.next();
                     String lname = sc.next();
                     String name = fname+" "+lname;
                     System.out.print("Enter user id: ");
                     String id = sc.next();
                     System.out.print("Enter user password: ");
                     String password = sc.next();
                     System.out.println();

                     if(password.length() < 8 || password.indexOf("*") < 0)
                     {
                         throw new InvalidPasswordFormatException("Error: Must Enter a Valid Password\n");
                     }

                     Checking_Account ac = new Checking_Account(name, id, password);
                     list.add(ac);
                 }
                 catch(InvalidPasswordFormatException exp)
                 {
                     System.out.println("\nInvalidPasswordFormatException: Invalid Password Format");
                     System.out.println(exp.getMessage());
                 }
             }
             else if(choice == 2)
             {
                 try{
                     System.out.print("\nEnter user id: ");
                     String id = sc.next();
                     System.out.print("Enter user password: ");
                     String password = sc.next();
                     System.out.println();
                     boolean isExists = false;

                     for(int i=0;i<list.size();i++)
                     {
                         if(list.get(i).getUserId().equals(id) && list.get(i).getUserPassword().equals(password))
                         {
                             isExists = true;
                             list.remove(i);
                             Bank_Account.decrementNumberOfAccounts();
                             break;
                         }
                     }

                     if(!isExists)
                     {
                         throw new CustomerAccountNotFoundException("CustomerAccountNotFoundException: Customer Account Not Found\n");
                     }
                 }
                 catch(CustomerAccountNotFoundException exp)
                 {
                     System.out.println("\nError: Must Enter a Valid User ID and Password");
                     System.out.println(exp.getMessage());
                 }
             }
             else if(choice == 3)
             {
                 try{
                     System.out.print("\nEnter user id: ");
                     String id = sc.next();
                     System.out.print("Enter user password: ");
                     String password = sc.next();
                     boolean isExists = false;

                     for(int i=0;i<list.size();i++)
                     {
                         if(list.get(i).getUserId().equals(id) && list.get(i).getUserPassword().equals(password))
                         {
                             isExists = true;

                             System.out.print("Enter the amount: ");
                             double amount = sc.nextDouble();
                             System.out.println();

                             if(amount < 0)
                             {
                                 throw new NegativeDollarAmountException("Error: Must Enter a Positive Dollar Amount\n");
                             }

                             list.get(i).setAccountBalance(amount);
                             break;
                         }
                     }

                     if(!isExists)
                     {
                         throw new CustomerAccountNotFoundException("CustomerAccountNotFoundException: Customer Account Not Found\n");
                     }
                 }
                 catch(CustomerAccountNotFoundException exp)
                 {
                     System.out.println("\nError: Must Enter a Valid User ID and Password");
                     System.out.println(exp.getMessage());
                 }
                 catch(NegativeDollarAmountException exp)
                 {
                     System.out.println("\nNegativeDollarAmountException: Negative Dollar Amount");
                     System.out.println(exp.getMessage());
                 }
             }
             else if(choice == 4)
             {
                 try{
                     System.out.print("\nEnter user id: ");
                     String id = sc.next();
                     System.out.print("Enter user password: ");
                     String password = sc.next();
                     boolean isExists = false;

                     for(int i=0;i<list.size();i++)
                     {
                         if(list.get(i).getUserId().equals(id) && list.get(i).getUserPassword().equals(password))
                         {
                             isExists = true;

                             System.out.print("Enter the amount: ");
                             double amount = sc.nextDouble();
                             System.out.println();

                             if(amount < 0)
                             {
                                 throw new NegativeDollarAmountException("Error: Must Enter a Positive Dollar Amount\n");
                             }
                             if(list.get(i).getAccountBalance() < amount)
                             {
                                 throw new InsufficientFundsException("InsufficientFundsException: Insufficient Funds\n");
                             }

                             list.get(i).setAccountBalance(-amount);
                             break;
                         }
                     }

                     if(!isExists)
                     {
                         throw new CustomerAccountNotFoundException("CustomerAccountNotFoundException: Customer Account Not Found\n");
                     }
                 }
                 catch(CustomerAccountNotFoundException exp)
                 {
                     System.out.println("\nError: Must Enter a Valid User ID and Password");
                     System.out.println(exp.getMessage());
                 }
                 catch(NegativeDollarAmountException exp)
                 {
                     System.out.println("\nNegativeDollarAmountException: Negative Dollar Amount");
                     System.out.println(exp.getMessage());
                 }
                 catch(InsufficientFundsException exp)
                 {
                     System.out.println("\nError: Must Withdraw an Amount Less Than Your Balance");
                     System.out.println(exp.getMessage());
                 }
             }
             else if(choice == 5)
             {
                 try{
                     System.out.print("\nEnter user id: ");
                     String id = sc.next();
                     System.out.print("Enter user password: ");
                     String password = sc.next();
                     System.out.println();
                     boolean isExists = false;

                     for(int i=0;i<list.size();i++)
                     {
                         if(list.get(i).getUserId().equals(id) && list.get(i).getUserPassword().equals(password))
                         {
                             isExists = true;
                             System.out.println("Customer Name: "+list.get(i).getName());
                             System.out.println("Account Number: "+list.get(i).getAccountId());
                             System.out.println("Account Balance: "+list.get(i).getAccountBalance());
                             System.out.println("Account Type: Checking");
                             System.out.println("Account Daily Withdrawal Limit: "+list.get(i).getDailyWithdrawalLimit());
                             System.out.println();
                             break;
                         }
                     }

                     if(!isExists)
                     {
                         throw new CustomerAccountNotFoundException("CustomerAccountNotFoundException: Customer Account Not Found\n");
                     }
                 }
                 catch(CustomerAccountNotFoundException exp)
                 {
                     System.out.println("\nError: Must Enter a Valid User ID and Password");
                     System.out.println(exp.getMessage());
                 }
             }
             else if(choice == 6)
             {
                 System.exit(0);
             }
             else{
                 System.out.println("\nError: Please enter a valid choice (1 thru 6)\n");
             }
         }
     }
}
