import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    int V;
    ArrayList<DirectedEdge> adj[];
    DirectedEdge[] edgeTo;
    double[] distTo;
    List pq[] = new ArrayList[V];

    public Dijkstra(int v)
    {
       V = v;
        adj = new ArrayList[V];
       for(int i=0;i<V;i++)
       {
        distTo[i] = Double.POSITIVE_INFINITY;
        adj[i] = new ArrayList<DirectedEdge>();
       }
    }

    public void addEdge(DirectedEdge e)
    {
        int v= e.from();
        int u = e.to();
        adj[v].add(e);
        adj[u].add(e);
    }
    
    void path(int s)
    {
        PriorityQueue pq = new PriorityQueue<>();
        distTo[s] =0;
        pq.add(s);

        while(!pq.isEmpty())
        {
            int j = (int)pq.remove();
            for(DirectedEdge e:adj[j])
            {
                int from = e.from();
                int to = e.to();
                int weight = e.weight();
                if((distTo[from]+weight)<distTo[to])
                {
                    distTo[to] = distTo[from]+weight;
                    pq.add(to);
                }
            }
        }
        for(double d:distTo)
        {
            System.out.println(d);
        }
    }

    void relax(DirectedEdge e)
    {
        
    }
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(4);
        dijkstra.addEdge(new DirectedEdge(0,1,5));
        dijkstra.addEdge(new DirectedEdge(0,2,8));
        dijkstra.addEdge(new DirectedEdge(1,2,9));
        dijkstra.addEdge(new DirectedEdge(1,0,5));
        dijkstra.addEdge(new DirectedEdge(1,3,2));
        dijkstra.addEdge(new DirectedEdge(2,3,6));
        dijkstra.addEdge(new DirectedEdge(2,0,8));
        dijkstra.addEdge(new DirectedEdge(2,3,6));
        dijkstra.addEdge(new DirectedEdge(3,2,6));
        dijkstra.addEdge(new DirectedEdge(3,1,3));

        dijkstra.path(0);
    }
}
