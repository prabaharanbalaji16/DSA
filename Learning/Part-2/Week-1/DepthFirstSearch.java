import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class DepthFirstSearch {
    private int V;
    private LinkedList<Integer> adj[];
    private boolean visited[];

    DepthFirstSearch(int v)
    {
        V = v;
        visited = new boolean[V];
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int u)
    {
        adj[v].add(u);
    }
    void dfs(int v)
    {
        visited[v] = true;
        System.out.println(v+" ");
        Iterator<Integer> i = adj[v].iterator();
        while(i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
            {
                dfs(n);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2,3);
        dfs.addEdge(3, 3);
        dfs.dfs(3);
    }
}
