import java.util.Locale;

public class EdgeImpl implements Edge {

    private Node fromNode;
    private Node toNode;
    private String lineColour;
    private int edgeWeight;


    public EdgeImpl(Node fromNode, Node toNode, String lineColour, int edgeWeight) {
        setFromNode(fromNode);
        setToNode(toNode);
        setLineColour(lineColour);
        setEdgeWeight(edgeWeight);
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
        toNode = node;
    }

    public Node getToNode() {
        return toNode;
    }

    //LineID
    public void setLineColour(String colour) {
        lineColour = colour.toLowerCase(Locale.ROOT);
    }

    public String getLineColour() {
        return lineColour;
    }

    //edgeWeight
    public void setEdgeWeight(int weight) {
        edgeWeight = weight;
    }

    public int getEdgeWeight() {
        return edgeWeight;
    }

}
