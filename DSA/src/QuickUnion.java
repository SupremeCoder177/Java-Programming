public class QuickUnion {

    private int[] id;

    QuickUnion(int nodes){
        id = new int[nodes];
        for(int i = 0; i < nodes; i++) id[i] = i;
    }

    public int root(int node)
    {
        while(node != id[node]) node = id[node];
        return node;
    }

    public void union(int node1, int node2)
    {
        int i = root(node1);
        int j = root(node2);
        id[i] = j;
    }

    public boolean connected(int node1, int node2)
    { return root(node1) == root(node2); }

    public static void main(String[] args){
        QuickUnion union = new QuickUnion(10);
        union.union(7, 1);
        System.out.println(union.connected(7, 1));

    }

}
