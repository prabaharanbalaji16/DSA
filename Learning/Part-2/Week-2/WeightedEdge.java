public class WeightedEdge implements Comparable<WeightedEdge>{
        private int v,w;
        private int weight;

        public WeightedEdge(int v, int w, int weight)
        {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public WeightedEdge() {
        }

        public int either()
        {
            return v;
        }

        public int other(int v)
        {
            if(this.v==v)
                return w;
            else
                return v;
        }

        public int weight()
        {
            return weight;
        }


        public int compareTo(WeightedEdge that)
        {
            if( this.weight < that.weight) return -1;
            else if( this.weight > that.weight) return 1;
            else return 0;
        }

        public String toString()
        {
            return " "+v+"->"+w+"  "+weight;
        }
        
}
