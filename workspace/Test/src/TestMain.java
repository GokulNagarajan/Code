
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={4,-1,9,-6,7};
		System.out.println("Max "+max(a));
		System.out.println("Min "+min(a));
	}
	public static int max(int ...a)
	{
		int max=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(max<a[i])
				max=a[i];
		}
		return max;
	}
	public static int min(int ...a)
	{
		int min=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(min>a[i])
				min=a[i];
		}
		return min;
	}
}
