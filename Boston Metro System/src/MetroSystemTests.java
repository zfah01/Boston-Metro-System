import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MetroSystemTests
{
    MetroSystem metroSystem;
    @BeforeEach
    void setUp() throws Exception
    {
        metroSystem = new MetroSystem();
    }

    @Test
    void testResetGraph() throws Exception
    {
        Graph oldGraph = metroSystem.getGraph();
        metroSystem.resetGraph();
        Graph newGraph = metroSystem.getGraph();

        assertNotEquals(oldGraph, newGraph);
    }

    @Test
    void testGetStationCount() throws Exception
    {
        Graph graph = metroSystem.getGraph();
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);

        assertEquals(2, metroSystem.getStationCount());
    }

    @Test
    void testGetLineCount() throws Exception
    {
        Graph graph = metroSystem.getGraph();
        graph.addNode("node1", 1);
        graph.addNode("node2", 2);
        graph.addNode("node3", 3);
        graph.addNode("node4", 4);
        graph.addNode("node5", 5);

        graph.addEdge("green", 1, 2);
        graph.addEdge("green", 2, 3);
        graph.addEdge("red", 1, 3);
        graph.addEdge("red", 3, 4);
        graph.addEdge("yellow", 2, 5);

        assertEquals(3, metroSystem.getLineCount());
    }
}
