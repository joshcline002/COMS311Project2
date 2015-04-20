import java.util.HashMap;

public class Vertex<V, E>{
		int uniqueID;
		V data;
		// 0 is undiscovered 1 is discovered 2 for unresolved.
		int discovered = 0;
		HashMap<Integer, Edge<E>> outgoingEdges = new HashMap<Integer, Edge<E>>();
		
		public Vertex(V data, int num_Vertexes) {
			this.uniqueID = num_Vertexes;
			this.data = data;
		}
		
		public void setDiscovered(int dis){
			 discovered = dis;
		}
		
		public int getDiscovered(){
			return discovered;
		}
}