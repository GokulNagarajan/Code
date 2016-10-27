import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem10 {
	private static Scanner scan;
	static BufferedReader in=null;
	static BufferedWriter out=null;
	static String input;
	private static char[] inputArr;
	public static void main(String[] args) throws IOException {
		scan=new Scanner(System.in);
		int i=0,n;
		String check=new String();
		String user=new String();
		String number=new String();
		check="1";
		String regex = "^[7|8|9]([0-9]){9}$";
		Pattern pattern = Pattern.compile(regex);
		HashMap<String, TreeSet<String>> contact=new HashMap<String,TreeSet<String>>();	
		try {
			in=new BufferedReader(new FileReader("D://TextFile//contacts.txt"));
		} catch (IOException e1) {
			//TextFile// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while((input=in.readLine())!=null)
		{
			i=0;
			if(input.equals(""))
				break;
			inputArr=input.toCharArray();
			for(char c:inputArr)
			{
				if((int)c<48||(int)c>57)
					i++;
				else 
					break;
			}
			user=input.substring(0, i-1);
			number=input.substring(i);
			String[] numbers;
			if(number.length()>10)
			{
				numbers=number.split(" ");
				for(i=0;i<numbers.length;i++)
				{
					if(contact.get(user)==null)
						contact.put(user,new TreeSet<String>(Arrays.asList(numbers[i])));
					else
						contact.get(user).add(numbers[i]);
				}
			}
			else
			{
			if(contact.get(user)==null)
				contact.put(user,new TreeSet<String>(Arrays.asList(number)));
			else
				contact.get(user).add(number);
			}
		}
		in.close();
		while(check.equals("1"))
		{
		System.out.println("Enter the name : ");
		user=scan.nextLine();
		if(contact.get(user)==null)
		{
			while(true)
			{
				System.out.println("Enter the number : ");
				number=scan.nextLine();
				Matcher matcher = pattern.matcher(number);
				if(matcher.matches())
				{	
					System.out.println("Contact Added");
					break;
				}
				else
					System.out.println("Enter the valid number");
			}
			contact.put(user,new TreeSet<String>(Arrays.asList(number)));
		}
		else
		{
			System.out.println("Name already exists ");
			System.out.println("Enter new number : ");
			number=scan.nextLine();
			contact.get(user).add(number);
			System.out.println("Contact Updated");
		}
		System.out.println("Enter 1 to continue adding contact details ");
		check=scan.nextLine();
		}
		String [] names=new String[50];
		Iterator itr=contact.entrySet().iterator();
		Map.Entry map_Entry;
		i=0;
		while(itr.hasNext())
		{
			map_Entry = (Map.Entry)itr.next();
			names[i]= (String)map_Entry.getKey();
			i++;
		}
		n=i;
		sort(names,0,n-1,n);
		try {
			out=new BufferedWriter(new FileWriter("D://TextFile//contacts.txt"));
		} catch (IOException e1) {
			//TextFile// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		i=0;
		while(i<n)
		{
			input="";
			System.out.printf("%s ",names[i]);
			input+=names[i];
		
			for(String e:contact.get(names[i]))
			{
				System.out.printf("%s ",e);
				input+=" "+e;
			}
			i++;
			System.out.println("");
			out.write(input);
			out.newLine();
			
	    }	
		out.close();
	}
	public static void sort(String arr[],int low,int high,int n)
	{
		if(low<high)
		{
			int mid=low+(high-low)/2;
			sort(arr,low,mid,n);
			sort(arr,mid+1,high,n);
			merge(arr,low,mid,high,n);
		}
	}
	public static void merge(String arr[],int low,int mid,int high,int n)
	{
		int n1=mid-low+1;
		int n2=high-mid;
		String [] L=new String[n1];
		String [] R=new String[n2];
		int i,j,k;
		for(i=0;i<n1;i++)
			L[i]=arr[low+i];
		for(j=0;j<n2;j++)
			R[j]=arr[mid+1+j];
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
