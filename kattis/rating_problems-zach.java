import java.util.Scanner;

public class Scores {
    public static void main(String [] args)
    {
        Scanner r = new Scanner(System.in);
        int m = r.nextInt();
        int n = r.nextInt();
        int totalScores = 0;
        for(int i=0; i<n; i++)
        {
            totalScores+=r.nextInt();
        }
        System.out.println(((float)(totalScores+(-3*(m-n)))/(float)m) + " " + ((float)(totalScores+(3*(m-n)))/(float)m));
    }
}
