import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalProgrmming {
	public static boolean isEven(int e)
	{
		return e%2==0;
	}
	public void print()
	{
		
	}
	public static boolean isPrime(int e)
	{
		Predicate<Integer> isDivisor= i->e%i==0;
		return e>1 && IntStream.range(2, e/2+1)
				.noneMatch(i->isDivisor.test(i));
				//.noneMatch(i -> e%i==0);						
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al=new ArrayList<Integer>();
		List<Integer> values=Arrays.asList(1,2,3,4,5,6,7,8);
		for (int i = 0; i < 10; i++)
			al.add(i+1);
		Function<Integer, Predicate<Integer>> isFunction = i-> 
		e -> e%i==0;
		//al.forEach(System.out::println);
		//values.forEach(System.out::println);
		System.out.println(
			values.stream()
			//.filter(e->isPrime(e))
			//.filter(FunctionalProgrmming::isEven)
			//.filter(e -> e% 2==0)
			//.map(e -> e*2 )
			.filter(isFunction.apply(2))
			.collect(Collectors.toList())
			//.findAny()
			//.findFirst()
			//.forEach(e->isPrime(e))
			);
		/*
		for (int i : values) {
			if(isPrime(i))
			System.out.println(i);
		}
		*/
		welcome w= name -> System.out.println("Hello "+name);
		w.welcomeName("Gokul");
		greet g=new Wish();
		g.greetName("Gokul");
	}

}
interface welcome
{
	void welcomeName(String name);
}
interface greet
{
	default void greetName(String name)
	{
		System.out.println("Greeting "+name);
	}
}
class Wish implements greet
{
	//@Override
	public void greetName(String name)
	{
		greet.super.greetName(name);
		System.out.println("Wish "+name);
		
	}
}