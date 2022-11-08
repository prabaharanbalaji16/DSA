package Assignments;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> {

    private int n;
    private Item[] rq;

    public RandomizedQueue()
    {
        n=0;
        rq=(Item[]) new Object[2];
    }

    public static void main(String[] args) {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue(10);
        randomizedQueue.enqueue(4);
        randomizedQueue.enqueue(8);
        System.out.println(randomizedQueue.dequeue());
        randomizedQueue.enqueue(5);
        randomizedQueue.enqueue(3);
        randomizedQueue.enqueue(1);
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
    }

    public boolean isEmpty()
    {
        return size()==0;
    }

    public int size()
    {
        return n;
    }

    public void enqueue(Item item)
    {
        if(item==null) throw new IllegalArgumentException();
        if(n ==rq.length) resize(2*rq.length);

        rq[n++] = item;
    }

    private void resize(int capacity)
    {
        Item[] temp = (Item[])new Object[capacity];
        for(int i= 0;i<n;i++)
        {
            temp[i] = rq[i];
        }
        rq=temp;
    }

    public Item dequeue()
    {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int index = sample();
        Item item = rq[index];
        rq[index] = null;
        if(n>0 && n==rq.length/4) resize(rq.length/2);
        return item;
    }

    public int sample()
    {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Random r = new Random();
        return (int) (r.nextInt(n));
    }


}
