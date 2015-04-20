
public class Edge<E>{ 
		int srcID;
		int targetID;
		E attr;
		int uniqueID;
		
		public Edge(int srcID, int targetID, E attr, int num_Edges){
			this.srcID = srcID;
			this.targetID = targetID;
			this.attr = attr;
			uniqueID = num_Edges;
			num_Edges++;
		}
		
		
	}