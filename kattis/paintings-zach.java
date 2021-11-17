//solution works but too slow
```java
import java.util.*;

public class Paintings {
    static HashMap<String, HashSet<String>> ugly;
    static int strips;
    static ArrayList<String> preferred;
    static int totalAnswers;

    public static void main(String [] args)
    {
        ugly = new HashMap<>();
        Scanner reader = new Scanner(System.in);
        int t = Integer.parseInt(reader.nextLine());
        for(int i=0; i<t; i++)
        {
            strips = Integer.parseInt(reader.nextLine());
            totalAnswers = 0;
            preferred = null;
            ugly.clear();
            ArrayList colors = new ArrayList<>(Arrays.asList(reader.nextLine().split(" ")));
            int m = Integer.parseInt(reader.nextLine());
            for(int j=0; j<m; j++)
            {
                String [] pair = reader.nextLine().split(" ");
                if(ugly.get(pair[0])==null)
                {
                    ugly.put(pair[0], new HashSet<>());
                }
                if(ugly.get(pair[1])==null)
                {
                    ugly.put(pair[1], new HashSet<>());
                }
                ugly.get(pair[0]).add(pair[1]);
                ugly.get(pair[1]).add(pair[0]);
            }
            backtrack(new ArrayList<String>(), colors);
            System.out.println(totalAnswers);
            for(int k=0; k<preferred.size(); k++)
            {
                System.out.print(preferred.get(k) + " ");
            }
            System.out.println();
        }
    }

    static void backtrack(ArrayList<String> current, ArrayList<String> avaliable)
    {

        if(feasible(current))
        {
            if(success(current))
            {
                if(preferred==null)
                {
                    preferred = current;
                }
                totalAnswers++;
            }
            for(int i=0; i<avaliable.size(); i++)
            {
                ArrayList<String> newA = (ArrayList<String>) avaliable.clone();
                newA.remove(avaliable.get(i));
                backtrack(next(current, avaliable.get(i)), newA);
            }
        }
    }

    static boolean feasible(ArrayList<String> current)
    {
        if(current.size()<2)
        {
            return true;
        }
        HashSet<String> uglyWithA = ugly.get(current.get(current.size()-2));
        HashSet<String> uglyWithB = ugly.get(current.get(current.size()-1));
        if(uglyWithA==null && uglyWithB==null)
        {
            return true;
        }
        else if((uglyWithA==null && !uglyWithB.contains(current.get(current.size()-2))) ||
                (uglyWithB==null && !uglyWithA.contains(current.get(current.size()-1))) )
        {
            return true;
        }
        return !(uglyWithA.contains(current.get(current.size()-1)) || uglyWithB.contains(current.get(current.size()-2)));
    }

    static ArrayList<String> next(ArrayList<String> current, String newColor)
    {
        ArrayList<String> s = (ArrayList<String>) current.clone();
        s.add(newColor);
        return s;
    }

    static boolean success(ArrayList<String> current)
    {
        return current.size() == strips;
    }
}

   ```