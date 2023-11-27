package ArvoreBinaria;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        raiz = null;

    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return (raiz == null);
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {

        if (raiz == null) {
            return false;
        } else {
            return (no.getInfo() == info) || pertence(no.getEsq(), info) || pertence(no.getDir(), info);
        }

    }

    // pre-ordem
    public String toString() {
        return ArvorePre(raiz);  
    }

    public String ArvorePre(NoArvoreBinaria<T> no) {
		if (no.getInfo() == null || no == null) {
			return "";
		}
		String str = "<" + no.getInfo().toString();

		if (no.getEsq() != null)
			str +=  ArvorePre(no.getEsq()) ;
		else
			str += "<>";

		if (no.getDir() != null)
			str +=  ArvorePre(no.getDir()) ;
		else
			str += "<>";

		return str + ">";
	}

    // simetrica
    public String emordem() {
        return emOrdemPrivate(raiz);
    }

    private String emOrdemPrivate(NoArvoreBinaria<T> no) {

        if (no == null) {
            return " ";
        }

        String str = ""; 

        if (no.getEsq() != null) {
            str += "<" + emOrdemPrivate(no.getEsq()) + ">";
        } else {
            str += "<>";
        }

        str += no.getInfo().toString();

        if (no.getDir() != null) {
            str += "<" + emOrdemPrivate(no.getDir()) + ">";
        } else {
            str += "<>";
        }

        return str;
    }

    public String posOrdem() {
        return posOrdemPrivate(raiz);
    }

    public String posOrdemPrivate(NoArvoreBinaria<T> no) {

        if (no == null) {
            return " ";
        }

        String str = "";

        if (no.getEsq() != null) {
            str += "<" + posOrdemPrivate(no.getEsq()) + ">";
        } else {
            str += "<>";
        }

        if (no.getDir() != null) {
            str += "<" + posOrdemPrivate(no.getDir()) + ">";
        } else {
            str += "<>";
        }

        str += no.getInfo().toString();
        return str;
    }

    public int contarNos() {
        if (estaVazia())
            return 0;

        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        int n = 1;

        if (no.getEsq() != null)
            n += contarNos(no.getEsq());

        if (no.getDir() != null)
            n += contarNos(no.getDir());

        return n;
    }

    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);

        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);

        arvore.setRaiz(no1);
        System.out.println(arvore.estaVazia());
        // System.out.println(arvore.toString());
        System.out.println(arvore.emordem());
        System.out.println(arvore.pertence(1));
        System.out.println(arvore.posOrdem());
    }
}
