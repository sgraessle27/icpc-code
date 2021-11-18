import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ICPC 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m;
        int r;
        int s;
        int d;
        
        for(int i = 0; i < n; i++)
        {
            Graph<Integer> g = new Graph();
            m = in.nextInt();
            r = in.nextInt();
            TreeSet<Integer> toVisit = new TreeSet();
            for(int j = 0; j < m; j++)
            {
                g.insert(j, null);
                toVisit.add(j);
            }
            for(int j = 0; j < r; j++)
            {
                s = in.nextInt();
                d = in.nextInt();
                g.insert(s, d);
                g.insert(d, s);
            }
            
            //BFS
            int nroads = 0;
            
            while(!toVisit.isEmpty())
            {
                nroads++;
                LinkedList<Integer> q = new LinkedList();
                Integer v = toVisit.first();
                q.add(v);
                while(!q.isEmpty())
                {
                    v = q.remove();
                    toVisit.remove(v);
                    for(Integer vert : g.adjList.get(v))
                    {
                        if(toVisit.contains(vert))
                        {
                            q.add(vert);
                        }
                    }
                }
            }
            System.out.println(nroads-1);
        }
    }
}
class Graph<V extends Comparable<V>>
{
    public Graph()
    {
        vertex = new TreeSet();
        adjList = new TreeMap();
        edge = new TreeSet();
        adjMatrix = new TreeMap();
    }
    
    public TreeSet<V> vertex;
    public TreeMap<V, TreeSet<V>> adjList;
    public TreeSet<Edge> edge;
    public TreeMap<Edge, Double> adjMatrix;
    
    public void insert (V src, V dest, Double weight)
        {
            vertex.add(src);
            
            if(!adjList.containsKey(src))
            {
                adjList.put(src, new TreeSet());
            }
            
            if(dest == null)
            {
                return;
            }
            
            vertex.add(dest);
            if(!adjList.containsKey(src))
            {
                adjList.put(src, new TreeSet());
            }
            adjList.get(src).add(dest);
            Edge e = new Edge(src, dest);
            edge.add(e);
            adjMatrix.put(e, weight);
        }
        
        public void insert(V src, V dest)
        {
            insert(src, dest, 1.0);
        }
    
    public class Edge implements Comparable<Edge>
    {
        public Edge(V src, V dest)
        {
            this.src = src;
            this.dest = dest;
        }
        
        public V src;
        public V dest;
        
        @Override
        public int compareTo(Edge o) {
            int r;
            r = src.compareTo(o.src);
            if(r != 0) return r;
            return dest.compareTo(o.dest);
        }
        
    }
}
