package Fila;

public class FilaLista <T> implements Fila<T> {
    ListaEncadeada lista = new ListaEncadeada<T>();

    @Override
    public void inserir(T valor) {
       lista.inserir(valor);
    }

    public void inserirNoFinal(T valor){
        lista.InserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
       return lista.EstaVazia();
    }

    @Override
    public T peek() {
           if (estaVazia() == true){
            throw new FilaVaziaException();
        }
        return (T) lista.getUltimo().getInfo();
    }

    @Override
    public T retirar() {
        T valor;
        valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        ListaEncadeada<T> NovaLista = new ListaEncadeada<T>();
        lista  = NovaLista;
    }

    public String toString(){
       return lista.toString();
    }

    public static void main(String[] args) {
        FilaLista<Integer> f = new FilaLista<>();

        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        f.retirar();
       System.out.println(f.peek());

        System.out.println(f.estaVazia());
    }
    
}
