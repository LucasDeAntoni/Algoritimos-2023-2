package Mapa;


public class NoMapa<E> {
	
	private int chave;
	private E info;
	
	protected NoMapa(int chave, E info) {
		this.chave = chave;
		this.info = info;
	}
	
	public int getChave() {
		return chave;
	}
	
	public void setChave(int chave) {
		this.chave = chave;
	}
	
	public E getInfo() {
		return info;
	}
	
	public void setInfo(E info) {
		this.info = info;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NoMapa) {
			return chave ==((NoMapa) obj).chave;
		}
		return false;
	}
}

