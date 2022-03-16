
interface Edge {

    //formNode
    public void setFromNode(Node node);
    public Node getFromNode();

    //toNode
    public void setToNode(Node node);
    public Node getToNode();

    //LineID
    public void setLineColour(String colour);
    public String getLineColour();

    //edgeWeight
    public void setEdgeWeight(int weight);
    public int getEdgeWeight();
}
