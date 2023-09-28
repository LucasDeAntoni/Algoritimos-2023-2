package arvoreNaria;

public class NoArvore <T> {
	
	private T info;
	private NoArvore<T> primeiro;
	private NoArvore<T> proximo;
	
	public NoArvore(T info) {
		this.info = info;
	}
	
	public void InserirFilho(NoArvore <T> sa) {
		sa.proximo = primeiro;
		primeiro = sa;
	}

	
	public NoArvore<T> getPrimeiro() {
		return this.primeiro;
	}
	
	public NoArvore<T> getProximo() {
		return this.proximo;
	}
	
	public T getInfo() {
		return info;
	}
}
