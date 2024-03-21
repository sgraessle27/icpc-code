//https://open.kattis.com/problems/thisaintyourgrandpascheckerboard

import java.util.Scanner;

public class checkerboard {

    public static void main(String [] args)
    {
        Scanner r = new Scanner(System.in);
        int n = Integer.parseInt(r.nextLine());
        String s;
        int bRow;
        int wRow;
        int bConRow;
        int wConRow;

        int [] bColumn = new int[n];
        int [] wColumn = new int[n];
        int [] bConColumn = new int[n];
        int [] wConColumn = new int[n];
        for(int i=0; i<n; i++)
        {
            s = r.nextLine();
            bRow=0;
            wRow=0;
            bConRow=0;
            wConRow=0;
            for(int j=0; j<s.length(); j++)
            {
                if(s.charAt(j)=='W')
                {
                    wColumn[j]++;
                    wRow++;
                    bConRow=0;
                    bConColumn[j]=0;
                    wConColumn[j]++;
                    wConRow++;
                }
                else if(s.charAt(j)=='B')
                {
                    bColumn[j]++;
                    bRow++;
                    wConRow=0;
                    bConColumn[j]++;
                    wConColumn[j]=0;
                    bConRow++;
                }
                if(bConRow>=3 || wConRow>=3 || bConColumn[j]>=3 || wConColumn[j]>=3)
                {
                    System.out.println("0");
                    return;
                }
            }
            if(bRow!=wRow)
            {
                System.out.println("0");
                return;
            }
        }
        for(int i=0; i<bColumn.length; i++)
        {
            if(bColumn[i]!=wColumn[i])
            {
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");
    }
}
