package ordenacao;

public abstract class OrdenacaoAbstract <T extends Comparable<T>>  {

    protected  T info[];

    public OrdenacaoAbstract(T[] info) {
        this.info = info;
    }

     public T[] getInfo() {
        return info;
    }
    public void setInfo(T[] info) {
        this.info = info;
    }
    

    public void trocar(int a, int b){
        T temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }
    public abstract void ordenar();
    

    



   
}