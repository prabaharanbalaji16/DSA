@SuppressWarnings("unchecked")
public class MaxHeap{
    Comparable[] pq;
    int size;

    public MaxHeap(int capacity)
    {
        pq = new Comparable[capacity];
        size = 0;
    }

    void insert(Comparable val)
    {
        size = size+1;
        int index = size;
        pq[index] = val;
        
        while(index > 1)
        {
            if(less(index/2,index) )
            {
                swap(index/2,index);

            }
            else return;
        }
    }

    void remove()
    {
        pq[1] = pq[size--];

        int i = 1;
        while(i<size)
        {
            int leftIndex = 2*i;
            int rightIndex = 2*i+1;

            if(leftIndex < size && less(i,leftIndex))
            {
                swap(i,leftIndex);
                i=leftIndex;
            }
            else if(rightIndex < size && less(i,rightIndex))
            {
                swap(i,rightIndex);
                i= rightIndex;
            }
            else return;
        }
    }

    boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }
    void print()
    {
        for(int i=1;i<=size;i++)
        {
            System.out.print(pq[i]+" ");
        }
        System.out.println();
        
    }

    void swap(int i, int j)
    {
        Comparable temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;   
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(50);
        maxHeap.insert(55);
        maxHeap.insert(53);
        maxHeap.insert(52);
        maxHeap.insert(54);
        maxHeap.print();
        maxHeap.remove();
        maxHeap.print();
    }
}