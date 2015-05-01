import java.util.HashMap;

public class HashVertex<V, E>{
		int uniqueID;
		V data;
		
		HashMap<Integer, HashEdge<E>> outgoingEdges = new HashMap<Integer, HashEdge<E>>();
		
		public HashVertex(V data, int num_Vertexes) {
			this.uniqueID = num_Vertexes;
			this.data = data;
		}
		
}