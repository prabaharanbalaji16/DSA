import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class MinimumSpanningTree {
    private int V;
    ArrayList<WeightedEdge> adj[];

    public MinimumSpanningTree(int v)
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

    Iterable<WeightedEdge> adj(int v)
    {
        return adj[v];
    }

    void calculate()
    {
        Integer key[] = new Integer[V];
        Boolean mst[] =  new Boolean[V];
        Integer parent[] = new Integer[V];

        for(int i=0;i<V;i++)
        {
            key[i] = 10000;
            mst[i] = false;
            parent[i] = -1;
        }       

        for( int i=0;i<V;i++)
        {
            int mini = 1000000;
            int u=0;
            for(int j=0;j<V;j++)
            {
                if(mst[j]==false && key[j] < mini)
                {
                    u=j;
                    mini = key[j];
                }
            }
            mst[u] = true;
            
            for(WeightedEdge e:adj[u])
            {
                int v = e.other(u);
                int w = e.weight();
                if(mst[v]==false || w<key[v])
                {
                    parent[v] = u;
                    key[v] = w;
                }
                mst[v] = true;
            }
        }
        int result = 0;
        for(int k=1;k<V;k++)
        {
            result+=key[k];
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        MinimumSpanningTree minimumSpanningTree = new MinimumSpanningTree(5);

        minimumSpanningTree.addEdge(new WeightedEdge(0,1,2));
        minimumSpanningTree.addEdge(new WeightedEdge(0,3,6));
        minimumSpanningTree.addEdge(new WeightedEdge(3,1,8));
        minimumSpanningTree.addEdge(new WeightedEdge(1,4,5));
        minimumSpanningTree.addEdge(new WeightedEdge(1,2,3));
        minimumSpanningTree.addEdge(new WeightedEdge(4,2,7));
        

        minimumSpanningTree.calculate();
    }
}
