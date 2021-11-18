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
		for(int i=x; i>=1; i--){
			if(i<=1){
				fact[i] = 1;
			} else{
				fact[i] = i;
			}
		}
		
		// reconstruct the solution
		// going back through the table, need to multiply each by its predecessor
		for(int i=2; i<=x; i++){
			fact[i] = fact[i] * fact[i-1];
		}
		System.out.println(fact[x]);
		
	}
}