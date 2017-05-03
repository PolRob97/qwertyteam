package krucals;

public class MatriceUnioni {
	private double[][] matPuntiUniti;
	
	public MatriceUnioni(int puntiTotali){
		matPuntiUniti = new double[puntiTotali+1][puntiTotali+1];
	}
	
	public void preparaMatrice(int puntiTotali){
		for(int i=0; i<matPuntiUniti[0].length; i++){
			matPuntiUniti[i][i]=0;
			matPuntiUniti[i][0]=i;
			matPuntiUniti[0][i]=i;
		}
	}
	
	public void aggiungiPunto(Nodo p1, double[] distanze){
		for(int i=1; i<matPuntiUniti[p1.x].length; i++){
			if(p1.x==i) continue;
			else matPuntiUniti[p1.x][i]=distanze[i-1];
		}
	}
	
	public boolean collegato(Nodo n1, Nodo n2){
		if(matPuntiUniti[n1.x][n2.x]==1) return true;
		else return false;
	}
	public double distanzaDi(Nodo n1, Nodo n2){
		return matPuntiUniti[n1.x][n2.x];
	}
	
	public double nodoVicino(int gradoVicinanza, Nodo n1){//If you add the Nodo's list it could return the nearest Nodo
		int primoElemento=1;
		if(n1.x==primoElemento) primoElemento++;
		double vicino=matPuntiUniti[n1.x][primoElemento];
		for(int i=1; i<matPuntiUniti[n1.x].length; i++){
			if(n1.x==i) continue;
			if(matPuntiUniti[n1.x][i]<vicino){
				vicino = matPuntiUniti[n1.x][i];
				gradoVicinanza--;
			}
			if(gradoVicinanza==0) return i;
		}
		return -1;
	}
	
	

}
