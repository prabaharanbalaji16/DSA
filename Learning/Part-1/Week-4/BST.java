public class BST <Key extends Comparable<Key>,Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key, Value val)
        {
            this.key = key;
            this.val = val;
        }
    }

    public void put(Key key, Value val)
    {
        root = put(root,key,val);
    }

    private Node put(Node x, Key key, Value val)
    {
        if(x==null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
        {
            x.left = put(x.left, key, val);
        }
        else if(cmp > 0)
        {
            x.right = put(x.right, key, val);
        }
        else
        {
            x.val = val;
        }
        return x;
    }

    public Value get(Key key)
    {
        Node x = root;
        while(x!=null)
        {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void delete(Key key)
    {
        root = delete(root,key);
        System.out.println(root.val);
    }


    private Node delete(Node x, Key key)
    {
        if(x == null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp<0)
            x.left = delete(x.left, key);
        else if(cmp>0) 
            x.right = delete(x.right,key);
        else
        {
            if(x.left ==null) return x.right;
            if(x.right==null) return x.left;
        }
        return x;
    }

    public Iterable<Key> Iterator()
    {
        return null;   
    }

    public static void main(String[] args) {
        BST tree = new BST<>();
        tree.put(1, "L");
        tree.put(2, "F");
        tree.put(3, "O");
        tree.put(4, "K");
        tree.put(5, "U");
        tree.put(6, "B");

        // System.out.println(tree.get(4));

        tree.put(7, "Z");
        tree.put(9, "M");
        tree.put(11, "G");

        // System.out.println(tree.get(11));
        // System.out.println(tree.get(3));
        
        tree.delete(1);
        tree.delete(2);
        tree.delete(9);
    }
}
