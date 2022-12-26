import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Kruskal {
    int V;
    ArrayList<WeightedEdge> adj[];
    Queue<WeightedEdge> mst = new PriorityQueue<WeightedEdge>();

    Kruskal(int v)
    {
        V = v;
        adj = new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(WeightedEdge e)
    {
        int v = e.either();
        int w = e.other(v);

        adj[v].add(e);
        adj[w].add(e);
    }

    void KruskalMST()
    {
        ArrayList<WeightedEdge> edge = new ArrayList<WeightedEdge>();

        for(int i=0;i<adj.length;i++)
        {
            for(WeightedEdge e: adj[i])
            {
                edge.add(e);
            }
        }
        Collections.sort(edge);

        WQU unionFind = new WQU(V);
        for(int k=0;k<edge.size();k++)
        {
            if(mst.size()<V)
            {
                for(Object e:edge.toArray())
                {   
                    e = (WeightedEdge) e;
                    int v = ((WeightedEdge) e).either();
                    int w = ((WeightedEdge) e).other(v);
                    if(!unionFind.connected(v,w))
                    {
                        unionFind.union(v, w);
                        mst.add((WeightedEdge) e);
                    }
                }
            }
        }
    }

    void print()
    {
        int result = 0;
        while(!mst.isEmpty())
        {
            result+=mst.poll().weight();
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal(8);
        kruskal.addEdge(new WeightedEdge(0,1,2));
        kruskal.addEdge(new WeightedEdge(0,3,6));
        kruskal.addEdge(new WeightedEdge(3,1,8));
        kruskal.addEdge(new WeightedEdge(1,4,5));
        kruskal.addEdge(new WeightedEdge(1,2,3));
        kruskal.addEdge(new WeightedEdge(4,2,7));

        kruskal.KruskalMST();
        kruskal.print();
    }
}
