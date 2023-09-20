package Fila;

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
		T valor = info[tamanho];
	//	inicio = (inicio+1) % limite;
		tamanho --;
				
		return valor;
	}

	@Override
	public void liberar() {
		while(tamanho!=0){
            retirar();
        }
		
	}

    public FilaVetor<T> CriarFilaConcatenada(FilaVetor<T> f2){
        int limite = f2.limite + this.limite;
        FilaVetor<T> f3 = new FilaVetor<T>(limite);

        for(int i=0;  i<tamanho;i++){
            f3.inserir(this.info[i]);
        }
        for(int i=0;  i<f2.tamanho;i++){
            f3.inserir(f2.info[i]);
        }
        return f3;
        
    }

    public String toString(){
        String resultado = "";
		
		for (int i = 0; i <tamanho; i++) {
            if(i==0) {
				resultado += info[i].toString() ;
			}else{
			resultado +=  ", "+ info[i].toString() ;
            }
		}
		return resultado;
	
    }
    public int getLimite(){
        return limite;
    }
	

    public static void main(String[] args) {
        FilaVetor<Integer> f1 =  new FilaVetor<>(5);
        FilaVetor<Integer> f2 =  new FilaVetor<>(3);
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);

        f2.inserir(40);
        f2.inserir(50);

     
       System.out.println(f1.CriarFilaConcatenada(f2).toString());
        
        
        System.out.println(f1.toString());

    }

}
