package ordenacao;

public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public OrdenacaoBolhaOtimizada(T info[]){
        super(info);
    }

    @Override
    public void ordenar() {
        boolean trocou;
        for(int i = 0; i< getInfo().length; i++){
            trocou = false;
            for (int j = 0; j < getInfo().length - i - 1; j++){
                 if(info[j].compareTo(info[j+1])> 0){
                         trocar(j, j+1);
                         trocou = true;
                 }
             }
             if(trocou = false){
                return;
             }
         }
    }
    
}
