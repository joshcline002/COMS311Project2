import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class TestingCode {
	
	Graph<Vertex, Edge> graph;
	Graph<Vertex, Edge> graph2;
	Graph<Vertex, Edge> graph3;
	Graph<Vertex, Edge> depGraph;
	Dijkstra<Vertex, Edge> shortBus;
	Weighing<Edge> weight;
	SolvingCoffee<Vertex, Edge> coffee;
	Edge e;
	Vertex v;
	List<Integer> loc1;
	List<Integer> loc2;
	List<Integer> loc3;
	
	
	@Before
	public void setup()
	{
		graph = new CreateGraph<Vertex, Edge>();
		graph2 = new CreateGraph<Vertex, Edge>();
		graph3 = new CreateGraph<Vertex, Edge>();
		depGraph = new CreateGraph<Vertex, Edge>();
		shortBus = new ShortPathDijkstra<Vertex, Edge>();
		weight = new EdgeWeight<Edge>();
		coffee = new SolvingCoffee<Vertex, Edge>();
		loc1 = new ArrayList<Integer>();
		loc2 = new ArrayList<Integer>();
		loc3 = new ArrayList<Integer>();
		
		
		Vertex A = new Vertex(0, 0, 0);
		Vertex B = new Vertex(1, 0, 0);
		Vertex C = new Vertex(2, 0, 0);
		Vertex D = new Vertex(3, 0, 0);
		Vertex E = new Vertex(4, 0, 0);
		
		Edge ab = new Edge(0, 1, A, B);
		Edge ad = new Edge(1, 1, A, D);
		Edge bd = new Edge(2, 1, B, D);
		Edge cd = new Edge(3, 1, C, D);
		Edge ae = new Edge(4, 1, A, E);
		
		graph2.addVertex(A);
		graph2.addVertex(B);
		graph2.addVertex(C);
		graph2.addVertex(D);
		graph2.addVertex(E);
		
		graph2.addEdge(0, 1, ab);
		graph2.addEdge(0, 3, ad);
		graph2.addEdge(1, 3, bd);
		graph2.addEdge(2, 3, cd);
		graph2.addEdge(0, 4, ae);
		
		Vertex A3 = new Vertex(0, 0, 0);
		Vertex B3 = new Vertex(3, 0, 0);
		Vertex C3 = new Vertex(7, 0, 0);
		Vertex D3 = new Vertex(4, 0, 0);
		Vertex E3 = new Vertex(5, 0, 0);
		
		depGraph.addVertex(A3);
		depGraph.addVertex(B3);
		depGraph.addVertex(C3);
		depGraph.addVertex(D3);
		depGraph.addVertex(E3);
		
		depGraph.addEdge(0, 1,new Edge(0, 1, A3, B3));
		depGraph.addEdge(0, 3,new Edge(1, 1, A3, D3));
		depGraph.addEdge(1, 2,new Edge(2, 1, B3, C3));
		depGraph.addEdge(1, 4,new Edge(3, 1, B3, E3));
		depGraph.addEdge(3, 2,new Edge(4, 1, D3, C3));
		
		Vertex Aa3 = new Vertex(0, 0, 0);
		Vertex F3 = new Vertex(1, 0, 0);
		Vertex G3 = new Vertex(2, 0, 0);
		Vertex Bb3 = new Vertex(3, 0, 0);
		Vertex Dd3 = new Vertex(4, 0, 0);
		Vertex Cc3 = new Vertex(5, 0, 0);
		Vertex H3 = new Vertex(6, 0, 0);
		Vertex Ee3 = new Vertex(7, 0, 0);
		
		Edge af3 = new Edge(0, 5, Aa3, F3);
		Edge ag3 = new Edge(1, 1, Aa3, G3);
		Edge fb3 = new Edge(2, 1, F3, Bb3);
		Edge gd3 = new Edge(3, 1, G3, Dd3);
		Edge gc3 = new Edge(4, 1, G3, Cc3);
		Edge df3 = new Edge(5, 1, Dd3, F3);
		Edge dh3 = new Edge(6, 5, Dd3, H3);
		Edge he3 = new Edge(7, 5, H3, E3);
		Edge ce3 = new Edge(8, 1, Cc3, E3);
		Edge bh3 = new Edge(9, 1, Bb3, H3);
		Edge hc3 = new Edge(10, 1, H3, Cc3);
		
		graph3.addVertex(Aa3);
		graph3.addVertex(F3);
		graph3.addVertex(G3);
		graph3.addVertex(Bb3);
		graph3.addVertex(Dd3);
		graph3.addVertex(Cc3);
		graph3.addVertex(H3);
		graph3.addVertex(Ee3);
		
		graph3.addEdge(0, 1, af3);
		graph3.addEdge(0, 2, ag3);
		graph3.addEdge(1, 3, fb3);
		graph3.addEdge(2, 4, gd3);
		graph3.addEdge(2, 5, gc3);
		graph3.addEdge(4, 1, df3);
		graph3.addEdge(4, 6, dh3);
		graph3.addEdge(6, 7, he3);
		graph3.addEdge(5, 7, ce3);
		graph3.addEdge(3, 6, bh3);
		graph3.addEdge(6, 5, hc3);
		
		v = new Vertex(0, 0, 0);
		
		Vertex v1 = new Vertex(1, 0, 1);
		Vertex v2 = new Vertex(2, 2, 1);
		Vertex v3 = new Vertex(3, 2, 3);
		Vertex v4 = new Vertex(4, 1, 1);
		Vertex v5 = new Vertex(5, 0, 5);
		
		e = new Edge(0, 1, v, v1);
		
		Edge e1 = new Edge(1, 2, v, v2);
		Edge e2 = new Edge(2, 3, v, v3);
		Edge e3 = new Edge(3, 4, v, v4);
		Edge e4 = new Edge(4, 5, v, v5);
		Edge e5 = new Edge(6, 2, v1, v2);
		Edge e6 = new Edge(5, 1, v1, v4);
		Edge e7 = new Edge(8, 2, v2, v3);
		Edge e8 = new Edge(7, 1, v2, v5);
		Edge e9 = new Edge(9, 1, v3, v5);
		Edge e10 = new Edge(10, 1, v4, v2);
		Edge e11 = new Edge(11, 1, v4, v3);
		
		graph.addVertex(v);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		
		graph.addEdge(0, 1, e );
		graph.addEdge(0, 2, e1 );
		graph.addEdge(0, 3, e2 );
		graph.addEdge(0, 4, e3 );
		graph.addEdge(0, 5, e4 );
		graph.addEdge(1, 2, e5 );
		graph.addEdge(1, 4, e6 );
		graph.addEdge(2, 3, e7 );
		graph.addEdge(2, 5, e8 );
		graph.addEdge(3, 5, e9 );
		graph.addEdge(4, 2, e10 );
		graph.addEdge(4, 3, e11 );
		
		
		shortBus.setGraph(graph);
		shortBus.setStart(0);
		shortBus.setWeighing(weight);
		
		loc1.add(0);
		loc1.add(1);
		loc1.add(2);
		loc1.add(5);
		
		loc2.add(0);
		loc2.add(5);
		
		loc3.add(0);
		loc3.add(4);
	}


	@Test
	public void testAttribute() {
		Edge T = graph.getAttribute(0);
		assertTrue(T.equals(e));
	}
	
	@Test
	public void testData() {
		Vertex T = graph.getData(0);
		assertTrue(T.equals(v));
	}
	
	@Test
	public void testSrc() {
		int T = graph.getSource(0);
		assertTrue(T == 0);
	}
	
	@Test
	public void testTar(){
		int T = graph.getTarget(0);
		assertTrue(T == 1);
	}
	
	@Test
	public void testWeightC(){
		double T = weight.weight(e);
		assertTrue(T == 1);
	}
	
	@Test
	public void testWeightE(){
		double T = e.getWeight();
		assertTrue(T == 1);
	}
	
	@Test
	public void pathD0(){
		shortBus.computeShortestPath();
		List<Integer> T = shortBus.getPath(5);
		assertTrue(T.toString().compareTo("[0, 2, 5]")==0);
	}
	
	@Test
	public void pathD1(){
		shortBus.computeShortestPath();
		List<Integer> T = shortBus.getPath(1);
		assertTrue(T.toString().compareTo("[0, 1]")==0);
	}
	
	@Test
	public void pathD2(){
		shortBus.computeShortestPath();
		List<Integer> T = shortBus.getPath(4);
		assertTrue(T.toString().compareTo("[0, 1, 4]")==0);
	}
	
	@Test
	public void costD1(){
		shortBus.computeShortestPath();
		double T = shortBus.getCost(5);
		assertTrue(T == 3);
	}
	
	@Test
	public void costD2(){
		shortBus.computeShortestPath();
		double T = shortBus.getCost(1);
		assertTrue(T == 1);
	}
	
	@Test
	public void costD3(){
		shortBus.computeShortestPath();
		double T = shortBus.getCost(4);
		assertTrue(T == 2);
	}
	
	@Test
	public void shortestD0(){
		List<Integer> T = coffee.shortestPath(graph, loc1, weight);
		assertTrue(T.toString().compareTo("[0, 1, 2, 5]")==0);
	}
	
	@Test
	public void shortestD1(){
		List<Integer> T = coffee.shortestPath(graph, loc2, weight);
		assertTrue(T.toString().compareTo("[0, 2, 5]")==0);
	}
	
	@Test
	public void shortestD2(){
		List<Integer> T = coffee.shortestPath(graph, loc3, weight);
		assertTrue(T.toString().compareTo("[0, 1, 4]")==0);
	}
	
	@Test
	public void validGraph(){
		Collection<List<Integer>> T = coffee.generateValidSortS(graph);
		assertTrue(T.toString().compareTo("[[0, 1, 4, 2, 3, 5]]")==0);
	}
	
	@Test
	public void validGraph2(){
		Collection<List<Integer>> T = coffee.generateValidSortS(graph2);
		assertTrue(T.toString().compareTo("[[0, 1, 2, 3, 4], [2, 0, 4, 1, 3], [0, 2, 4, 1, 3], [0, 1, 4, 2, 3], [0, 1, 2, 4, 3]]")==0);
	}
	
	@Test
	public void THEshortestPath(){
		shortBus.setGraph(graph3);
		shortBus.setStart(0);
		shortBus.setWeighing(weight);
		Collection<List<Integer>> T = coffee.generateValidSortS(depGraph);
		System.out.println(T);
		Iterator<List<Integer>> I = T.iterator();
		List<Integer> BestShortestPath = new ArrayList<Integer>();
		List<Integer> ShortestOrdering = new ArrayList<Integer>();
		double cost = Double.POSITIVE_INFINITY;
		while(I.hasNext()){
			List<Integer> locUnconvert = I.next();
			List<Integer> locConvert = new ArrayList<Integer>();
			for(int i = 0; i<locUnconvert.size(); i++){
				locConvert.add(depGraph.getData(locUnconvert.get(i)).getID());
			}
			System.out.println(locConvert);
			List<Integer> temp = coffee.shortestPath(graph3,locConvert, weight);
			if(cost > coffee.getCost()){
				cost = coffee.getCost();
				BestShortestPath = temp;
				ShortestOrdering = locConvert;
			}
		}
		System.out.println("\n Shortest Ordering \n");
		System.out.println("Cost : " + cost + " Shortest Ordering : " + ShortestOrdering + " Path : " + BestShortestPath);
		assertTrue(cost == 7);
	}
}