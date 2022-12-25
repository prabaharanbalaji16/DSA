package Assignments;

import java.util.Scanner;
@SuppressWarnings("unchecked")
public class Permutation {
    public static void main(String[] args) {
        int count = Integer.parseInt("3");
        RandomizedQueue rq = new RandomizedQueue<>();

        Scanner s = new Scanner(System.in);

        for(int i=0;i<10;i++)
        {
            String item = s.nextLine();
            rq.enqueue(item);
        }
        s.close();
        for(int i=0;i<count;i++)
        {
            System.out.println(rq.dequeue());
        }
    }
}
