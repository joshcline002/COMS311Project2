import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


public class ShortPathDijkstra<V, E> implements Dijkstra<V, E> {
	Graph<V,E> graph;
	int startID;
	Weighing<E> weight = null;
	int[] parents;
	double[] distance;
	boolean complete = false;
	
	public ShortPathDijkstra(){
	}

	
	@Override
	public void setGraph(Graph<V, E> graph) {
		this.graph = graph;
		
	}

	@Override
	public void setStart(int startId) throws IllegalArgumentException,
			IllegalStateException { 
		if(graph == null){
			throw new IllegalStateException("Graph not found");
		} else if(graph.getVertices().contains(startId)){
		startID = startId;
		}else{
			throw new IllegalArgumentException("StartID not found");
		}
		
		
	}

	@Override
	public void setWeighing(Weighing<E> weighing) {
		weight = weighing;
		
	}

	@Override
	public void computeShortestPath() throws IllegalStateException {
		distance = new double[graph.getVertices().size()];
		parents = new int[graph.getVertices().size()];
		for(int j = 0; j<distance.length; j++){
			distance[j] = Double.POSITIVE_INFINITY;
			parents[j] = -1;
		}
		if(weight == null){
			throw new IllegalStateException("No weight set");
		} else if(graph == null){
			throw new IllegalStateException("Graph was not found");
		} else{
			distance[startID] = 0;
			PriorityQueue<Integer> vertQue = new PriorityQueue<Integer>();
			vertQue.add(startID);
			
			while(!vertQue.isEmpty()){
				Integer srcID = vertQue.poll();
				
				for(Integer i : graph.getEdgesOf(srcID)){
					Integer tarID = graph.getTarget(i);
					Edge e = (Edge) graph.getAttribute(i);
					double weight = e.getWeight();
					double totalDist = distance[srcID] + weight;
					if(totalDist < distance[tarID]){
						vertQue.remove(tarID);
						distance[tarID] = totalDist;
						parents[tarID] = srcID;
						vertQue.add(tarID);
						
					}
				}
			}
		}
		complete = true;
	}

	@Override
	public List<Integer> getPath(int endId) throws IllegalArgumentException,
			IllegalStateException {
		List<Integer> path = new ArrayList<Integer>();
		Stack<Integer> tempPath = new Stack<Integer>();
		if(!complete){
			throw new IllegalStateException("No path");
		}else if(!graph.getVertices().contains(endId)){
			throw new IllegalArgumentException("No such end Vertices");
		} else{
			for(int k = endId; k != -1; k = parents[k]){
				tempPath.push(k);
			}
			while(!tempPath.isEmpty()){
				path.add(tempPath.pop());
			}
		}
		return path;
	}

	@Override
	public double getCost(int endId) throws IllegalArgumentException,
			IllegalStateException {
		if(!complete){
			throw new IllegalStateException("No path");
		}else if(!graph.getVertices().contains(endId)){
			throw new IllegalArgumentException("No such end Vertices");
		} else{	
		return distance[endId];
		}
	}

}
