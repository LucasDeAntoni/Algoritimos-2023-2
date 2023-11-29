package Ordenacao2;

public class MergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public MergeSort(T[] info) {
        super(info);
    }

    @Override
    public void ordenar() {
    }

    public void mergeSort(int inicio, int fim) {

        if (inicio > fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }

    public void merge(int inicio, int fim, int meio) {
        int tamEsquerda = meio - inicio + 1;

        T[] esquerda = (T[]) new Comparable[tamEsquerda];

        for (int i = 0; i <= tamEsquerda - 1; i++) {
            esquerda[i] = info[inicio + 1];
        }

        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];

        for (int i = 0; i <= tamDireita - 1; i++) {
            direita[i] = info[meio + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;

        for (int i = inicio; i < fim; i++) {
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


    public static void main(String[] args) {
        Integer[] valor = new Integer[10];
        
        
        valor[0] =70;
        valor[1] =2;
        valor[2]= 88;
        valor[3]=15;
        valor[4]= 90;
        valor[5]= 30;

        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>(valor);
        bolha.ordenar();

        for (Integer elemento : valor) {
            if(elemento!=null){
            System.out.print(elemento + " ");
            }
        }
    }

}
