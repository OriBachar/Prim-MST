//Name: Ori Bachar ID: 208254516
//Nitzan Miranda ID:316591759

package algo1;

import java.util.LinkedList;

public class Node implements Comparable<Node> {

	private LinkedList<Edge> edges;
	private Node father;
	int key;
	String label;

	public Node() {
		this.edges = new LinkedList<Edge>();
	}

	public Node(String label, Node father, int key) {
		super();
		this.father = father;
		this.key = key;
		this.label = label;
	}

	@Override
	public int compareTo(Node n) {
		if (this.getKey() > n.getKey())
			return 1;

		else if (this.getKey() < n.getKey())
			return -1;

		return 0;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public LinkedList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Edge> edges) {
		this.edges = edges;
	}

	public Node getFather() {
		return father;
	}

	public void setFather(Node father) {
		this.father = father;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
