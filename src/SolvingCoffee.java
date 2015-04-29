import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class SolvingCoffee<V, E> implements CoffeeSolver<V, E> {
	
	ArrayList<Integer> sorted_Graph;
	
	private final Integer UNDISCOVERED = 0;
	private final Integer DISCOVERED = 1;
	private final Integer UNRESOLVED = 1;
	
	@Override
	public List<Integer> shortestPath(Graph<V, E> graph, List<Integer> locations, Weighing<E> weigh) {
		List<Integer> path = new ArrayList<Integer>();
		Dijkstra<V,E> shortCompute = new ShortPathDijkstra<V,E>();
		shortCompute.setGraph(graph);
		shortCompute.setWeighing(weigh);
		path.add(locations.get(0));
		for(int i = 0; i< locations.size()-1; i++){
			shortCompute.setStart(locations.get(i));
			shortCompute.computeShortestPath();
			path.addAll(shortCompute.getPath(i+1));
		}
		return path;
	}

	@Override
	public Collection<List<Integer>> generateValidSortS(Graph<V, E> graph) {
		Collection<List<Integer>> col = new HashSet<List<Integer>>();
		Iterator<Integer> vert = graph.getVertices().iterator();
		while(vert.hasNext()){
			sorted_Graph = new ArrayList<Integer>();
			DFS(graph, vert.next());
			col.add(sorted_Graph);
		}
		return col;
	}
	
	public void DFS(Graph<V,E> G, int vID){
		Integer[] disc = new Integer[G.getVertices().size()];
		for(int i = 0; i<disc.length; i++){
			disc[i] = UNDISCOVERED;
		}
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
