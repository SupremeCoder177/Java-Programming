public class QuickFind {

    private int[] id;

    QuickFind(int nodes)
    {
        id = new int[nodes];
        for(int i = 0; i < nodes; i++) id[i] = i;
    }

    public boolean connected(int node1, int node2)
    { return id[node1] == id[node2]; }

    public void union(int node1, int node2)
    { id[node2] = node1; }

    public int id(int node)
    { return id[node]; }

    public static void main(String[] args){
        QuickFind find = new QuickFind(10);
        System.out.println("Connecting 6 and 5....");
        find.union(6, 5);
        System.out.println("Are 6 and 1 connected : " + find.connected(6, 1));
        System.out.println("Id of 5 : " + find.id(5));
    }

}
