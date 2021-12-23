//Name: Ori Bachar ID: 208254516
//Nitzan Miranda ID:316591759

package algo1;


@SuppressWarnings("unused")
public class Edge 
{
	private Node source;
	
	private Node dest;
	
	private int weight;
	
	public Edge() {}

	public Edge(Node source, Node dest, int weight) {
		super();
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}


	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public Node getDest() {
		return dest;
	}

	public void setDest(Node dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	

	@Override
	public String toString()
	{
		return "[" + source.getLabel() + "," + weight +  "," + dest.getLabel() + "]";
	}
	
}
