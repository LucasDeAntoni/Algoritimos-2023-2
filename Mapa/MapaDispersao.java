package MapaDispersao;
import java.time.LocalDate;
public class MapaDispersao <T>{
    
    private ListaEncadeada<NoMapa<T>> [] info;

    public MapaDispersao(int tamanho) {
       info = (ListaEncadeada<NoMapa<T>> []) new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave){
        int tamanho = info.length;
        return chave % tamanho;
    }

    public void inserir(int chave, T dado){
        int indice = calcularHash(chave);
        if(info[indice] == null){
            ListaEncadeada<NoMapa<T>> lista = new ListaEncadeada<NoMapa<T>>();
            info[indice] = new ListaEncadeada<NoMapa<T>>();

        }

        NoMapa<T> noMapa = new NoMapa<T>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        info[indice].inserir(noMapa);
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
        MapaDispersao<Aluno> mapa = new MapaDispersao<Aluno>(53);

        Aluno a1 = new Aluno("Jean", 12000, LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno("Pedro", 14226, LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno("Marta", 12500, LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno("Lucas", 17180, LocalDate.of(1998, 11, 25));

        mapa.inserir(12000, a1);
        mapa.inserir(14226, a2);
        mapa.inserir(12500, a3);
        mapa.inserir(17180, a4);
        
        System.out.println(mapa.buscar(12000).getNome());
        System.out.println(mapa.buscar(14226).getNome());
        System.out.println(mapa.buscar(12500).getNome());
        System.out.println(mapa.buscar(17180).getNome());
    }

    
}
