import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class MetroMapParser {


    String ccpath = "C:\\Users\\Nas\\IdeaProjects\\untitled4\\src\\bostonmetro.txt";

    LinkedList<String[]> nodesList = new LinkedList<>();
    LinkedList<String[]> edgesList = new LinkedList<>();

    public void populateGraphFromFile(Graph graph, String path){
        fillNodesEdgesListFromFile(path);
        fillNodesInGraph(graph);
        fillEdgesInGraph(graph);
        System.out.println("MetroMapParser: Nodes and edges have been added to graph");

    }

    private void fillNodesEdgesListFromFile(String path){
        try {
            BufferedReader buffered = new BufferedReader( new FileReader(path));
            String line;
            String lineMinSpace;
            String[] lineSplit;

            while((line = buffered.readLine()) != null){
                lineMinSpace = line.replaceAll("\\s+", " ").trim();
                lineSplit = lineMinSpace.split(" ");

                if (lineSplit.length > 0) {
                    nodesList.add(Arrays.copyOfRange(lineSplit, 0, 2));

                    for (int i = 2; i < lineSplit.length; i += 3) {
                        edgesList.add(Arrays.copyOfRange(lineSplit, i, i + 3));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("MetroMapParser: Found " + nodesList.size() +" nodesList and " + edgesList.size() + " edgesList");
    }

    private void fillNodesInGraph(Graph graph){
        System.out.println("MetroMapParser: Filling nodes in graph");
        for (String[] node: nodesList){
            graph.addNode(node[1], Integer.parseInt(node[0]));
            // todo: addNode in graph needs to accept node name and node ID
        }
    }

    private void fillEdgesInGraph(Graph graph){
        System.out.println("MetroMapParser: Filling edges in graph");
        for (String[] edge: edgesList){
            String colour = edge[0];
            Integer node1 = Integer.parseInt(edge[1]);
            Integer node2 = Integer.parseInt(edge[2]);
            graph.addEdge(colour, node1, node2);
            // todo: addEdge needs to accept line name, node 1 ID, node 2 ID. This means that addEdge needs to look up Node instance based on node ID
            // todo: if a nodeID was 0 in edge, that means the node must be considered as terminal
        }
    }


}
