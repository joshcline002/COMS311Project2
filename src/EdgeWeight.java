
public class EdgeWeight<E> implements Weighing<E> {

	@Override
	public double weight(E edge) {
		Edge castEdge = (Edge)edge;
		return castEdge.getWeight();
	}

}
