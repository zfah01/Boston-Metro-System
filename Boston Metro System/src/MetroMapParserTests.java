import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MetroMapParserTests
{
    MetroMapParser parser;
    Graph graph;
    @BeforeEach
    void setUp() throws Exception
    {
        parser = new MetroMapParser();
        graph = new GraphImpl();
        parser.populateGraphFromFile(graph,"Boston Metro System/src/testMap.txt");
    }

    @Test
    void testNodes() throws Exception
    {
        assertEquals(5, graph.getNodeCount());
        assertTrue(graph.isNode(1));
        assertTrue(graph.isNode(2));
        assertTrue(graph.isNode(3));
        assertTrue(graph.isNode(4));
        assertTrue(graph.isNode(5));

        assertTrue(graph.isNode("Station1"));
        assertTrue(graph.isNode("Station2"));
        assertTrue(graph.isNode("Station3"));
        assertTrue(graph.isNode("Station4"));
        assertTrue(graph.isNode("Station5"));
    }

    @Test
    void testEdges() throws Exception
    {
        assertEquals(4, graph.getEdgeCount());

        assertTrue(graph.isEdge(1,2));
        assertTrue(graph.isEdge(2,3));
        assertTrue(graph.isEdge(3,4));
        assertTrue(graph.isEdge(3,5));
    }


}
