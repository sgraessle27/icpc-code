import java.util.HashSet;
import java.util.Scanner;

public class Everywhere {
    public static void main(String [] args)
    {
        Scanner r = new Scanner(System.in);
        int n = Integer.parseInt(r.nextLine());

        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            int l = Integer.parseInt(r.nextLine());
            hs.clear();
            for(int j=0; j<l; j++)
            {
                hs.add(r.nextLine());
            }
            System.out.println(hs.size());
        }
    }
}
