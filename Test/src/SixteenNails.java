import java.util.*;

public class SixteenNails {
	 
	public static void main(String[] args) {
		//prompt user to enter initial sixteen coins 
		System.out.println("Enter the initial " + "sixteen coins Hs and Ts: "); 
		//Creating scanner class object 
		Scanner in = new Scanner(System.in); 
		//reading input line 
		String s = in.nextLine(); 
		//saving input string inside character array chain 
		char [] initNode = s.toCharArray(); 
		//creating TailModel class object 
		TailModel tailModel = new TailModel(); 
		
		//creating an integer type list 
		List<Integer> shortPath = tailModel.getShortestPath(TailModel.getIndex(initNode)); 
		
		//when no solution exists 
		if (shortPath == null) 
		System.out.println("No solutions"); 
		else { 
			//when solution exists 
			System.out.println("The steps" + " to flip the coins are "); 
			for (int itr = 0; itr < shortPath.size(); itr++) 
				TailModel.nodePrint( TailModel.getNode(shortPath.get(itr)));
			} } 
	
	
	static class TailModel { 
		//storing the dimension of the grid 
		public final static int BOUNDARY_DIMENSION = 4; 
		//storing number of nodes 
		public final static int NO_OF_NODES = 1 
			<< BOUNDARY_DIMENSION*BOUNDARY_DIMENSION; 
		// Defining a tree 
		protected AbstractGraph<Integer>.Tree tree; 
		
		//constructing a model 
		public TailModel() { 
			// Create edges for the model 
			List<AbstractGraph.Edge> edge = getEdge(); 
			// Creating graph 
			UnweightedGraph<Integer> graph = new UnweightedGraph<>( edge, NO_OF_NODES); 
			// Obtaining a BSF tree which is 
			//rooted at target node 
			tree = graph.bfs(NO_OF_NODES - 1); 
	} 
		
		//creating all the edges for the graph
		private List<AbstractGraph.Edge> getEdge() { 		
			// Store edges 			
			List<AbstractGraph.Edge> edge = new ArrayList<>(); 
		for (int u = 0; u < NO_OF_NODES; u++) { 
			for (int itr = 0; itr < BOUNDARY_DIMENSION * BOUNDARY_DIMENSION; itr++) { 
				// Get the node for vertex itrl 
				char [] n = getNode(u); 
				if (n[itr] == 'H') { 
					int v = getRpNode(n, itr); 
					// Add edge for a legal move from u It node to v node 
					edge.add(new AbstractGraph.Edge(v, u)); 
					} } } 
		return edge; 
				}
		
//		public static Object getIndex(char[] initNode) {
//			// TODO Auto-generated method stub
//			return null;
//		}

	
	// method to get the flipped node 
	public static int getRpNode(char[] n, int pos) { 
		//assigning number or rows 
		int row = pos / BOUNDARY_DIMENSION; 
		//assigning number of columns 
		int col = pos % BOUNDARY_DIMENSION; 
		//calling flipCell method to flip cells 
		flipCell(n, row, col); 
		flipCell(n, row -1, col); 
		flipCell(n, row + 1, col); 
		flipCell(n, row, col - 1); 
		flipCell(n, row, col + 1); 
		//return index of n 
		return getIndex(n); 

			}
	
	
	// method to flip a cell 
	public static void flipCell(char[] n, int r, int c) { 
		if (r >= 0 && r < BOUNDARY_DIMENSION && c >= 0 && c < BOUNDARY_DIMENSION) { 
			// Within the boundary 
			if (n[r* BOUNDARY_DIMENSION + c] == 'H') 
				// Flip the coin from H to T 
				n[r* BOUNDARY_DIMENSION + c] = 'T; 
				else // Flip the coin from T to H 
					n[r * BOUNDARY DIMENSION + c] = 'H'; 
			} } 

	//method to return the index 
	public static int getIndex(char[] n) { 
		int res = 0; 
		for (int i = 0; i < BOUNDARY_DIMENSION * BOUNDARY_DIMENSION; i++) 
			if (n[i] == 'T')
				res = res* 2 + 1; 
			else res = res* 2 + 0; 
		return res; } 
	
			// method to get the node at a particular index 
	public static char[] getNode(int index) { 
		//creating character array 
		char[] res = new char[BOUNDARY_DIMENSION * BOUNDARY_DIMENSION]; 
		for (int i = 0; i < BOUNDARY_DIMENSION * BOUNDARY_DIMENSION; i++) { 
			int digit = index % 2; 
			if (digit == 0) 
				res[BOUNDARY_DIMENSION* BOUNDARY_DIMENSION - 1 - i] = 'H'; 
			else res[BOUNDARY_DIMENSION * BOUNDARY_DIMENSION - 1 - i] = 'T'; 
			index = index / 2; 
	}
		return res;
	} 
	
	// method to get the shortest path from a particular 
	//node 
	public List<Integer> getShortestPath(int nlndex) 
	{ 
		//creating integer list to store the shortest path 
		List<Integer> shortestPath = tree.getPath(nlndex); 
		if (shortestPath.size() == 1 && shortestPath.get(0) != BOUNDARY_DIMENSION * BOUNDARY_DIMENSION - 1)
			return null; 
		else return shortestPath; 
		} 
	//method to print the node 
	public static void nodePrint(char[] n) { 
		for (int i = 0; i < BOUNDARY_DIMENSION * BOUNDARY_DIMENSION; i++) 
			//checking if a row has been printed 
			//of not 
			if (i % BOUNDARY_DIMENSION != BOUNDARY_DIMENSION - 1) 
				System.out.print(n[i]); 
			else 
		System.out.println(n[i]); 
		System.out.println();
		} } } 

	