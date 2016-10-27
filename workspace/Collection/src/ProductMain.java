import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductMain{
	private static Scanner scan;
	static ArrayList<Product> al=new ArrayList<Product>();
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		String choice="";
		while(true)
		{
		getDetails();
		scan.nextLine();
		System.out.println("Enter the 1 to continue adding Product details");
		choice=scan.nextLine();
		if(choice.equals("1"))
			continue;
		break;
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Product details");
		System.out.println("-----------------------------------------------------------------------------------------------");
		displayDetails();
		Collections.sort(al);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Sorted Product details by Product Id");
		System.out.println("-----------------------------------------------------------------------------------------------");
		displayDetails();
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Product details after Comparable");
		System.out.println("-----------------------------------------------------------------------------------------------");
		displayDetails();
		while(true)
		{
		System.out.println("Press 1 to sort by Brand and 2 to sort by Price");
		choice=scan.nextLine();
		if(choice.equals("1"))
		{
			Collections.sort(al, new BrandComparator());
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Sorted Product details by Brand Name");
			System.out.println("-----------------------------------------------------------------------------------------------");
			displayDetails();
		}
		else if(choice.equals("2"))
		{
			Collections.sort(al, new PriceComparator());
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Sorted Product details by Price");
			System.out.println("-----------------------------------------------------------------------------------------------");
			displayDetails();
		}
		System.out.println("Enter the 1 to continue sorting Product details");
		choice=scan.nextLine();
		if(choice.equals("1"))
			continue;
		break;
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Product details after Comparator");
		System.out.println("-----------------------------------------------------------------------------------------------");
		displayDetails();
		
	}
	private static void displayDetails() {
		String space="";
		int i,x;
		System.out.println("Product ID \t\t Brand Name \t\t Description \t\t Price");
		for(i=0;i<al.size();i++)
		{	space="";
			for(x=0;x<(25-al.get(i).productId.length());x++)
				space=space+" ";
			System.out.printf("%s%s%s",al.get(i).productId,space,al.get(i).brandName);
			space="";
			for(x=0;x<(25-al.get(i).brandName.length());x++)
				space=space+" ";
			System.out.printf("%s%s",space,al.get(i).description);
			space="";
			for(x=0;x<(25-al.get(i).description.length());x++)
				space=space+" ";
			System.out.printf("%s%f",space,al.get(i).price);
			System.out.println("");
		}
	}
	private static void getDetails() {
		Product p=new Product();
		System.out.println("Enter the Product Id");
		p.productId=scan.nextLine();
		System.out.println("Enter the Product Brand");
		p.brandName=scan.nextLine();
		System.out.println("Enter the Product Description");
		p.description=scan.nextLine();
		while(true)
		{
		try
		{
		System.out.println("Enter the Product Price");
		p.price=scan.nextDouble();
		if(p.price>0)
			break;
		else
		{
			System.out.println("Enter valid Product Price");
		}
		}
		catch(Exception e)
		{
			System.out.println("Enter valid Product Price");
			scan.next();
		}
		}
		al.add(p);
	}
}

