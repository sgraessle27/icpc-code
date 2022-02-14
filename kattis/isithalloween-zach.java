import java.util.Scanner;

public class Halloween {
    public static void main(String [] args)
    {
        Scanner r = new Scanner(System.in);
        String s = r.nextLine();
        if(s.equals("DEC 25") || s.equals("OCT 31"))
        {
            System.out.println("yup");
        }
        else
        {
            System.out.println("nope");
        }
    }
}
