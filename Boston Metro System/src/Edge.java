
interface Edge {
    //edgeID
    public void setEdgeID(int id);
    public int getEdgeID();

    //formNode
    public void setFromNode(Node node);
    public Node getFromNode();

    //toNode
    public void setToNode(Node node);
    public Node getToNode();

    //LineID
    public void setLineID(int id);
    public int getLineID();

    //edgeWeight
    public void setEdgeWeight(int weight);
    public int getEdgeWeight();
}
