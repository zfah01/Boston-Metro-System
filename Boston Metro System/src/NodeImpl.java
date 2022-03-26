public class NodeImpl implements Node  {

    private String name;
    private int nodeID;

    /**
     * This method is the constructor method for this class. It creates a new node
     * and sets its name and ID
     *
     * @param name: string value of node name
     * @param nodeID: integer value of node ID
     */
    public NodeImpl(String name, int nodeID){
        setNodeName(name);
        setNodeID(nodeID);
    }

    /**
     * Setter method to set node name. Name is trimmed
     * @param nodeName: string value of node's name
     */
    public void setNodeName(String nodeName){
        name = nodeName.trim();
    }

    /**
     * Getter method to get the name of the node
     * @return string value of node name
     */
    public String getNodeName(){
        return name;
    }

    /**
     * Setter method to set the integer value of node ID
     * @param id: integer value of node ID
     */
    public void setNodeID(int id){
        nodeID = id;
    }

    /**
     * Getter method to get the integer value of the node ID
     * @return integer value of node ID
     */
    public int getNodeID(){
        return nodeID;
    }

}
