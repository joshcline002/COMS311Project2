
public class Edge {
	private int id;
	private double weight;
	private Vertex src;
	private Vertex tar;
	
	public Edge(int ID, double WEIGHT, Vertex source, Vertex target){
		id = ID;
		weight = WEIGHT;
		src = source;
		tar = target;
	}
	
	public int getID(){
		return id;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public Vertex getSrc(){
		return src;
	}
	
	public Vertex getTarget(){
		return tar;
	}
}
