interface Graph {
    public void addEdge(String lineColour, int fromNodeID, int toNodeID, int edgeWeight);
    public void addEdge(String lineColour, int fromNodeID, int toNodeID);

    public void addNode(String nodeName, int nodeID);
}
