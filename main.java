package algo1;

import java.util.ArrayList;
import java.util.Random; 


@SuppressWarnings("unused")
public class main {

	public static void main(String[] args)
	{
		Graph graph = new Graph(20);
		
		String[] nodes = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s","t"};
		
		int i = 0;
		
		for (String string : nodes)
		{
			graph.getwGraph()[i].setLabel(string);
			
			i++;
		}
		
       
        
        
		int index;
		
		for (i = 0; i < 50; i++)
		{
			
			Random rand = new Random(); 
		    
			int weight = rand.nextInt((55 - 2) + 1) + 2;
			
			String src;
			
			String dest;
			
	        do 
	        {
	        	Random rand2 = new Random();
			    
	        	index = rand.nextInt(nodes.length);
	        	
	        	src = nodes[index];
	        	
	        	index = rand.nextInt(nodes.length);
	        
	        	dest = nodes[index];
	        }
	        while (dest == src);
	        
	    
	        graph.addEdge(src, dest, weight);
	        graph.addEdge(dest, src, weight);

		}
		
		
		for (int j = 0; j < graph.getwGraph().length; j++)
			if(graph.getwGraph()[j].getEdges().size() == 0)
			{
				System.out.println("Because of the random there is a vertex in the graph without egdes");
				
				return;
				
			}
		
		System.out.println("Graph:");
		
		Graph.PrintGraph(graph.getwGraph());
		
		System.out.println();
		
		ArrayList<Node> tree = Algo.PrimMST(graph,"a");
		
		System.out.println("MST:");
		
		Algo.RealMst(tree);
		
		Algo.PrintMST(tree);
		
		System.out.println();
			
		Random rand = new Random(); 
	    
		int start = rand.nextInt(20);
		
		Edge newEdge = new Edge();
		
		newEdge.setSource(tree.get(start));
		
		rand = new Random();
		
		int end = rand.nextInt(20);
		
		newEdge.setDest(tree.get(end));
		
		newEdge.setWeight(101);
		
		Algo.NewMST(tree,newEdge);
		Algo.RealMst(tree);
		
		System.out.println();
		
		System.out.println("Node added: "+  newEdge.toString()+ "-> Didnt change the mst");
		Algo.PrintMST(tree);
		
		newEdge = new Edge();
		
	     do 
	       {
	    	start = rand.nextInt(20);
	  		
	  		newEdge.setSource(tree.get(start));
	  		
	  		rand = new Random();
	  		
	  		end = rand.nextInt(20);
	  		
	  		newEdge.setDest(tree.get(end));
	        }
	        while (start == end);
		
		newEdge.setWeight(1);
		
		
		
		Algo.NewMST(tree,newEdge);
		Algo.RealMst(tree);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Node added: "+  newEdge.toString()+ "-> change the mst");
		Algo.PrintMST(tree);
		
		
		System.out.println();
		System.out.println();
		System.out.println();
	
	}

	

}
