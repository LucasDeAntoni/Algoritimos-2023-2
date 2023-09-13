package pilhas;

import java.lang.reflect.Array;

public class PilhaVetor<T> implements Pilha<T> {

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
        this.tamanho = 0;
		this.limite = limite;
        this.info = (T[]) new Object[limite];
	}

	@Override
	public void push(T valor) {
		if (getTamanho() == getLimite()) {
			throw new PilhaCheiaException();
		}

		info[tamanho] = valor;
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
		if (tamanho != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void liberar() {
		while (tamanho!= 0) {
			pop();
		}

	}
	
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		for (int i = tamanho-1; i >= 0; i--) {
			str.append(",").append(info[i]);
		}
		return str.toString();
		
	}

    public void concatenar(PilhaVetor<T> p){
        for(int i = 0; i<p.getTamanho(); i++){
            push(p.info[i]);
        }
    }

     public static void main(String[] args) {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
		
        pilha.push(10);
		pilha.push(20);
		pilha.push(30);

		PilhaVetor<Integer> p = new PilhaVetor<>(5);
		p.push(40);
		p.push(50);
		//System.out.println(pilha.peek());
		
		
		pilha.concatenar(p);
		System.out.println(pilha.toString());
		
        System.out.println(pilha.estaVazia());
    }

}