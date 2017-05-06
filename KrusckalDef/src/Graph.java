
public class Graph {
	private int n_vertici;
	private Collegamenti adiacenze;
	
	public Graph(int n_vertici){
		this.n_vertici=n_vertici;
		this.adiacenze=new Collegamenti(n_vertici);
	}
	
	public void aggSpigolo(int n1, int n2){
		adiacenze.aggUnioni(n1, n2);
	}
	
	public boolean isCyclicUtil(int currentV, boolean visited[], int parentV){
		visited[currentV]=true;
		int accanto=adiacenze.vicino(parentV, currentV);
		System.out.println(accanto);
		while(accanto!=-1){
			if(!visited[accanto]) if(isCyclicUtil(accanto, visited, currentV)) return true;
			if(accanto!=parentV) return true;
		}
		System.out.println("merda");
		return false;
	}
	
	public boolean isCyclic(){
		boolean visited[] = new boolean[n_vertici];
		for(int i=0; i<n_vertici; i++){
			visited[i]=false;
		}
		for(int i=0; i<n_vertici; i++){
			if(!visited[i]){
				System.out.println("crd");
				boolean speranza = isCyclicUtil(i, visited, -1);
				System.out.println(speranza);
				if(isCyclicUtil(i, visited, -1)){
					return true;
				}
			}			
		}
		System.out.println("mammamia");
		return false;
		
	}

	public static void main(String[] args) {
		//Ciclico
		Graph g1 = new Graph(5);
		g1.aggSpigolo(1, 0);
		g1.aggSpigolo(0, 2);
		g1.aggSpigolo(2, 1);
		g1.aggSpigolo(0, 3);
		g1.aggSpigolo(3, 4);
		if(g1.isCyclic()) System.out.println("Graph contiene cicli");
		else System.out.println("Nessun ciclo");
		//Non ciclico ma al momento è ciclico
		Graph g2 = new Graph(3);
		g2.aggSpigolo(0, 1);
		g2.aggSpigolo(1, 2);
		if(g2.isCyclic()) System.out.println("Graph contiene cicli");
		else System.out.println("Nessun ciclo");

	}

}
