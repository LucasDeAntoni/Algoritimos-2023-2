package Mapa;



public class NoLista<E> {
	
	private E info;
	private NoLista<E> proximo;
	
	protected NoLista(E info) {
		this.info = info;
	}

	public E getInfo() {
		return info;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public NoLista<E> getProximo() {
		return proximo;
	}

	public void setProximo(NoLista<E> proximo) {
		this.proximo = proximo;
	}
}

