package ordenacao;

public class OrdenacaoBolha <T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public  OrdenacaoBolha(T info[]){
        super(info);
    }
    
    @Override
    public void ordenar(){
        for(int i = 0; i< getInfo().length; i++){

           for (int j = 0; j < getInfo().length - i - 1; j++){
                if(info[j].compareTo(info[j+1])> 0){
                        trocar(j, j+1);
                }
            }
        }
    }

    


   
}
