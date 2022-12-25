@SuppressWarnings("unchecked")
public class SeparateChaining<Key,Value>
{
    private int M = 97;
    private Node[] st = new Node[M];

    private static class Node{
        private Object key;
        private Object val;
        private Node next;

        private Node(Object key, Object val, Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff)%M;
    }

    public Value get(Key key)
    {
        int i = hash(key);
        for(Node x = st[i];x!=null;x=x.next)
        {
            if(key.equals(x.key))
            {
                return (Value) x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val)
    {
        int i = hash(key);
        for(Node x = st[i]; x!=null;x=x.next)
        {
            if(key.equals(x.key))
            {
                x.val = val;
                return;
            }
        }
        st[i] = new Node(key,val,st[i]);
    }

    public static void main(String[] args) {
        SeparateChaining separateChaining = new SeparateChaining();
        separateChaining.put("Hello", 2);
        separateChaining.put("New", 7);
        separateChaining.put("York", 1);
        separateChaining.put("AMS", 3);
        separateChaining.put("USA", 8);

        System.out.println(separateChaining.get("AMS"));
    }
}