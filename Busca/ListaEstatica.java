package Busca;

public class ListaEstatica <T> extends ListaAbstract<T> {
    T[] infoLocal ;
    @Override
    public void inserir(T valor) {
        if(getTamanho() == info.length){
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public int buscar(T valor) {
        for (int i = 0; i<tamanho-1; i++){
            if (info[i] == valor){
                return i;
            }
        }
        return -1;
    }
    
}
