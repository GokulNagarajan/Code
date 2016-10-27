
public class StringMain {
	public static void main(String[] args) {
			String str1="Hello",str2="Hello",str3="hello";
			if(str1.equals(str2))
				System.out.println(str1+" and "+str2+" are same ");
			if(str1.compareToIgnoreCase(str3)==0)
				System.out.println(str1+" and "+str3+" are same ");
			if(str3.compareTo(str1)>0)
				System.out.println(str3+" is greater than "+str1);
			if(str1.compareTo(str3)<0)
				System.out.println(str1+" is lesser than "+str3);
			System.out.println("length of "+str1+" : "+str1.length());
			System.out.println("length of "+str2+" : "+str2.length());
			System.out.println("length of "+str3+" : "+str3.length());
			String str4=str1.concat(str3);
			System.out.println(str1+" + "+str3+" : "+str4);
			str2=str4.substring(5);
			System.out.println("substring of "+str4+" from position 5 : "+str2);
			str2=str4.substring(0,5);
			System.out.println("substring of "+str4+" from position 0 to 5 : "+str2);
			System.out.println(str1.toString());
			System.out.println(str1.toLowerCase());
			System.out.println(str1.toUpperCase());
			String str="A-B=10,B-C=10,C-A=10";
			String [] strArray=str.split(",");
			String [] strs=str.split("");
			int i;
			for(i=0;i<strs.length;i++)
				System.out.println(strs[i]);
			for(i=0;i<strArray.length;i++)
				System.out.println(strArray[i]);
			char[] array=str.toCharArray();
			for(i=0;i<array.length;i++)
				System.out.print(array[i]);
			System.out.println();
			i=10;
			Integer x;
			str="777";
			System.out.println("i before int parse "+i);
			i=Integer.parseInt(str);
			x=Integer.valueOf(str);
			System.out.println("value of i : "+i);
			System.out.println("value of x : "+x);
			if(i==x)
				System.out.println("i is not equal to x");
			else
				System.out.println("i is equal to x");
			System.out.println("i in float "+(float)i);
			System.out.println("i in double "+(double)i);
			System.out.println("i in String "+String.valueOf(i));
			System.out.println("str after double parse "+Double.parseDouble(str));
			System.out.println("str after float parse "+Float.parseFloat(str));
			if(Double.parseDouble(str)==Float.parseFloat(str))
				System.out.println("Double(str) is not equal to Float(str)");
			else
				System.out.println("Double(str) is equal to Float(str)");
			
		}
}
