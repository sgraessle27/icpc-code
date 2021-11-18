// Compute fibanocci numbers using tabulation
import java.util.Scanner;
public class Fib
{
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		
		// get number
		System.out.print("n=");
		n = Scanner.nextInt();
		
		// construct table
		int [] fib = new int[n+1]; // fib[x] will be the xth fibanocci number
		
		// tabulate (bottom-up)
		for (int i=1; i<=n; i++){
			// tabulated version of the recursive fibanocci algorithm
			if(i<=2){
				fib[i] = 1;
			}
			else{
				fib[i] = fib[i-2] + fib[i-1];
			}
		}
		
		// use the table to print the nth fibanocci number
		System.out.println(fib[n]);
	}
}