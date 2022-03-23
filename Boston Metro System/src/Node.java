import java.lang.reflect.Array;
import java.util.ArrayList;


public class Node {
	
	private int id;
    public String stationName;
    private String color;
    private int vertex;
	private int cost;
    

    public Node(int id, String stationName, String color, int vertex, int cost) {
		super();
		this.id = id;
		this.stationName = stationName;
		this.color = color;
		this.vertex = vertex;
		this.cost = cost;
	}

    //    An auxiliary function which allows
    //    us to remove any child nodes from
    //    our list of child nodes.
    public boolean removeChild(Node n){
        return false;
    }

	public int getCost() {
		return cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
}
