/**
 * MetroSystem
 * This class is the entry point for the graph-based metro system.
 * It creates the graph object and calls MetroMapParser to populate
 * it. It also has an instance of MetroRouteFinder which can be
 * fetched using its getter method.
 *
 * This class provides some counts about the metro system such as
 * station count and line count.
 *
 * This class has a static main method which is called when the system
 * is used without a GUI.
 *
 * @author Nasser Alkhaldy
 * @since 21/03/2022
 */


import java.util.HashSet;
import java.util.List;

public class MetroSystem {

    private Graph graph = new GraphImpl();
    private final MetroRouteFinder routeFinder = new MetroRouteFinder();

    public static void main(String[] args) {
        MetroSystem metro = new MetroSystem();
        metro.loadFromFile();

        System.out.println("Done");
    }

    public void loadFromFile() {
        MetroMapParser parser = new MetroMapParser();
        String path = "Boston Metro System/src/map.txt";
        parser.populateGraphFromFile(graph, path);
    }

    public Graph getGraph() {
        return graph;
    }

    public void resetGraph(){
        graph = new GraphImpl();
    }

    public int getStationCount(){
        return graph.getNodeCount();
    }

    public int getLineCount(){
        List<Edge> edges = graph.getEdges();
        HashSet<String> lineColours = new HashSet<>();
        for (Edge edge: edges) {
            lineColours.add(edge.getLineColour());
        }
        return lineColours.size();
    }

    public int getStopCount(){
        return 0; // todo: get stop count
    }

    public MetroRouteFinder getRouteFinder(){
        return routeFinder;
    }
}
