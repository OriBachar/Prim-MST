package algo1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Vector;

public class Algo
{

	public static ArrayList<Node> PrimMST(Graph g, String str)
	{
		Node root = null;

		PriorityQueue<Node> queue = new PriorityQueue<>();

		for (Node vertex : g.getwGraph())
			queue.add(vertex);

		ArrayList<Node> tree = new ArrayList<>();

		for (Node vertex : queue) 
		{
			vertex.setKey(Integer.MAX_VALUE);

			if (vertex.getLabel().contains(str))
				root = vertex;
		}

		root.setKey(0);

		root.setFather(null);

		while (!queue.isEmpty())
		{
			Node u = queue.poll();

			LinkedList<Edge> uEdge = u.getEdges();

			for (Edge e : uEdge) 
			{
				Node v = e.getDest();

				int weight = e.getWeight();

				if (queue.contains(e.getDest()) && weight < v.getKey()) 
				{
					queue.remove(v);

					v.setFather(u);

					v.setKey(weight);

					queue.add(v);
				}

			}

			tree.add(u);
		}

		return tree;
	}

	public static void NewMST(ArrayList<Node> mst, Edge e)
	{

		Vector<Edge> path = FindPath(e.getSource(), e.getDest(), mst);

		if (path == null)
			return;

		int Maxweight = -1;

		Edge ed = new Edge();

		for (int i = 0; i < path.size(); i++)
			if (path.elementAt(i).getWeight() > Maxweight) 
			{
				Maxweight = path.elementAt(i).getWeight();

				ed = path.elementAt(i);
			}
		

		if (e.getWeight() > Maxweight)
			return;

		else 
		{
			int i;
			
			for (i = 0; i < mst.size(); i++)
				if (mst.get(i).getLabel() == ed.getSource().getLabel())
				{
					mst.get(i).getEdges().remove();
					
					break;
				}
			
			
			for (i = 0; i < mst.size(); i++)
				if (mst.get(i).getLabel() == e.getSource().getLabel())
				{
					mst.get(i).getEdges().add(e);
					
					break;
				}
			
			

			for (i = 0; i < mst.size(); i++)
				if (mst.get(i).getLabel() == e.getDest().getLabel())
				{
					mst.get(i).setKey(e.getWeight());
					
					mst.get(i).setFather(e.getSource());
					
					break;
				}
			
			
			
			return;

		}
	}
	
	public static Vector<Edge> FindPath(Node src, Node dest, ArrayList<Node> tree) 
	{
		Vector<Edge> path = new Vector<Edge>();

		if (src.getLabel() == dest.getLabel()) 
		{
			Edge e = new Edge();

			e.setSource(src);

			e.setDest(dest);

			e.setWeight(0);

			path.add(e);

			return path;
		}

		
		
		for (int i = tree.indexOf(src); i < tree.size(); i++)
		{
			if (tree.get(i).getLabel() != dest.getLabel())
				path.add(tree.get(i).getEdges().getFirst());
			
			else break;
		}

		return path;

	}

	public static void PrintMST(ArrayList<Node> tree)
	{
		System.out.print("[null," + tree.get(0).getKey() + "," + tree.get(0).getLabel() + "]" + "->");

		int j;
		
		
		
		for (j = 1; j < tree.size() - 1; j++)
			System.out.print("[" + tree.get(j).getFather().getLabel() + "," + tree.get(j).getKey() + ","
					+ tree.get(j).getLabel() + "]" + "->");

		System.out.print("[" + tree.get(j).getFather().getLabel() + "," + tree.get(j).getKey() + ","
				+ tree.get(j).getLabel() + "]");
		
	}

	public static void RmEdge(LinkedList<Edge> edge, ArrayList<Node> tree, int i)
	{
		if (i == 0)
		{
			Node first = new Node(tree.get(0).getLabel(), null, 0);

			Node second = new Node(tree.get(1).getLabel(), first, tree.get(1).getKey());

			Edge e = new Edge(first, second, tree.get(1).getKey());

			edge.removeAll(edge);

			edge.add(e);

			return;
		}

		Node src = new Node(tree.get(i).getLabel(), tree.get(i-1), 0);

		Node dest = new Node(tree.get(i + 1).getLabel(), src, tree.get(i + 1).getKey());

		Edge e = new Edge(src, dest, tree.get(i + 1).getKey());

		edge.removeAll(edge);

		edge.add(e);

	}

	public static void RealMst(ArrayList<Node> tree) 
	{
		for (int i = 0; i < tree.size() - 1; i++)
			RmEdge(tree.get(i).getEdges(), tree, i);
	}
}
