package fila;

public class FilaVetor <T> implements Fila<T> {
	private int tamanho;
	private int limite;
	private int inicio;
	private T[] info;
	
	public FilaVetor(int limite) {
		super();
		this.tamanho = 0;
		this.limite = limite;
		this.inicio = 0;
		 this.info = (T[]) new Object[limite];
	}

	@Override
	public void inserir(T valor) {
		if(tamanho == limite) {
			throw new FilaCheiaException();
		}
		int posicaoInserir;
		posicaoInserir = (inicio + tamanho) % limite;
		info [posicaoInserir] = valor;
		tamanho++;
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public T peek() {
		if( info[inicio]== null) {
			throw new FilaVaziaException();
		}
		return info[inicio];
	}

	@Override
	public T retirar() {
		T valor = peek();
		inicio = (inicio+1) % limite;
		tamanho --;
				
		return valor;
	}

	@Override
	public void liberar() {
		
		
	}
	

}
