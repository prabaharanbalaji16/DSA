class QF{
    private int[] id;
    QF(int N)
    {
        id = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i]=i;
        }
    }

    public boolean connected(int p,int q)
    {
        return id[p]==id[q];
    }

    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for(int i=0;i<id.length;i++)
        {
            if(id[i]==pid)
            {
                id[i] = qid;
            }
        }

        for(int i:id)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

public class QuickFind {
    public static void main(String[] args) {
        QF qf = new QF(10);
        qf.union(1, 6);
        qf.union(1, 7);
        qf.union(2, 4);
        qf.union(2, 5);
        qf.union(2, 8);
        qf.union(7, 6);
        System.out.println(qf.connected(3, 1));
        System.out.println(qf.connected(6, 7));
    }
    
}

// Time complexity for find() is N (Linear) and for union is N^2 (Quadratic).
// In Scable computer the Quadratic will be slow.