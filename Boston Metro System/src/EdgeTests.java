import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeTests
{
    Node node1;
    Node node2;
    Edge edge1;
    @BeforeEach
    void setUp() throws Exception
    {
        node1 = new NodeImpl("node1", 1);
        node2 = new NodeImpl("node2", 2);
        edge1 = new EdgeImpl(node1, node2, "green", 1);
    }

    @Test
    void testEdgeWeight() throws Exception
    {
        assertEquals(1, edge1.getEdgeWeight());
        edge1.setEdgeWeight(5);
        assertEquals(5, edge1.getEdgeWeight());
    }

    @Test
    void testLineColour() throws Exception
    {
        assertEquals("green", edge1.getLineColour());
        edge1.setLineColour("red");
        assertEquals("red", edge1.getLineColour());
    }

    @Test
    void testFromNode() throws Exception
    {
        assertEquals(node1, edge1.getFromNode());
        Node node12 = new NodeImpl("node12", 12);
        edge1.setFromNode(node12);
        assertEquals(node12, edge1.getFromNode());
    }

    @Test
    void testToNode() throws Exception
    {
        assertEquals(node2, edge1.getToNode());
        Node node22 = new NodeImpl("node22", 22);
        edge1.setToNode(node22);
        assertEquals(node22, edge1.getToNode());
    }
}
