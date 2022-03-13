import java.util.List;

interface Graph {
    public boolean isGraphEmpty();

    public List<Node> getAdjacentNodes(String nodeName);

    public List<Node> getAdjacentNodes(int nodeID);


    // Nodes //

    public List<Node> getAllNodes();

    public void addNode(String nodeName, int nodeID);

    public void removeNode(String nodeName);

    public void removeNode(int nodeID);

    public int getNodeIndex(String nodeName);

    public int getNodeIndex(int nodeID);

    public Node getNode(String nodeName);

    public Node getNode(int nodeID);

    public boolean isNode(String nodeName);

    public boolean isNode(int nodeID);

    public int getNodeCount();

    // Edges //

    public void addEdge(String lineColour, int fromNodeID, int toNodeID, int edgeWeight);

    public void addEdge(String lineColour, int fromNodeID, int toNodeID);

    public int getEdgeIndex(int fromNodeID, int toNodeID);

    public int getEdgeIndex(String fromNodeName, String toNodeName);

    public int getEdgeIndex(int fromNodeID, int toNodeID, String lineColour);

    public int getEdgeIndex(String fromNodeName, String toNodeName, String lineColour);

    public void removeEdge(String fromNodeName, String toNodeName);

    public void removeEdge(int fromNodeID, int toNodeID);

    public boolean isEdge(int fromNodeID, int toNodeID);

    public boolean isEdge(String fromNodeName, String toNodeName);

    public int getEdgeCount();
}
