import java.util.TreeMap;
import java.util.TreeSet;

public class Dijkstra
{
	//Dpath = "Dijkstra path"
	public static class Dpath{
		public TreeMap<Integer, Double> dist;
		public TreeMap<Integer, Integer> prev;
	}
	
	public static Dpath dijkstra(Graph<Integer> g, Integer s){
		Dpath path = new Dpath();
		//not using a linked list or an array list, using a tree set
		TreeSet<Integer> q = new TreeSet<>();
		
		//create the path elements
		path.dist = new TreeMap<>();
		path.prev = new TreeMap<>();
		
		for(Integer v : g.vertex) {
			path.dist.put(v, Double.POSITIVE_INFINITY);
			path.prev.put(v, null);
			q.add(v);
		}
		//set up the source (s)
		path.dist.put(s, 0.0);
		//the minimum is the source
		Integer min = s;
		double minDist = 0.0;
		
		while(q.size() != 0) {
			//find the minimum
			minDist = Double.POSITIVE_INFINITY;
			for(Integer v : q) {
				if(path.dist.get(v) < minDist) {
					minDist = path.dist.get(v);
					min = v;
				}
			}
			//pull out the smallest
			Integer u = min;
			q.remove(u);
			
			minDist = Double.POSITIVE_INFINITY;
			//adj = adjacency
			for(Integer v : g.adjlist.get(u)) {
				double alt = path.dist.get(u) + g.adjmatrix.get(g.new Edge(u,v));
				if(alt < path.dist.get(v)) {
					path.dist.put(v,alt);
					path.prev.put(v,u);			
				}
			}
		}
		return path;
	}
}