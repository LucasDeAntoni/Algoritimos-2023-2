package ordenacao;

public class quicksort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    
    public quicksort(T info[]){
        super(info);
    }

    @Override
    public void ordenar() {
       int n = info.length -1;
       quickSort(0, n);
    }

    private void quickSort(int inico, int fim){
        if(inico<fim){
            int indexPivo = patricionar(inico, fim);
            quickSort(inico, indexPivo-1);
            quickSort(indexPivo+1, fim);
        }
    }

    private int patricionar(int inicio, int fim){
        int a = inicio;
        int b = fim;
        T pivo = info[inicio];

    while(true){
        	do {
        		a++;
        	}
            while(a<=fim &&info[a].compareTo(pivo)>=0);
               
            
        	do {
        		b--;
        	}
            while (b >= inicio && info[b].compareTo(pivo) > 0);
           

            if(a>=b){
                break;
            }

            trocar(a, b);
        }
        trocar(b, inicio);

        return b;
    }
}
