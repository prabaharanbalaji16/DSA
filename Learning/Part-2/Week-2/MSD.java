public class MSD {
    public static void main(String[] args) {
        MSD msd = new MSD();
        int arr[] = new int[]{22,17,97,55,43,39,90,88,23,60};
        // System.out.println(arr.length);
        msd.radixSort(arr,arr.length);
    }

    void radixSort(int[] arr, int n)
    {
        int max = getMax(arr,n);
        int zeros=1;

        int digit = (int) Math.log10(max);
        System.out.println(digit);
        while(digit>0)
        {
            zeros*=10;
            digit--;
        }
        System.out.println(digit);
        for(int pos=zeros;max/pos>0;pos/=10)
        {
            System.out.println(pos);
            arr = countSort(arr,n,pos);
            if((pos/10)==0)
            {
                break;
            }
        }

    }

    int[] countSort(int[] arr,int n, int pos)
    {
        int count[] = new int[n+1];

        for(int i=0;i<n;i++)
        {
            
            count[(arr[i]/pos)%10]++;
            // System.out.println(i);
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

        for(int c:aux)
        {
            System.out.print(c+" ");
        }
        System.out.println();
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
