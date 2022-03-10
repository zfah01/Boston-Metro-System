

public class EdgeImpl implements Edge {

    private int edgeID;
    private Node fromNode;
    private Node toNode;
    private int LineID;
    private int edgeWeight;


    public EdgeImpl(int edgeID, Node fromNode, Node toNode, int LineID, int edgeWeight) {
        this.edgeID = edgeID;
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.LineID = LineID;
        this.edgeWeight = edgeWeight;
    }

    //edgeID
    public void setEdgeID(int id) {
        edgeID = id;
    }

    public int getEdgeID() {
        return edgeID;
    }

    //formNode
    public void setFromNode(Node node) {
        fromNode = node;
    }

    public Node getFromNode() {
        return fromNode;
    }

    //toNode
    public void setToNode(Node node) {
        fromNode = node;
    }

    public Node getToNode() {
        return toNode;
    }

    //LineID
    public void setLineID(int id) {
        LineID = id;
    }

    public int getLineID() {
        return LineID;
    }

    //edgeWeight
    public void setEdgeWeight(int weight) {
        edgeWeight = weight;
    }

    public int getEdgeWeight() {
        return edgeWeight;
    }

}
