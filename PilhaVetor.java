package pilhas;

public class PilhaVetor<T> implements Pilha {

	private int tamanho;
	private int limite;
	private T[] info;

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public T[] getInfo() {
		return info;
	}

	public void setInfo(T[] info) {
		this.info = info;
	}

	public PilhaVetor(int limite) {
		super();
		this.limite = limite;
	}

	@Override
	public void push(Object valor) {
		if (getTamanho() == getLimite()) {
			throw new PilhaCheiaException();
		}

		info[tamanho] = (T) valor;
		tamanho++;
	}

	@Override
	public T pop() {
		T valor;
		valor = peek();
		tamanho--;

		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia() == true) {
			throw new PilhaVaziaException();
		} else {
			return info[tamanho - 1];
		}
		
	}

	@Override
	public boolean estaVazia() {
		if (info[tamanho] == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void liberar() {
		while (tamanho!= 0) {
			pop();
		}

	}
	
	public String ToString() {
		
		String str = "";
		for(int i =0; i<tamanho; i++) {
			str += "," + info[i].toString();
		}
		return str;
		
	}

}
