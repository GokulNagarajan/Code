
public class Account 
{
	String accountNo,accountHolderName;
	double balance;
	public Account()
	{
		accountNo="";
		accountHolderName="";
		balance=0;
	}
	public Account(String accNo,String accHolderName,double bal)
	{
		accountNo=accNo;
		accountHolderName=accHolderName;
		balance=bal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((accountHolderName == null) ? 0 : accountHolderName
						.hashCode());
		result = prime * result
				+ ((accountNo == null) ? 0 : accountNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountHolderName == null) {
			if (other.accountHolderName != null)
				return false;
		} else if (!accountHolderName.equals(other.accountHolderName))
			return false;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double
				.doubleToLongBits(other.balance))
			return false;
		return true;
	}
	
}