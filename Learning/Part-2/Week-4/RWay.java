public class RWay{
    public static final int R = 256;
    Node root = new Node();

    class Node{
        Node[] next = new Node[R];
        int value;
    }

    
    void put(String key, int val)
    {
        root = put(root,key,val,0);
    }

    Node put(Node x,String key,int val, int d)
    {
        if(x==null) x = new Node();
        if(d==key.length()) 
        {
            x.value = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c],key,val,d+1);
        return x;
    }

    public boolean contains(String key)
    {
        return get(key)!=0;
    }

    public int get(String key)
    {
        Node x = get(root,key,0);
        if(x==null) return 0;
        return  x.value;
    }

    public Node get(Node x, String key, int d)
    {
        if(x==null) x = new Node();
        if(d==key.length())
        {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c],key,d+1);
    }

    public static void main(String[] args) {
        RWay trie = new RWay();
        trie.put("ace",2);
        trie.put("ago",3);
        trie.put("dim",4);
        trie.put("gig",5);
        trie.put("nob",6);
        trie.put("man",1);

        System.out.println(trie.get("ace"));
        System.out.println(trie.get("yep"));
    }
}
