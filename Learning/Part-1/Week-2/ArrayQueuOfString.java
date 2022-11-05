class ArrayQueue{
     String[] q = new String[1];
     int head=0;
     int tail = q.length;

     boolean isEmpty(){
        return head==tail;
     }

     void enqueue(String item)
     {
        if(tail==q.length) resize(2*q.length);
        q[tail++] = item;
     }

     String dequeue()
     {
        String item= q[++head];
        q[head] = null;
        if(tail > head && tail == q.length/4) resize(q.length/2);
        return item;
     }

     void resize(int capacity)
     {
        String[] copy = new String[capacity];
        for(int i=0;i<q.length;i++)
        {
            copy[i] = q[i];
        }
        q = copy;
    }
}
public class ArrayQueuOfString {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        String[] texts = {"to","be","-","not","to","-","be","that","-"};
        for(String text:texts)
        {
            if(text.equals("-"))
            {
            String pop =  arrayQueue.dequeue();
            System.out.println(pop);
            }
            else
            {
                arrayQueue.enqueue(text);
            }
        }
    }    
}
