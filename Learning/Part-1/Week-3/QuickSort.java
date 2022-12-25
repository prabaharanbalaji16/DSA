@SuppressWarnings("unchecked")
public class QuickSort{
    public static void main(String[] args) {

        QuickSort qs = new QuickSort();
         Comparable[] arr = {'P','R','A','B','A','H','A','R','A','N'};
         qs.sort(arr, 0, arr.length-1);

         for(Comparable a:arr)
         {
            System.out.println(a);
         }
    }

    public int partition(Comparable[] a, int low, int high)
    {
        int i =low, j=high+1;
        while(true)
        {
            while(less(a[++i],a[low]))
            {
                if(i==high) break;
                // i++;
            }

            while(less(a[low],a[--j]))
            {
                if(j==low) break;
                // j--;
            }

            if(i>=j) break;
            swap(a,i,j);
        }
        swap(a,low,j);
        return j;
    }

    public void sort(Comparable[] a, int low, int high)
    {
        if(high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }


    private Boolean less(Comparable a, Comparable b)
    {
       return a.compareTo(b) < 1 ;
    }
    private void swap(Comparable[] a , int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}