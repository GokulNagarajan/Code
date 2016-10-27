import java.util.Scanner;
public class Problem3 {
	private static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double cx=0,cy=0,d1=0,d2=0,d3=0,r=0,dx=0,dy=0;
		double [][] map=new double[3][2];
		int i=0,j=0;
		scan=new Scanner(System.in);
		do
		{
		try
		{
		System.out.println("enter centre co ordinates");
		cx=scan.nextDouble();
		cy=scan.nextDouble();
		break;
		}
		catch(Exception e)
		{
			System.out.println("enter valid co ordinates");
			scan.next();
		}
		}while(true);
		for(i=0;i<3;i++)
		{
			System.out.println("enter co ordinates x"+(i+1)+",y"+(j+1));
			for(j=0;j<2;j++)
			{
				try
				{
				map[i][j]=scan.nextDouble();
				}
				catch(Exception e)
				{
					System.out.println("enter valid co ordinates");
					j=0;
					scan.next();
				}
			}
		}
		System.out.println("enter the radius");
		r=scan.nextDouble();
		dx=Math.abs(cx-map[0][0]);
		dy=Math.abs(cy-map[0][1]);
		d1=Math.sqrt((dx*dx)+(dy*dy));
		dx=Math.abs(cx-map[1][0]);
		dy=Math.abs(cy-map[1][1]);
		d2=Math.sqrt((dx*dx)+(dy*dy));
		dx=Math.abs(cx-map[2][0]);
		dy=Math.abs(cy-map[2][1]);
		d3=Math.sqrt((dx*dx)+(dy*dy));
		if(d1<=r&&d2<=r&&d3<=r)
			System.out.println("All points are inside the cirlce");
		else
			System.out.println("All points are not inside the cirlce");
	}

}
