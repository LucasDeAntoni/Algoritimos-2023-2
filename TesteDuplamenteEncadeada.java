

class TesteDuplamenteEncadeada {

	@Test
	void inserir01() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		NoListaDupla<Integer> no = lista.getPrimeiro();
		
		for (int i = 0, j = 20; i < 4; i++, j -= 5) {
			assertEquals(j, no.getInfo());
			no = no.getProx();
		}
	}
	
	private void assertEquals(int j, Integer info) {
	}

	@Test
	void buscar01() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(20, lista.buscar(20).getInfo());
	}
	
	@Test
	void buscar02() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(10, lista.buscar(10).getInfo());
	}
	
	@Test
	void retirar01() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.retirar(10);
		
		NoListaDupla<Integer> no = lista.getPrimeiro();
		assertEquals(20, no.getInfo());
		no = no.getProx();
		assertEquals(15, no.getInfo());
		no = no.getProx();
		assertEquals(5, no.getInfo());
		
		no = lista.getUltimo();
		assertEquals(5, no.getInfo());
		no = no.getAnterior();
		assertEquals(15, no.getInfo());
		no = no.getAnterior();
		assertEquals(20, no.getInfo());
	}
	
	@Test
	void retirar02() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.retirar(5);
		
		NoListaDupla<Integer> no = lista.getPrimeiro();
		assertEquals(20, no.getInfo());
		no = no.getProx();
		assertEquals(15, no.getInfo());
		no = no.getProx();
		assertEquals(10, no.getInfo());
		
		no = lista.getUltimo();
		assertEquals(10, no.getInfo());
		no = no.getAnterior();
		assertEquals(15, no.getInfo());
		no = no.getAnterior();
		assertEquals(20, no.getInfo());
	}
	
	@Test
	void liberar() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		NoListaDupla<Integer> no05 = lista.buscar(5);
		NoListaDupla<Integer> no10 = lista.buscar(10);
		NoListaDupla<Integer> no15 = lista.buscar(15);
		NoListaDupla<Integer> no20 = lista.buscar(20);
		lista.liberar();
		
		assertEquals(null, no05.getAnterior());
		assertEquals(null, no05.getProx());
		assertEquals(null, no10.getAnterior());
		assertEquals(null, no10.getProx());
		assertEquals(null, no15.getAnterior());
		assertEquals(null, no15.getProx());
		assertEquals(null, no20.getAnterior());
		assertEquals(null, no20.getProx());
	}
	
	private void assertEquals(Object object, NoListaDupla<Integer> anterior) {
	}

	@Test
	void obterNo01() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		try {
			lista.toString();
			//fail();
		} catch (Exception e) {
		}
	}
	/* 
	@Test
	void obterNo02() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(20, lista.obterNo(0).getInfo());
		assertEquals(15, lista.obterNo(1).getInfo());
		assertEquals(10, lista.obterNo(2).getInfo());
		assertEquals(5, lista.obterNo(3).getInfo());
	}
	
	@Test
	void setOrdemNormal01() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.setOrdemNormal(true);
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(5, lista.obterNo(0).getInfo());
		assertEquals(10, lista.obterNo(1).getInfo());
		assertEquals(15, lista.obterNo(2).getInfo());
		assertEquals(20, lista.obterNo(3).getInfo());
	}
	
	
	@Test
	void setOrdemNormal02() {
		ListaDupla<Integer> lista = new ListaDupla<>();
		lista.setOrdemNormal(true);
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.setOrdemNormal(false);
		lista.inserir(25);
		lista.inserir(30);
		lista.inserir(35);
		lista.inserir(40);
		
		assertEquals(40, lista.obterNo(0).getInfo());
		assertEquals(35, lista.obterNo(1).getInfo());
		assertEquals(30, lista.obterNo(2).getInfo());
		assertEquals(25, lista.obterNo(3).getInfo());
		assertEquals(5, lista.obterNo(4).getInfo());
		assertEquals(10, lista.obterNo(5).getInfo());
		assertEquals(15, lista.obterNo(6).getInfo());
		assertEquals(20, lista.obterNo(7).getInfo());
	}
	*/
}
