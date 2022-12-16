import java.util.ArrayList;

public class TopologicalSort {
    int V;
    ArrayList<ArrayList<Integer>> adj;
    Boolean visited[];

    Integer stack[];
    int N=0;

    public TopologicalSort(int v)
    {
        V =v;

        adj = new ArrayList<ArrayList<Integer>>(V);
        visited = new Boolean[V];
        for(int i=0;i<V;++i)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++)
        {
            visited[i] = false;
        }
        stack = new Integer[V+1];
    }

    void addEdge(int v, int w)
    {
        adj.get(v).add(w);
    }

    void dfs()
    {
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfs(i);
            }
        }
    }

    void dfs(int u)
    {
        visited[u] =true;

        for(int i:adj.get(u))
        {
            if(!visited[i])
            {
                dfs(i);
            }
        }

        push(u);
    }

    void push(int u)
    {
        stack[++N] = u;
    }

    void printStack()
    {
        for(int i=N;i>0;--i)
            System.out.println(stack[i]);
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort(6);

        topologicalSort.addEdge(5, 2);
        topologicalSort.addEdge(5, 0);
        topologicalSort.addEdge(4, 0);
        topologicalSort.addEdge(4, 1);
        topologicalSort.addEdge(2, 3);
        topologicalSort.addEdge(3, 1);

        topologicalSort.dfs();

        topologicalSort.printStack();
    }
}
