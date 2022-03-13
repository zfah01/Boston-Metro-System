import java.util.Locale;

public class NodeImpl implements Node  {

    private String name;
    private int nodeID;

    public NodeImpl(String name, int nodeID){
        setNodeName(name);
        setNodeID(nodeID);
    }

    public void setNodeName(String nodeName){
        name = nodeName.toLowerCase(Locale.ROOT);
    }

    public String getNodeName(){
        return name;
    }

    public void setNodeID(int id){
        nodeID = id;
    }

    public int getNodeID(){
        return nodeID;
    }

}
