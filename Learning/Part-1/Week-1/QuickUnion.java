class QU{
    public int[] id;
    public QU(int N){
        id = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i]=i;
        }
    }
    private int root(int i)
    {
        while(i!=id[i])
        {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p,int q)
    {
        return root(p)==root(q);
    }

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    
    for(int I:id)
        {
            System.out.print(I+" ");
        }
        System.out.println();
    }
}
public class QuickUnion {
    public static void main(String[] args) {
        QU qu = new QU(10);
        qu.union(1, 6);
        qu.union(1, 7);
        qu.union(2, 4);
        qu.union(2, 5);
        qu.union(2, 8);
        qu.union(7, 6);
        System.out.println(qu.connected(3, 1));
        System.out.println(qu.connected(6, 7));
    }
}

// QuickUnion is some times too fast and sometimes too slow when compared to QuickFind.
// The defect is the tree get thin and long, each nodes point to the one before.