 package ordenacao;

public class Quicksort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    
    public Quicksort(T info[]){
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

        while(a <= b){
            while(info[a].compareTo(pivo) < 0){
                a++;
            }
            while(info[b].compareTo(pivo) > 0){
                b--;
            }
            if(a <= b){
                trocar(a, b);
                // Atualiza o índice do pivô
                if(info[a].compareTo(pivo) == 0){
                    b--;
                }else{
                    a++;
                }
            }
        }
        return a;
    }

    
    
    public static void main(String[] args) {
		
    	

        // Cria um array de inteiros com os dados da imagem
        Integer[] dados = {70, 2, 88, 15, 90, 30};

        // Cria uma instância da classe OrdenacaoBolha
        Quicksort<Integer> ordenacao = new Quicksort(dados);

        // Ordena o array de inteiros
        ordenacao.ordenar();

        // Imprime o array ordenado
        for (Integer dado : dados) {
            System.out.print(dado + " ");
        }
        System.out.println();
    }
}
