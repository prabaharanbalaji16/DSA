public class LinearProbing<Key,Value> {
    private int M = 30001;
    private Value[] vals = (Value[]) new Object[M];
    private Key[] keys =(Key[]) new Object[M];
    
    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff)%M;
    }

    public void put(Key key, Value val)
    { 
        int i;
        for( i = hash(key);keys[i]!=null;i=(i+1)%M)
        {
            if(keys[i].equals(key))
            {
                break;
            }   
        }
        keys[i] = key;
        vals[i] = val;
    }

    public Value get(Key key)
    {
        for(int i = hash(key);keys[i]!=null;i=(i+1)%M)
        {
            if(key.equals(keys[i]))
            {
                return (Value) vals[i];
            }    
        }
        return null;
    }


    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing();
        linearProbing.put(2, 2);
        linearProbing.put(7, 7);
        linearProbing.put(1, 1);
        linearProbing.put(3, 3);
        linearProbing.put(8, 8);
    
        System.out.println(linearProbing.get(2));       
    }

}
