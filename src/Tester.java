import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Tester {
	public static <V,E> void main(String[] args) throws IOException{
		Graph<Vertex,Edge> graph = new CreateGraph<Vertex,Edge>();
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
	}
}
