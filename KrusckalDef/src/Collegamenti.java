


public class Collegamenti {
	
	public int[][] collegamenti;
	
	public Collegamenti(int dim){
		collegamenti = new int[dim][dim];
	}
	
	public void aggUnioni(int n1, int n2){
		collegamenti[n1][n2]=1;
		collegamenti[n2][n1]=1;
	}
	
	public int vicino(int nodoPrecedente, int nodoAttuale){
		for(int i=0; i<collegamenti[nodoAttuale].length; i++){
			if(i==nodoPrecedente) continue;
			if(collegamenti[nodoAttuale][i]==1) return i;
		}
		return -1;
	}
}
