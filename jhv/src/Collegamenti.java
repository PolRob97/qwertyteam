
public class Collegamenti {
	
	public double[][] collegamenti;
	
	public Collegamenti(int dim){
		collegamenti = new double[dim][dim];
	}
	
	public Nodo cercaVicino(Nodo n, ListaNodi lista){
		int indice = (int)n.nome-97;
		int j = 0;
		double minore = collegamenti[indice][0];
		for(int i=0; i<collegamenti.length; i++){
			if(collegamenti[indice][i]<minore){
				minore=collegamenti[indice][i];
				j=i+97;
			}
		}
		return lista.listaNodi.get(j);
	}
	
	public double cercaDistanza(Nodo n1, Nodo n2){
		int indice = (int)n1.nome-97;
		int secondoIndice = (int)n2.nome-97;
		return collegamenti[indice][secondoIndice];
	}

}
