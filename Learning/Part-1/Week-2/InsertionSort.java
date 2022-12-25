
@SuppressWarnings("unchecked")
public class InsertionSort {
    public static void main(String[] args) {
        Comparable[] a = {8,3,2,6,4,1,5,9};
        sort(a);
        
        for(Comparable v:a)
        {
            System.out.println(v);
        }
    }

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i=0;i<N;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(less(a[j],a[j-1]))
                    swap(a,j,j-1);
                else break;
            }
        }
    }

    public static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b)<0;
    }

    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
