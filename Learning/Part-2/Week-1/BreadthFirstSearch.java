import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class BreadthFirstSearch {

    private int V;
    private LinkedList<Integer> adj[];
    private boolean visited[];

    public BreadthFirstSearch(int v)
    {
        V = v;
        visited = new boolean[V];
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int w)
    {
        adj[u].add(w);
    }

    void bfs(int v)
    {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(queue.size()!=0)
        {
            Integer s = (Integer) queue.poll();
            System.out.println(s+" ");
            for(Integer a:adj[s])
            {
                if(!visited[a])
                {
                    queue.add(a);
                    visited[a] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch(6);
        bfs.addEdge(0,1);
        bfs.addEdge(0,2);
        bfs.addEdge(1,2);
        bfs.addEdge(2,0);
        bfs.addEdge(2,3);
        bfs.addEdge(3,3);

        bfs.bfs(2);

    }
    
}
