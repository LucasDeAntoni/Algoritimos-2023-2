package ArvoreBusca;



public abstract class ArvoreBinariaAbstract<T> {

	private NoArvoreBinaria<T> raiz;

	public ArvoreBinariaAbstract() {
		raiz = null;

	}

	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	public boolean estaVazia() {
		return (raiz == null);
	}

	public abstract NoArvoreBinaria<T> buscar(T info);

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

	// simetrica,em ordem
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

	// pos ordem
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

}