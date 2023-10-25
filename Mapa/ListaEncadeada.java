package Mapa;


public class ListaEncadeada<E> {
	
	private NoLista<E> primeiro;
	
	public NoLista<E> getPrimeiro() {
		return primeiro;
	}
	
	public NoLista<E> getUltimo() {
		if (primeiro == null) {
			return null;
		}
		NoLista<E> no = primeiro;
		NoLista<E> proximo = primeiro.getProximo();
		while (proximo != null) {
			no = proximo;
			proximo = proximo.getProximo();
		}
		return no;
	}

	public void inserir(E info) {
		NoLista<E> primeiroAux = primeiro;
		primeiro = new NoLista<E>(info);
		primeiro.setProximo(primeiroAux);
	}
	
	public boolean estaVazia() {
		return primeiro == null;
	}
	
	public NoLista<E> buscar(E info) {
		NoLista<E> no = primeiro;
		while(no != null) {
			if (no.getInfo().equals(info)) {
				return no;
			}
			no = no.getProximo();
		}
		return null;
	}
	
	public void retirar(E info) {
		if (primeiro == null) {
			return;
		}
		if (primeiro.getInfo().equals(info)) {
			primeiro = primeiro.getProximo();
			return;
		}
		NoLista<E> no = primeiro;
		NoLista<E> proximo = primeiro.getProximo();
		while (proximo != null) {
			if (proximo.getInfo().equals(info)) {
				no.setProximo(proximo.getProximo());
				return;
			}
			no = proximo;
			proximo = proximo.getProximo();
		}
		
	}
	
	public int obterComprimento() {
		NoLista<E> no = primeiro;
		int q = 0;
		while(no != null) {
			q++;
			no = no.getProximo();
		}
		return q;
	}
	
	public NoLista<E> obterNo(int idx) {
		if (idx < 0) {
			throw new IndexOutOfBoundsException(idx);
		}
		NoLista<E> no = primeiro;
		int pos = idx;
		int i = 0;
		while (i < idx && no != null) {
			no = no.getProximo();
			i++;
		}
		
		if (no == null) {
			throw new IndexOutOfBoundsException(pos);
		}
		return no;
	}
	
	public void liberar() {
		primeiro = null;
	}
	
	public void exibir() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		if (primeiro == null) {
			return "[]";
		}
		String string = "[";
		NoLista<E> no = primeiro;
		string += no.getInfo();
		no = no.getProximo();
		while (no != null) {
			string += ", " + no.getInfo();
			no = no.getProximo();
		}
		return string += "]";
	}
}

