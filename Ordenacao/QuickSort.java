package Ordenacao2;

public class QuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public QuickSort(T[] info) {
        super(info);
    }

    @Override
    public void ordenar() {
        int n = info.length - 1;
        quickSort(0, n);
    }

    public void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo - 1);
            quickSort(idxPivo + 1, fim);
        }
    }

    public int particionar(int inicio, int fim) {
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];

        while (true) {

            while (a <= fim && info[a].compareTo(pivo) < 0) {
                a++;
            }
            while (b >= inicio && info[b].compareTo(pivo) > 0) {
                b--;
            }
            if (a >= b) {
                break;
            }
            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
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
