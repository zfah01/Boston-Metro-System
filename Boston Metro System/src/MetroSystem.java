public class MetroSystem {
    public static void main(String[] args) {
        MetroMapParser parser = new MetroMapParser();
        Graph graph = new GraphImpl();

        String path = "Boston Metro System/src/map.txt";

        parser.populateGraphFromFile(graph, path);

        System.out.println("Done");


    }
}
