public class NodeImpl implements Node  {

    private String name;
    private int nodeId;

    public NodeImpl(String name, int nodeId){
        this.name = name;
        this.nodeId = nodeId;
    }

    public void setNodeName(String nodeName){
        name = nodeName;
    }

    public String getNodeName(){
        return name;
    }

    public void setNodeID(int id){
        nodeId = id;
    }

    public int getNodeID(){
        return nodeId;
    }

}
