import java.util.Locale;

public class EdgeImpl implements Edge {

    private Node fromNode;
    private Node toNode;
    private String lineColour;
    private int edgeWeight;

    /**
     * This method is the constructor method for this class. It creates a new Edge
     * and sets the nodes on both sides of it, as well as the metro line colour this
     * edge belongs to along with the edge weight which is the time cost.
     *
     * @param fromNode: node instance on one side of the edge
     * @param toNode: node instance on the other side of the edge
     * @param lineColour: colour string of the edge
     * @param edgeWeight: integer value describing the time cost of traveling through the edge. default is 1
     */
    public EdgeImpl(Node fromNode, Node toNode, String lineColour, int edgeWeight) {
        setFromNode(fromNode);
        setToNode(toNode);
        setLineColour(lineColour);
        setEdgeWeight(edgeWeight);
    }

    /**
     * Setter method to set the first node instance on one side of the edge
     * @param node: node instance on one side of the edge
     */
    public void setFromNode(Node node) {
        fromNode = node;
    }

    /**
     * Getter method to retrieve the first node instance on one side of the edge
     * @return node instance on one side of the edge
     */
    public Node getFromNode() {
        return fromNode;
    }

    /**
     * Setter method to set the second node instance on one side of the edge
     * @param node: node instance on one side of the edge
     */
    public void setToNode(Node node) {
        toNode = node;
    }

    /**
     * Getter method to retrieve the second node instance on one side of the edge
     * @return node instance on one side of the edge
     */
    public Node getToNode() {
        return toNode;
    }

    /**
     * Setter method to set the line colour of the edge. Value is trimmed.
     * @param colour: colour string of the edge
     */
    public void setLineColour(String colour) {
        lineColour = colour.toLowerCase(Locale.ROOT).trim();
    }

    /**
     * Getter method to get the line colour of the edge
     * @return colour string of the edge
     */
    public String getLineColour() {
        return lineColour;
    }

    /**
     * Setter method to set the weight of the edge
     * @param weight: integer value describing the time cost of traveling through the edge. default is 1
     */
    public void setEdgeWeight(int weight) {
        edgeWeight = weight;
    }

    /**
     * Getter method to get the weight of the edge
     * @return integer value describing the time cost of traveling through the edge
     */
    public int getEdgeWeight() {
        return edgeWeight;
    }
}
