import java.util.*;
public class Temp{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int bt[],wt[],num,process[];
		System.out.println("Enter the number of processes");
		num=sc.nextInt();
		bt=new int[num];
		wt=new int[num];
		process=new int[num];
		for(int i=1;i<num;i++)
		process[i-1]=i;
		System.out.println("Enter burst time");
		for(int i=0;i<num;i++)
			bt[i]=sc.nextInt();
		
		//sort the proceess and bt
		int temp,pos;
		for(int i=0;i<num;i++){
			pos=i;
			for(int j=i+1;j<num;j++){
				if(bt[j]<bt[pos])
					pos=j;
			}
			temp=bt[i];
			bt[i]=bt[pos];
			bt[pos]=temp;
			
			temp=process[i];
			process[i]=process[pos];
			process[pos]=temp;
		}
		//calculate wt array
		int twt=0;
		wt[0]=0;
		for(int i=1;i<num;i++){
			wt[i]=wt[i-1]+bt[i-1];
			twt += wt[i];
		}
		float awt=(float)twt/num;
		
		//calculate tot
		int tot=0;
		for(int i=0;i<num;i++){
			tot=wt[i]+bt[i];
		}
		float atot=(float)tot/num;
		
		System.out.println("Process\t Burst Time\t Wait Time\t"); 
		for(int i=0;i<num;i++){
			System.out.println("P["+process[i]+"]\t\t" + bt[i] +"\t\t" + wt[i]);
		}
		System.out.println("Average wait time is " + awt );
		System.out.println("Average turnout time " + atot);
	}
}
	
		
		
