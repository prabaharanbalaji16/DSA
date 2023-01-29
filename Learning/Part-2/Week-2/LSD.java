public class LSD {
    public static void main(String[] args) {
        LSD lsd = new LSD();
        int arr[] = new int[]{432,8,530,90,88,231,011,45,677,199};

        lsd.radixSort(arr,arr.length);
    }

    void radixSort(int[] arr, int n)
    {
        int max = getMax(arr,n);
        int pos=0;
        for(pos=1;max/pos >0;pos*=10)
        {
            arr= countSort(arr,n,pos);
        } 
        
        for(int a:arr)
        {
            System.out.print(a+" ");
        }
    }

    int[] countSort(int arr[], int n, int pos)
    {
        int count[] = new int[n+1];

        for(int i=0;i<n;i++)
        {
            count[(arr[i]/pos)%10]++;
        }

        for(int i=1;i<=n;i++)
        {
            count[i] = count[i]+count[i-1];
        }

        int[] aux = new int[n];

        for(int i=n-1;i>=0;i--)
        {
            aux[--count[(arr[i]/pos)%10]] = arr[i];
        }
        return aux;
    }

    int getMax(int[] arr, int n)
    {
        int max = arr[0];

        for(int i=1;i<n;i++)
        {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}
