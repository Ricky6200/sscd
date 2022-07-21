import java.util.*;
public class fifo
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of inputs");
		int n=sc.nextInt();
		int input[]=new int[n];
		int frame[]=new int[3];
		for(int i=0;i<n;i++)
		{
		    input[i]=sc.nextInt();
		}
		int hit=0,fault=0,c=0;
		for(int i=0;i<n;i++)
		{
		    boolean check=false;
		    for(int j=0;j<3;j++)
		    {
		        if(input[i]==frame[j])
		        {
		            hit++;
		            check=true;
		        }
		    }
		    if(check==false)
		    {
		        frame[c%3]=input[i];
		        c++;
		        fault++;
		    }
		}
		System.out.println("Hits = "+hit);
		System.out.println("Fault = "+fault);
	}
}
