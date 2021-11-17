```java
/* Blake Bleem */
/* Kattis: This Ain't Your Grandpa's Checkerboard */
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    input.nextLine();

    boolean grid[][] = new boolean[n][n];

    boolean valid = true;
    for(int i = 0; i < n && valid; i++) {
      String line = input.nextLine();
      int rowBalance = 0;
      boolean current = false;
      int consecutive = 0;
      for(int j = 0; j < n; j++) {
        if(line.charAt(j) == 'W') {
          if(!current) {
            consecutive++;
            if(consecutive > 3) {
              valid = false;
              break;
            }
          }
          else {
            consecutive = 1;
          }
          grid[i][j] = false;
          rowBalance--;
        }
        else {
          if(current) {
            consecutive++;
            if(consecutive > 3) {
              valid = false;
              break;
            }
          }
          else {
            consecutive = 1;
          }
          grid[i][j] = true;
          rowBalance++;
        }
      }

      if(rowBalance != 0) {
        valid = false;
      }
    }

    if(!valid) {
      System.out.println("0");
    }
    else {
      for(int i = 0; i < n && valid; i++) {
        int rowBalance = 0;
        boolean current = false;
        int consecutive = 0;
        
        for(int j = 0; j < n; j++) {
          if(grid[j][i]) {
            if(!current) {
              consecutive++;
              if(consecutive > 3) {
                valid = false;
                break;
              }
            }
            else {
              consecutive = 1;
            }
            rowBalance--;
          }
          else {
            if(current) {
              consecutive++;
              if(consecutive > 3) {
                valid = false;
                break;
              }
            }
            else {
              consecutive = 1;
            }
            rowBalance++;
          }

        }
        
        if(rowBalance != 0) {
          valid = false;
        }
      }

      if(valid) {
        System.out.println("1");
      }
      else {
        System.out.println("0");
      }
    }
  }
}
```