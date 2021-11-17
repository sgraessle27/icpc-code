/* Blake Bleem */
/* Kattis: FizzBuzz */
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int f = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();

    for(int i = 1; i <= c; i++) {
      if(i % f == 0 && i % b == 0) {
        System.out.println("FizzBuzz");
      }
      else if(i % f == 0) {
        System.out.println("Fizz");
      }
      else if(i % b == 0) {
        System.out.println("Buzz");
      }
      else {
        System.out.println(i);
      }
    }
  }
}
