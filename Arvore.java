package arvoreNaria;

public class Arvore <T> {

	private NoArvore<T> raiz;
	
	public Arvore() {
		this.raiz = null;
	}
	
	public void setRaiz(NoArvore<T> raiz) {
		this.raiz=raiz;
	}
	
	public Object getRaiz() {
		return raiz;
	}
	
	public String toString() {
		if(raiz==null) {
			return "<>";
		}
		return ObterRepresentacaotextual(raiz);
	}
	private String ObterRepresentacaotextual(NoArvore<T> no) {
		
		String str = "<";
		str = str + no.getInfo();
		
		NoArvore <T> p =no.getPrimeiro();
		while(p!=null) {
			str = str + ObterRepresentacaotextual(p);
			p=p.getProximo();
		}
		str = str+ ">";
		
		return str;
	}
	
	public boolean pertence(T info) {
		if(raiz == null) {
			return false;
		}
		return pertence(info, raiz);
	}
	
	private boolean pertence (T info, NoArvore<T> no) {
		if(no.getInfo() == info) {
			return true;
		}else {
			NoArvore<T> p;
			p = no.getPrimeiro();
			while (p!= null) {
				if(pertence(info,p)) {
					return true;
				}
				p = p.getProximo();
			}
		}
		
		return false;
	}
	
	public int ContarNos() {
		return ContarNos(raiz);
	}
	private int ContarNos(NoArvore<T> no) {
		int i =1;
		NoArvore<T> p = no.getPrimeiro();
		while(p!=null) {
			i++;
			p= p.getProximo();
		}
	
	return i;
	}
}
