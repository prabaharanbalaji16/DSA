public class KeyIndexed
{
    int size;
    public KeyIndexed(int[] arr)
    {
        int size = arr.length;
        int R = 12;
        int[] count = new int[R+1];
        int[] aux = new int[size];

        for(int i=0;i<size;i++)
        {
            count[arr[i]+1]++;
        }

        for(int r=0;r<R;r++)
        {
            count[r+1] +=count[r];
        }

        for(int i:arr)
        {
            System.out.print(i +" ");
        }
        System.out.println();
        for(int i:count)
        {
            System.out.print(i +" ");
        }
        System.out.println();
        for(int i=0;i<arr.length;i++)
        {
            aux[count[arr[i]]++] = arr[i];
        }
        for(int i:aux)
        {
            System.out.print(i +" ");
        }      


    }
    public static void main(String[] args)
    {
        int[] arr = {8,5,6,5,11,4,7,8,8,10};
        KeyIndexed keyIndexed = new KeyIndexed(arr);
    }
}