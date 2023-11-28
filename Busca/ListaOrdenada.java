package Busca2;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    Object[] infoLocal = getInfo();

    public ListaOrdenada() {
        infoLocal = new Object[0];
    }
    @Override
    public void inserir(T valor) {

        if (tamanho == infoLocal.length) {
            redimensionar();
            infoLocal = info;
            infoLocal[tamanho] = valor;
            tamanho++;
            return;
        }

        int i = 0;

        while (i < tamanho && valor.compareTo((T) infoLocal[i]) > 0) {
            i++;
        }

        for (int j = tamanho; j > i; j--) {
            infoLocal[j] = infoLocal[j - 1];
        }

        infoLocal[i] = valor;
        tamanho++;

    }

    @Override
    public int buscar(T valor) {
        int n = tamanho;
        int inicio = 0;
        int fim = n - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (valor.compareTo((T)infoLocal[meio]) < 0) { // redefine pos final
                fim = meio - 1;
            } else if (valor.compareTo((T)infoLocal[meio]) > 0) { // redefine pos inicial
                inicio = meio + 1;
            } else {
                return meio; // achou :D
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
    lista.inserir(100);
       lista.inserir(0);
       lista.inserir(10);
       lista.inserir(20);
       lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
       
      

        System.out.println(lista.toSTring());
        System.out.println(lista.buscar(100));
    }

}
