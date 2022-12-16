import java.util.ArrayList;

public class UndirectedGraph{

    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    private boolean visited[];

    public UndirectedGraph(int v)
    {
        V=v;
        adj = new ArrayList<>();
        visited = new boolean[V];

        for(int i=0;i<V;i++)
        {
            adj.add(i,new ArrayList<>());
        }
    }

    void addEdge(int v, int w)
    {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    void dfs(int v)
    {
        visited[v] = true;
        System.out.print(v+" ");

        for(int x:adj.get(v))
        {
            if(!visited[x])
            {
                dfs(x);
            }
        }
    }

    void connectedComponents(){
        for(int v=0;v<V;++v)
        {
            if(!visited[v])
            {
                dfs(v);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph(7);
        undirectedGraph.addEdge(1, 0);
        undirectedGraph.addEdge(2,1);
        undirectedGraph.addEdge(3,4);
        undirectedGraph.addEdge(0,4);
        undirectedGraph.addEdge(5,6);

        undirectedGraph.connectedComponents();
    }
}
