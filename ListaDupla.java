

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {

    }

    public void inserir(T valor) {

        NoListaDupla<T> novo = new NoListaDupla<T>();
        novo.setInfo(valor);
        novo.setProx(getPrimeiro());
        novo.setAnterior(null);
        if (getPrimeiro() != null) {
            getPrimeiro().setAnterior(novo);
        }
        primeiro = novo;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p.getInfo() == valor) {
                return p;
            } else {
                p = p.getProx();
            }

        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);
        if (p != null) {
            if (p.getProx() == null) {
                p.getAnterior().setProx(null);
            } else if (p.getAnterior() == null) {
                primeiro = p.getProx();
                p.getProx().setAnterior(null);
            } else {
                p.getAnterior().setProx(p.getProx());
                p.getProx().setAnterior(p.getAnterior());
            }
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> p = getPrimeiro();
        // leva p ao ultimo
        while (p != null && p.getProx() != null) {
            p = p.getProx();
        }
        // desce a lista exibindo seus valores
        while (p != null) {
            System.out.println(p.getInfo().toString());
            p = p.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> p = getPrimeiro();
        p = p.getProx();
        while (p != null) {
            p.getAnterior().setProx(null);
            p.setAnterior(null);

            p = p.getProx();
        }
    }

    public String toString() {

        NoListaDupla<T> p = getPrimeiro();
        String str = "";

        while (p != null) {
            if (p.getAnterior() == null) {
                str = str + p.getInfo().toString();
                p = p.getProx();
            }

            str = str + ", " + p.getInfo().toString();
            p = p.getProx();
        }
        return str;
    }

    public static void main(String[] args) {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        // lista.exibirOrdemInversa();

        // System.out.println(lista.buscar(10).getInfo().toString());

        // System.out.println(lista.toString());
        // System.out.println(lista.getPrimeiro().getInfo());
        // lista.liberar();
        System.out.println(lista.toString());

    }

}
