import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTests
{
    Graph graph;
    @BeforeEach
    void setUp() throws Exception
    {
        graph = new GraphImpl();
    }

    @Test
    void testIsGraphEmpty() throws Exception
    {
        assertTrue(graph.isGraphEmpty());
        graph.addNode("node12", 12);
        assertFalse(graph.isGraphEmpty());
    }

    @Test
    void testGetAdjacentNodesByNodeID() throws Exception
    {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addNode("node3", 3);
        graph.addNode("node4", 4);
        graph.addNode("node5", 5);
        graph.addNode("node6", 6);

        graph.addEdge("green", 1, 2);
        graph.addEdge("green", 1, 3);
        graph.addEdge("red", 2, 4);
        graph.addEdge("green", 4, 5);
        graph.addEdge("red", 3, 6);
        graph.addEdge("yellow", 5, 6);

        List<Node> adjNodes = graph.getAdjacentNodes(3);
        assertEquals(2, adjNodes.size());
        assertEquals(1, adjNodes.get(0).getNodeID());
        assertEquals(6, adjNodes.get(1).getNodeID());
    }

    @Test
    void testGetAdjacentNodesByNodeName() throws Exception
    {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addNode("node3", 3);
        graph.addNode("node4", 4);
        graph.addNode("node5", 5);
        graph.addNode("node6", 6);

        graph.addEdge("green", 1, 2);
        graph.addEdge("green", 1, 3);
        graph.addEdge("red", 2, 4);
        graph.addEdge("green", 4, 5);
        graph.addEdge("red", 3, 6);
        graph.addEdge("yellow", 5, 6);

        List<Node> adjNodes = graph.getAdjacentNodes("node5");
        assertEquals(2, adjNodes.size());
        assertEquals(4, adjNodes.get(0).getNodeID());
        assertEquals(6, adjNodes.get(1).getNodeID());
    }

    @Test
    void testGetAllNodes() throws Exception
    {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addNode("node3", 3);
        graph.addNode("node4", 4);
        graph.addNode("node5", 5);
        graph.addNode("node6", 6);

        List<Node> allNodes = graph.getAllNodes();

        assertEquals(6, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());
        assertEquals(2, allNodes.get(1).getNodeID());
        assertEquals(3, allNodes.get(2).getNodeID());
        assertEquals(4, allNodes.get(3).getNodeID());
        assertEquals(5, allNodes.get(4).getNodeID());
        assertEquals(6, allNodes.get(5).getNodeID());
    }

    @Test
    void testAddNode_idNotAlreadyExists() throws Exception
    {
        graph.addNode("node1", 1);

        List<Node> allNodes = graph.getAllNodes();

        assertEquals(1, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());

    }

    @Test
    void testAddNode_idAlreadyExists() throws Exception
    {
        graph.addNode("node1", 1);
        graph.addNode("node2", 1);

        List<Node> allNodes = graph.getAllNodes();

        assertEquals(1, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());
        assertEquals("node1", allNodes.get(0).getNodeName());
    }

    @Test
    void testRemoveNode_byID_nodeExistsNoEdge() throws Exception
    {
        graph.addNode("node1", 1);

        List<Node> allNodes = graph.getAllNodes();

        assertEquals(1, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());
        assertEquals("node1", allNodes.get(0).getNodeName());

        graph.removeNode(1);

        allNodes = graph.getAllNodes();
        assertEquals(0, allNodes.size());
    }

    @Test
    void testRemoveNode_byName_nodeExistsNoEdge() throws Exception
    {
        graph.addNode("node1", 1);

        List<Node> allNodes = graph.getAllNodes();

        assertEquals(1, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());
        assertEquals("node1", allNodes.get(0).getNodeName());

        graph.removeNode("node1");

        allNodes = graph.getAllNodes();
        assertEquals(0, allNodes.size());
    }

    @Test
    void testRemoveNode_byID_nodeNotExistsNoEdge() throws Exception
    {
        List<Node> allNodes = graph.getAllNodes();

        assertEquals(0, allNodes.size());

        graph.removeNode(1);

        allNodes = graph.getAllNodes();
        assertEquals(0, allNodes.size());
    }

    @Test
    void testRemoveNode_byName_nodeNotExistsNoEdge() throws Exception
    {
        List<Node> allNodes = graph.getAllNodes();

        assertEquals(0, allNodes.size());

        graph.removeNode("node1");

        allNodes = graph.getAllNodes();
        assertEquals(0, allNodes.size());
    }

    @Test
    void testRemoveNode_byID_nodeExistsEdgeExists() throws Exception
    {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        List<Node> allNodes = graph.getAllNodes();

        assertEquals(2, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());
        assertEquals(2, allNodes.get(1).getNodeID());
        assertEquals("node1", allNodes.get(0).getNodeName());
        assertEquals("node2", allNodes.get(1).getNodeName());

        graph.removeNode(1);

        allNodes = graph.getAllNodes();
        assertEquals(2, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());
        assertEquals(2, allNodes.get(1).getNodeID());
        assertEquals("node1", allNodes.get(0).getNodeName());
        assertEquals("node2", allNodes.get(1).getNodeName());
    }

    @Test
    void testRemoveNode_byName_nodeExistsEdgeExists() throws Exception
    {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        List<Node> allNodes = graph.getAllNodes();

        assertEquals(2, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());
        assertEquals(2, allNodes.get(1).getNodeID());
        assertEquals("node1", allNodes.get(0).getNodeName());
        assertEquals("node2", allNodes.get(1).getNodeName());

        graph.removeNode("node1");

        allNodes = graph.getAllNodes();
        assertEquals(2, allNodes.size());
        assertEquals(1, allNodes.get(0).getNodeID());
        assertEquals(2, allNodes.get(1).getNodeID());
        assertEquals("node1", allNodes.get(0).getNodeName());
        assertEquals("node2", allNodes.get(1).getNodeName());
    }

    @Test
    void testGetNode_byID_exists() throws Exception {
        graph.addNode("node1", 1);

        Node node = graph.getNode(1);

        assertEquals(1, node.getNodeID());
        assertEquals("node1", node.getNodeName());
    }

    @Test
    void testGetNode_byName_exists() throws Exception {
        graph.addNode("node1", 1);

        Node node = graph.getNode("node1");

        assertEquals(1, node.getNodeID());
        assertEquals("node1", node.getNodeName());
    }

    @Test
    void testGetNode_byID_notExists() throws Exception {
        graph.addNode("node2", 2);

        Node node = graph.getNode(1);

        assertNull(node);
    }

    @Test
    void testGetNode_byName_notExists() throws Exception {
        graph.addNode("node2", 2);

        Node node = graph.getNode("node1");

        assertNull(node);
    }

    @Test
    void testIsNode_byID_exists() throws Exception {
        graph.addNode("node1", 1);

        assertTrue(graph.isNode(1));
    }

    @Test
    void testIsNode_byName_exists() throws Exception {
        graph.addNode("node1", 1);

        assertTrue(graph.isNode("node1"));
    }

    @Test
    void testIsNode_byID_notExists() throws Exception {
        graph.addNode("node2", 2);

        assertFalse(graph.isNode(1));
    }

    @Test
    void testIsNode_byName_notExists() throws Exception {
        graph.addNode("node2", 2);

        assertFalse(graph.isNode("node1"));
    }

    @Test
    void testGetNodeCount() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addNode("node3", 3);
        graph.addNode("node4", 4);

        assertEquals(4, graph.getNodeCount());
    }

    // Edges
    @Test
    void testAddEdge_fromNodeNotExists() throws Exception {
        graph.addNode("node2", 2);

        assertEquals(0, graph.getEdgeCount());

        graph.addEdge("green", 1,2, 5);

        assertEquals(0, graph.getEdgeCount());
    }

    @Test
    void testAddEdge_toNodeNotExists() throws Exception {
        graph.addNode("node1", 1);

        assertEquals(0, graph.getEdgeCount());

        graph.addEdge("green", 1,2, 5);

        assertEquals(0, graph.getEdgeCount());
    }

    @Test
    void testAddEdge_same_colour_EdgeAlreadyExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("green", 1,2, 5);

        assertEquals(1, graph.getEdgeCount());

        graph.addEdge("green", 1,2, 7);

        assertEquals(1, graph.getEdgeCount());

        List<Edge> edges = graph.getEdges();
        assertEquals(5, edges.get(0).getEdgeWeight());
    }

    @Test
    void testAddEdge_different_colour_EdgeAlreadyExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("green", 1,2, 5);

        assertEquals(1, graph.getEdgeCount());

        graph.addEdge("red", 1,2, 7);

        assertEquals(2, graph.getEdgeCount());

        List<Edge> edges = graph.getEdges();
        assertEquals(5, edges.get(0).getEdgeWeight());
        assertEquals(7, edges.get(1).getEdgeWeight());
    }

    @Test
    void testAddEdge_EdgeNotExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);

        assertEquals(0, graph.getEdgeCount());

        graph.addEdge("red", 1,2, 7);

        assertEquals(1, graph.getEdgeCount());
    }

    @Test
    void testRemoveEdge_byNodeName_EdgeNotExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        assertEquals(1, graph.getEdgeCount());

        graph.removeEdge("node1", "node3");

        assertEquals(1, graph.getEdgeCount());
    }

    @Test
    void testRemoveEdge_byNodeID_EdgeNotExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        assertEquals(1, graph.getEdgeCount());

        graph.removeEdge(1, 3);

        assertEquals(1, graph.getEdgeCount());
    }

    @Test
    void testRemoveEdge_byNodeName_EdgeExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        assertEquals(1, graph.getEdgeCount());

        graph.removeEdge("node1", "node2");

        assertEquals(0, graph.getEdgeCount());
    }

    @Test
    void testRemoveEdge_byNodeID_EdgeExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        assertEquals(1, graph.getEdgeCount());

        graph.removeEdge(1, 2);

        assertEquals(0, graph.getEdgeCount());
    }

    @Test
    void testIsEdge_byNodeName_EdgeNotExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        assertFalse(graph.isEdge("node1", "node3"));
    }

    @Test
    void testIsEdge_byNodeID_EdgeNotExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        assertFalse(graph.isEdge(1, 3));
    }

    @Test
    void testIsEdge_byNodeName_EdgeExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        assertTrue(graph.isEdge("node1", "node2"));
    }

    @Test
    void testIsEdge_byNodeID_EdgeExists() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addEdge("red", 1, 2);

        assertTrue(graph.isEdge(1, 2));
    }

    @Test
    void testGetEdgeCount() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addNode("node3", 3);
        graph.addNode("node4", 4);
        graph.addEdge("red", 1, 2);
        graph.addEdge("red", 1, 3);
        graph.addEdge("red", 2, 4);

        assertEquals(3, graph.getEdgeCount());
    }

    @Test
    void testGetEdges() throws Exception {
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addNode("node3", 3);
        graph.addNode("node4", 4);
        graph.addEdge("red", 1, 2);
        graph.addEdge("red", 1, 3);
        graph.addEdge("red", 2, 4);

        List<Edge> edges = graph.getEdges();

        assertEquals(3, edges.size());

        assertEquals(1, edges.get(0).getFromNode().getNodeID());
        assertEquals(2, edges.get(0).getToNode().getNodeID());
        assertEquals("red", edges.get(0).getLineColour());

        assertEquals(1, edges.get(1).getFromNode().getNodeID());
        assertEquals(3, edges.get(1).getToNode().getNodeID());
        assertEquals("red", edges.get(1).getLineColour());

        assertEquals(2, edges.get(2).getFromNode().getNodeID());
        assertEquals(4, edges.get(2).getToNode().getNodeID());
        assertEquals("red", edges.get(2).getLineColour());
    }

}
