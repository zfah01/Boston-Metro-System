import java.util.LinkedList;
import java.util.List;

public class GraphImpl implements Graph {

        private List<Node> nodes = new LinkedList<>();
        private List<Edge> edges = new LinkedList<>();

        public boolean isGraphEmpty() {
                return nodes.isEmpty();
        }

        public List<Node> getAdjacentNodes(String nodeName) {
                Node node = getNode(nodeName);
                return getAdjacentNodesOfNode(node);
        }

        public List<Node> getAdjacentNodes(int nodeID) {
                Node node = getNode(nodeID);
                return getAdjacentNodesOfNode(node);
        }

        private List<Node> getAdjacentNodesOfNode(Node node){
                List<Node> adjNodes = new LinkedList<>();
                for (Edge edge : edges) {
                        if (edge.getFromNode() == node)
                                adjNodes.add(edge.getToNode());
                        if (edge.getToNode() == node)
                                adjNodes.add(edge.getFromNode());
                }
                return adjNodes;
        }

        // Nodes //

        public List<Node> getAllNodes() {
                return new LinkedList<>(nodes);  // return copy to avoid changes
        }

        public void addNode(String nodeName, int nodeID) {
                if (getNodeIndex(nodeID) >= 0) {
                        System.out.println("Graph: ERROR: Node ID " + nodeID + " already exists");
                } else {
                        nodes.add(new NodeImpl(nodeName, nodeID));
                        System.out.println("Graph: Node " + nodeName + " was added");
                }
        }

        public void removeNode(String nodeName) {
                int nodeIndex = getNodeIndex(nodeName);
                if (nodeIndex >= 0) {
                        Node node = nodes.get(nodeIndex);
                        removeNodeByIndex(nodeIndex, node);
                        System.out.println("Graph: Node " + node.getNodeName() + " (" + node.getNodeID() + ") has been removed");
                } else
                        System.out.println("Graph: ERROR: Node " + nodeName + " was not found!");
        }

        public void removeNode(int nodeID) {
                int nodeIndex = getNodeIndex(nodeID);
                if (nodeIndex >= 0) {
                        Node node = nodes.get(nodeIndex);
                        removeNodeByIndex(nodeIndex, node);
                        System.out.println("Graph: Node " + node.getNodeName() + " (" + node.getNodeID() + ") has been removed");
                } else
                        System.out.println("Graph: ERROR: Node ID " + nodeID + " was not found!");
        }

        private void removeNodeByIndex(int nodeIndex, Node node){
                List<Node> adjNodes = getAdjacentNodes(node.getNodeID());
                if (adjNodes.isEmpty())
                        nodes.remove(nodeIndex);
                else
                        System.out.println("Graph: ERROR: Cannot delete this node because it has " + adjNodes.size() + " edges linked to it");
        }

        public int getNodeIndex(String nodeName){
                Node node;
                for (int i=0; i<nodes.size(); i++){
                        node = nodes.get(i);
                        if (node.getNodeName().equalsIgnoreCase(nodeName)) {
                                return i;
                        }
                }
                return -1;
        }

        public int getNodeIndex(int nodeID){
                Node node;
                for (int i=0; i<nodes.size(); i++){
                        node = nodes.get(i);
                        if (node.getNodeID() == nodeID) {
                                return i;
                        }
                }
                return -1;
        }

        public Node getNode(String nodeName){
                int nodeIndex = getNodeIndex(nodeName);
                if (nodeIndex >= 0)
                        return nodes.get(nodeIndex);
                return null;
        }

        public Node getNode(int nodeID){
                int nodeIndex = getNodeIndex(nodeID);
                if (nodeIndex >= 0)
                        return nodes.get(nodeIndex);
                return null;
        }

        public boolean isNode(String nodeName) {
                return getNodeIndex(nodeName) >= 0;
        }

        public boolean isNode(int nodeID) {
                return getNodeIndex(nodeID) >= 0;
        }

        public int getNodeCount() {
                return nodes.size();
        }

        // Edges //

        public void addEdge(String lineColour, int fromNodeID, int toNodeID, int edgeWeight) {
                Node fromNode = getNode(fromNodeID);
                Node toNode = getNode(toNodeID);
                if (fromNode == null) {
                        System.out.println("Graph: ERROR: Origin Node ID " + fromNodeID + " was not found!");
                } else if (toNode == null) {
                        System.out.println("Graph: ERROR: Destination Node ID " + toNodeID + " was not found!");
                } else if (getEdgeIndex(fromNodeID, toNodeID, lineColour) >= 0) {
                        System.out.println("Graph: ERROR: Edge from node ID " + fromNodeID + " to node ID " + toNodeID + " already exists!");
                } else {
                        Edge newEdge = new EdgeImpl(fromNode, toNode, lineColour, edgeWeight);
                        edges.add(newEdge);
                        System.out.println("Graph: Edge from " + fromNode.getNodeName() + " to " + toNode.getNodeName() + " was added");
                }
        }

        public void addEdge(String lineColour, int fromNodeID, int toNodeID) {
                addEdge(lineColour, fromNodeID, toNodeID, 1);
        }

        public int getEdgeIndex(int fromNodeID, int toNodeID){
                return getEdgeIndex(fromNodeID, toNodeID, null);
        }

        public int getEdgeIndex(String fromNodeName, String toNodeName){
                return getEdgeIndex(fromNodeName, toNodeName, null);
        }

        public int getEdgeIndex(int fromNodeID, int toNodeID, String lineColour){
                Edge edge;
                for (int i=0; i<edges.size(); i++){
                        edge = edges.get(i);
                        if (edge.getFromNode().getNodeID() == fromNodeID && edge.getToNode().getNodeID() == toNodeID && (lineColour == null || edge.getLineColour().equalsIgnoreCase(lineColour))) {
                                return i;
                        }
                }
                return -1;
        }

        public int getEdgeIndex(String fromNodeName, String toNodeName, String lineColour){
                Edge edge;
                for (int i=0; i<edges.size(); i++){
                        edge = edges.get(i);
                        if (edge.getFromNode().getNodeName().equalsIgnoreCase(fromNodeName) && edge.getToNode().getNodeName().equalsIgnoreCase(toNodeName) && (lineColour == null || edge.getLineColour().equalsIgnoreCase(lineColour))) {
                                return i;
                        }
                }
                return -1;
        }

        public void removeEdge(String fromNodeName, String toNodeName) {
                int edgeIndex = getEdgeIndex(fromNodeName, toNodeName);
                if (edgeIndex >= 0) {
                        Edge edge = edges.get(edgeIndex);
                        edges.remove(edgeIndex);
                        System.out.println("Graph: Edge from " + edge.getFromNode().getNodeName() + " to " + edge.getToNode().getNodeName() + " was removed");
                } else
                        System.out.println("Graph: ERROR: Edge from node " + fromNodeName + " to node " + toNodeName + " was not found!");
        }

        public void removeEdge(int fromNodeID, int toNodeID) {
                int edgeIndex = getEdgeIndex(fromNodeID, toNodeID);
                if (edgeIndex >= 0) {
                        Edge edge = edges.get(edgeIndex);
                        edges.remove(edgeIndex);
                        System.out.println("Graph: Edge from " + edge.getFromNode().getNodeName() + " to " + edge.getToNode().getNodeName() + " was removed");
                } else
                        System.out.println("Graph: ERROR: Edge from node ID " + fromNodeID + " to node ID " + toNodeID + " was not found!");
        }

        public boolean isEdge(int fromNodeID, int toNodeID) {
                return getEdgeIndex(fromNodeID, toNodeID) >= 0;
        }

        public boolean isEdge(String fromNodeName, String toNodeName) {
                return getEdgeIndex(fromNodeName, toNodeName) >= 0;
        }


        public int getEdgeCount() {
                return edges.size();
        }

        public List<Edge> getEdges() {
                return edges;
        }

}