public class ListaEncadeada <T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    

    
    public void inserir(T valor) {
         NoLista novo = new NoLista();
        novo.setInfo(valor);
        if (this.EstaVazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.setProx(primeiro);
            primeiro = novo;
        }
       
    }

   
    public void retirar(T valor) {
        NoLista p = this.primeiro;
        NoLista anterior = null;
        while (p != null && p.getInfo() != valor) {
            anterior = p;
            p = p.getProx();
        }
            if(p != null) {
                if (anterior == null) {
                   this.primeiro = p.getProx(); 
                } else {
              anterior.setProx(p.getProx());
            }
            if(this.ultimo == p) {
                this.ultimo = anterior;
            }
           
        }
           
        
    }

    
    public NoLista<T> buscar(T valor) {
        NoLista<T> p = primeiro;
        while ( p != null) {
            if(p.getInfo() == valor) {
                return p;
            }
            p = p.getProx();
            
        }
        return null;

    }

    
    public String ToString() {
        NoLista p = primeiro;
        String str = "[";
        while (p != null) {
            if(p == ultimo){
                str +=p.getInfo();
                p = p.getProx();
            } else{
            str += p.getInfo() + ",";
            p = p.getProx();
            }
        }
        return str + "]";
    }

    public int ObterComprimento(){
        NoLista p = primeiro;
        int comprimeento = 0;
        while(p!= null){
            p = p.getProx();
            comprimeento++;
        }
        return comprimeento;
    }

    
    

    
    public boolean EstaVazia() {
        if (primeiro == null) {
            return true;
        } else {
            return false;
        }

    }

    
    public Object ObterNo(int pos) {
        if(pos<0 || pos >= ObterComprimento()) {
            throw new IndexOutOfBoundsException("Pos = " + pos);
        }
        NoLista<T> p = this.primeiro;
        for (int i = 0; i < pos; i++) {
           p = p.getProx(); 
        }
        return p.getInfo();

    }

    public NoLista<T> getPrimeiro(){
        return primeiro;
    }

    public static void main(String[] args) {
    ListaEncadeada<Integer> lista = new ListaEncadeada<>();

    lista.inserir(5);
    lista.inserir(10);
    lista.inserir(15);
    lista.inserir(20);



    System.out.println(lista.EstaVazia());
    //System.out.println(lista.getPrimeiro());
        System.out.println(lista.ToString());

    System.out.println(lista.ObterComprimento());
       // System.out.println(lista.ObterNo(10));

    
    }
    }

