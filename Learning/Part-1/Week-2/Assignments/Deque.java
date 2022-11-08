package Assignments;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{

    private int first, last, n;
    private Item[] dq;

    public Deque()
    {
        first=0;
        last=0;
        n=0;
        dq = (Item[]) new Object[2];
    }

    public boolean isEmpty()
    {
        return size()==0;
    }

    public int size(){
        return n;
    }

    public void addFirst(Item item)
    {
        if(item==null) throw new IllegalArgumentException("Item is Empty");

        if(n ==dq.length) resize(2*dq.length);
        
        if(first == last && dq[first]==null)
        {
            dq[first] = item;
        }
        else if(first==0)
        {
            first = dq.length-1;
            dq[first] = item;
        }
        else
        {
            first--;
            dq[first] = item;
        }
        n++;
    }

    public void addLast(Item item){
        if(item==null) throw new IllegalArgumentException("Item is Empty");
        if(n ==dq.length) resize(2*dq.length);

        if(first==last && dq[last]==null)
        {
            dq[last] = item;
        }
        else if(last== dq.length -1)
        {
            last = 0;
            dq[last] = item;
        }
        else{
            last++;
            dq[last] = item;
        }
        n++;
    }

    public Item removeFirst()
    {
        if(!isEmpty())
        {
            Item item = dq[first];
            dq[first] = null;

            if(first == dq.length-1)
            {
                first=0;
            }
            else
            {
                first++;
            }
            n--;
            if(n>0 && n==dq.length/4) resize(dq.length/2);
            
            return item;
        }
        else
        {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    public Item removeLast()
    {
        if(!isEmpty())
        {
            Item item = dq[last];
            dq[last] = null;
            if(last == 0 && n>1)
            {
                last = dq.length-1;
            }
            else if(last!=0 && n!=1)
            {
                last--;
            }
            n--;
            if(n>0 && n==dq.length/4) resize(dq.length/2);
            
            return item;
        }
        else
        {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    private void resize(int capacity)
    {
        Item[] temp = (Item[])new Object[capacity];
        for(int i= 0;i<n;i++)
        {
            temp[i] = dq[i];
        }
        dq=temp;
        first=0;
        last = n-1;
    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.addFirst(4);
        deque.addFirst(4);
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        deque.addLast(10);
        System.out.println(deque.size());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
    }

    // @Override
    public Iterator<Item> iterator() {
        
        return new ArrayIterator<>();
    }


private class ArrayIterator<Item> implements Iterator<Item>{

    private int i=0;

    // @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return i<n;
    }    

    public Item next()
    {
        if(!hasNext())
        {
            throw new NoSuchElementException();
        }
        Item item = (Item) dq[(i+first)];
        i++;
        return item;
    }
}
}