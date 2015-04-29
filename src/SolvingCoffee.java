import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class SolvingCoffee<V, E> implements CoffeeSolver<V, E> {
	
	ArrayList<Integer> sorted_Graph;
	
	private final int UNDISCOVERED = 0;
	private final int DISCOVERED = 1;
	private final int UNRESOLVED = 1;
	
	@Override
	public List<Integer> shortestPath(Graph<V, E> graph, List<Integer> locations, Weighing<E> weigh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<List<Integer>> generateValidSortS(Graph<V, E> graph) {
		Collection<List<Integer>> col = new HashSet<>();
		Iterator<Integer> vert = graph.getVertices().iterator();
		while(vert.hasNext()){
			DFS(graph, vert.next());
			col.add(sorted_Graph);
		}
		return null;
	}
	
	public void DFS(Graph<V,E> G, int vID){
		Integer[] disc = new Integer[G.getVertices().size()];
		if(disc[vID]==UNRESOLVED){
			throw new IllegalStateException("Graph contains a cycle.");
		}
		disc[vID]=UNRESOLVED;
		int nextID;
		Iterator<Integer> edgeIDs;
		edgeIDs = G.getEdgesOf(vID).iterator();
		while(edgeIDs.hasNext()){
			nextID = G.getTarget(edgeIDs.next());
			if (!(disc[nextID] == DISCOVERED)){
				DFS(G, nextID);
			}
		}
		disc[vID] = DISCOVERED;
		sorted_Graph.add(0, vID);
	}

	@Override
	public List<Integer> sortVertices(Graph<V, E> graph) {
		sorted_Graph = new ArrayList<Integer>();
		try{
		DFS(graph, graph.getVertices().iterator().next());
		} catch (IllegalStateException e){
			return null;
		}
		return sorted_Graph;
	}

}
