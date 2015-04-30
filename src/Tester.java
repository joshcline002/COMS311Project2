import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Tester {
	public static <V,E> void main(String[] args) throws IOException{
		Graph<Vertex,Edge> graph = new CreateGraph<Vertex,Edge>();
		Graph<Vertex, Edge> depGraph = new CreateGraph<Vertex, Edge>();
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
		line = reader.readLine();
		count = Integer.parseInt(line.substring(1+line.indexOf(':')).trim());
		for(int i = 0; i< count; i++){
			String[] arr = reader.readLine().split(",");
			int src = Integer.parseInt(arr[0]);
			int tar = Integer.parseInt(arr[1]);
			double dist = Double.parseDouble(arr[2]);
			graph.addEdge(src, tar, new Edge(i, dist, graph.getData(src), graph.getData(tar))); 
		}
		reader.close();
		
		Weighing<Edge> weigh = new EdgeWeight<Edge>();
		
		List<Integer> loc1 = new ArrayList<Integer>();
		loc1.add(2893);
		loc1.add(1055);
		loc1.add(371);
		loc1.add(2874);
		loc1.add(2351);
		loc1.add(2956);
		loc1.add(1171);
		loc1.add(1208);
		
		Vertex ME = graph.getData(2893);
		Vertex A = graph.getData(1055);
		Vertex B = graph.getData(371);
		Vertex C = graph.getData(2874);
		Vertex D = graph.getData(2351);
		Vertex E = graph.getData(2956);
		Vertex F = graph.getData(1171);
		Vertex G = graph.getData(1208);
		
		depGraph.addVertex(ME);
		depGraph.addVertex(A);
		depGraph.addVertex(B);
		depGraph.addVertex(C);
		depGraph.addVertex(D);
		depGraph.addVertex(E);
		depGraph.addVertex(F);
		depGraph.addVertex(G);
		
		depGraph.addEdge(0, 1,new Edge(0, 1, ME, A));
		depGraph.addEdge(1, 2,new Edge(1, 1, A, B));
		depGraph.addEdge(1, 5,new Edge(2, 1, A, E));
		depGraph.addEdge(1, 7,new Edge(3, 1, A, G));
		depGraph.addEdge(2, 3,new Edge(4, 1, B, C));
		depGraph.addEdge(2, 4,new Edge(5, 1, B, D));
		depGraph.addEdge(2, 7,new Edge(6, 1, B, G));
		depGraph.addEdge(3, 7,new Edge(7, 1, C, G));
		depGraph.addEdge(4, 5,new Edge(8, 1, D, E));
		depGraph.addEdge(4, 6,new Edge(9, 1, D, F));
		depGraph.addEdge(4, 7,new Edge(10, 1, D, G));
		depGraph.addEdge(5, 7,new Edge(11, 1, E, G));
		depGraph.addEdge(6, 7,new Edge(12, 1, F, G));
		
		
		SolvingCoffee<Vertex,Edge> test = new SolvingCoffee<Vertex,Edge>();
		
		System.out.println(test.shortestPath(graph, loc1, weigh));
		
		System.out.println(test.sortVertices(depGraph));
		
		System.out.println(test.generateValidSortS(depGraph));
		
		System.out.println(test.shortestPath(graph, loc1, weigh));
		
	}
}
