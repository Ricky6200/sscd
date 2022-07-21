import java.util.*;

public class Banker {
	static int alloc[][], max[][], need[][], avail[];
	static int p, r;

	public static void main(String[] args) {
		int flag=0;
		Scanner sc = new Scanner(System.in);
		p = sc.nextInt();
		r = sc.nextInt();
		alloc = new int[p][r];
		max = new int[p][r];
		avail = new int[r];
		need = new int[p][r];
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				alloc[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				max[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < r; i++) {
			avail[i] = sc.nextInt();
		}
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				need[i][j] = max[i][j] - alloc[i][j];
			}
		}

		boolean done[] = new boolean[p];
		while (true) {
			int pos = -1;
			for (int i = 0; i < p; i++) {
				if (done[i] != true) {
					pos = helper(i);
					if (pos >= 0) {
						System.out.println("process " + (i + 1) + " safely allocated");
						for (int j = 0; j < r; j++) {
							avail[j] += alloc[i][j];
						}
						done[pos] = true;
						break;
					}
				}
			}
			if (pos < 0)
				break;
		}
		for(int i=0;i<p;i++){
			if(done[i]==false){
				flag=1;
				break;
			}
		}
		if(flag==1)
		System.out.println("Deadlock");
		else
		System.out.println("Safely alloacted");
	}

	static int helper(int x) {
		for (int i = 0; i < r; i++) {
			if (avail[i] < need[x][i]) {
				return -1;
			}
		}
		return x;
	}
}
