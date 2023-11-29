package MapaDispersao;
import java.time.LocalDate;

public class MapaDispersaoColisao<T> {
    

    private ListaEncadeada<NoMapa<T>>[] info;
    private int tamanho;
    boolean rehash = false;
    private int quantidadeElementos;
    private double cargaMaxima = 0.75;

    public MapaDispersaoColisao(int tamanho) {
        this.tamanho = tamanho;
        info = (ListaEncadeada<NoMapa<T>>[]) new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            info[i] = new ListaEncadeada<>();
        }
        quantidadeElementos = 0;
    }

    private void rehash() {
        int novoTamanho = tamanho * 2;
        ListaEncadeada<NoMapa<T>>[] novoInfo = (ListaEncadeada<NoMapa<T>>[]) new ListaEncadeada[novoTamanho];
    
        for (int i = 0; i < novoTamanho; i++) {
            novoInfo[i] = new ListaEncadeada<>();
        }
    
        for (int i = 0; i < tamanho; i++) {
            ListaEncadeada<NoMapa<T>> lista = info[i];
            for (NoLista<NoMapa<T>> noLista = lista.getPrimeiro(); noLista != null; noLista = noLista.getProx()) {
                int novoIndice = noLista.getInfo().getChave() % novoTamanho;
                novoInfo[novoIndice].inserir(noLista.getInfo());
            }
        }
    
        info = novoInfo;
        tamanho = novoTamanho;
        rehash = true;
    }
    

    private int calcularHash(int chave) {
        return chave % tamanho;
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);

        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        info[indice].inserir(noMapa);
        quantidadeElementos++;

        double fatorDeCarga = (double) quantidadeElementos / tamanho;
        if (fatorDeCarga > cargaMaxima) {
            rehash();
        }
    }

    public T buscar (int chave){
        int indice = calcularHash(chave);

        if(info[indice]!= null){
            ListaEncadeada<NoMapa<T>> lista = new ListaEncadeada<NoMapa<T>>();
            NoMapa<T> noMapa = new NoMapa<T>();
            noMapa.setChave(chave);
            
            NoLista<NoMapa<T>> no =info[indice].buscar(noMapa);
            if(no==null){
                return null;
            }
            return no.getInfo().getInfo();
        }
        return null;
        
    }

    public void retirar(int chave){
        ListaEncadeada<NoMapa<T>> lista = info[calcularHash(chave)];
        if (lista == null){
            return;
        } else{
            lista.retirar((NoMapa<T>) buscar(chave));
        }
    }

    
    

    public static void main(String[] args) {
        MapaDispersaoColisao<Aluno> mapa = new MapaDispersaoColisao<Aluno>(10);

        Aluno a1 = new Aluno("Jean", 12000, LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno("Pedro", 14000, LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno("Marta", 12500, LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno("Lucas", 13000, LocalDate.of(1998, 11, 25));
        Aluno a5 = new Aluno("Lucasa", 17000, LocalDate.of(1998, 11, 25));
        Aluno a6 = new Aluno("Lucassa", 18000, LocalDate.of(1998, 11, 25));
        Aluno a7 = new Aluno("Luscasa7", 19000, LocalDate.of(1998, 11, 25));
        Aluno a8 = new Aluno("Lucasa8", 20000, LocalDate.of(1998, 11, 25));

        mapa.inserir(12000, a1);
        mapa.inserir(14000, a2);
        mapa.inserir(12500, a3);
        mapa.inserir(13000, a4);
        mapa.inserir(17000, a5);
        mapa.inserir(18000, a6);
        mapa.inserir(19000, a7);
        mapa.inserir(20000, a8);
        
        
        System.out.println(mapa.tamanho);
        System.out.println(mapa.rehash);
        //mapa.retirar(12000);
        /*
        System.out.println(mapa.buscar(12000).getNome());
        System.out.println(mapa.buscar(14226).getNome());
        System.out.println(mapa.buscar(12500).getNome());
        System.out.println(mapa.buscar(17180).getNome());
        */
    }

}


