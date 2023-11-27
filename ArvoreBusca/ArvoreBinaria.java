package ArvoreBusca;

public class ArvoreBinaria<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        buscar(getRaiz(), info);
        return null;
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }
        if (info.equals(no)) {
            return no;
        } else if (info.compareTo(no.getInfo()) < 0) {
            return buscar(no.getEsq(), info);
        } else if (info.compareTo(no.getInfo()) > 0) {
            return buscar(no.getDir(), info);
        }   else {
            return null;
        }

    }

}