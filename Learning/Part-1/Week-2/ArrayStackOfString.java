class ArrayOfString{
    String[] s;
    int N=0;
    ArrayOfString(int capacity){
        s = new String[capacity];
    }

    Boolean isEmpty()
    {
        return N==0;
    }

    void push(String item)
    {
        s[N++] = item;
    }

    String pop()
    {
        String item = s[--N];
        s[N]= null;
        return item;
    }
}

public class ArrayStackOfString {
    public static void main(String[] args) {
        ArrayOfString stack = new ArrayOfString(10);
        String[] texts = {"to","be","-","not","to","-","be","that","-"};
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
