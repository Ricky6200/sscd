import java.util.*;
public class Lru
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of inputs");
		int n=sc.nextInt();
		int input[]=new int[n];
		int frame[][]=new int[3][2];
		
		
		for(int i=0;i<3;i++)
			for(int j=0;j<2;j++)
				frame[i][j] = -1;
				
				
		for(int i=0;i<n;i++) 
			input[i]=sc.nextInt();
		int hit=0,fault=0;
		
		for(int i=0;i<n;i++){
			boolean check=false;
			for(int j=0;j<3;j++){
				if(frame[j][0]==input[i])
				{
					check=true;
					frame[j][1]=i+1;
					hit++;
				}
			}
			if(check==false)
			{
				int pos=helper(frame);
				fault++;
				frame[pos][0]=input[i];
				frame[pos][1]=i+1;
			}
		}
		
		System.out.println("Hits = "+hit);
		System.out.println("Fault = "+fault);
	}
	
	static int helper(int frame[][])
	{
		int min=10000;
		int pos=-1;
		for(int i=0;i<3;i++){
			if(frame[i][1]==-1)
				return i;
			if(frame[i][1]<min){
				pos=i;
				min=frame[i][1];
			}
		}
		return pos;
	}
}
