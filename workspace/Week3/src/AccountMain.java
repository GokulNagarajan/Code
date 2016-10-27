import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class AccountMain  {
	static Map<String,Account> m=new HashMap<String,Account>();
	public static Scanner scan=new Scanner(System.in);
			public static void main(String[] args) throws MyException{
			String choice="";
			String accountNo;
			double amount;
			while(true)
			{
				System.out.println("1. Add Account");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Balance Enquiry");
				System.out.println("Press others to Exit");
				System.out.println("Enter the choice");
				choice=scan.nextLine();
				try
				{
				switch(choice)
				{
				case "1":
					addAccount();
					scan.nextLine();
					break;
				case "2":
					accountNo=getAccountNo();
					amount=getAmount();
					if(checkDeposit(accountNo,amount)==1)
					{
						System.out.println("Balance Amount : "+getbalance(accountNo));
						scan.nextLine();
					}
					break;
				case "3":
					accountNo=getAccountNo();
					amount=getAmount();
					if(checkWithdraw(accountNo,amount)==1)
					{
						System.out.println("Balance Amount : "+getbalance(accountNo));
						scan.nextLine();
					}
					break;
				case "4":
					accountNo=getAccountNo();
					if(checkBalance(accountNo)==1)
					{
						System.out.println("Balance Amount : "+getbalance(accountNo));
						//scan.nextLine();
					}
					break;
				default:
					System.exit(0);;
				}
				}
				catch(Exception e)
				{
					System.out.println();
				}
				}
			}	
			public static double getbalance(String accountNo) {
				return m.get(accountNo).balance;
			}
			private static double getAmount() {
				double amount;
				while(true)
				{
				try
				{
					System.out.println("Enter the Amount");
					amount=scan.nextDouble();
					if(amount>0)
						break;
					else
					{
						throw new MyException("Invalid amount");
					}
				}
				catch(MyException e)
				{
				}
				catch(Exception e)
				{
					System.out.println(e.toString());
					scan.next();
				}
				}
				return amount;
			}
			private static String getAccountNo() {
				System.out.println("Enter the Account Number");
				String accNo = scan.nextLine();
				return accNo;
			}
			public static int checkBalance(String accountNo) {
				if(m.containsKey(accountNo))
					//System.out.println("Balance Amount : "+m.get(accountNo).balance);
					return 1;
				else
					//System.out.println("Account Number is Not Present");
					return 0;
			}
			public static int checkWithdraw(String accountNo,double amount) throws MyException {
				if(m.containsKey(accountNo))
				{
					while(true)
					{
						if(amount>0)
						{
						if(m.get(accountNo).balance>=amount)
						{
							m.get(accountNo).balance-=amount;
							return 1;
						}
						else
						{
							throw new MyException("Insufficient amount");
						}
						}
						else
						{
							throw new MyException("Invalid amount");
						}
					}
				}
				else
					System.out.println("Account Number is Not Present");
				return 0;
			}
			public static int checkDeposit(String accountNo,double amount) throws MyException {
				if(m.containsKey(accountNo))
				{
					if(amount>0)
						{
							m.get(accountNo).balance+=amount;
							return 1;
						}
						else
						{
							throw new MyException("Invalid amount");
						}
				}
				else
					System.out.println("Account Number is Not Present");
				return 0;
			}
			public static void addAccount() {
				Account a=new Account();
				getDetails(a);
				addAccount(a);
			}
			public static void addAccount(Account a) {
				m.put(a.accountNo,a);
			}
			
			public static void getDetails(Account a)
			{
				System.out.println("Enter the Account Number");
				a.accountNo=scan.nextLine();
				System.out.println("Enter the Account Holder Name");
				a.accountHolderName=scan.nextLine();
				while(true)
				{
				try
				{
					System.out.println("Enter the Balance Amount");
					a.balance=scan.nextDouble();
					if(a.balance>0)
						break;
					else
					{
						throw new MyException("Invalid amount");
					}
				}
				catch(MyException e)
				{
				}
				catch(Exception e)
				{
					System.out.println(e.toString());
					scan.next();
				}
				}
			}
			public void displayDetails(Account a)
			{
				System.out.println("Account Number : "+a.accountNo+"\nAccount Holder : "+a.accountHolderName+"\nBalance Amount : "+a.balance);
			}
			public static int getAccounts(String accountNo)
			{
				//Account a=new Account("108","gokul",2500);
				if(m.containsKey(accountNo))
					return 1;
				else
					return 0;
			}
}
