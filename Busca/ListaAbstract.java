package Busca2;

public abstract class ListaAbstract<T> {
    protected int tamanho;
    protected T[] info;

    public ListaAbstract() {

        info = (T[]) new Object[10];
        tamanho = 0;

    }

    protected T[] getInfo() {
        return info;
    }

    public int getTamanho() {
        return tamanho;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    protected void redimensionar() {
        T[] novo;
        int novoTamanho = info.length + 10;

        novo = (T[]) new Object[novoTamanho];

        for (int i = 0; i < tamanho; i++) {

            novo[i] = info[i];

        }
        info = novo;
    }

    public abstract void inserir(T valor);

    public abstract int buscar(T valor);

    public void exibir() {

        for (int i = 0; i < tamanho; i++) {
            System.out.println("Posição " + i + ":" + info[i]);

        }
    }

    public void retirar(T valor) {
        int posicao = buscar(valor);

        if (posicao != -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        T[] novo;
        int novoTamanho = 0;

        novo = (T[]) new Object[novoTamanho];

        info = novo;

    }

    public T obterElemento(int posicao) {
        if (posicao >= 0 && posicao <= tamanho) {
            return info[posicao];

        } else {
            throw new IndexOutOfBoundsException("posição invalida");
        }
    }

    public boolean estaVazia() {
        if (info.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toSTring() {

        String infoString = info[0] + "";

        for (int i = 1; i < tamanho; i++) {
            infoString = infoString + "," + info[i];
        }
        return infoString;
    }

    public void inverter() {
        T[] novo;
        int novoTamanho = tamanho;

        novo = (T[]) new Object[novoTamanho];

        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[tamanho - i - 1];
        }
        info = novo;
    }

    /*
     * public static void main(String[] args) {
     * ListaEstaticaGenerica<Aluno> lista = new ListaEstaticaGenerica<>();
     * 
     * Aluno a1 = new Aluno("Lucas", 10);
     * Aluno a2 = new Aluno("eu", 19);
     * Aluno a3 = new Aluno("e", 39);
     * Aluno a4 = new Aluno("aaa", 139);
     * lista.inserir(a1);
     * lista.inserir(a2);
     * lista.inserir(a3);
     * lista.inserir(a4);
     * 
     * // lista.exibir();
     * lista.toSTring();
     * lista.inverter();
     * // lista.exibir();
     * }
     * 
     * 
     */


}

