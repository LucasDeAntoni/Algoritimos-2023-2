package Ordenacao2;

public class OrdenacaoBolhaOtimizada <T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    

    
    public OrdenacaoBolhaOtimizada(T[] info) {
        super(info);
        
    }

    @Override
    public void ordenar() {
        boolean trocou;
        int n = getInfo().length;

        for (int i = 0; i < n; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (info[j] != null && info[j+1] != null &&info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }
            if (trocou == true){
                return;
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
