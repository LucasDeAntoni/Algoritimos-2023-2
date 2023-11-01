package ordenacao;

public class Mergesort<T extends Comparable<T>> extends OrdenacaoAbstract<T>  {
           
    public Mergesort(T info[]){
        super(info);
    }

    @Override
    public void ordenar() {
        int n = info.length-1;
        mergeSort(0, n);
    }

    private void mergeSort(int inicio, int fim){
        if(inicio> fim){
           int meio = (inicio+fim)/2;
           mergeSort(inicio,meio);
           mergeSort(meio+1, fim);
           merge(inicio, fim, meio);
        }
    }
 
    private void merge(int inicio, int fim, int meio) {
        T[] info = getInfo();

        int tamEsquerda = meio-inicio-1;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];

        for (int i = 0; i <  tamEsquerda; i++) {
            esquerda[i] = info[i];
        }

        int tamDireita = fim-meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for (int i = 0; i <  tamDireita; i++) {
            direita[i] = info[i+meio+1];
        }

        int cEsq = 0;
        int cDir = 0;

        int i;
        for (i = inicio; i <= fim; i++) {
            if (cEsq < tamEsquerda && cDir < tamDireita) {
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                    info[i] = esquerda[cEsq];
                    cEsq++;
                } else {
                    info[i] = direita[cDir];
                    cDir++;
                }
            } else {
                break;
            }
        }

        while (cEsq < tamEsquerda) {
            info[i] = esquerda[cEsq];
            cEsq++;
            i++;
        }

        while (cDir < tamDireita) {
            info[i] = direita[cDir];
            cDir++;
            i++;
        }
    }
    
    
    
    
}
