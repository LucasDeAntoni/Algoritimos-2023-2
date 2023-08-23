public class NoLista <T> {
    private T info;
    private NoLista prox;

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public NoLista getProx() {
        return prox;
    }
    public void setProx(NoLista prox) {
        this.prox = prox;
    }
}