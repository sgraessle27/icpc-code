/* Blake Bleem */
/* Kattis: Some Sum */
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();

    if(n % 4 == 0) {
      System.out.println("Even");
    }
    else if(n % 2 == 0) {
      System.out.println("Odd");
    }
    else {
      System.out.println("Either");
    }
  }
}
