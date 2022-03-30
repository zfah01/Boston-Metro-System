import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MetroRouteFinder {

    private Graph graph;

    MetroRouteFinder(Graph graph){
        this.graph = graph;
    }

    public void setGraph(Graph graph){
        this.graph = graph;
    }

    public Graph getGraph(){
        return graph;
    }

    /**
     * This method runs a breadth first graph search to find the route between 2 nodes.
     * It accepts the node ID of each node, and returns a list of node objects representing the route.
     *
     * The method starts by creating a queue which will contain the full path from the starting node
     * to the current one. If the current node is not the destination, its neighbours are found, and the ones
     * which were not visited before will be added to the queue each in its own path list.
     *
     * @param node1ID: integer value of origin node ID
     * @param node2ID: integer value of destination node iD
     * @return a list of node instances representing the route from origin to destination
     */
    public List<Node> breadthFirstSearch(int node1ID, int node2ID){
        LinkedList<Node> visitedNodes = new LinkedList<>();
        Queue<LinkedList<Node>> toVisit = new LinkedList<>();
        Node node1 = graph.getNode(node1ID);
        LinkedList<Node> firstRoute = new LinkedList<>();
        firstRoute.add(node1);
        toVisit.add(firstRoute);

        LinkedList<Node> path;

        while (!toVisit.isEmpty()){
            path = toVisit.poll();
            for (Node n: graph.getAdjacentNodes(path.getLast().getNodeID())){
                if (visitedNodes.contains(n))
                    continue;

                LinkedList<Node> newPath = new LinkedList<>(path);
                newPath.add(n);
                if (node2ID == n.getNodeID()){
                    return newPath;
                }
                toVisit.add(newPath);

            }
            visitedNodes.add(path.getLast());
        }
        return null;
    }

}
