import java.util.ArrayList;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
public class BellmanFord {

    int V;
    ArrayList<DirectedEdge> adj[];
    double distTo[];
 
    public BellmanFord(int v)
    {
        V = v;
        adj = new ArrayList[V];
        distTo = new double[V];
        for(int i=0;i<V;i++)
        {
            adj[i] = new ArrayList<DirectedEdge>();
            distTo[i] = Double.POSITIVE_INFINITY;
        }
    }
    
    void addEdge(DirectedEdge e)
    {
        int v = e.from();
        adj[v].add(e);
    }
    void path(int src, int dest)
    {
        distTo[src] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(src);
        int pass = V-1;
        while(pass!=0)
        {
            while(!pq.isEmpty())
            {
                int s = (int)pq.remove();
                for(DirectedEdge e: adj[s])
                {
                int v = e.from();
                int w = e.to();

                if((distTo[v]+e.weight())<distTo[w])
                {
                    distTo[w]= distTo[v]+e.weight();
                    pq.add(w);
                }
                }
            }
            pass--;
        }
        System.out.println((int)distTo[dest]);
    }

    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord(3);
        bellmanFord.addEdge(new DirectedEdge(0, 1, 2));
        bellmanFord.addEdge(new DirectedEdge(0, 2, 2));
        bellmanFord.addEdge(new DirectedEdge(1, 2, -1));
        bellmanFord.path(0,2);
    }
}
