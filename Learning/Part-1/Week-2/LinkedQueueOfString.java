class LinkedQueue{
    private Node first, last;

    private class Node{
        String item;
        Node next;
    }

    Boolean isEmpty()
    {
        return first == null;
    }

    void enqueue(String item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }
        else
        {
            oldLast.next = last;
        }
    }

    String dequeue()
    {
        String item = first.item;
        first = first.next;
        if(isEmpty()) last=null;
        return item;
    }
}
public class LinkedQueueOfString{
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        String[] texts = {"to","be","or","not","to","-","be","that","-"};
        for(String text:texts)
        {
            if(text.equals("-"))
            {
            String pop =  linkedQueue.dequeue();
            System.out.println(pop);
            }
            else
            {
                linkedQueue.enqueue(text);
            }
    }
}
}