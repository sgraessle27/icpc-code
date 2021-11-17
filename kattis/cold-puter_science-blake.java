/* Blake Bleem */
/* Kattis: Cold-puter Science */
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();

    int count = 0;
    for(int i = 0; i < n; i++) {
      if(input.nextInt() < 0) {
        count++;
      }
    }

    System.out.println(count);
    
  }
}
