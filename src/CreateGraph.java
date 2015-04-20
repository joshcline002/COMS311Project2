import java.util.HashMap;
import java.util.Set;

public class CreateGraph<V, E> implements Graph<V, E>  {
	
	private HashMap<Integer, HashVertex<V, E>> vert = new HashMap<Integer, HashVertex<V, E>>();
	private HashMap<Integer, HashEdge<E>> edge = new HashMap<Integer, HashEdge<E>>();
	
	int num_Vertexes = 0;
	int num_Edges = 0;
	
	@Override
	public int addVertex(V v) {
		HashVertex<V, E> vertex = new HashVertex<V, E>(v, num_Vertexes);
		int ID = vertex.uniqueID;
		
		vert.put(ID, vertex);
		
		return ID;
	}

	@Override
	public int addEdge(int srcID, int targetID, E attr)
			throws IllegalArgumentException {
			int ID = -1;
		if(vert.containsKey(srcID) && vert.containsKey(targetID)){
			@SuppressWarnings({ })
			HashEdge<E> e = new HashEdge<E>(srcID, targetID, attr, num_Edges);
			ID = e.uniqueID;
			
			edge.put(ID, e);
			vert.get(srcID).outgoingEdges.put(ID, e);
		} else {
			throw new IllegalArgumentException("srcID or targetID are not valid vertices");
		}
			
		return ID;
	}

	@Override
	public Set<Integer> getVertices() {
		return vert.keySet();
	}

	@Override
	public Set<Integer> getEdges() {
		return edge.keySet();
	}

	@Override
	public E getAttribute(int id) throws IllegalArgumentException {
		if(edge.containsKey(id)){
		} else {
			throw new IllegalArgumentException("id is invalid");
		}
		
		return edge.get(id).attr;
	}

	@Override
	public V getData(int id) throws IllegalArgumentException {
		if(vert.containsKey(id)){
		} else {
			throw new IllegalArgumentException("id is invalid");
		}
		return vert.get(id).data;
	}

	@Override
	public int getSource(int id) throws IllegalArgumentException {
		if(edge.containsKey(id)){
		} else {
			throw new IllegalArgumentException("id is invalid");
		}
		return edge.get(id).srcID;
	}

	@Override
	public int getTarget(int id) throws IllegalArgumentException {
		if(edge.containsKey(id)){
		} else {
			throw new IllegalArgumentException("id is invalid");
		}
		return edge.get(id).targetID;
	}

	@Override
	public Set<Integer> getEdgesOf(int id) throws IllegalArgumentException {
		if(vert.containsKey(id)){
		} else {
			throw new IllegalArgumentException("id is invalid");
		}
		
		return vert.get(id).outgoingEdges.keySet();
	}
}
