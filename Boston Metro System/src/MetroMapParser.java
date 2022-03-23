/*
  MetroMapParser
  This class populates a Graph object with nodes and edges
  listed in a map text file. The file format is custom as
  shown below:
  nodeNumber nodeName  edgeColour1 edgeFromNodeNum1 edgeToNodeNum1 edgeColour2 edgeFromNodeNum2 edgeToNodeNum2 ...

  For each edge entry, 2 edges are created: one for the segment
  that connects the node with the one before it, and another that
  connects it with the one after it.

  The entry method is populateGraphFromFile which accepts
  a graph object and the path to the map file. It returns
  nothing.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class MetroMapParser {

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
                        String[] edgeArray1 = Arrays.copyOfRange(lineSplit, i, i + 3);
                        String[] edgeArray2 = Arrays.copyOfRange(lineSplit, i, i + 3);
                        edgeArray1[2] = lineSplit[0];
                        edgeArray2[1] = lineSplit[0];
                        edgesList.add(edgeArray1);
                        edgesList.add(edgeArray2);
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
            graph.addNode(node[1].trim(), Integer.parseInt(node[0]));
        }
    }

    private void fillEdgesInGraph(Graph graph){
        System.out.println("MetroMapParser: Filling edges in graph");
        for (String[] edge: edgesList){
            String colour = edge[0].trim();
            int node1 = Integer.parseInt(edge[1]);
            int node2 = Integer.parseInt(edge[2]);
            if (node1 > 0 && node2 > 0)
                graph.addEdge(colour, node1, node2);
        }
    }


}
