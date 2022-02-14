import java.util.Scanner;

public class Javelins {
    public static void main(String [] args)
    {
        Scanner r = new Scanner(System.in);
        int size = r.nextInt();
        int sum=0;
        for(int i=0; i<size; i++)
        {
            sum+=r.nextInt();
        }
        System.out.println(sum+1-size);
    }

}
