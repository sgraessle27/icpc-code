// Factorial completed via memoization
import java.util.Scanner;

public class FactorialMemo{
	public static void main(String [] args){
		int x;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("x=");
		x = scanner.nextInt();
		
		// build table memoized
		int fact[] = new int[x+1];
		for(int i=1; i<=x; i++){
			if(i<=1){
				fact[i] = 1;
			} else{
				fact[i] = i * fact[i-1];
			}
		}
		
		// reconstruct the solution
		System.out.println(fact[x]);
	}
}