import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MetroRouteFinderTests
{
    Graph graph = new GraphImpl();
    MetroRouteFinder routeFinder = new MetroRouteFinder(graph);
    @BeforeEach
    void setUp() throws Exception
    {
        MetroMapParser parser = new MetroMapParser();
        String path = "Boston Metro System/src/testMap.txt";
        parser.populateGraphFromFile(graph, path);
    }

    @Test
    void breadthFirstSearch__finds_route() throws Exception
    {
        List<Node> route = routeFinder.breadthFirstSearch(1, 5);
        List<String> routeNames = new LinkedList<>();
        for (Node n: route){
            routeNames.add(n.getNodeName());
        }
        List<String> expectedRouteNames = new LinkedList<String>();
        expectedRouteNames.add("Station1");
        expectedRouteNames.add("Station2");
        expectedRouteNames.add("Station3");
        expectedRouteNames.add("Station5");
        assertEquals(routeNames, expectedRouteNames);
    }

    @Test
    void breadthFirstSearch__doesnt_find_route() throws Exception
    {
        List<Node> route = routeFinder.breadthFirstSearch(1, 50);
        assertNull(route);
    }

}
