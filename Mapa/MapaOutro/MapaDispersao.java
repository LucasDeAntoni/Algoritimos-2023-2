package Mapa;

public class MapaDispersao<E> {
	
	private ListaEncadeada<NoMapa<E>>[] info;
	
	@SuppressWarnings("unchecked")
	public MapaDispersao(int tamanho) {
		info = (ListaEncadeada<NoMapa<E>>[]) new ListaEncadeada[tamanho];
	}
	
	private int calcularHash(int chave) {
		return chave % info.length;
	}
	
	public void inserir(int chave, E dado) {
		int hash = calcularHash(chave);
		if (info[hash] == null) {
			ListaEncadeada<NoMapa<E>> lista = new ListaEncadeada<NoMapa<E>>();
			info[hash] = lista;
			lista.inserir(new NoMapa<>(chave, dado));
		} else {
			info[hash].inserir(new NoMapa<E>(chave, dado));
		}
	}
	
	public void remover(int chave) {
		ListaEncadeada<NoMapa<E>> lista = info[calcularHash(chave)];
		if (lista == null) {
			return;
		}
		lista.retirar(new NoMapa<E>(chave, null));
	}
	
	public E buscar(int chave) {
		ListaEncadeada<NoMapa<E>> lista = info[calcularHash(chave)];
		if (lista == null) {
			return null;
		}
		NoLista<NoMapa<E>> no = lista.buscar(new NoMapa<E>(chave, null));
		if(no == null) {
			return null;
		}
		return no.getInfo().getInfo();
	}
}