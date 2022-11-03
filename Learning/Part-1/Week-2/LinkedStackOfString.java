// package Learning.Part-1.Week-2;

class StackOfString{
    private Node first = null;

    private class Node{
        String item;
        Node next;
    }
    void push(String text)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = text;
        first.next = oldFirst;
    }

    String pop()
    {
        String item = first.item;
        first.next = first;
        return item;
    }
}

public class LinkedStackOfString {
    public static void main(String[] args) {
        StackOfString stack = new StackOfString();
        String[] texts = {"to","be","or","not","to","-","be","that","-"};
        for(String text:texts)
        {
            if(text.equals("-"))
            {
            String pop =  stack.pop();
            System.out.println(pop);
            }
            else
            {
                stack.push(text);
            }
        }
    }
}
