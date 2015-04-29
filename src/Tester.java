import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Tester {
	public static <V,E> void main(String[] args) throws IOException{
		Graph<V,E> graph = new CreateGraph<V,E>();
		BufferedReader reader = new BufferedReader(new FileReader("src/AmesData.txt"));
		String line = reader.readLine();
		int count = Integer.parseInt(line.substring(1+line.indexOf(':')).trim());
		for(int i = 0; i< count; i++){
			String[] arr = reader.readLine().split(",");
			int id = Integer.parseInt(arr[0]);
			double lat = Double.parseDouble(arr[1]);
			double lon = Double.parseDouble(arr[2]);
			graph.addVertex(new Vertex(id, lat, lon));
		}
		
		count = Integer.parseInt(line.substring(1+line.indexOf(':')).trim());
		for(int i = 0; i< count; i++){
			String[] arr = reader.readLine().split(",");
			int src = Integer.parseInt(arr[0]);
			int tar = Integer.parseInt(arr[1]);
			double dist = Double.parseDouble(arr[2]);
			graph.addEdge(src, tar, new Edge(i, dist, graph.getData(src), graph.getData(tar))); 
		}
		
		Weighing<E> weigh = new EdgeWeight<E>();
		
		List<Integer> loc1 = new ArrayList<Integer>;
		loc1.add(2893);
		loc1.add(1055);
		loc1.add(371);
		loc1.add(2874);
		loc1.add(2351);
		loc1.add(2956);
		loc1.add(1171);
		loc1.add(1208);
		
		SolvingCoffee<V,E> test = new SolvingCoffee<V,E>();
		
		test.shortestPath(graph, loc1, weigh);
	
		
	}
}
