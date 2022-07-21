import java.util.*;
class frame
{
	int pagenumber = -1;
	int lastaccesstime = -1;
	void replaceframe(int pagenumber,int lastaccesstime)
	{
		this.pagenumber = pagenumber;
		this.lastaccesstime = lastaccesstime;
	}
	void refreshframe(int lastaccesstime)
	{
		this.lastaccesstime = lastaccesstime;
	}
}
public class pgm_9a
{
	public static frame cache[];
	public static int nF;
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of page requests");
		int nR = sc.nextInt();
		int pnumber[] = new int[nR];
		System.out.println("Enter page Requests");
		for(int i=0;i<nR;i++)
		{
			pnumber[i] = sc.nextInt();
		}
		System.out.println("Enter the number of frames");
		nF = sc.nextInt();
		cache = new frame[nF];
		for(int i=0;i<nF;i++)
		{
			cache[i] = new frame();
		}
		int hit = 0,fault = 0;
		for(int i=0;i<nR;i++)
		{
			int index = findpagenumber(pnumber[i]);
			if(index!=-1)
			{
				hit = hit+1;
				cache[index].refreshframe(i);
			}
			else
			{
				fault = fault+1;
				int temp = getlruindex();
				cache[temp].replaceframe(pnumber[i],i);
			}
		}
		System.out.println("Hit: "+hit);
		System.out.println("Fault: "+fault);
	}
	public static int findpagenumber(int pn)
	{
		for(int i=0;i<nF;i++)
		{
			if(pn == cache[i].pagenumber)
			{
				return i;
			}
		}
		return -1;
	}
	public static int getlruindex()
	{
		int min = cache[0].lastaccesstime;
		int index=0;
		for(int i=0;i<nF;i++)
		{
			if(cache[i].lastaccesstime<min){
				min=cache[i].lastaccesstime;
				index=i;
			}
		}
		return index;
	}
}

enter the size of the array
10
enter the elements
2 3 5 4 2 5 7 3 8 7


/////////////////////////////////////////////////////////////////////////////////////


import java.util.*;
import java.io.*;
 
public class fifo_9b{
	public static void main(String [] args)throws IOException{	
		int frame[] = new int[3];
 
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		n = Integer.parseInt(br.readLine());
		int ip[] = new int[n];
 
		System.out.println("Enter the inputs");
 
		for(int i=0;i<n;i++)
			ip[i] = Integer.parseInt(br.readLine());
 
		for(int i=0;i<3;i++)
			frame[i] = -1;
 
		int hit = 0;
		int fault = 0;
		int j = 0;
 
		boolean check;
		for(int i=0;i<n;i++){
			check = false;
			for(int k=0;k<3;k++){
				if(ip[i] == frame[k]){
					hit++;
					check = true;
				}
			}
			if(check == false){
				frame[j] = ip[i];
				fault++;
				j++;
			}
			j %= 3;	
		}
 
		System.out.println("Number of hits " + hit);
		System.out.println("Number of fault " + fault);
	}
}


Enter the number of inputs :
10
Enter the inputs:
2,3,5,4,2,5,7,3,8,7
