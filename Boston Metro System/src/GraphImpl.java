import java.util.LinkedList;
import java.util.List;

public class GraphImpl implements Graph {

        private final List<Node> nodes = new LinkedList<>();
        private final List<Edge> edges = new LinkedList<>();

        /**
         * Checks if the graph instance is empty
         * @return boolean, true if graph is empty else false
         */
        public boolean isGraphEmpty() {
                return nodes.isEmpty();
        }

        /**
         * Accepts string value of a node's name and finds all the adjacent
         * nodes of the given node
         * @param nodeName: string value of node's name
         * @return list of all node instances adjacent to given node
         */
        public List<Node> getAdjacentNodes(String nodeName) {
                Node node = getNode(nodeName);
                return getAdjacentNodesOfNode(node);
        }

        /**
         * Accepts integer value of a node's ID and finds all the adjacent
         * nodes of the given node
         * @param nodeID: integer value of node's ID
         * @return list of all node instances adjacent to given node
         */
        public List<Node> getAdjacentNodes(int nodeID) {
                Node node = getNode(nodeID);
                return getAdjacentNodesOfNode(node);
        }

        /**
         * Accepts node instance and finds all the adjacent
         * nodes of the given node
         * @param node: node instance
         * @return list of all node instances adjacent to given node
         */
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

        /**
         * Getter method to return a copy of the nodes list within the graph
         * @return list of all node instances in graph
         */
        public List<Node> getAllNodes() {
                return new LinkedList<>(nodes);  // return copy to avoid changes
        }

        /**
         * Method to create a new node and add it to graph. Node ID must be unique
         * @param nodeName: string value of node name
         * @param nodeID: integer value of node ID
         */
        public void addNode(String nodeName, int nodeID) {
                if (getNodeIndex(nodeID) >= 0) {
                        System.out.println("Graph: ERROR: Node ID " + nodeID + " already exists");
                } else {
                        nodes.add(new NodeImpl(nodeName, nodeID));
                        System.out.println("Graph: Node " + nodeName + " was added");
                }
        }

        /**
         * Method to remove a node instance from the graph by node's name
         * This method calls another method which ensures that the node
         * is not part of any edge. Removal will be skipped if that was the case
         * @param nodeName: string value of node's name
         */
        public void removeNode(String nodeName) {
                int nodeIndex = getNodeIndex(nodeName);
                if (nodeIndex >= 0) {
                        Node node = nodes.get(nodeIndex);
                        if (removeNodeByIndex(nodeIndex, node))
                                System.out.println("Graph: Node " + node.getNodeName() + " (" + node.getNodeID() + ") has been removed");
                } else
                        System.out.println("Graph: ERROR: Node " + nodeName + " was not found!");
        }

        /**
         * Method to remove a node instance from the graph by node's ID
         * This method calls another method which ensures that the node
         * is not part of any edge. Removal will be skipped if that was the case
         * @param nodeID: integer value of node's ID
         */
        public void removeNode(int nodeID) {
                int nodeIndex = getNodeIndex(nodeID);
                if (nodeIndex >= 0) {
                        Node node = nodes.get(nodeIndex);
                        if (removeNodeByIndex(nodeIndex, node))
                                System.out.println("Graph: Node " + node.getNodeName() + " (" + node.getNodeID() + ") has been removed");
                } else
                        System.out.println("Graph: ERROR: Node ID " + nodeID + " was not found!");
        }

        /**
         * Method to remove node by its index/position in the nodes list within the graph
         * Removal is skipped if the node had any adjacent nodes (i.e. it was part of an edge)
         * @param nodeIndex: index of node in graph's node list
         * @param node: node instance to be deleted
         * @return true if delete was successful else false
         */
        private boolean removeNodeByIndex(int nodeIndex, Node node){
                List<Node> adjNodes = getAdjacentNodes(node.getNodeID());
                if (adjNodes.isEmpty()){
                        nodes.remove(nodeIndex);
                        return true;
                } else {
                        System.out.println("Graph: ERROR: Cannot delete this node because it has " + adjNodes.size() + " edges linked to it");
                        return false;
                }
        }

        /**
         * This method finds the first node in the graph nodes list
         * by the node's name
         * @param nodeName: string value of node's name
         * @return index integer value of node instance in graph node list. returns -1 if not found
         */
        private int getNodeIndex(String nodeName){
                Node node;
                for (int i=0; i<nodes.size(); i++){
                        node = nodes.get(i);
                        if (node.getNodeName().equalsIgnoreCase(nodeName)) {
                                return i;
                        }
                }
                return -1;
        }

        /**
         * This method finds the first node in the graph nodes list
         * by the node's ID
         * @param nodeID: integer value of node's ID
         * @return index integer value of node instance in graph node list. returns -1 if not found
         */
        private int getNodeIndex(int nodeID){
                Node node;
                for (int i=0; i<nodes.size(); i++){
                        node = nodes.get(i);
                        if (node.getNodeID() == nodeID) {
                                return i;
                        }
                }
                return -1;
        }

        /**
         * This method returns a node instance in the graph node list
         * based on the given node's name. returns null if not found
         * @param nodeName: string value of node's name
         * @return node instance
         */
        public Node getNode(String nodeName){
                int nodeIndex = getNodeIndex(nodeName);
                if (nodeIndex >= 0)
                        return nodes.get(nodeIndex);
                return null;
        }

        /**
         * This method returns a node instance in the graph node list
         * based on the given node's ID. returns null if not found
         * @param nodeID: integer value of node's ID
         * @return node instance
         */
        public Node getNode(int nodeID){
                int nodeIndex = getNodeIndex(nodeID);
                if (nodeIndex >= 0)
                        return nodes.get(nodeIndex);
                return null;
        }

        /**
         * This method checks if there exists a node in the graph
         * with a given node's name
         * @param nodeName: string value of node's name
         * @return true if the node exists else false
         */
        public boolean isNode(String nodeName) {
                return getNodeIndex(nodeName) >= 0;
        }

        /**
         * This method checks if there exists a node in the graph
         * with a given node's ID
         * @param nodeID: integer value of node's ID
         * @return true if the node exists else false
         */
        public boolean isNode(int nodeID) {
                return getNodeIndex(nodeID) >= 0;
        }

        /**
         * Finds the number of nodes in the graph
         * @return integer count of number of nodes in graph
         */
        public int getNodeCount() {
                return nodes.size();
        }

        // Edges //

        /**
         * Method to add an edge to the graph. This method accepts the IDs of the 2 nodes
         * the edge will map to, and confirms that the given IDs exist in the graph.
         * It also checks if there is an existing edge mapping the same nodes
         * @param lineColour: string value of colour the edge belongs to
         * @param fromNodeID: integer value of ID of one node of the edge
         * @param toNodeID: integer value of ID of second node of the edge
         * @param edgeWeight: integer value of time weight/cost of edge
         */
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

        /**
         * Method to add an edge to the graph. This method accepts the IDs of the 2 nodes
         * the edge will map to, and confirms that the given IDs exist in the graph.
         * It also checks if there is an existing edge mapping the same nodes.
         * Edge weight is set to 1
         * @param lineColour: string value of colour the edge belongs to
         * @param fromNodeID: integer value of ID of one node of the edge
         * @param toNodeID: integer value of ID of second node of the edge
         */
        public void addEdge(String lineColour, int fromNodeID, int toNodeID) {
                addEdge(lineColour, fromNodeID, toNodeID, 1);
        }

        /**
         * Method to get index of edge in graph edge list given the IDs of the nodes
         * the edge maps to. Line colour is ignored
         * @param fromNodeID: integer value of ID of first node
         * @param toNodeID: integer value of ID of second node
         * @return integer value of edge index in node edge list
         */
        private int getEdgeIndex(int fromNodeID, int toNodeID){
                return getEdgeIndex(fromNodeID, toNodeID, null);
        }

        /**
         * Method to get index of edge in graph edge list given the names of the nodes
         * the edge maps to. Line colour is ignored
         * @param fromNodeName: string value of name of first node
         * @param toNodeName: string value of name of second node
         * @return integer value of edge index in node edge list
         */
        private int getEdgeIndex(String fromNodeName, String toNodeName){
                return getEdgeIndex(fromNodeName, toNodeName, null);
        }

        /**
         * Method to get index of edge in graph edge list given the IDs of the nodes
         * the edge maps to, and colour of line. Edges are non-directional
         * @param fromNodeID: integer value of ID of first node
         * @param toNodeID: integer value of ID of second node
         * @param lineColour: string value of colour of line
         * @return integer value of edge index in node edge list
         */
        private int getEdgeIndex(int fromNodeID, int toNodeID, String lineColour){
                Edge edge;
                for (int i=0; i<edges.size(); i++){
                        edge = edges.get(i);
                        if (edge.getFromNode().getNodeID() == fromNodeID
                                && edge.getToNode().getNodeID() == toNodeID
                                && (lineColour == null || edge.getLineColour().equalsIgnoreCase(lineColour))) {
                                return i;
                        }
                        if (edge.getFromNode().getNodeID() == toNodeID
                                && edge.getToNode().getNodeID() == fromNodeID
                                && (lineColour == null || edge.getLineColour().equalsIgnoreCase(lineColour))) {
                                return i;
                        }
                }
                return -1;
        }

        /**
         * Method to get index of edge in graph edge list given the names of the nodes
         * the edge maps to, and colour of line. Edges are non-directional
         * @param fromNodeName: string value of name of first node
         * @param toNodeName: string value of name of second node
         * @param lineColour: string value of colour of line
         * @return integer value of edge index in node edge list
         */
        private int getEdgeIndex(String fromNodeName, String toNodeName, String lineColour){
                Edge edge;
                for (int i=0; i<edges.size(); i++){
                        edge = edges.get(i);
                        if (edge.getFromNode().getNodeName().equalsIgnoreCase(fromNodeName)
                                && edge.getToNode().getNodeName().equalsIgnoreCase(toNodeName)
                                && (lineColour == null || edge.getLineColour().equalsIgnoreCase(lineColour))) {
                                return i;
                        }
                        if (edge.getFromNode().getNodeName().equalsIgnoreCase(toNodeName)
                                && edge.getToNode().getNodeName().equalsIgnoreCase(fromNodeName)
                                && (lineColour == null || edge.getLineColour().equalsIgnoreCase(lineColour))) {
                                return i;
                        }
                }
                return -1;
        }

        /**
         * This method removes the edge from the graph which maps the nodes given the string values of
         * both of those nodes names
         * @param fromNodeName: string value of name of first node
         * @param toNodeName: string value of name of second node
         */
        public void removeEdge(String fromNodeName, String toNodeName) {
                int edgeIndex = getEdgeIndex(fromNodeName, toNodeName);
                if (edgeIndex >= 0) {
                        Edge edge = edges.get(edgeIndex);
                        edges.remove(edgeIndex);
                        System.out.println("Graph: Edge from " + edge.getFromNode().getNodeName() + " to " + edge.getToNode().getNodeName() + " was removed");
                } else
                        System.out.println("Graph: ERROR: Edge from node " + fromNodeName + " to node " + toNodeName + " was not found!");
        }

        /**
         * This method removes the edge from the graph which maps the nodes given the integer values of
         * both of those nodes IDs
         * @param fromNodeID: integer value of name of first ID
         * @param toNodeID: integer value of name of second ID
         */
        public void removeEdge(int fromNodeID, int toNodeID) {
                int edgeIndex = getEdgeIndex(fromNodeID, toNodeID);
                if (edgeIndex >= 0) {
                        Edge edge = edges.get(edgeIndex);
                        edges.remove(edgeIndex);
                        System.out.println("Graph: Edge from " + edge.getFromNode().getNodeName() + " to " + edge.getToNode().getNodeName() + " was removed");
                } else
                        System.out.println("Graph: ERROR: Edge from node ID " + fromNodeID + " to node ID " + toNodeID + " was not found!");
        }

        /**
         * This method checks if there exists an edge with 2 nodes given their IDs
         * @param fromNodeID: integer value of node 1 ID
         * @param toNodeID: integer value of node 2 ID
         * @return true if edge exists else false
         */
        public boolean isEdge(int fromNodeID, int toNodeID) {
                return getEdgeIndex(fromNodeID, toNodeID) >= 0;
        }

        /**
         * This method checks if there exists an edge with 2 nodes given their names
         * @param fromNodeName: string value of node 1 name
         * @param toNodeName: string value of node 2 name
         * @return true if edge exists else false
         */
        public boolean isEdge(String fromNodeName, String toNodeName) {
                return getEdgeIndex(fromNodeName, toNodeName) >= 0;
        }

        /**
         * Finds the number of edges in the graph
         * @return integer count of number of edges in graph
         */
        public int getEdgeCount() {
                return edges.size();
        }

        /**
         * This method gets a copy of the list of edges in the graph
         * @return list of edges
         */
        public List<Edge> getEdges() {
                return new LinkedList<>(edges);
        }

}
