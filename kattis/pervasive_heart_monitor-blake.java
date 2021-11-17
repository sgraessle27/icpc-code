/* Blake Bleem */
/* Kattis: Pervasive Heart Monitor */
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    while(input.hasNextLine()) {
      String line = input.nextLine();
      StringBuilder name = new StringBuilder();
      double sum = 0;
      int count = 0;
      
      for(String s : line.split(" ")) {
        if(!Character.isDigit(s.charAt(0))) {
          name.append(s);
          name.append(" ");
        }
        else {
          sum += Double.parseDouble(s);
          count++;
        }
      }

      System.out.printf("%f %s\n", sum / (double) count, name.toString());
    }
  }
}
