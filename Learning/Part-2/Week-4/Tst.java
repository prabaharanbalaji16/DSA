public class Tst
{
    class Node
    {
        int val;
        char c;
        Node left, right,mid;
    }

    Node root;

    void put(String key,int val)
    {
        root = put(root,key,val,0);
    }

    private Node put(Node x,String key, int val, int d)
    {
        char c = key.charAt(d);
        if(x==null) 
        {
            x = new Node();
            x.c = c;
        }

        if(c < x.c) 
        {
            x.left = put(x.left,key,val,d);
        }
        else if (c > x.c) 
        {
            x.right = put(x.right,key,val,d);
        }
        else if (d < key.length()-1) 
        {
            x.mid = put(x.mid,key,val,d+1);
        }
        else
            x.val = val;
        return x;

    }

    boolean contains(String key)
    {
        if(get(key)!=0)
        {
            return true;
        }
        return false;
    }

    int get(String key)
    {
        Node x =  get(root,key,0);
        if(x==null) return 0;
        return x.val;
    }

    Node get(Node x, String key, int d)
    {
        if(x==null) return null;
        char c= key.charAt(d);
        if(c < x.c) return get(x.left,key,d);
        else if (c > x.c) return get(x.right,key,d);
        else if (d < key.length()-1) return get(x.mid,key,d+1);
        else
            return x;
    }

    public static void main(String[] args) {
        Tst tst = new Tst();
        tst.put("SEA", 1);
        tst.put("SEE", 2);
        tst.put("HEL", 3);
        tst.put("YEP", 4);
        tst.put("NICE", 5);
        tst.put("WHATEVER",7);
        tst.put("YOU", 6);

        // System.out.println(tst.get("NICE"));
        // System.out.println(tst.get("NINE"));
        System.out.println(tst.get("HEL"));

    }
}