package ArvoreBinaria;

public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> esq;
    private NoArvoreBinaria<T> dir;

    public NoArvoreBinaria(T info) {
        this.info = info;
        this.esq = null;
        this.dir = null;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        this.info = info;
        this.esq = esq;
        this.dir = dir;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public void setEsq(NoArvoreBinaria<T> no) {
        esq = no;
    }

    public NoArvoreBinaria<T> getEsq() {
        return esq;
    }

    public void setDir(NoArvoreBinaria<T> no) {
        dir = no;
    }

    public NoArvoreBinaria<T> getDir() {
        return dir;
    }

}
