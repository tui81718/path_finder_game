import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

public class Dijkstra {

    public static void calculateShortestPath(Node source) {
        source.setDistance(0);
        
        Set<Node> settledNodes = new HashSet<>();
        PriorityQueue<Node> unsettledNodes = new PriorityQueue<>();
        
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
    public static void printPaths(List<Node> nodes) {
      nodes.forEach(node -> {
          String path = node.getShortestPath().stream()
                            .map(Node::getName)
                            .collect(Collectors.joining(" -> "));
          String output = path.isBlank()
                          ? String.format("%s : %s", node.getName(), node.getDistance())
                          : String.format("%s -> %s : %s", path, node.getName(), node.getDistance());
          System.out.println(output);
      });
  }
  
  
}
