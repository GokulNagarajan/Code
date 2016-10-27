import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class GettingDigits {
	private static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		String input=scan.nextLine();
		int i,n=input.length(),count;
		int [] num=new int[10];
		
		char [] inputArray=input.toCharArray();
		Map<String,Integer> m=new HashMap<String,Integer>();
		for(i=0;i<n;i++)
		{
			count=0;
			if(m.containsKey(String.valueOf(inputArray[i])))
				count=m.get(String.valueOf(inputArray[i]));
			m.put(String.valueOf(inputArray[i]), count+1);
		}
		for (Entry<String, Integer> e : m.entrySet()) {
		{
			System.out.println(e.getKey()+" "+e.getValue());
			if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[0]++;
				m.put("Z", m.get("Z")-1);
				m.put("E", m.get("E")-1);
				m.put("R", m.get("R")-1);
				m.put("O", m.get("O")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[1]++;
				m.put("Z", m.get("Z")-1);
				m.put("E", m.get("E")-1);
				m.put("R", m.get("R")-1);
				m.put("O", m.get("O")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[2]++;
				m.put("Z", m.get("Z")-1);
				m.put("E", m.get("E")-1);
				m.put("R", m.get("R")-1);
				m.put("O", m.get("O")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[3]++;
				m.put("Z", m.get("Z")-1);
				m.put("E", m.get("E")-1);
				m.put("R", m.get("R")-1);
				m.put("O", m.get("O")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[4]++;
				m.put("Z", m.get("Z")-1);
				m.put("E", m.get("E")-1);
				m.put("R", m.get("R")-1);
				m.put("O", m.get("O")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[5]++;
				m.put("Z", m.get("Z")-1);
				m.put("E", m.get("E")-1);
				m.put("R", m.get("R")-1);
				m.put("O", m.get("O")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[6]++;
				m.put("S", m.get("S")-1);
				m.put("I", m.get("I")-1);
				m.put("X", m.get("X")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[7]++;
				m.put("S", m.get("S")-1);
				m.put("E", m.get("E")-1);
				m.put("V", m.get("V")-1);
				m.put("E", m.get("E")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[8]++;
				m.put("E", m.get("E")-1);
				m.put("I", m.get("I")-1);
				m.put("G", m.get("G")-1);
				m.put("H", m.get("H")-1);
			}
			else if((m.containsKey("Z")&&m.get("Z")>0)&&(m.containsKey("E")&&m.get("E")>0)&&(m.containsKey("R")&&m.get("R")>0)&&(m.containsKey("O")&&m.get("O")>0))
			{	
				num[9]++;
				m.put("N", m.get("N")-1);
				m.put("I", m.get("I")-1);
				m.put("N", m.get("N")-1);
				m.put("E", m.get("E")-1);
			}
		}
		for(i=0;i<n;i++)
		{
			System.out.println((i+1)+" "+num[i]);
			while(num[i]>0)
				System.out.print(num[i]--);
		}
	}
	}
}