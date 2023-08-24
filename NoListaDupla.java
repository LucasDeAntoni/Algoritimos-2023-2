
public class NoListaDupla<T> {
		private T info;
	    private NoListaDupla<T> prox;
	    private NoListaDupla<T> anterior;
	    

	    public NoListaDupla<T> getAnterior() {
			return anterior;
		}
		public void setAnterior(NoListaDupla<T> anterior) {
			this.anterior = anterior;
		}
		public T getInfo() {
	        return info;
	    }
	    public void setInfo(T info) {
	        this.info = info;
	    }
	    public NoListaDupla<T> getProx() {
	        return prox;
	    }
	    public void setProx(NoListaDupla<T> prox) {
	        this.prox = prox;
	    }
	    
	    

}
