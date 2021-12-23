//Name: Ori Bachar ID: 208254516
//Nitzan Miranda ID:316591759

package algo1;

import java.util.ArrayList;

public class Graph
{
	
	private int numOfNodes;
	
	private Node[] wGraph;
	
	
	public Graph(int numOfNodes) 
	{
		this.numOfNodes = numOfNodes;
		
		this.wGraph = new Node[this.numOfNodes];
		
		for (int i = 0; i < wGraph.length; i++)
			this.wGraph[i] = new Node();
	}
	
	public void addEdge (String sourceLabel, String destLabel, int weight)
	{
		Node sourceNode = null;
		
		Node destNode = null;
		
		for (Node node : this.wGraph)
		{
			if (node.getLabel().contains(sourceLabel))
				sourceNode = node;
			
			if (node.getLabel().contains(destLabel))
				destNode = node;
		}
		
		Edge e = new Edge();
		
		e.setWeight(weight);
		
		e.setDest(destNode);
		
		e.setSource(sourceNode);
		
		sourceNode.getEdges().add(e);
	}
	
	
	public int getNumOfNodes() 
	{
		return numOfNodes;
	}

	public void setNumOfNodes(int numOfNodes) 
	{
		this.numOfNodes = numOfNodes;
	}

	public Node[] getwGraph() 
	{
		return wGraph;
	}

	public void setwGraph(Node[] wGraph) 
	{
		this.wGraph = wGraph;
	}
	
	public static void PrintGraph(Node[] Graph)
	{

		int i;

		for (i = 0; i < Graph.length - 1; i++)
			System.out.println("Edges of " + Graph[i].getLabel() + ":" + Graph[i].getEdges().toString() + "->");

		System.out.println("Edges of " + Graph[i].getLabel() + ":" + Graph[i].getEdges().toString());
		
    } 

	
	
}
