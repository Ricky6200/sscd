import java.util.*; 
public class RoundRobin_7a{
	public static void main(String [] args){
		int bt[],rt[],num,quantum,rp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of operations");
		num = sc.nextInt();
		bt = new int[num];
		rt = new int[num];
		System.out.println("Enter the burst times");
		for(int i=0;i<num;i++){
			System.out.println("p["+(i+1)+"]"); 
			bt[i] = sc.nextInt();
			rt[i] = bt[i];
		}
 
		System.out.println("Enter the quantum");
		quantum = sc.nextInt();
 
		int i = 0;
		int time = 0;
		rp = num;
		System.out.println("|Process|Time|");
 
 
		while(rp > 0){
			if(rt[i] > quantum){
				time += quantum; 
				rt[i] -= quantum;
				System.out.println("|P"+(i+1)+"|"+":"time);
			}else if(rt[i] <= quantum && rt[i] > 0){
				time += rt[i];
				rt[i] = 0;
				System.out.println("|P"+(i+1)+"|"+":"time);
				rp--;
			}
			i = (i+1)%num;
		}
	}
 
}
/*
P[1]: 4
P[2]: 5
P[3]: 8
P[4]: 2
Enter quantum: 4
*/
