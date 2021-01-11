import java.util.Arrays;

public class DisjointSet {
    int[] nodes = new int[10];

    public DisjointSet() {
        Arrays.fill(nodes, -1);
    }

    public int findParent(int node) {
        return findParent(node, node);
    }

    private int findParent(int node, int ogNode) {
        if (nodes[node] < 0) {
            // reached root parent
            // collapse if parent of the original node is not itself
            if ( nodes[node] != nodes[ogNode]) {
                nodes[ogNode] = node;
            }
            return node;
        }
        // keep going up the "tree"
        return findParent(nodes[node], ogNode);
    }

    public void connect(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        if (parent1 == parent2) return;
        if (nodes[parent1] > nodes[parent2]) {
            nodes[parent2] = nodes[parent2] + nodes[parent1];
            nodes[parent1] = parent2;
        }
        else if (nodes[parent1] <= nodes[parent2]) {
            nodes[parent1] = nodes[parent1] + nodes[parent2];
            nodes[parent2] = parent1;
        }
    }

    public boolean isConnected(int node1, int node2) {
        return findParent(node1) == findParent(node2);
    }

    public void print() {
        System.out.println(Arrays.toString(this.nodes));
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();
        ds.connect(0,1);
        ds.print();
        ds.connect(7, 5);
        ds.print();
        ds.connect(0, 5);
        ds.print();
    }
}
