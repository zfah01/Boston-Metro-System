import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class BFS {
  private int V;
  private LinkedList<Node> adj[];

  // Create a graph
  BFS(int v) {
	//Dynamic size of adj Link list is created, in our case, its size is 125  
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList<>();
  }
  // Add edges to the graph
  void addNodeEdge(Node node) {
//	station1 is adjacent to statin2, so station2 added as n  neighbor of station1
    adj[node.getVertex()].add(node);
  }

  // BFS algorithm
  void BFS(Node node) {
//  n number of boolean list to tell neighoor, in our case its size is 125
    boolean visited[] = new boolean[V];
    LinkedList<Node> queue = new LinkedList();
    //set station whch is passed to check, its labeled as true t shown its visited 
    visited[node.getVertex()] = true;
//    and then added in queue
    queue.add(node);
//  list of adjacent station added in queue
    while (queue.size() != 0) {
      node = queue.poll();
      System.out.print(node.stationName + " ");
      Iterator<Node> i = adj[node.getVertex()].listIterator();
      while (i.hasNext()) {
//    	  loop on node(station)
        Node n = i.next();
        if (!visited[n.getVertex()]) {
//        	if not visited, set i true add in queue 
          visited[n.getVertex()] = true;
          queue.add(n);
        }
      }
    }
  }

  //IO exception is added to handle reading file operation
  public static void main(String args[]) throws IOException {
	//125 is the total number of stations  
    BFS g = new BFS(125);
    String PROJECT_PATH = Paths.get("").toAbsolutePath().normalize().toString();
    //inside project, file->map.txt file, to read stations details
    BufferedReader reader = new BufferedReader(new FileReader(PROJECT_PATH+"\\src\\file\\map.txt"));
    StringBuilder stringBuilder = new StringBuilder();
    String line = null;
    //line seperator used to seperate lines
    String ls = System.getProperty("line.separator");
    while ((line = reader.readLine()) != null) {
    	stringBuilder.append(line);
    	stringBuilder.append(ls);
//    	splitting 1st line with parameters, 
    	String[] newStr = line.split("\\s+");
//    	Parameters are: station No, Station Name, Station Color, station1, sation2 
        g.addNodeEdge(new Node(Integer.parseInt(newStr[1]), newStr[2], newStr[3], Integer.parseInt(newStr[4]), Integer.parseInt(newStr[5])));
    }
    // delete the last new line separator
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    reader.close();
    //add the node that you want to look.
    g.BFS(new Node(47, "Kenmore", "GreenB", 46, 51));
   
  }
}
