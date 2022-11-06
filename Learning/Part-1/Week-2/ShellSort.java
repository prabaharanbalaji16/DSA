public class ShellSort
{
    public static void main(String[] args) {
        int[] elements = {21,38,29,11,32,9};
        sort(elements);

        // for(int a: elements)
        //     {
        //         System.out.print(a+" ");
        //     } 
            System.out.println();
    }
    public static void sort(int[] arr)
    {
        int size = arr.length;
        int gap=(size/2);

        while(gap >0)
        {
            for(int i=gap;i<size;i++)
            {
                int anchor = arr[i];
                int j=i;
                
                while(j>=gap && arr[j-gap]>anchor)
                {
                    arr[j] = arr[j-gap];
                    j-=gap;
                    arr[j] = anchor;
                }
                for(int a: arr)
                {
                    System.out.print(a+" ");
                } 
                System.out.println();
            }
        gap=gap/2;
        }
    }
}