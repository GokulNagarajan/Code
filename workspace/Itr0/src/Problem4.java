import java.util.Scanner;
public class Problem4 {
	private static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0,k=-1,n,choice=0,absent,totItems=0;
		scan=new Scanner(System.in);
		do
		{
		try
		{
		System.out.println("Enter the stock details");
		System.out.println("enter the number of items");
		n=scan.nextInt();
		break;
		}
		catch(Exception e)
		{
			System.out.println("Enter valid input");
			scan.next();
		}
		}while(true);
		double sum=0;
		String [] id=new String[20];
		String [] itemId=new String[20];
		int [] pos=new int [10];
		double [] amount=new double[20];
		double [] discount=new double[20];
		int [] quantity=new int[20];
		int [] qty=new int[20];
		double [] price=new double[20];
		String [] name=new String[20];
		do
		{
			scan.nextLine();
			System.out.println("enter the product id");
			id[i]=scan.nextLine();
			System.out.println("enter the product name");
			name[i]=scan.nextLine();
			do
			{
			try
			{
			System.out.println("enter the product quantity");
			qty[i]=scan.nextInt();
			if(qty[i]>0)
			{	
			do
			{
				try
				{
					System.out.println("enter the product price");
					price[i]=scan.nextDouble();
					if(price[i]>0)
						break;
					else
						System.out.println("enter the product price > 0");
				}
				catch(Exception e)
				{
					System.out.println("Enter valid credentials");
					scan.next();
				}
			}while(true);
			break;
			}
			else
				System.out.println("enter the product quantity > 0");
			}
			catch(Exception e)
			{
				System.out.println("Enter valid credentials");
				scan.next();
			}
			}while(true);
			i++;
		}while(i<n);
		System.out.println("enter the purchase details");
		int count=1;
		while(count==1)
		{
			++k;
			absent=n;
			scan.nextLine();
			System.out.println("enter the product id");
			itemId[k]=scan.nextLine();
			pos[k]=-1;
			for(i=0;i<n;i++)
			{
				if(itemId[k].equals(id[i])&&qty[i]>0)
				{
					pos[k]=i;
					System.out.println("enter the quantity");
					quantity[k]=scan.nextInt();
					while(quantity[k]>qty[i])
					{
						System.out.println("quantity remaining is "+qty[i]);
						System.out.println(" enter quantity less than or equal to "+qty[i]);
						quantity[k]=scan.nextInt();
					}
					System.out.println("enter the discount");
					discount[k]=scan.nextDouble();
					amount[k]=(quantity[k]*price[i])*((100-discount[k])/100);
					sum=sum+amount[k];
					qty[i]=qty[i]-quantity[k];
					++totItems;
					absent--;
					break;
				}
				else if(itemId[k].equals(id[i])&&qty[i]==0)
				{	
					System.out.println("product out of stock");
					absent--;
					break;
				}
			}
			if(absent==n)
			{
				System.out.println("product not found");
				--k;
			}
			System.out.println("press 1 to continue purchase");
			count=scan.nextInt();
		}		
		System.out.println("Bill details ");
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("Item id \t\t Name \t Quantity \t Price \t\t Discount \t Amount");
		System.out.println("------------------------------------------------------------------------------------------------");
		for(i=0;i<totItems;i++)
		{
			System.out.println("\t"+itemId[i]+"\t\t"+name[pos[i]]+"\t"+quantity[i]+"\t\t"+price[pos[i]]+"\t\t"+discount[i]+"\t\t"+amount[i]);
		}
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("Total \t\t\t\t\t\t\t\t\t\t"+sum);
		String pid;
		int loc;
		System.out.println();
		for(i=0;i<n;i++)
		{
			itemId[i]=id[i];
			pos[i]=i;
		}
		sort(itemId,pos,0,n-1,n);
		do
		{
		scan.nextLine();
		System.out.println("enter product id to get details");
		pid=scan.nextLine();
		loc=search(itemId,pos,pid,n);
		if(loc==-1)
		{
			System.out.println("product not found");
		}
		else
		{
			System.out.println("Item found at Position "+loc);
			System.out.println("itemId\t\tname\tquantity\tprice");
			System.out.println(id[loc]+"\t\t"+name[loc]+"\t"+qty[loc]+"\t\t"+price[loc]);
		}
		do
		{
		try
		{
		System.out.println("press 1 to continue search");
		choice=scan.nextInt();
		break;
		}
		catch(Exception e)
		{
			System.out.println("Enter valid input");
			scan.next();
		}
		}while(true);
		}while(choice==1);
	}
	public static int search(String itemId[],int pos[],String pid,int n)
	{
		int low=0,high=n-1,mid,loc;
		while(low<=high)
		{
			mid=low+(high-low)/2;
			if(itemId[mid].equals(pid))
			{
				loc=pos[mid];
				return loc;
			}
			else if(itemId[mid].compareTo(pid)>0)
				high=mid-1;
			else
				low=mid+1;
		}
		return -1;
	}
	public static void sort(String arr[],int pos[],int low,int high,int n)
	{
		if(low<high)
		{
			int mid=low+(high-low)/2;
			sort(arr,pos,low,mid,n);
			sort(arr,pos,mid+1,high,n);
			merge(arr,pos,low,mid,high,n);
		}
	}
	public static void merge(String arr[],int pos[],int low,int mid,int high,int n)
	{
		int n1=mid-low+1;
		int n2=high-mid;
		String [] L=new String[n1];
		String [] R=new String[n2];
		int i,j,k;
		for(i=0;i<n1;i++)
		{
			L[i]=arr[low+i];
		}
		for(j=0;j<n2;j++)
		{
			R[j]=arr[mid+1+j];
		}
		i=0;
		j=0;
		k=low;
		while(i<n1&&j<n2)
		{
			if(L[i].compareTo(R[j])<0)
			{
				arr[k]=L[i];
				i++;
			}
			else
			{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			arr[k]=R[j];
			j++;
			k++;
		}
	}
}
