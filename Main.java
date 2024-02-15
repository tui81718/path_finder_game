import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create nodes
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        // Add edges
        nodeA.addAdjacentNode(nodeB, 2);
        nodeA.addAdjacentNode(nodeC, 4);

        nodeB.addAdjacentNode(nodeC, 3);
        nodeB.addAdjacentNode(nodeD, 1);
        nodeB.addAdjacentNode(nodeE, 5);

        nodeC.addAdjacentNode(nodeD, 2);

        nodeD.addAdjacentNode(nodeE, 1);
        nodeD.addAdjacentNode(nodeF, 4);

        nodeE.addAdjacentNode(nodeF, 2);

        // Calculate shortest paths from node A to all other nodes
        Dijkstra.calculateShortestPath(nodeA);

        // Print out shortest paths and distances
        List<Node> nodes = Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF);
        Dijkstra.printPaths(nodes);
    }
}
