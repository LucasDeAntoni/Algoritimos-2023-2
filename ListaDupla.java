
public class ListaDupla<T> {
	
	
	private NoListaDupla<T> primeiro;

		public ListaDupla() {
		
	}	
	
	public void inserir(T valor) {
		
		NoListaDupla<T> novo = new NoListaDupla<T>();
		novo.setInfo(valor);
		novo.setProx(getPrimeiro());
		novo.setAnterior(null);
		if(getPrimeiro() != null) {
			getPrimeiro().setAnterior(null);
		}
		primeiro = novo;
	}

	public NoListaDupla<T> getPrimeiro() {
		return primeiro;
	}

	
}
